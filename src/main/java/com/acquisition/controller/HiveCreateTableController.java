package com.acquisition.controller;

import com.acquisition.entity.*;
import com.acquisition.entity.pojo.CjDwCrtDdlColPojo;
import com.acquisition.entity.pojo.TableOptionPojo;
import com.acquisition.service.*;
import com.acquisition.util.*;
import com.acquisition.util.Result;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yili.pool.pool.GroupPoolFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Api(tags = "hiveCreateTable", description = "hive建表")
@RestController
@RequestMapping(value = "/hiveCreateTable")
public class HiveCreateTableController {

    @Resource(name = "cjDataSourceConnDefineServiceImpl")
    public ICjDataSourceConnDefineService cjDataSourceConnDefineService;

    @Resource(name = "cjDataSourceTabColInfoServiceImpl")
    public ICjDataSourceTabColInfoService cjDataSourceTabColInfoService;

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    public ICjDataSourceTabInfoService cjDataSourceTabInfoService;

    @Resource(name = "cjOdsCrtTabDdlInfoServiceImpl")
    public ICjOdsCrtTabDdlInfoService cjOdsCrtTabDdlInfoService;

    @Resource(name = "cjDwCrtTabDdlInfoServiceImpl")
    public ICjDwCrtTabDdlInfoService cjDwCrtTabDdlInfoService;

    @Resource(name = "cjDataSourceTabRowsServiceImpl")
    public CjDataSourceTabRowsService cjDataSourceTabRowsService;

    @Resource(name = "cjDataSourceUniqueIndexInfoServiceImpl")
    public CjDataSourceUniqueIndexInfoService cjDataSourceUniqueIndexInfoService;

    @Resource(name = "cjOdsTableLoadModeInfoServiceImpl")
    public CjOdsTableLoadModeInfoService cjOdsTableLoadModeInfoService;

    @Resource(name = "cjOdsTableColInfoServiceImpl")
    public CjOdsTableColInfoService cjOdsTableColInfoService;

    /**
     * @Author: zhangdongmao
     * @Date: 2019/6/5
     * @Description: 获取DW建表页面筛选列表
     * @Param: * @param null 1
     * @return:
     */
    @ApiOperation("获取dw建表页面的筛选列表")
    @GetMapping(value = "/getDWSystemAndSchemaFilterList")
    public Result getDWSystemAndSchemaFilterList() {
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findDistSystemAndSchemaFromCjVGetPrepareCrtDwTabList();
        Set<String> systemSet = new HashSet<>();
        List<SystemSchemaFilterEntity> systemSchemaFilterEntities = new ArrayList<>();
        Result result = new Result();
        Map<String, List<String>> systemSchemaMap = new HashMap<>();
        for (CjDataSourceTabInfo cjDataSourceTabInfo : cjDataSourceTabInfos) {
            systemSet.add(cjDataSourceTabInfo.getBusinessSystemNameShortName());
        }
        Iterator<String> it = systemSet.iterator();
        while (it.hasNext()) {
            String str = it.next();
            systemSchemaMap.put(str, new ArrayList<>());
        }
        for (CjDataSourceTabInfo cjDataSourceTabInfo : cjDataSourceTabInfos) {
            systemSchemaMap.get(cjDataSourceTabInfo.getBusinessSystemNameShortName()).add(cjDataSourceTabInfo.getDataSourceSchema());
        }
        for (String key : systemSchemaMap.keySet()) {
            SystemSchemaFilterEntity systemSchemaFilterEntity = new SystemSchemaFilterEntity();
            systemSchemaFilterEntity.setBusinessSystemNameShortName(key);
            systemSchemaFilterEntity.setDataSourceSchemas(systemSchemaMap.get(key));
            systemSchemaFilterEntities.add(systemSchemaFilterEntity);
        }
        return result.success(systemSchemaFilterEntities);
    }

