package com.acquisition.controller;

import com.acquisition.entity.*;
import com.acquisition.service.ICjDataSourceConnDefineService;
import com.acquisition.service.ICjDataSourceSystemInfoService;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yili.pool.pool.GroupPoolFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yxk
 * @Description: 获取导入元数据
 * @create 2019/6/5
 * @since 1.0.0
 */
@Api(tags = "getSourceMetaData", description = "初始化业务元数据")
@RestController
@RequestMapping(value = "/getSourceMetaData")
public class GetSourceMetaDataController {

    @Resource(name = "cjDataSourceConnDefineServiceImpl")
    ICjDataSourceConnDefineService iCjDataSourceConnDefineService;

    @Resource(name = "cjDataSourceSystemInfoServiceImpl")
    ICjDataSourceSystemInfoService iCjDataSourceSystemInfoService;

    @Resource(name = "cjDataSourceTabColInfoServiceImpl")
    ICjDataSourceTabColInfoService iCjDataSourceTabColInfoService;

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    ICjDataSourceTabInfoService iCjDataSourceTabInfoService;


    @ApiOperation("获取配置的参数")
    @GetMapping("/getDataInfo")
    public Result getDataSourceInfo(PageGeorge reqParams) {
        PageHelper.startPage(reqParams.getPagenum(), reqParams.getPagesize());
        List<ViewSourceSystemEntity> list = iCjDataSourceConnDefineService.selectViewContet();
        PageInfo<ViewSourceSystemEntity> page = new PageInfo<>(list);
        return new Result().success(page);
    }


