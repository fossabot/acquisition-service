package com.acquisition.controller;

import com.acquisition.entity.*;
import com.acquisition.entity.excel.EtuInfo;
import com.acquisition.entity.pojo.SqoopScriptEntity;
import com.acquisition.service.*;
import com.acquisition.util.EasyExcelUtil;
import com.acquisition.util.Result;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.yili.pool.pool.GroupPoolFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yxk
 * @Description: 通过导入excel元数据生成显示文件建表
 * @create 2019/6/18
 * @since 1.0.0
 */
@Api(tags = "convertMetadata", description = "定制化入湖")
@RequestMapping("convertMetadata")
@RestController
public class ConvertMetadataController {


    @Resource(name = "cjDataSourceConnDefineServiceImpl")
    ICjDataSourceConnDefineService iCjDataSourceConnDefineService;


    @Resource(name = "cjDataSourceTabColInfoServiceImpl")
    ICjDataSourceTabColInfoService iCjDataSourceTabColInfoService;

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    ICjDataSourceTabInfoService iCjDataSourceTabInfoService;

    @Resource(name = "cjDataSourceUniqueIndexInfoServiceImpl")
    CjDataSourceUniqueIndexInfoService cjDataSourceUniqueIndexInfoService;


    @Resource(name = "cjDataSourceTabRowsServiceImpl")
    CjDataSourceTabRowsService cjDataSourceTabRowsService;

    @Resource(name = "cjDataSourceConnDefineServiceImpl")
    ICjDataSourceConnDefineService cjDataSourceConnDefineService;

    @Resource(name = "cjOdsDataScriptDefInfoServiceImpl")
    ICjOdsDataScriptDefInfoService cjOdsDataScriptDefInfoService;

    @Resource(name = "cjOdsTableColInfoServiceImpl")
    CjOdsTableColInfoService cjOdsTableColInfoService;

    @ApiOperation(" 上传excel并转成map数据")
    @ApiImplicitParam(name = "file", value = "excel", dataType = "MultipartFile", required = true)
    @PostMapping("/uploadExcel")
    public Result uploadExcel(@RequestParam("file") MultipartFile file) throws IOException {
        Result result = new Result();
        if (file.isEmpty()) {
            return result.error(500, "上传文件为null");
        }
        try {
            InputStream inputStream = file.getInputStream();
            List<EtuInfo> excelList = (List) getExcelList(inputStream, file.getOriginalFilename());
            result.success(excelList);
        } catch (Exception e) {
            result.error(500, "excel数据异常：" + e.getMessage());
        }
        return result;
    }


    /**
     * 判断文件格式
     *
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
     */
    public List<Object> getExcelList(InputStream inStr, String fileName) throws Exception {
        List<Object> list = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            list = EasyExcelUtil.readExcelWithModel(inStr, EtuInfo.class, ExcelTypeEnum.XLS);
        } else if (".xlsx".equals(fileType)) {
            list = EasyExcelUtil.readExcelWithModel(inStr, EtuInfo.class, ExcelTypeEnum.XLSX);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return list;
    }