    /**
     * @Author: zhangdongmao
     * @Date: 2019/6/5
     * @Description: 获取ODS建表页面筛选列表
     * @Param: * @param null 1
     * @return:
     */
    @ApiOperation("获取ods建表页面的筛选列表")
    @GetMapping(value = "/getODSSystemAndSchemaFilterList")
    public Result getODSSystemAndSchemaFilterList() {
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findDistSystemAndSchemaFromCjVGetPrepareCrtOdsTabList();
        Set<String> systemSet = new HashSet<>();
        List<SystemSchemaFilterEntity> systemSchemaFilterEntities = new ArrayList<>();
        Result result = new Result();
        Map<String, List<String>> systemSchemaMap = new HashMap<>();
        for (CjDataSourceTabInfo cjDataSourceTabInfo : cjDataSourceTabInfos) {
            systemSet.add(cjDataSourceTabInfo.getBusinessSystemNameShortName());
        }
        Iterator<String> it = systemSet.iterator();
        while (it.hasNext()) {
            String str = it.next();
            systemSchemaMap.put(str, new ArrayList<>());
        }
        for (CjDataSourceTabInfo cjDataSourceTabInfo : cjDataSourceTabInfos) {
            systemSchemaMap.get(cjDataSourceTabInfo.getBusinessSystemNameShortName()).add(cjDataSourceTabInfo.getDataSourceSchema());
        }
        for (String key : systemSchemaMap.keySet()) {
            SystemSchemaFilterEntity systemSchemaFilterEntity = new SystemSchemaFilterEntity();
            systemSchemaFilterEntity.setBusinessSystemNameShortName(key);
            systemSchemaFilterEntity.setDataSourceSchemas(systemSchemaMap.get(key));
            systemSchemaFilterEntities.add(systemSchemaFilterEntity);
        }
        return result.success(systemSchemaFilterEntities);
    }

    /**
     * @Author: zhangdongmao
     * @Date: 2019/6/5
     * @Description: DW建表页面筛选查询
     * @Param: * @param null 1
     * @return:
     */
    @ApiOperation("dw建表页面按系统名和schema筛选接口")
    @PostMapping(value = "/getDWCreateTabListByFilter")
    public Result getDWCreateTabListByFilter(@RequestBody PageGeorge<List<String>> reqParams) {
        Result result = new Result();
        PageHelper.startPage(reqParams.getPagenum(), reqParams.getPagesize());
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findFromCjVGetPrepareCrtDwTabListBySystemAndSchema(reqParams.getQuery().get(0), reqParams.getQuery().get(1));
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(cjDataSourceTabInfos);
        result.setMsg("查询成功");
        return result.success(page);
    }

    /**
     * @Author: zhangdongmao
     * @Date: 2019/6/5
     * @Description: ODS建表页面筛选查询
     * @Param: * @param null 1
     * @return:
     */
    @ApiOperation("ODS建表页面按系统名和schema筛选接口")
    @PostMapping(value = "/getODSCreateTabListByFilter")
    public Result getODSCreateTabListByFilter(@RequestBody Page reqParams) {
        Result result = new Result();
        PageHelper.startPage(reqParams.getPagenum(), reqParams.getPagesize());
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findFromCjVGetPrepareCrtOdsTabListBySystemAndSchema(reqParams.getQuery().get(0), reqParams.getQuery().get(1));
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(cjDataSourceTabInfos);
        return result.success(page);
    }

    @ApiOperation("dw建表页面获取表清单接口")
    @GetMapping(value = "/getDWCreateTabList")
    public Result getDWCreateTabList(Page reqParams) {
        Result result = new Result();
        PageHelper.startPage(reqParams.getPagenum(), reqParams.getPagesize());
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService
                .findAllCjVGetPrepareCrtDwTabList();
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(cjDataSourceTabInfos);

        return result.success(page);
    }