    @ApiOperation(value = "生成schema数据信息", notes = "List<ViewSourceSystemEntity> 复杂对象", produces = "application/json")
    @PostMapping("/getConnection")
    public Result setStauts(@RequestBody List<ViewSourceSystemEntity> sourcesysteminfo) {
        String[] arr = new String[100];
        for (int i = 0; i < sourcesysteminfo.size(); i++) {
            arr[i] = sourcesysteminfo.get(i).getBusiness_system_ID();
        }
        List<CjDataSourceConnDefine> list = iCjDataSourceConnDefineService.findListBySystemID(arr);
        Result result = new Result();
        List<CjDataSourceSystemInfo> DataSourceSystemInfo = new ArrayList<>();
        if (list != null) {
            for (CjDataSourceConnDefine table : list) {
                Connection con = null;
                Statement st = null;
                ResultSet rs = null;
                try {
                    GroupPoolFactory groupPoolFactory = GroupPoolFactory.getInstance((table.getBusinessSystemNameShortName() + table.getDataSourceSchema()));
                    con = groupPoolFactory.getConnection();
                    if (con == null) {
                        continue;
                    }
                    st = con.createStatement();
                    if (table.getDataBaseType().equals("mysql")) {
                        rs = st.executeQuery("select distinct table_schema as schema_name FROM INFORMATION_SCHEMA.tables");
                    } else if (table.getDataBaseType().equals("sqlserver")) {
                        rs = st.executeQuery("SELECT name AS schema_name FROM  master..sysdatabases WHERE name = '" + table.getDataSourceSchema() + "'");
                    } else if (table.getDataBaseType().equals("oracle")) {
                        rs = st.executeQuery("SELECT DISTINCT username AS schema_name FROM all_users");
                    }
                    while (rs.next()) {
                        CjDataSourceSystemInfo systeminfo = new CjDataSourceSystemInfo();
                        systeminfo.setBusinessSystemNameShortName(table.getBusinessSystemNameShortName());
                        systeminfo.setDataSourceSchema(rs.getString("schema_name"));
                        systeminfo.setBusinessSystemId(table.getBusinessSystemId());
                        DataSourceSystemInfo.add(systeminfo);
                    }
                    for(int i=0;i<DataSourceSystemInfo.size();i++){
                        System.out.println(DataSourceSystemInfo.get(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (con != null) {
                        try {
                            rs.close();
                            st.close();
                            con.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
                iCjDataSourceSystemInfoService.deleteBySystemName(table.getBusinessSystemId());
            }

            if (DataSourceSystemInfo.size() > 0 && iCjDataSourceSystemInfoService.insertBatch(DataSourceSystemInfo) > 0) {
                result.success("");
            } else {
                result.error(500, "导入失败");
            }
        } else {
            result.error(500, "连接未配置");
        }
        return result;
    }


    @ApiOperation("获取 schema信息表")
    @GetMapping("/getSchema")
    public Result getSchema(PageGeorge reqParams) {
        Result result = new Result();
        PageHelper.startPage(reqParams.getPagenum(), reqParams.getPagesize());
        List<CjDataSourceSystemInfo> list = iCjDataSourceSystemInfoService.selectInfo();
        PageInfo<CjDataSourceSystemInfo> page = new PageInfo<>(list);
        result.success(page);
        return result;
    }


    @ApiOperation("获取源系统数据模式")
    @GetMapping("/getSystemFilterList")
    public Result getSystemFilterList() {
        List<String> distBusinessSystemNameShortName = iCjDataSourceSystemInfoService.findDistBusinessSystemNameShortName();
        return new Result().success(distBusinessSystemNameShortName);
    }


    @ApiOperation("获取表及字段的查询")
    @PostMapping("/getSchemaByFilter")
    public Result getDataInfoByFilter(@RequestBody PageGeorge<List<String>> reqParams) {
        PageHelper.startPage(reqParams.getPagenum(), reqParams.getPagesize());
        CjDataSourceSystemInfoExample example = new CjDataSourceSystemInfoExample();
        CjDataSourceSystemInfoExample.Criteria criteria = example.createCriteria();
        criteria.andBusinessSystemNameShortNameEqualTo(reqParams.getQuery().get(0));
        List<CjDataSourceSystemInfo> list = iCjDataSourceSystemInfoService.findByExample(example);
        PageInfo<CjDataSourceSystemInfo> page = new PageInfo<>(list);
        return new Result().success(page);
    }


    @ApiOperation(value = "按schema导入元数据", notes = "List<CjDataSourceSystemInfo> 复杂对象", produces = "application/json")
    @PostMapping("/importingMetadata")
    public Result importingMetadata(@RequestBody List<CjDataSourceSystemInfo> sourcesysteminfo) {
        Result result = new Result();
        List<CjDataSourceTabColInfo> datasourcetabcolInfo = new ArrayList<>();
        if (sourcesysteminfo.size() > 0) {
            for (CjDataSourceSystemInfo table : sourcesysteminfo) {
                Connection con = null;
                Statement st = null;
                ResultSet rs = null;
                try {
                    String basetype = iCjDataSourceConnDefineService.selectBySystemID(table.getBusinessSystemId());
                    GroupPoolFactory groupPoolFactory = GroupPoolFactory.getInstance((table.getBusinessSystemNameShortName() + (basetype.equals("sqlserver") ? table.getDataSourceSchema() : "-")));
                    con = groupPoolFactory.getConnection();
                    if (con == null) {
                        continue;
                    }
                    st = con.createStatement();
                    String sql = "";
                    if (basetype.equals("mysql")) {
                        sql = "select DISTINCT " +
                                " tab_col.table_schema AS data_source_schema " +
                                ",tab_col.table_name AS data_source_table" +
                                ",tab_tab.TABLE_COMMENT AS data_source_table_comment" +
                                ",tab_col.column_name AS data_source_col_name" +
                                ",tab_col.ordinal_position AS data_source_col_order" +
                                ",CASE WHEN tab_col.COLUMN_KEY='PRI' THEN 'true' ELSE '' END  AS data_source_col_primarykey" +
                                ",CASE WHEN tab_col.is_nullable='NO' THEN '0' " +
                                "      WHEN tab_col.IS_NULLABLE='YES' THEN '1' " +
                                "      ELSE tab_col.IS_NULLABLE END  AS data_source_col_isnull_flag" +
                                ",tab_col.data_type AS data_source_col_datatype      " +
                                ",tab_col.column_type AS data_source_col_len" +
                                ",'' AS data_source_col_precision" +
                                ",'' AS data_source_col_scale" +
                                ",tab_col.column_comment AS data_source_col_comment " +
                                "from information_schema.COLUMNS tab_col " +
                                "LEFT JOIN information_schema.TABLES tab_tab " +
                                "ON (tab_col.TABLE_NAME=tab_tab.TABLE_NAME AND tab_col.table_schema=tab_tab.TABLE_SCHEMA)" +
                                "WHERE tab_col.table_schema='" + table.getDataSourceSchema() + "'" +
                                "ORDER BY tab_col.table_schema,tab_col.table_name,tab_col.ordinal_position";
                    } else if (basetype.equals("sqlserver")) {
                        sql = "select '" + table.getDataSourceSchema() + "' AS data_source_schema " +
                                ",cast(d.name as varchar(200))  as data_source_table " +
                                ",cast(f.value as varchar(1000)) as data_source_table_comment " +
                                ",cast(a.name as varchar(200))  as data_source_col_name " +
                                ",cast(a.colid as varchar(5)) as  data_source_col_order " +
                                ",case when  exists(SELECT 1 FROM sysobjects where  xtype='PK' AND name in ( " +
                                "SELECT cast(name as varchar(200)) as name FROM sysindexes WHERE indid   in( " +
                                "SELECT cast(indid as varchar(200)) as indid FROM sysindexkeys WHERE id = a.id AND colid=a.colid " +
                                ")))   then   '1'   else   ''   end as data_source_col_primarykey " +
                                ",cast(a.isnullable as varchar(1)) AS data_source_col_isnull_flag " +
                                ",cast(b.name  as varchar(200)) as data_source_col_datatype " +
                                ",'' AS data_source_col_len " +
                                ",cast(a.prec as varchar(200)) AS data_source_col_precision " +
                                ",cast(a.xscale as varchar(200)) AS data_source_col_scale " +
                                ",cast(g.value as varchar(800)) as data_source_col_comment " +
                                "from sysobjects d inner join syscolumns a on a.id=d.id and d.xtype='U' " +
                                "left join systypes b on a.xusertype=b.xusertype " +
                                "left join sys.extended_properties g on a.id=g.major_id and a.colid=g.minor_id " +
                                "left join sys.extended_properties f on d.id=f.major_id and f.minor_id=0 " +
                                "order by d.name,a.colid";
                    } else if (basetype.equals("oracle")) {
                        sql = "SELECT  T.owner as data_source_schema ,T.table_name as data_source_table,T.tab_comments as data_source_table_comment,T.column_name as data_source_col_name,T.column_id as data_source_col_order,T.primarykey as data_source_col_primarykey,T.isnullflag as data_source_col_isnull_flag,T.data_type as data_source_col_datatype,T.data_length as data_source_col_len,T.data_precision as data_source_col_precision,T.data_scale as data_source_col_scale " +
                                ",replace(T.comments,chr(10)) AS data_source_col_comment  " +
                                "FROM  (  " +
                                "SELECT DISTINCT T1.TABLE_name,T1.column_name,T1.DATA_type,T1.column_id, " +
                                "T1.data_length,T1.primaryKEY,T2.comments,T1.OWNER,t1.tab_comments,t1.isnullflag,t1.data_precision,t1.data_scale " +
                                "FROM ( " +
                                "SELECT DISTINCT  " +
                                "tab1.TABLE_name,tab1.column_name,tab1.column_id,tab1.DATA_type, " +
                                "replace(tab2.comments,chr(10)) as tab_comments " +
                                ",CASE WHEN tab1.nullable='N' THEN '0' WHEN tab1.nullable='Y' THEN '1' ELSE tab1.nullable end AS isnullflag " +
                                ",'' AS data_length,nvl(tab1.data_precision,tab1.data_length) AS data_precision,tab1.data_scale " +
                                ",CASE WHEN tab3.primaryKEY IS NOT NULL THEN  'true' ELSE '' END  AS primaryKEY,tab1.OWNER  " +
                                "from all_tab_columns tab1 JOIN all_tab_comments tab2  " +
                                "on (tab1.TABLE_name=tab2.TABLE_name AND tab1.owner=tab2.owner AND tab2.table_type<>'VIEW') " +
                                "LEFT JOIN ( " +
                                "SELECT DISTINCT  " +
                                "con.TABLE_name ,con.owner,col.column_name AS primaryKEY " +
                                "FROM all_constraints con JOIN all_cons_columns col  " +
                                "ON (con.constraint_name = col.constraint_name AND con.constraint_type='P' AND con.owner=col.owner) " +
                                ") tab3 " +
                                "ON (tab1.TABLE_name=tab3.TABLE_name AND tab1.owner=tab3.owner AND tab1.column_name=tab3.primaryKEY) " +
                                ") T1 LEFT JOIN all_col_comments T2  " +
                                "ON (T1.TABLE_name=T2.TABLE_name AND T1.column_name=T2.column_name AND T1.OWNER=T2.OWNER) " +
                                " WHERE T1.OWNER IN (UPPER('" + table.getDataSourceSchema() + "')) " +
                                ") T " +
                                "ORDER BY T.OWNER,T.TABLE_name ,T.column_id ";
                    }
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        CjDataSourceTabColInfo sourcetabcolinfo = new CjDataSourceTabColInfo();
                        sourcetabcolinfo.setBusinessSystemId(table.getBusinessSystemId());
                        sourcetabcolinfo.setBusinessSystemNameShortName(table.getBusinessSystemNameShortName());
                        sourcetabcolinfo.setDataSourceSchema(rs.getString("data_source_schema"));
                        sourcetabcolinfo.setDataSourceTable(rs.getString("data_source_table"));
                        sourcetabcolinfo.setDataSourceTableComment(rs.getString("data_source_table_comment"));
                        sourcetabcolinfo.setDataSourceColName(rs.getString("data_source_col_name"));
                        sourcetabcolinfo.setDataSourceColOrder(rs.getString("data_source_col_order"));
                        sourcetabcolinfo.setDataSourceColPrimarykeyFlag(rs.getString("data_source_col_primarykey"));
                        sourcetabcolinfo.setDataSourceColIsnullFlag(rs.getString("data_source_col_isnull_flag"));
                        sourcetabcolinfo.setDataSourceColDatatype(rs.getString("data_source_col_datatype"));
                        sourcetabcolinfo.setDataSourceColLen(rs.getString("data_source_col_len"));
                        sourcetabcolinfo.setDataSourceColPrecision(rs.getString("data_source_col_precision"));
                        sourcetabcolinfo.setDataSourceColScale(rs.getString("data_source_col_scale"));
                        sourcetabcolinfo.setDataSourceColComment(rs.getString("data_source_col_comment"));
                        datasourcetabcolInfo.add(sourcetabcolinfo);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (con != null) {
                        try {
                            rs.close();
                            st.close();
                            con.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }

                iCjDataSourceTabColInfoService.deleteBySystemName(table.getBusinessSystemNameShortName(), table.getDataSourceSchema(),null);
                /*iCjDataSourceTabInfoService.deleteBySystemName(table.getBusinessSystemNameShortName());*/
            }

            if (datasourcetabcolInfo.size() > 0 && InBatchesInsert(datasourcetabcolInfo)) {
                List<CjDataSourceTabColInfo> tabcolinfo = iCjDataSourceTabColInfoService.findListOnlyTable(sourcesysteminfo);
                List<CjDataSourceTabInfo> arrDataSourceTabInfo = new ArrayList<>();
                if (tabcolinfo != null) {
                    for (CjDataSourceTabColInfo model : tabcolinfo) {
                        CjDataSourceTabInfo en = new CjDataSourceTabInfo();
                        en.setBusinessSystemId(model.getBusinessSystemId());
                        en.setBusinessSystemNameShortName(model.getBusinessSystemNameShortName());
                        en.setDataSourceSchema(model.getDataSourceSchema());
                        en.setDataSourceTable(model.getDataSourceTable());
                        en.setDataSourceTableComment(model.getDataSourceTableComment());
                        en.setDataFlagForGetCols("1");
                        arrDataSourceTabInfo.add(en);
                    }
                    if (arrDataSourceTabInfo.size() > 0 && iCjDataSourceTabInfoService.insertBatch(arrDataSourceTabInfo) > 0) {
                        result.success("");
                    } else {
                        result.error(200, "源库未新增表");
                    }
                } else {
                    result.error(500, "查询失败");
                }
            } else {
                result.error(200, "该schema下没有表");
            }

        } else {
            result.error(500, "参数为null");
        }
        return result;
    }


    /**
     * 分批逻辑insert
     *
     * @return
     */
    public boolean InBatchesInsert(List<CjDataSourceTabColInfo> list) {
        int size = list.size();
        //一次性插入数据
        int unitNum = 100;
        int startIndex = 0;
        int endIndex = 0;
        while (size > 0) {
            if (size > unitNum) {
                endIndex = startIndex + unitNum;
            } else {
                endIndex = startIndex + size;
            }
            List<CjDataSourceTabColInfo> insertData = list.subList(startIndex, endIndex);
            iCjDataSourceTabColInfoService.insertBatch(insertData);
            size = size - unitNum;
            startIndex = endIndex;
        }
        return true;
    }


}