    @ApiOperation(value = "导入元数据", notes = "List<EtuInfo> 复杂对象", produces = "application/json")
    @PostMapping("/importingMetadata")
    public Result importingMetadata(@RequestBody List<EtuInfo> reqParmsEtu) {
        Result result = new Result();
        if (!reqParmsEtu.isEmpty()) {
            List<CjDataSourceSystemInfo> listSysEntity = new ArrayList<>();
            List<CjDataSourceTabColInfo> datasourcetabcolInfo = new ArrayList<>();
            List<CjDataSourceTabInfo> cjDataSourceTabInfos = new ArrayList<>();
            for (EtuInfo etuInfo : reqParmsEtu) {
                Connection con = null;
                Statement st = null;
                ResultSet rs = null;
                String dataSourceSchema = "";
                String dataSourceColComment = "";
                CjDataSourceSystemInfo model = new CjDataSourceSystemInfo();
                model.setBusinessSystemNameShortName(etuInfo.getBusinessSystemNameShortName());
                model.setDataSourceSchema(etuInfo.getDataSourceSchema());
                listSysEntity.add(model);
                CjDataSourceConnDefine connDefine = iCjDataSourceConnDefineService.selectDataBaseType(etuInfo.getBusinessSystemNameShortName(), etuInfo.getDataSourceSchema());
                try {
                    GroupPoolFactory groupPoolFactory = GroupPoolFactory.getInstance((etuInfo.getBusinessSystemNameShortName() + (connDefine.getDataBaseType().equals("sqlserver") ? etuInfo.getDataSourceSchema() : "-")));
                    con = groupPoolFactory.getConnection();
                    if (con == null) {
                        continue;
                    }
                    st = con.createStatement();
                    String sql = "";
                    if (connDefine.getDataBaseType().equals("mysql")) {
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
                                "WHERE tab_col.table_schema='" + etuInfo.getDataSourceSchema() + "' and tab_col.table_name='" + etuInfo.getDataSourceTable() + "'" +
                                "ORDER BY tab_col.table_schema,tab_col.table_name,tab_col.ordinal_position";
                    } else if (connDefine.getDataBaseType().equals("sqlserver")) {
                        sql = "select '" + etuInfo.getDataSourceSchema() + "' AS data_source_schema " +
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
                                "left join sys.extended_properties f on d.id=f.major_id and f.minor_id=0 where d.name='" + etuInfo.getDataSourceTable() + "'" +
                                "order by d.name,a.colid";
                    } else if (connDefine.getDataBaseType().equals("oracle")) {
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
                                " WHERE T1.OWNER = UPPER('" + etuInfo.getDataSourceSchema() + "') and  T1.table_name='" + etuInfo.getDataSourceTable() + "'" +
                                ") T " +
                                "ORDER BY T.OWNER,T.TABLE_name ,T.column_id ";
                    }
                    rs = st.executeQuery(sql);
                    if (rs.next()) {
                        CjDataSourceTabColInfo sourcetabcolinfo1 = new CjDataSourceTabColInfo();
                        dataSourceSchema = rs.getString("data_source_schema");
                        dataSourceColComment = rs.getString("data_source_table_comment");
                        sourcetabcolinfo1.setBusinessSystemId(connDefine.getBusinessSystemId());
                        sourcetabcolinfo1.setBusinessSystemNameShortName(etuInfo.getBusinessSystemNameShortName());
                        sourcetabcolinfo1.setDataSourceSchema(rs.getString("data_source_schema"));
                        sourcetabcolinfo1.setDataSourceTable(rs.getString("data_source_table"));
                        sourcetabcolinfo1.setDataSourceTableComment(rs.getString("data_source_table_comment"));
                        sourcetabcolinfo1.setDataSourceColName(rs.getString("data_source_col_name"));
                        sourcetabcolinfo1.setDataSourceColOrder(rs.getString("data_source_col_order"));
                        sourcetabcolinfo1.setDataSourceColPrimarykeyFlag(rs.getString("data_source_col_primarykey"));
                        sourcetabcolinfo1.setDataSourceColIsnullFlag(rs.getString("data_source_col_isnull_flag"));
                        sourcetabcolinfo1.setDataSourceColDatatype(rs.getString("data_source_col_datatype"));
                        sourcetabcolinfo1.setDataSourceColLen(rs.getString("data_source_col_len"));
                        sourcetabcolinfo1.setDataSourceColPrecision(rs.getString("data_source_col_precision"));
                        sourcetabcolinfo1.setDataSourceColScale(rs.getString("data_source_col_scale"));
                        sourcetabcolinfo1.setDataSourceColComment(rs.getString("data_source_col_comment"));
                        datasourcetabcolInfo.add(sourcetabcolinfo1);
                        while (rs.next()) {
                            CjDataSourceTabColInfo sourcetabcolinfo = new CjDataSourceTabColInfo();
                            dataSourceSchema = rs.getString("data_source_schema");
                            dataSourceColComment = rs.getString("data_source_table_comment");
                            sourcetabcolinfo.setBusinessSystemId(connDefine.getBusinessSystemId());
                            sourcetabcolinfo.setBusinessSystemNameShortName(etuInfo.getBusinessSystemNameShortName());
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
                        iCjDataSourceTabColInfoService.deleteBySystemName(etuInfo.getBusinessSystemNameShortName(), etuInfo.getDataSourceSchema(), etuInfo.getDataSourceTable());
                        CjDataSourceTabInfo cjDataSourceTabInfo = new CjDataSourceTabInfo();
                        cjDataSourceTabInfo.setBusinessSystemId(connDefine.getBusinessSystemId());
                        cjDataSourceTabInfo.setBusinessSystemNameShortName(etuInfo.getBusinessSystemNameShortName());
                        cjDataSourceTabInfo.setDataSourceSchema(dataSourceSchema);
                        cjDataSourceTabInfo.setDataSourceTable(etuInfo.getDataSourceTable());
                        cjDataSourceTabInfo.setDataSourceTableComment(dataSourceColComment);
                        cjDataSourceTabInfo.setDataFlagForGetCols("1");
                        cjDataSourceTabInfos.add(cjDataSourceTabInfo);
                        etuInfo.setIsExists("Y");
                    } else {
                        etuInfo.setIsExists("N");
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
            }
            inBatchesInsert(datasourcetabcolInfo);
            iCjDataSourceTabInfoService.insertBatch(cjDataSourceTabInfos);
        }
        return result.success(reqParmsEtu);
    }


    /**
     * 分批逻辑insert
     *
     * @return
     */
    public boolean inBatchesInsert(List<CjDataSourceTabColInfo> list) {
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


    @ApiOperation(value = "导入索引", notes = "List<EtuInfo> ", produces = "application/json")
    @PostMapping("/importIndex")
    public Result importIndex(@RequestBody List<EtuInfo> reqParmsEtu) {
        Result result = new Result();
        if (!reqParmsEtu.isEmpty()) {

            List<CjDataSourceUniqueIndexInfo> listModel = new ArrayList<>();

            for (EtuInfo etuEnt : reqParmsEtu) {
                Connection con = null;

                Statement st = null;

                ResultSet rs = null;

                CjDataSourceConnDefine connDefine = iCjDataSourceConnDefineService.selectDataBaseType(etuEnt.getBusinessSystemNameShortName(), etuEnt.getDataSourceSchema());

                try {
                    con = GroupPoolFactory.getInstance((etuEnt.getBusinessSystemNameShortName() + (connDefine.getDataBaseType().equals("sqlserver") ? etuEnt.getDataSourceSchema() : "-"))).getConnection();

                    if (con == null) {
                        continue;
                    }

                    st = con.createStatement();

                    String executeSql = reqSqlIndex(connDefine.getDataBaseType(), etuEnt);

                    rs = st.executeQuery(executeSql);

                    while (rs.next()) {

                        CjDataSourceUniqueIndexInfo model = new CjDataSourceUniqueIndexInfo();
                        model.setBusinessSystemId(connDefine.getBusinessSystemId());
                        model.setBusinessSystemNameShortName(etuEnt.getBusinessSystemNameShortName());
                        model.setDataSourceSchema(etuEnt.getDataSourceSchema());
                        model.setDataSourceTable(etuEnt.getDataSourceTable());
                        model.setUniqueIndexName(rs.getString("index_name"));
                        model.setDataSourceColName(rs.getString("column_name"));
                        model.setDataSourceColOrder(rs.getString("column_position"));
                        model.setLastModifyDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                        /*model.setLastModifyBy(rs.getString("data_source_schema"));*/
                        listModel.add(model);
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
            }

            if (cjDataSourceUniqueIndexInfoService.insertBatch(listModel) > 0) {
                result.success("");
            } else {
                result.error(200, "源库未新增表");
            }

        } else {
            result.error(500, "请选择数据");
        }
        return result;
    }


    /**
     * 获取sql
     *
     * @param dataBaseType
     * @return
     */
    private String reqSqlIndex(String dataBaseType, EtuInfo etuEnt) {
        String sql = "";
        if (dataBaseType.equals("mysql")) {
            sql = "SELECT " +
                    " tab1.table_schema as owner, " +
                    " tab1.table_name, " +
                    " tab1.index_name, " +
                    " tab1.column_name as column_name, " +
                    " tab1.seq_in_index as column_position " +
                    " from INFORMATION_SCHEMA.STATISTICS tab1 " +
                    " where tab1.non_unique=0 and tab1.table_schema='" + etuEnt.getDataSourceSchema() + "' " +
                    " and tab1.table_name='" + etuEnt.getDataSourceTable() + "' " +
                    " order by tab1.table_schema,tab1.table_name,tab1.seq_in_index;";
        } else if (dataBaseType.equals("sqlserver")) {
            sql = "SELECT '" + etuEnt.getDataSourceSchema() + "' AS owner, t4.name AS table_name,t1.name AS index_name,t3.name AS column_name,t3.colid AS column_position " +
                    "FROM sys.indexes t1 " +
                    "join sys.index_columns t2  " +
                    "on (t1.object_id=t2.object_id and t1.index_id=t2.index_id and t1.is_unique='true') " +
                    "join syscolumns t3  " +
                    "on (t3.id=t1.object_id and t3.colid=t2.column_id) " +
                    "join sys.sysobjects t4 " +
                    "on (t4.id=t1.object_id and t4.xtype='U') " +
                    "WHERE T4.NAME='" + etuEnt.getDataSourceTable() + "';";
        } else if (dataBaseType.equals("oracle")) {
            sql = "SELECT tab1.owner,tab1.table_name,tab1.index_name,tab2.column_name,tab2.column_position " +
                    "FROM all_indexes tab1 JOIN ALL_ind_columns tab2 " +
                    "ON (tab1.owner=tab2.INDEX_owner AND tab1.table_name=tab2.table_name " +
                    "AND tab1.uniqueness='UNIQUE' AND tab1.index_name=tab2.index_name) " +
                    "WHERE tab2.INDEX_owner='" + etuEnt.getDataSourceSchema() + "' AND tab2.table_name='" + etuEnt.getDataSourceTable() + "'" +
                    "ORDER BY tab1.owner,tab1.table_name,tab1.index_name,tab2.column_position;";
        }
        return sql;
    }





    @ApiOperation(value = "获取容量", notes = "List<EtuInfo> ", produces = "application/json")
    @PostMapping("/getCapacity")
    public Result getCapacity(@RequestBody List<EtuInfo> reqParmsEtu) {
        Result result = new Result();

        if (!reqParmsEtu.isEmpty()) {

            List<CjDataSourceTabRows> listModel = new ArrayList<>();

            for (EtuInfo etuEnt : reqParmsEtu) {
                Connection con = null;

                Statement st = null;

                ResultSet rs = null;

                CjDataSourceConnDefine connDefine = iCjDataSourceConnDefineService.selectDataBaseType(etuEnt.getBusinessSystemNameShortName(), etuEnt.getDataSourceSchema());

                try {
                    con = GroupPoolFactory.getInstance((etuEnt.getBusinessSystemNameShortName() + (connDefine.getDataBaseType().equals("sqlserver") ? etuEnt.getDataSourceSchema() : "-"))).getConnection();

                    if (con == null) {
                        continue;
                    }

                    st = con.createStatement();

                    String executeSql = reqSqlCapacity(connDefine.getDataBaseType(), etuEnt);

                    rs = st.executeQuery(executeSql);

                    while (rs.next()) {

                        CjDataSourceTabRows model = new CjDataSourceTabRows();
                        model.setBusinessSystemId(connDefine.getBusinessSystemId());
                        model.setBusinessSystemNameShortName(etuEnt.getBusinessSystemNameShortName());
                        model.setDataSourceSchema(etuEnt.getDataSourceSchema());
                        model.setDataSourceTable(etuEnt.getDataSourceTable());
                        model.setDataSourceTabRows(rs.getString("data_source_tab_rows"));
                        model.setDataSourceTabSizes(rs.getString("data_source_tab_sizes"));
                        model.setLastModifyDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                        /*model.setLastModifyBy(rs.getString("data_source_schema"));*/
                        listModel.add(model);
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
            }

            if (cjDataSourceTabRowsService.insertBatch(listModel) > 0) {
                result.success("");
            } else {
                result.error(200, "源库未新增表");
            }

        } else {
            result.error(500, "请选择数据");
        }


        return result;
    }



    /**
     * 获取sql
     *
     * @param dataBaseType
     * @return
     */
    private String reqSqlCapacity(String dataBaseType, EtuInfo etuEnt) {
        String sql = "";
        if (dataBaseType.equals("mysql")) {
            sql = "select  " +
                    "tab1.table_schema as data_source_schema, " +
                    "tab1.table_name as data_source_table, " +
                    "tab1.table_rows as data_source_tab_rows, " +
                    "ROUND(tab1.data_length/1024/1024,2) as data_source_tab_sizes " +
                    "from INFORMATION_SCHEMA.TABLES tab1 " +
                    "where tab1.table_type='base table'  " +
                    "and tab1.table_schema='"+etuEnt.getDataSourceSchema()+"' " +
                    "and tab1.table_name='"+etuEnt.getDataSourceTable()+"';";
        } else if (dataBaseType.equals("sqlserver")) {
            sql = "select  " +
                    "'"+etuEnt.getDataSourceSchema()+"' as data_source_schema, " +
                    "b.name as data_source_table, " +
                    "a.rows as data_source_tab_rows, " +
                    "convert(decimal(18,2),8*a.dpages/1024) as data_source_tab_sizes " +
                    "from sysindexes a inner join sysobjects b  " +
                    "on a.id = b.id " +
                    "where a.indid in (1,0) and b.type = 'u'  " +
                    "and b.name='"+etuEnt.getDataSourceTable()+"'";
        } else if (dataBaseType.equals("oracle")) {
            sql = "SELECT " +
                    "tab1.owner as data_source_schema, " +
                    "tab1.table_name as data_source_table, " +
                    "tab1.num_rows AS data_source_tab_rows, " +
                    "round((tab1.num_rows * tab1.avg_row_len)/1024/1024,2) " +
                    "FROM all_tables tab1 WHERE tab1.owner=UPPER('"+etuEnt.getDataSourceSchema()+"')  " +
                    "AND tab1.table_name=UPPER('"+etuEnt.getDataSourceTable()+"')";
        }
        return sql;
    }



}