    @ApiOperation("dw建表接口")
    @PostMapping(value = "/dWCreateTable")
    public Result dWCreateTable(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        data = jsonObject.getString("params");
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = JSONObject.parseArray(data, CjDataSourceTabInfo.class);
        String businessSystemNameShortName;
        String dataSourceSchema;
        String dataSourceTable;
        String dwTableName;
        String odsTableName = "";
        String colName;
        String colType;
        String colComment;
        Result result = new Result();
//        //遍历每张表，生成DW建表语句
        for (CjDataSourceTabInfo cjDataSourceTabInfo : cjDataSourceTabInfos) {
            businessSystemNameShortName = cjDataSourceTabInfo.getBusinessSystemNameShortName();
            dataSourceSchema = cjDataSourceTabInfo.getDataSourceSchema();
            dataSourceTable = cjDataSourceTabInfo.getDataSourceTable();
            odsTableName = CreateTableUtil.getOdsTableName(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
            dwTableName = CreateTableUtil.getDwTableName(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
            //使用StringBuffer拼接DW建表语句
            StringBuffer dwddl = new StringBuffer();
            dwddl.append("create external table if not exists " + Constant.DW_HIVE_SCHEMA + "." + dwTableName + "\n");
            dwddl.append("(" + "\n");
            //通过系统名、数据模式、表名获取表的字段信息
            List<CjDwCrtDdlColPojo> cjDwCrtDdlColPojos = cjDataSourceTabColInfoService.selectCjDwCrtDdlColPojoBySysAndSchemaAndTab(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
            for (int i = 0; i < cjDwCrtDdlColPojos.size(); i++) {
                colName = cjDwCrtDdlColPojos.get(i).getDataSourceColName().toLowerCase();
                colComment = cjDwCrtDdlColPojos.get(i).getDataSourceColComment();
                if (colComment == null) {
                    colComment = "";
                }
                //判断colName中是否包含中文，若包含，则colName转为全拼，源colName赋值给colComment
                Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
                Matcher m = p.matcher(colName);
                if (m.find()) {
                    colComment = colName;
                    colName = PinyinUtil.getPinYin(colName);
                }
                if (colName.equals("src_table_name")) {
                    colName = "src_table_name_dl";
                }
                colType = cjDwCrtDdlColPojos.get(i).getColMapper().toLowerCase();
                dwddl.append("    `" + colName + "`    " + colType + "    " + "comment \"" + colComment + "\"" + ",\n");
            }
            dwddl.append("    `src_sys_row_id`    string    comment \"源系统pk\",\n");
            dwddl.append("    `src_sys_cd`    string    comment \"源系统代码\",\n");
            dwddl.append("    `src_table_name`    string    comment \"源表名\",\n");
            dwddl.append("    `etl_dt`    string    comment \"etl处理时间\",\n");
            dwddl.append("    `data_dt`    string    comment \"数据日期\"\n");
            dwddl.append(")" + "\n");
            dwddl.append("row format delimited fields terminated by '\\001' lines terminated by '\\n' stored as orc");


            /**
             * 将dw建表语句存入mysql中
             */

            CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo = new CjDwCrtTabDdlInfo();
            cjDwCrtTabDdlInfo.setBusinessSystemId(cjDataSourceTabInfo.getBusinessSystemId());
            cjDwCrtTabDdlInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
            cjDwCrtTabDdlInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
            cjDwCrtTabDdlInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
            cjDwCrtTabDdlInfo.setOdsDataTable(odsTableName);
            cjDwCrtTabDdlInfo.setDwDataTable(dwTableName);
            cjDwCrtTabDdlInfo.setDwDataTableDdlInfo(dwddl.toString());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjDwCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
            GroupPoolFactory instance = GroupPoolFactory.getInstance("DATALAKE-");
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            try {
                connection = instance.getConnection();
                preparedStatement = connection.prepareStatement(dwddl.toString());
                preparedStatement.execute();
                cjDwCrtTabDdlInfoService.deleteByPrimaryKey(cjDwCrtTabDdlInfo);
                if (cjDwCrtTabDdlInfoService.save(cjDwCrtTabDdlInfo).equals("保存成功")) {
                    //生成DW建表语句成功，设置状态表中的相应状态字段
                    cjDataSourceTabInfo.setDataFlagForCrtDwDll(Constant.DW_CRT_DDL);
                    cjDataSourceTabInfo.setDataFlagForCrtDwHive(Constant.DW_CRT_HIVE);
                    //将状态改变更新到数据库
                    CjDataSourceTabInfoExample cjDataSourceTabInfoExample = new CjDataSourceTabInfoExample();
                    CjDataSourceTabInfoExample.Criteria criteria = cjDataSourceTabInfoExample.createCriteria();
                    //where条件使用业务系统缩写、数据模式和表名做限制
                    criteria.andBusinessSystemNameShortNameEqualTo(businessSystemNameShortName);
                    criteria.andDataSourceSchemaEqualTo(dataSourceSchema);
                    criteria.andDataSourceTableEqualTo(dataSourceTable);
                    cjDataSourceTabInfoService.updateByExampleSelective(cjDataSourceTabInfo, cjDataSourceTabInfoExample);
                }
                dwddl.setLength(0);
            } catch (Exception e) {
                e.printStackTrace();
                dwddl.setLength(0);
                return result.error(500, "建表失败");
            } finally {
                if (connection != null) {
                    try {
                        preparedStatement.close();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        result.setCode(200);
        result.setMsg("建表成功");
        return result;
    }

    /**
     * @return 返回已经导入清单，但没有在ODS建表的表
     */
    @ApiOperation("ods建表页面获取表清单接口")
    @RequestMapping(value = "/getODSTableInfo", method = RequestMethod.GET)
    @ResponseBody
    public Result getODSTable(PageGeorge reqParams) {
        Result result = new Result();
        PageHelper.startPage(reqParams.getPagenum(), reqParams.getPagesize());
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findAllByColsAndOds();
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(cjDataSourceTabInfos);
        return result.success(page);
    }


    @ApiOperation(value = "判断ODS抽取策略和分区字段")
    @PostMapping("/getODSLoadMode")
    public Result getODSLoadMode(@RequestBody List<CjDataSourceTabInfo> cjDataSourceTabInfos) {
        Result result = new Result();
        List<CjOdsTableLoadModeInfo> cjOdsTableLoadModeInfos = new ArrayList<>();
        CjDataSourceConnDefine cjDataSourceConnDefine;
        String odsTableName;
        for (CjDataSourceTabInfo cjDataSourceTabInfo : cjDataSourceTabInfos) {
            String businessSystemId;
            if (cjDataSourceTabInfo.getBusinessSystemId() == null) {
                cjDataSourceConnDefine = cjDataSourceConnDefineService.selectDataBaseType(cjDataSourceTabInfo.getBusinessSystemNameShortName(), cjDataSourceTabInfo.getDataSourceSchema());
                businessSystemId = cjDataSourceConnDefine.getBusinessSystemId();
            } else {
                businessSystemId = cjDataSourceTabInfo.getBusinessSystemId();
            }
            CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo = new CjOdsTableLoadModeInfo();
            String businessSystemNameShortName = cjDataSourceTabInfo.getBusinessSystemNameShortName();
            String dataSourceSchema = cjDataSourceTabInfo.getDataSourceSchema();
            String dataSourceTable = cjDataSourceTabInfo.getDataSourceTable();
            odsTableName=CreateTableUtil.getOdsTableName(businessSystemNameShortName,dataSourceSchema,dataSourceTable);
            cjOdsTableLoadModeInfo.setBusinessSystemId(businessSystemId);
            cjOdsTableLoadModeInfo.setBusinessSystemNameShortName(businessSystemNameShortName);
            cjOdsTableLoadModeInfo.setDataSourceSchema(dataSourceSchema);
            cjOdsTableLoadModeInfo.setOdsDataSchema(Constant.ODS_HIVE_FULL_SCHEMA);
            cjOdsTableLoadModeInfo.setOdsDataTable(odsTableName);
            cjOdsTableLoadModeInfo.setDataSourceTable(dataSourceTable);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjOdsTableLoadModeInfo.setLastModifyDt(df.format(new Date()));
            Integer tableSize = cjDataSourceTabRowsService.findTabSizeBytable(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
            if (tableSize >= Constant.ODS_INCREMENT_TABLE_SIZE) {
                List<CjDataSourceTabColInfo> incrementCols = cjDataSourceTabColInfoService.findIncrementCol(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
                if (incrementCols != null && incrementCols.size() > 0) {

                    //查询表的唯一索引
                    List<CjDataSourceUniqueIndexInfo> uniqueIndexs = cjDataSourceUniqueIndexInfoService.findUniqueIndexByTable(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
                    if (uniqueIndexs != null && uniqueIndexs.size() > 0) {
                        MultiValueMap<String, String> uniqueIndexMap = new LinkedMultiValueMap();
                        for (CjDataSourceUniqueIndexInfo cjDataSourceUniqueIndexInfo : uniqueIndexs) {
                            uniqueIndexMap.add(cjDataSourceUniqueIndexInfo.getUniqueIndexName(), cjDataSourceUniqueIndexInfo.getDataSourceColName());
                        }
                        Set<String> keySet = uniqueIndexMap.keySet();
                        int size = 100;
                        String indexKey = "";
                        //唯一索引可能是由多个字段联合组成的，取字段个数最少的联合唯一索引作为ODS表的唯一索引
                        for (String key : keySet) {
                            if (size > uniqueIndexMap.get(key).size()) {
                                size = uniqueIndexMap.get(key).size();
                                indexKey = key;
                            }
                        }
                        List<String> indexs = uniqueIndexMap.get(indexKey);
                        String index = String.join(",", indexs);

                        //满足所有的增量条件，定义为增量方式抽取
                        cjOdsTableLoadModeInfo.setOdsDataLoadMode(Constant.ODS_INCREMENT_EXTRACT);
                        //取list中的第一个值做增量字段
                        cjOdsTableLoadModeInfo.setOdsTableIncrementColName(incrementCols.get(0).getDataSourceColName());
                        //设置唯一索引
                        cjOdsTableLoadModeInfo.setOdsTablePrimaryColName(index);
                        //获取表的分区字段
                        List<CjDataSourceTabColInfo> partitionKeys = cjDataSourceTabColInfoService.findPartitionKey(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
                        if (partitionKeys != null && partitionKeys.size() > 0) {
                            cjOdsTableLoadModeInfo.setOdsTablePartitionColName(Constant.ODS_PARTITION_KEY);
                            cjOdsTableLoadModeInfo.setOdsTablePartitionUnit(Constant.ODS_PARTITION_UNIT);
                            cjOdsTableLoadModeInfo.setOdsTablePartitionColNameSource(partitionKeys.get(0).getDataSourceColName());
                        }
                        //获取切割字段，可能不带索引
                        List<String> splictColWithIndex = cjDataSourceTabColInfoService.findSplictColWithIndex(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
                        if (splictColWithIndex != null && splictColWithIndex.size() > 0) {
                            cjOdsTableLoadModeInfo.setOdsTableSplitColName(splictColWithIndex.get(0));
                        } else {
                            List<String> splictColNoIndex = cjDataSourceTabColInfoService.findSplictColNoIndex(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
                            if (splictColNoIndex != null && splictColNoIndex.size() > 0) {
                                cjOdsTableLoadModeInfo.setOdsTableSplitColName(splictColNoIndex.get(0));
                            }
                        }
                    } else {
                        //无索引，抽取方式为全量
                        cjOdsTableLoadModeInfo.setOdsDataLoadMode(Constant.ODS_FULL_EXTRACT);
                    }
                } else {
                    //无增量字段，抽取方式为全量
                    cjOdsTableLoadModeInfo.setOdsDataLoadMode(Constant.ODS_FULL_EXTRACT);
                }
            } else {
                // 表大小小于2G，抽取方式为全量，无分区
                cjOdsTableLoadModeInfo.setOdsDataLoadMode(Constant.ODS_FULL_EXTRACT);
            }
            cjOdsTableLoadModeInfos.add(cjOdsTableLoadModeInfo);
        }
//        for (CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo:cjOdsTableLoadModeInfos){
//            System.out.println(cjOdsTableLoadModeInfo.getDataSourceTable()+"-------------asdfasdfasf");
//        }
        if (cjOdsTableLoadModeInfoService.insertBatch(cjOdsTableLoadModeInfos) > 0) {
            result.setCode(200);
            result.setMsg("定义ODS加载策略成功");
        } else {
            result.setCode(500);
            result.setMsg("定义ODS加载策略失败");
        }
        return result;
    }

    /**
     * @return 获取前端传来的需要去ODS创建的表信息
     */
    @ApiOperation("ods建表接口")
    @PostMapping("/createODSTable")
    public Result createODSTable(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("params");
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = JSONObject.parseArray(odsTableList, CjDataSourceTabInfo.class);
        List<CjOdsCrtTabDdlInfo> cjOdsCrtTabDdlInfos = saveOdsTableInfos(cjDataSourceTabInfos);
        List<TableOptionPojo> tableOptionPojos = hiveCreateTableBatch(cjOdsCrtTabDdlInfos);
        for (TableOptionPojo tableOptionPojo : tableOptionPojos) {
            if (tableOptionPojo.getResult().equals(Constant.TABLE_OPTION_SUCCESS)){
                cjDataSourceTabInfoService.updateODSFlg(
                        "1", "1",
                        tableOptionPojo.getBusinessSystemNameShortName(),
                        tableOptionPojo.getDataSourceSchema(),
                        tableOptionPojo.getDataSourceTable());
            }
        }


        return new Result().success(tableOptionPojos);
    }

    /**
     * @return 拼接并保存SQL, 返回状态码
     */
    public List<CjOdsCrtTabDdlInfo> saveOdsTableInfos(List<CjDataSourceTabInfo> cjDataSourceTabInfos) {
        String businessSystemId;
        String odsFullDdl = "";
        String odsIncrementDdl = "";
        List<CjOdsCrtTabDdlInfo> cjOdsCrtTabDdlInfos = new ArrayList<>();

        //遍历从前端获取到表的列表，拼接字段，创建 Hive DDL
        for (CjDataSourceTabInfo cjDataSourceTabInfo : cjDataSourceTabInfos) {
            String businessSystemNameShortName = cjDataSourceTabInfo.getBusinessSystemNameShortName();
            String dataSourceSchema = cjDataSourceTabInfo.getDataSourceSchema();
            String dataSourceTable = cjDataSourceTabInfo.getDataSourceTable();
            //拼接ODS表名
            String odsTableName = businessSystemNameShortName.toLowerCase() + "_" + dataSourceSchema.toLowerCase() + "_" + dataSourceTable.toLowerCase();

            //查询该表的ODS加载策略
            CjOdsTableLoadModeInfoKey cjOdsTableLoadModeInfoKey = new CjOdsTableLoadModeInfo();
            cjOdsTableLoadModeInfoKey.setBusinessSystemNameShortName(businessSystemNameShortName);
            cjOdsTableLoadModeInfoKey.setDataSourceSchema(dataSourceSchema);
            cjOdsTableLoadModeInfoKey.setDataSourceTable(dataSourceTable);
            cjOdsTableLoadModeInfoKey.setOdsDataTable(odsTableName);
            CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo = cjOdsTableLoadModeInfoService.findByPrimaryKey(cjOdsTableLoadModeInfoKey);

            if(cjOdsTableLoadModeInfo.getOdsDataLoadMode().equals(Constant.ODS_INCREMENT_EXTRACT)){
                //如果是增量抽取，生成ODS全量表和增量表建表
                odsFullDdl = generateOdsFullDdl(cjOdsTableLoadModeInfo);
                odsIncrementDdl = generateOdsIncrementDdl(cjOdsTableLoadModeInfo);
            } else if(cjOdsTableLoadModeInfo.getOdsDataLoadMode().equals(Constant.ODS_FULL_EXTRACT)){
                //如果是增量抽取，生成ODS全量表和增量表建表
                odsFullDdl = generateOdsFullDdl(cjOdsTableLoadModeInfo);
            }

            if (cjDataSourceTabInfo.getBusinessSystemId() == null) {
                CjDataSourceConnDefine cjDataSourceConnDefine = cjDataSourceConnDefineService.selectDataBaseType(cjDataSourceTabInfo.getBusinessSystemNameShortName(), cjDataSourceTabInfo.getDataSourceSchema());
                businessSystemId = cjDataSourceConnDefine.getBusinessSystemId();
            } else {
                businessSystemId = cjDataSourceTabInfo.getBusinessSystemId();
            }
            CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo = new CjOdsCrtTabDdlInfo();
            cjOdsCrtTabDdlInfo.setBusinessSystemId(businessSystemId);
            cjOdsCrtTabDdlInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
            cjOdsCrtTabDdlInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
            cjOdsCrtTabDdlInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
            cjOdsCrtTabDdlInfo.setOdsDataSchema(Constant.ODS_HIVE_FULL_SCHEMA);
            cjOdsCrtTabDdlInfo.setOdsDataTable(odsTableName);
            cjOdsCrtTabDdlInfo.setOdsDataTableDdlInfo(odsFullDdl);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjOdsCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));

            cjOdsCrtTabDdlInfos.add(cjOdsCrtTabDdlInfo);
            if(!odsIncrementDdl.equals("")){
                CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfoInc = new CjOdsCrtTabDdlInfo();
                cjOdsCrtTabDdlInfoInc.setBusinessSystemId(businessSystemId);
                cjOdsCrtTabDdlInfoInc.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
                cjOdsCrtTabDdlInfoInc.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
                cjOdsCrtTabDdlInfoInc.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
                cjOdsCrtTabDdlInfoInc.setOdsDataSchema(Constant.ODS_HIVE_INCREMENT_SCHEMA);
                cjOdsCrtTabDdlInfoInc.setOdsDataTable(odsTableName);
                cjOdsCrtTabDdlInfoInc.setOdsDataTableDdlInfo(odsIncrementDdl);
                cjOdsCrtTabDdlInfoInc.setLastModifyDt(df.format(new Date()));
                cjOdsCrtTabDdlInfos.add(cjOdsCrtTabDdlInfoInc);
                odsIncrementDdl = "";
            }

        }
        cjOdsCrtTabDdlInfoService.insertBatch(cjOdsCrtTabDdlInfos);
        return cjOdsCrtTabDdlInfos;
    }

    public String generateOdsFullDdl(CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo) {
        StringBuffer odsDDL = new StringBuffer();
        String odsTableComment = "";
        List<CjOdsTableColInfo> cjOdsTableColInfos = new ArrayList<>();

        //开始拼接ods建表语句
        odsDDL.append("create external table if not exists " + Constant.ODS_HIVE_FULL_SCHEMA + "." + cjOdsTableLoadModeInfo.getOdsDataTable() + "\n");
        odsDDL.append("(" + "\n");

        List<CjDataSourceTabColInfo> infoList = cjDataSourceTabColInfoService
                .findBySystemAndSchemaAndTab(cjOdsTableLoadModeInfo.getBusinessSystemNameShortName(),
                        cjOdsTableLoadModeInfo.getDataSourceSchema(),
                        cjOdsTableLoadModeInfo.getDataSourceTable());
        for (int i = 0; i < infoList.size(); i++) {
            odsTableComment = infoList.get(i).getDataSourceTableComment();
            CjOdsTableColInfo cjOdsTableColInfo = new CjOdsTableColInfo();
            BeanUtils.copyProperties(infoList.get(i), cjOdsTableColInfo);
            cjOdsTableColInfo.setOdsDataSchema(Constant.ODS_HIVE_FULL_SCHEMA);
            cjOdsTableColInfo.setOdsTableComment(odsTableComment);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjOdsTableColInfo.setLastModifyDt(df.format(new Date()));
            cjOdsTableColInfo.setOdsDataTable(cjOdsTableLoadModeInfo.getOdsDataTable());
            String colName = infoList.get(i).getDataSourceColName().toLowerCase();
            String colComment = infoList.get(i).getDataSourceColComment();
            if (colComment == null) {
                colComment = "";
            }
            //判断colName中是否包含中文，若包含，则colName转为全拼，源colName赋值给colComment
            Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
            Matcher m = p.matcher(colName);
            if (m.find()) {
                colComment = colName;
                colName = PinyinUtil.getPinYin(colName);
            }
            cjOdsTableColInfo.setOdsTableColName(colName);
            cjOdsTableColInfo.setOdsTableColComment(colComment);
            cjOdsTableColInfo.setOdsTableColType(Constant.ODS_COL_TYPE);
            cjOdsTableColInfo.setOdsTableColOrder(infoList.get(i).getDataSourceColOrder());
            odsDDL.append("    `" + colName + "`    " + Constant.ODS_COL_TYPE + "    " + "comment \"" + colComment + "\"" + ",\n");
            cjOdsTableColInfos.add(cjOdsTableColInfo);
        }
        odsDDL.append("    etl_dt    string    comment \"ETL时间\"\n");
        odsDDL.append(")" + "\n");
        //如果该表加载策略中有分区字段，则生成建表语句时加入分区
        if (cjOdsTableLoadModeInfo.getOdsTablePartitionColName() != null) {
            odsDDL.append("partitioned by (" + cjOdsTableLoadModeInfo.getOdsTablePartitionColName() + " string)\n");
            CjOdsTableColInfo cjOdsTableColInfo = new CjOdsTableColInfo();
            cjOdsTableColInfo.setBusinessSystemId(cjOdsTableLoadModeInfo.getBusinessSystemId());
            cjOdsTableColInfo.setBusinessSystemNameShortName(cjOdsTableLoadModeInfo.getBusinessSystemNameShortName());
            cjOdsTableColInfo.setDataSourceSchema(cjOdsTableLoadModeInfo.getDataSourceSchema());
            cjOdsTableColInfo.setDataSourceTable(cjOdsTableLoadModeInfo.getDataSourceTable());
            cjOdsTableColInfo.setOdsDataSchema(Constant.ODS_HIVE_FULL_SCHEMA);
            cjOdsTableColInfo.setOdsDataTable(cjOdsTableLoadModeInfo.getOdsDataTable());
            cjOdsTableColInfo.setOdsTableComment(odsTableComment);
            cjOdsTableColInfo.setOdsTableColName(cjOdsTableLoadModeInfo.getOdsTablePartitionColName());
            cjOdsTableColInfo.setOdsTableColType(Constant.ODS_COL_TYPE);
            cjOdsTableColInfo.setOdsTableColComment("分区字段");
            cjOdsTableColInfo.setOdsTableColOrder(infoList.size() + 1 + "");
            cjOdsTableColInfo.setOdsTablePartitionFlag("1");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjOdsTableColInfo.setLastModifyDt(df.format(new Date()));
            cjOdsTableColInfos.add(cjOdsTableColInfo);
        }
        odsDDL.append("row format delimited fields terminated by '\\001' lines terminated by '\\n'");
        //保存ODS抽取的字段
        if (cjOdsTableColInfos.size() > 0) {
            cjOdsTableColInfoService.insertBatch(cjOdsTableColInfos);
        }
        return odsDDL.toString();
    }

    public String generateOdsIncrementDdl(CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo) {
        StringBuffer odsDDL = new StringBuffer();

        //开始拼接ods建表语句
        odsDDL.append("create external table if not exists " + Constant.ODS_HIVE_INCREMENT_SCHEMA + "." + cjOdsTableLoadModeInfo.getOdsDataTable() + "\n");
        odsDDL.append("(" + "\n");

        List<CjDataSourceTabColInfo> infoList = cjDataSourceTabColInfoService
                .findBySystemAndSchemaAndTab(cjOdsTableLoadModeInfo.getBusinessSystemNameShortName(),
                        cjOdsTableLoadModeInfo.getDataSourceSchema(),
                        cjOdsTableLoadModeInfo.getDataSourceTable());
        for (int i = 0; i < infoList.size(); i++) {
            String colName = infoList.get(i).getDataSourceColName().toLowerCase();
            String colComment = infoList.get(i).getDataSourceColComment();
            if (colComment == null) {
                colComment = "";
            }
            //判断colName中是否包含中文，若包含，则colName转为全拼，源colName赋值给colComment
            Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
            Matcher m = p.matcher(colName);
            if (m.find()) {
                colComment = colName;
                colName = PinyinUtil.getPinYin(colName);
            }
            odsDDL.append("    `" + colName + "`    " + Constant.ODS_COL_TYPE + "    " + "comment \"" + colComment + "\"" + ",\n");
        }

        odsDDL.append("    etl_dt    string    comment \"ETL时间\"\n");
        odsDDL.append(")" + "\n");
        odsDDL.append("partitioned by (" + Constant.ODS_PARTITION_KEY + " string)\n");
        odsDDL.append("row format delimited fields terminated by '\\001' lines terminated by '\\n'");
        return odsDDL.toString();
    }


    public List<TableOptionPojo> hiveCreateTableBatch(List<CjOdsCrtTabDdlInfo> cjOdsCrtTabDdlInfos) {
        GroupPoolFactory instance = GroupPoolFactory.getInstance("DATALAKE-");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        TableOptionPojo tableOptionPojo = null;
        List<TableOptionPojo> tableOptionPojos = new ArrayList<>();

        for (CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo : cjOdsCrtTabDdlInfos) {
            try {
                connection = instance.getConnection();
                preparedStatement = connection.prepareStatement(cjOdsCrtTabDdlInfo.getOdsDataTableDdlInfo());
                tableOptionPojo = new TableOptionPojo();
                tableOptionPojo.setBusinessSystemNameShortName(cjOdsCrtTabDdlInfo.getBusinessSystemNameShortName());
                tableOptionPojo.setDataSourceSchema(cjOdsCrtTabDdlInfo.getDataSourceSchema());
                tableOptionPojo.setDataSourceTable(cjOdsCrtTabDdlInfo.getDataSourceTable());
                tableOptionPojo.setOdsDataSchema(cjOdsCrtTabDdlInfo.getOdsDataSchema());
                preparedStatement.execute();
                tableOptionPojo.setResult(Constant.TABLE_OPTION_SUCCESS);
            } catch (Exception e) {
                tableOptionPojo.setResult(Constant.TABLE_OPTION_FAILED);
            } finally {
                if (connection != null) {
                    try {
                        preparedStatement.close();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            tableOptionPojos.add(tableOptionPojo);
        }
        return tableOptionPojos;
    }

}
