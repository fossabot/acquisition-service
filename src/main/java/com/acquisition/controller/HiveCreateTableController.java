package com.acquisition.controller;

import com.acquisition.entity.*;
import com.acquisition.entity.dto.CjDataSourceTabInfoDto;
import com.acquisition.entity.dto.CjDwCrtTabDdlInfoDto;
import com.acquisition.entity.dto.CjDwTableColInfoDto;
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
    public CjDwCrtTabDdlInfoService cjDwCrtTabDdlInfoService;

    @Resource(name = "cjDataSourceTabRowsServiceImpl")
    public CjDataSourceTabRowsService cjDataSourceTabRowsService;

    @Resource(name = "cjDataSourceUniqueIndexInfoServiceImpl")
    public CjDataSourceUniqueIndexInfoService cjDataSourceUniqueIndexInfoService;

    @Resource(name = "cjOdsTableLoadModeInfoServiceImpl")
    public CjOdsTableLoadModeInfoService cjOdsTableLoadModeInfoService;

    @Resource(name = "cjOdsTableColInfoServiceImpl")
    public CjOdsTableColInfoService cjOdsTableColInfoService;

    @Resource(name = "cjDwTableColInfoServiceImpl")
    public CjDwTableColInfoService cjDwTableColInfoService;

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

    @ApiOperation("dw备用区建表接口")
    @PostMapping(value = "/dWCreateTable")
    public Result dWCreateTable(@RequestBody String data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("建表成功");
        JSONObject jsonObject = JSONObject.parseObject(data);
        data = jsonObject.getString("params");
        List<CjDataSourceTabInfoDto> cjDataSourceTabInfoDtos = JSONObject.parseArray(data, CjDataSourceTabInfoDto.class);
        List<CjDwCrtTabDdlInfoDto> cjDwCrtTabDdlInfoDtos = saveDwBakTableInfos(cjDataSourceTabInfoDtos);
        List<TableOptionPojo> tableOptionPojos = hiveCreateDwBakTableBatch(cjDwCrtTabDdlInfoDtos);

        for (TableOptionPojo tableOptionPojo : tableOptionPojos) {
            if (tableOptionPojo.getResult().equals(Constant.TABLE_OPTION_SUCCESS)) {
                CjDataSourceTabInfo cjDataSourceTabInfo = new CjDataSourceTabInfo();
//                生成DW建表语句成功，设置状态表中的相应状态字段
                cjDataSourceTabInfo.setDataFlagForCrtDwDll(Constant.DW_CRT_DDL);
                cjDataSourceTabInfo.setDataFlagForCrtDwHive(Constant.DW_CRT_HIVE);
                //将状态改变更新到数据库
                CjDataSourceTabInfoExample cjDataSourceTabInfoExample = new CjDataSourceTabInfoExample();
                CjDataSourceTabInfoExample.Criteria criteria = cjDataSourceTabInfoExample.createCriteria();
                //where条件使用业务系统缩写、数据模式和表名做限制
                criteria.andBusinessSystemNameShortNameEqualTo(tableOptionPojo.getBusinessSystemNameShortName());
                criteria.andDataSourceSchemaEqualTo(tableOptionPojo.getDataSourceSchema());
                criteria.andDataSourceTableEqualTo(tableOptionPojo.getDataSourceTable());
                cjDataSourceTabInfoService.updateByExampleSelective(cjDataSourceTabInfo, cjDataSourceTabInfoExample);
            } else if (tableOptionPojo.getResult().equals(Constant.TABLE_OPTION_FAILED) || tableOptionPojo.getResult().equals(Constant.TABLE_OPTION_AVAIL)) {
                result.setCode(500);
                result.setMsg("部分表建表失败");
            }
        }
        result.setData(tableOptionPojos);
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
            odsTableName = CreateTableUtil.getOdsTableName(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
            cjOdsTableLoadModeInfo.setBusinessSystemId(businessSystemId);
            cjOdsTableLoadModeInfo.setBusinessSystemNameShortName(businessSystemNameShortName);
            cjOdsTableLoadModeInfo.setDataSourceSchema(dataSourceSchema);
            cjOdsTableLoadModeInfo.setOdsDataSchema(Constant.ODS_HIVE_FULL_SCHEMA);
            cjOdsTableLoadModeInfo.setOdsDataTable(odsTableName);
            cjOdsTableLoadModeInfo.setDataSourceTable(dataSourceTable);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjOdsTableLoadModeInfo.setLastModifyDt(df.format(new Date()));

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

            Integer tableSize = cjDataSourceTabRowsService.findTabSizeBytable(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
            if (tableSize >= Constant.ODS_INCREMENT_TABLE_SIZE) {
                List<CjDataSourceTabColInfo> incrementCols = cjDataSourceTabColInfoService.findIncrementCol(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
                if (incrementCols != null && incrementCols.size() > 0) {

                    //查询表的唯一索引
                    List<CjDataSourceUniqueIndexInfo> uniqueIndexs = cjDataSourceUniqueIndexInfoService.findUniqueIndexByTable(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
                    if (uniqueIndexs != null && uniqueIndexs.size() > 0) {
                        MultiValueMap<String, List<String>> uniqueIndexMap = new LinkedMultiValueMap();
                        for (CjDataSourceUniqueIndexInfo cjDataSourceUniqueIndexInfo : uniqueIndexs) {
                            List<String> uniqueIndexList = new ArrayList<>();
                            uniqueIndexList.add(cjDataSourceUniqueIndexInfo.getDataSourceColName());
                            uniqueIndexList.add(cjDataSourceUniqueIndexInfo.getDataSourceColOrder());
                            System.out.println(cjDataSourceUniqueIndexInfo.getDataSourceColOrder());
                            uniqueIndexMap.add(cjDataSourceUniqueIndexInfo.getUniqueIndexName(), uniqueIndexList);
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
                        List<List<String>> indexs = uniqueIndexMap.get(indexKey);
                        StringBuffer index = new StringBuffer();
                        StringBuffer indexSeq = new StringBuffer();
                        for (List<String> indexList : indexs) {
                            index.append(indexList.get(0) + ",");
                            indexSeq.append(indexList.get(1) + ",");
                        }
                        index.deleteCharAt(index.length() - 1);
                        indexSeq.deleteCharAt(index.length() - 1);
                        //满足所有的增量条件，定义为增量方式抽取
                        cjOdsTableLoadModeInfo.setOdsDataLoadMode(Constant.ODS_INCREMENT_EXTRACT);
                        //取list中的第一个值做增量字段
                        cjOdsTableLoadModeInfo.setOdsTableIncrementColName(incrementCols.get(0).getDataSourceColName());
                        //设置唯一索引
                        cjOdsTableLoadModeInfo.setOdsTablePrimaryColName(index.toString());
                        cjOdsTableLoadModeInfo.setOdsTablePrimaryColSeqStr(indexSeq.toString());
                        //获取表的分区字段
                        List<CjDataSourceTabColInfo> partitionKeys = cjDataSourceTabColInfoService.findPartitionKey(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
                        if (partitionKeys != null && partitionKeys.size() > 0) {
                            cjOdsTableLoadModeInfo.setOdsTablePartitionColName(Constant.ODS_PARTITION_KEY);
                            cjOdsTableLoadModeInfo.setOdsTablePartitionUnit(Constant.ODS_PARTITION_UNIT);
                            cjOdsTableLoadModeInfo.setOdsTablePartitionColNameSource(partitionKeys.get(0).getDataSourceColName());
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
     * 将 ODS 建表语句保存到数据库中
     *
     * @param data eg:[{
     *             "businessSystemNameShortName": "MLGX",
     *             "dataSourceSchema": "datalake_meta",
     *             "dataSourceTable": "cj_import_source_tab_list"
     *             }]
     * @return 返回包含ODS DDL的CjDataSourceTabInfo对象
     */
    @ApiOperation("保存ODS DDL")
    @PostMapping(value = "/saveOdsDdlInfo")
    public Result saveOdsDdlInfo(@RequestBody String data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("建表成功");
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("params");
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = JSONObject.parseArray(odsTableList, CjDataSourceTabInfo.class);
        result.setData(saveOdsTableInfos(cjDataSourceTabInfos));
        result.setCode(200);
        return result;
    }

    /**
     * 执行建ODS表语句并更新建表状态
     *
     * @param params eg: [{
     *                   "businessSystemNameShortName": "MLGX",
     *                   "dataSourceSchema": "datalake_meta",
     *                   "dataSourceTable": "cj_import_source_tab_list"
     *                  }]
     * @return 返回执行状态
     */
    @ApiOperation("执行ODS建表语句")
    @PostMapping(value = "/createOdsTable")
    public Result createOdsTable(@RequestBody List<CjOdsCrtTabDdlInfo> params) {
        Result result = new Result();

        for (CjOdsCrtTabDdlInfo param : params) {
            List<CjOdsCrtTabDdlInfo> ddlInfosList = cjOdsCrtTabDdlInfoService.selectByParams(
                    param.getBusinessSystemNameShortName(),
                    param.getDataSourceSchema(),
                    param.getDataSourceTable(),
                    CreateTableUtil.getOdsTableName(param.getBusinessSystemNameShortName(), param.getDataSourceSchema(), param.getDataSourceTable())
            );

            List<TableOptionPojo> tableOptionPojos = hiveCreateOdsTableBatch(ddlInfosList);

            for (TableOptionPojo tableOptionPojo : tableOptionPojos) {
                if (tableOptionPojo.getResult().equals(Constant.TABLE_OPTION_SUCCESS)) {
                    cjDataSourceTabInfoService.updateODSFlg(
                            "1", "1",
                            tableOptionPojo.getBusinessSystemNameShortName(),
                            tableOptionPojo.getDataSourceSchema(),
                            tableOptionPojo.getDataSourceTable());
                } else if (tableOptionPojo.getResult().equals(Constant.TABLE_OPTION_FAILED)) {
                    result.setCode(500);
                    result.setMsg("建表状态更新失败，请重新建表！");
                }
            }
        }
        result.setData("ODS表建表成功");
        result.setCode(200);
        return result;
    }

    /**
     * 执行生成的ODS DDL ，去 Hive 中建表
     *
     * @param cjOdsCrtTabDdlInfos 传入CjOdsCrtTabDdlInfo实体列表
     * @return 返回 tableOptionPojos
     */
    public List<TableOptionPojo> hiveCreateOdsTableBatch(List<CjOdsCrtTabDdlInfo> cjOdsCrtTabDdlInfos) {
        GroupPoolFactory instance = GroupPoolFactory.getInstance(Constant.HIVE_INSTANCE);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        TableOptionPojo tableOptionPojo;
        List<TableOptionPojo> tableOptionPojos = new ArrayList<>();

        for (CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo : cjOdsCrtTabDdlInfos) {
            tableOptionPojo = new TableOptionPojo();
            tableOptionPojo.setBusinessSystemNameShortName(cjOdsCrtTabDdlInfo.getBusinessSystemNameShortName());
            tableOptionPojo.setDataSourceSchema(cjOdsCrtTabDdlInfo.getDataSourceSchema());
            tableOptionPojo.setDataSourceTable(cjOdsCrtTabDdlInfo.getDataSourceTable());
            tableOptionPojo.setOdsDataSchema(cjOdsCrtTabDdlInfo.getOdsDataSchema());
            tableOptionPojo.setResult(Constant.TABLE_OPTION_SUCCESS);
            String[] odsDdl = cjOdsCrtTabDdlInfo.getOdsDataTableDdlInfo().split(";");
            for (int i = 0; i < odsDdl.length; i++) {
                try {
                    connection = instance.getConnection();
                    preparedStatement = connection.prepareStatement(odsDdl[i]);
                    preparedStatement.execute();
                } catch (Exception e) {
                    tableOptionPojo.setResult(Constant.TABLE_OPTION_FAILED);
                    e.printStackTrace();
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
            tableOptionPojos.add(tableOptionPojo);
        }
        return tableOptionPojos;
    }

    /**
     * @return 拼接并保存SQL, 返回状态码
     */
    public List<CjOdsCrtTabDdlInfo> saveOdsTableInfos(List<CjDataSourceTabInfo> cjDataSourceTabInfos) {
        String businessSystemId;
        String odsFullDdl = "";
        String odsIncrementDdl = "";
        String odsTmpDdl = "";
        String odsDdl = "";
        List<CjOdsCrtTabDdlInfo> cjOdsCrtTabDdlInfos = new ArrayList<>();
        List<CjOdsCrtTabDdlInfo> hiveCrtTabDdlInfos = new ArrayList<>();

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

            if (cjOdsTableLoadModeInfo.getOdsDataLoadMode().equals(Constant.ODS_INCREMENT_EXTRACT)) {
                //如果是增量抽取，生成ODS全量表和增量表建表
                odsFullDdl = generateOdsFullDdl(cjOdsTableLoadModeInfo.getOdsDataTable(), cjOdsTableLoadModeInfo);
                odsIncrementDdl = generateOdsIncrementDdl(cjOdsTableLoadModeInfo);
                odsDdl = odsFullDdl + ";\n" + odsIncrementDdl;
            } else if (cjOdsTableLoadModeInfo.getOdsDataLoadMode().equals(Constant.ODS_FULL_EXTRACT)) {
                //如果是增量抽取，生成ODS全量表和增量表建表
                odsFullDdl = generateOdsFullDdl(cjOdsTableLoadModeInfo.getOdsDataTable(), cjOdsTableLoadModeInfo);
                odsDdl = odsFullDdl;
            }
            //如果该表存在分区，需要建一张tmp表
            if (cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource() != null) {
                odsTmpDdl = generateOdstmpDdl(cjOdsTableLoadModeInfo);
                odsFullDdl = odsFullDdl + ";\n" + odsTmpDdl;
                odsDdl = odsDdl + ";\n" + odsTmpDdl;
            }

            if (cjDataSourceTabInfo.getBusinessSystemId() == null) {
                CjDataSourceConnDefine cjDataSourceConnDefine = cjDataSourceConnDefineService.selectDataBaseType(cjDataSourceTabInfo.getBusinessSystemNameShortName(), cjDataSourceTabInfo.getDataSourceSchema());
                businessSystemId = cjDataSourceConnDefine.getBusinessSystemId();
            } else {
                businessSystemId = cjDataSourceTabInfo.getBusinessSystemId();
            }
            //生成待插入的全量表ddl列表(如果有tmp表，会将全量表和tmp表拼接为一条记录)
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
            //生成待插入的增量表ddl列表
            if (!odsIncrementDdl.equals("")) {
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

            //生成hive建表列表
            CjOdsCrtTabDdlInfo hiveCrtTabDdlInfo = new CjOdsCrtTabDdlInfo();
            hiveCrtTabDdlInfo.setBusinessSystemId(businessSystemId);
            hiveCrtTabDdlInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
            hiveCrtTabDdlInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
            hiveCrtTabDdlInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
            hiveCrtTabDdlInfo.setOdsDataSchema(Constant.ODS_HIVE_INCREMENT_SCHEMA);
            hiveCrtTabDdlInfo.setOdsDataTable(odsTableName);
            hiveCrtTabDdlInfo.setOdsDataTableDdlInfo(odsDdl);
            hiveCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
            hiveCrtTabDdlInfos.add(hiveCrtTabDdlInfo);

        }
        cjOdsCrtTabDdlInfoService.insertBatch(cjOdsCrtTabDdlInfos);
        return hiveCrtTabDdlInfos;
    }

    public List<CjDwCrtTabDdlInfoDto> saveDwBakTableInfos(List<CjDataSourceTabInfoDto> cjDataSourceTabInfoDtos) {
        String businessSystemNameShortName;
        String businessSystemId;
        String dataSourceSchema;
        String dataSourceTable;
        String dwTableName;
        String odsTableName;
        List<CjDwCrtTabDdlInfo> cjDwCrtTabDdlInfos = new ArrayList<>();
        List<CjDwCrtTabDdlInfoDto> cjDwCrtTabDdlInfoDtos = new ArrayList<>();

//        //遍历每张表，生成DW建表语句
        for (CjDataSourceTabInfoDto cjDataSourceTabInfoDto : cjDataSourceTabInfoDtos) {
            businessSystemNameShortName = cjDataSourceTabInfoDto.getBusinessSystemNameShortName();
            dataSourceSchema = cjDataSourceTabInfoDto.getDataSourceSchema();
            dataSourceTable = cjDataSourceTabInfoDto.getDataSourceTable();
            odsTableName = CreateTableUtil.getOdsTableName(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
            dwTableName = CreateTableUtil.getDwTableName(businessSystemNameShortName, dataSourceSchema, dataSourceTable);

            String dwBakDdl = generateDwBakDdl(cjDataSourceTabInfoDto);

            if (dwBakDdl != null && !dwBakDdl.equals("")) {
                /**
                 * 将dw建表语句存入mysql中
                 */
                if (cjDataSourceTabInfoDto.getBusinessSystemId() == null) {
                    CjDataSourceConnDefine cjDataSourceConnDefine = cjDataSourceConnDefineService.selectDataBaseType(cjDataSourceTabInfoDto.getBusinessSystemNameShortName(), cjDataSourceTabInfoDto.getDataSourceSchema());
                    businessSystemId = cjDataSourceConnDefine.getBusinessSystemId();
                } else {
                    businessSystemId = cjDataSourceTabInfoDto.getBusinessSystemId();
                }
                CjDwCrtTabDdlInfoDto cjDwCrtTabDdlInfoDto = new CjDwCrtTabDdlInfoDto();
                cjDwCrtTabDdlInfoDto.setIndex(cjDataSourceTabInfoDto.getIndex());
                cjDwCrtTabDdlInfoDto.setBusinessSystemId(businessSystemId);
                cjDwCrtTabDdlInfoDto.setBusinessSystemNameShortName(cjDataSourceTabInfoDto.getBusinessSystemNameShortName());
                cjDwCrtTabDdlInfoDto.setDataSourceSchema(cjDataSourceTabInfoDto.getDataSourceSchema());
                cjDwCrtTabDdlInfoDto.setDataSourceTable(cjDataSourceTabInfoDto.getDataSourceTable());
                cjDwCrtTabDdlInfoDto.setOdsDataTable(odsTableName);
                cjDwCrtTabDdlInfoDto.setDwDataTable(dwTableName);
                cjDwCrtTabDdlInfoDto.setDwDataTableDdlInfo(dwBakDdl);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                cjDwCrtTabDdlInfoDto.setLastModifyDt(df.format(new Date()));
                CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo = new CjDwCrtTabDdlInfo();
                BeanUtils.copyProperties(cjDwCrtTabDdlInfoDto, cjDwCrtTabDdlInfo);
                cjDwCrtTabDdlInfos.add(cjDwCrtTabDdlInfo);
                cjDwCrtTabDdlInfoDtos.add(cjDwCrtTabDdlInfoDto);

            } else {
                CjDwCrtTabDdlInfoDto cjDwCrtTabDdlInfoDto = new CjDwCrtTabDdlInfoDto();
                cjDwCrtTabDdlInfoDto.setIndex(cjDataSourceTabInfoDto.getIndex());
                cjDwCrtTabDdlInfoDto.setBusinessSystemNameShortName(cjDataSourceTabInfoDto.getBusinessSystemNameShortName());
                cjDwCrtTabDdlInfoDto.setDataSourceSchema(cjDataSourceTabInfoDto.getDataSourceSchema());
                cjDwCrtTabDdlInfoDto.setDataSourceTable(cjDataSourceTabInfoDto.getDataSourceTable());
                cjDwCrtTabDdlInfoDto.setOdsDataTable(odsTableName);
                cjDwCrtTabDdlInfoDto.setDwDataTable(dwTableName);
                cjDwCrtTabDdlInfoDto.setDwDataTableDdlInfo(dwBakDdl);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                cjDwCrtTabDdlInfoDto.setLastModifyDt(df.format(new Date()));
                cjDwCrtTabDdlInfoDtos.add(cjDwCrtTabDdlInfoDto);
            }

            if (cjDwCrtTabDdlInfos != null && cjDwCrtTabDdlInfos.size() > 0) {
                cjDwCrtTabDdlInfoService.insertBatch(cjDwCrtTabDdlInfos);
            }
        }

        return cjDwCrtTabDdlInfoDtos;
    }

    /**
     * 生成dw备用区建表语句
     *
     * @param cjDataSourceTabInfoDto
     * @return
     */
    public String generateDwBakDdl(CjDataSourceTabInfoDto cjDataSourceTabInfoDto) {
        String businessSystemNameShortName;
        String dataSourceSchema;
        String dataSourceTable;
        String dwTableName;
        String tableComment = "";
        String colName;
        String colType;
        String colComment;
        List<CjDwTableColInfo> cjDwTableColInfos = new ArrayList<>();

        businessSystemNameShortName = cjDataSourceTabInfoDto.getBusinessSystemNameShortName();
        dataSourceSchema = cjDataSourceTabInfoDto.getDataSourceSchema();
        dataSourceTable = cjDataSourceTabInfoDto.getDataSourceTable();
        dwTableName = CreateTableUtil.getDwTableName(businessSystemNameShortName, dataSourceSchema, dataSourceTable);

        //使用StringBuffer拼接DW建表语句
        StringBuffer dwddl = new StringBuffer();
        //通过系统名、数据模式、表名获取表的字段信息
        List<CjDwCrtDdlColPojo> cjDwCrtDdlColPojos = cjDataSourceTabColInfoService.selectCjDwCrtDdlColPojoBySysAndSchemaAndTab(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
        if (cjDwCrtDdlColPojos != null && cjDwCrtDdlColPojos.size() > 0) {
            dwddl.append("create external table if not exists " + Constant.DW_HIVE_SCHEMA + "." + dwTableName + "\n");
            dwddl.append("(" + "\n");
            for (int i = 0; i < cjDwCrtDdlColPojos.size(); i++) {
                tableComment = cjDwCrtDdlColPojos.get(i).getDataSourceTableComment();
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
                CjDwTableColInfo cjDwTableColInfo = new CjDwTableColInfo();
                cjDwTableColInfo.setDwBusinessTopicDomain(Constant.DW_BAK_DEFAULT_TOPIC_DOMAIN);
                cjDwTableColInfo.setDwTableBelongDomain(Constant.DW_BAK_DOMAIN);
                cjDwTableColInfo.setDwDataSchema(Constant.DW_HIVE_SCHEMA);
                cjDwTableColInfo.setDwDataTable(dwTableName);
                cjDwTableColInfo.setDwTableColName(colName);
                cjDwTableColInfo.setDwTableColType(colType);
                cjDwTableColInfo.setDwTableColComment(colComment);
                cjDwTableColInfo.setDwTableColOrder(cjDwCrtDdlColPojos.get(i).getDataSourceColOrder());
                cjDwTableColInfo.setDwTableComment(tableComment);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                cjDwTableColInfo.setLastModifyDt(df.format(new Date()));
                cjDwTableColInfos.add(cjDwTableColInfo);
            }

            dwddl.append("    `" + Constant.DW_DEFAULT_COL_1 + "`    string    comment \"源系统pk\",\n");
            dwddl.append("    `" + Constant.DW_DEFAULT_COL_2 + "`    string    comment \"源系统代码\",\n");
            dwddl.append("    `" + Constant.DW_DEFAULT_COL_3 + "`    string    comment \"源表名\",\n");
            dwddl.append("    `" + Constant.DW_DEFAULT_COL_4 + "`    string    comment \"etl处理时间\",\n");
            dwddl.append("    `" + Constant.DW_DEFAULT_COL_5 + "`    string    comment \"数据日期\"\n");

            CjDwTableColInfo srcSysRowIdInfo = new CjDwTableColInfo();
            srcSysRowIdInfo.setDwBusinessTopicDomain(Constant.DW_BAK_DEFAULT_TOPIC_DOMAIN);
            srcSysRowIdInfo.setDwTableBelongDomain(Constant.DW_BAK_DOMAIN);
            srcSysRowIdInfo.setDwDataSchema(Constant.DW_HIVE_SCHEMA);
            srcSysRowIdInfo.setDwDataTable(dwTableName);
            srcSysRowIdInfo.setDwTableColName("src_sys_row_id");
            srcSysRowIdInfo.setDwTableColType("string");
            srcSysRowIdInfo.setDwTableColComment("源系统pk");
            srcSysRowIdInfo.setDwTableColOrder(cjDwCrtDdlColPojos.size() + 1 + "");
            srcSysRowIdInfo.setDwTableComment(tableComment);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            srcSysRowIdInfo.setLastModifyDt(df.format(new Date()));
            cjDwTableColInfos.add(srcSysRowIdInfo);

            CjDwTableColInfo srcSysCdInfo = new CjDwTableColInfo();
            srcSysCdInfo.setDwBusinessTopicDomain(Constant.DW_BAK_DEFAULT_TOPIC_DOMAIN);
            srcSysCdInfo.setDwTableBelongDomain(Constant.DW_BAK_DOMAIN);
            srcSysCdInfo.setDwDataSchema(Constant.DW_HIVE_SCHEMA);
            srcSysCdInfo.setDwDataTable(dwTableName);
            srcSysCdInfo.setDwTableColName("src_sys_cd");
            srcSysCdInfo.setDwTableColType("string");
            srcSysCdInfo.setDwTableColComment("源系统代码");
            srcSysCdInfo.setDwTableColOrder(cjDwCrtDdlColPojos.size() + 2 + "");
            srcSysCdInfo.setDwTableComment(tableComment);
            srcSysCdInfo.setLastModifyDt(df.format(new Date()));
            cjDwTableColInfos.add(srcSysCdInfo);

            CjDwTableColInfo srcTableNameInfo = new CjDwTableColInfo();
            srcTableNameInfo.setDwBusinessTopicDomain(Constant.DW_BAK_DEFAULT_TOPIC_DOMAIN);
            srcTableNameInfo.setDwTableBelongDomain(Constant.DW_BAK_DOMAIN);
            srcTableNameInfo.setDwDataSchema(Constant.DW_HIVE_SCHEMA);
            srcTableNameInfo.setDwDataTable(dwTableName);
            srcTableNameInfo.setDwTableColName("src_table_name");
            srcTableNameInfo.setDwTableColType("string");
            srcTableNameInfo.setDwTableColComment("源表名");
            srcTableNameInfo.setDwTableColOrder(cjDwCrtDdlColPojos.size() + 3 + "");
            srcTableNameInfo.setDwTableComment(tableComment);
            srcTableNameInfo.setLastModifyDt(df.format(new Date()));
            cjDwTableColInfos.add(srcTableNameInfo);

            CjDwTableColInfo etlDtInfo = new CjDwTableColInfo();
            etlDtInfo.setDwBusinessTopicDomain(Constant.DW_BAK_DEFAULT_TOPIC_DOMAIN);
            etlDtInfo.setDwTableBelongDomain(Constant.DW_BAK_DOMAIN);
            etlDtInfo.setDwDataSchema(Constant.DW_HIVE_SCHEMA);
            etlDtInfo.setDwDataTable(dwTableName);
            etlDtInfo.setDwTableColName("etl_dt");
            etlDtInfo.setDwTableColType("string");
            etlDtInfo.setDwTableColComment("etl处理时间");
            etlDtInfo.setDwTableColOrder(cjDwCrtDdlColPojos.size() + 4 + "");
            etlDtInfo.setDwTableComment(tableComment);
            etlDtInfo.setLastModifyDt(df.format(new Date()));
            cjDwTableColInfos.add(etlDtInfo);

            CjDwTableColInfo dataDtInfo = new CjDwTableColInfo();
            dataDtInfo.setDwBusinessTopicDomain(Constant.DW_BAK_DEFAULT_TOPIC_DOMAIN);
            dataDtInfo.setDwTableBelongDomain(Constant.DW_BAK_DOMAIN);
            dataDtInfo.setDwDataSchema(Constant.DW_HIVE_SCHEMA);
            dataDtInfo.setDwDataTable(dwTableName);
            dataDtInfo.setDwTableColName("data_dt");
            dataDtInfo.setDwTableColType("string");
            dataDtInfo.setDwTableColComment("数据日期");
            dataDtInfo.setDwTableColOrder(cjDwCrtDdlColPojos.size() + 5 + "");
            dataDtInfo.setDwTableComment(tableComment);
            dataDtInfo.setLastModifyDt(df.format(new Date()));
            cjDwTableColInfos.add(dataDtInfo);
            dwddl.append(")" + "\n");
            dwddl.append("row format delimited fields terminated by '\\001' lines terminated by '\\n' stored as orc");

            cjDwTableColInfoService.insertBatch(cjDwTableColInfos);
        }

        return dwddl.toString();
    }

    public String generateOdsFullDdl(String odsTableName, CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo) {
        StringBuffer odsDDL = new StringBuffer();
        String odsTableComment = "";
        List<CjOdsTableColInfo> cjOdsTableColInfos = new ArrayList<>();

        //开始拼接ods建表语句
        odsDDL.append("create external table if not exists " + Constant.ODS_HIVE_FULL_SCHEMA + "." + odsTableName + "\n");
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
        odsDDL.append("    etl_dt    string    comment \"etl处理时间\"\n");
        CjOdsTableColInfo etlColInfo = new CjOdsTableColInfo();
        etlColInfo.setBusinessSystemId(cjOdsTableLoadModeInfo.getBusinessSystemId());
        etlColInfo.setBusinessSystemNameShortName(cjOdsTableLoadModeInfo.getBusinessSystemNameShortName());
        etlColInfo.setDataSourceSchema(cjOdsTableLoadModeInfo.getDataSourceSchema());
        etlColInfo.setDataSourceTable(cjOdsTableLoadModeInfo.getDataSourceTable());
        etlColInfo.setOdsDataSchema(Constant.ODS_HIVE_FULL_SCHEMA);
        etlColInfo.setOdsDataTable(cjOdsTableLoadModeInfo.getOdsDataTable());
        etlColInfo.setOdsTableComment("etl处理时间");
        etlColInfo.setOdsTableColName("etl_dt");
        etlColInfo.setOdsTableColType(Constant.ODS_COL_TYPE);
        etlColInfo.setOdsTableColComment("etl处理时间");
        etlColInfo.setOdsTableColOrder(infoList.size() + 1 + "");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        etlColInfo.setLastModifyDt(df.format(new Date()));
        cjOdsTableColInfos.add(etlColInfo);

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
            cjOdsTableColInfo.setOdsTableColOrder(infoList.size() + 2 + "");
            cjOdsTableColInfo.setOdsTablePartitionFlag("1");
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

        odsDDL.append("    etl_dt    string    comment \"etl处理时间\"\n");
        odsDDL.append(")" + "\n");
        odsDDL.append("partitioned by (" + Constant.ODS_PARTITION_KEY + " string)\n");
        odsDDL.append("row format delimited fields terminated by '\\001' lines terminated by '\\n'");
        return odsDDL.toString();
    }

    public String generateOdstmpDdl(CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo) {
        StringBuffer odsDDL = new StringBuffer();

        //开始拼接ods建表语句
        odsDDL.append("create external table if not exists " + Constant.ODS_HIVE_INCREMENT_SCHEMA + "." + cjOdsTableLoadModeInfo.getOdsDataTable() + "_tmp" + "\n");
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

        odsDDL.append("    sysdate    string    comment \"etl处理时间\"\n");
        odsDDL.append(")" + "\n");
        odsDDL.append("row format delimited fields terminated by '\\001' lines terminated by '\\n'");
        return odsDDL.toString();
    }

    public List<TableOptionPojo> hiveCreateDwBakTableBatch(List<CjDwCrtTabDdlInfoDto> cjDwCrtTabDdlInfoDtos) {
        GroupPoolFactory instance = GroupPoolFactory.getInstance(Constant.HIVE_INSTANCE);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        TableOptionPojo tableOptionPojo;
        List<TableOptionPojo> tableOptionPojos = new ArrayList<>();

        for (CjDwCrtTabDdlInfoDto cjDwCrtTabDdlInfoDto : cjDwCrtTabDdlInfoDtos) {

            tableOptionPojo = new TableOptionPojo();
            tableOptionPojo.setBusinessSystemNameShortName(cjDwCrtTabDdlInfoDto.getBusinessSystemNameShortName());
            tableOptionPojo.setDataSourceSchema(cjDwCrtTabDdlInfoDto.getDataSourceSchema());
            tableOptionPojo.setDataSourceTable(cjDwCrtTabDdlInfoDto.getDataSourceTable());
            tableOptionPojo.setIndex(cjDwCrtTabDdlInfoDto.getIndex());
            if (cjDwCrtTabDdlInfoDto.getDwDataTableDdlInfo() != null && cjDwCrtTabDdlInfoDto.getDwDataTableDdlInfo().length() > 0) {
                try {
                    connection = instance.getConnection();
                    preparedStatement = connection.prepareStatement(cjDwCrtTabDdlInfoDto.getDwDataTableDdlInfo());
                    preparedStatement.execute();
                    tableOptionPojo.setResult(Constant.TABLE_OPTION_SUCCESS);
                } catch (Exception e) {
                    tableOptionPojo.setResult(Constant.TABLE_OPTION_FAILED);
                    e.printStackTrace();
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
            } else {
                tableOptionPojo.setResult(Constant.TABLE_OPTION_AVAIL);
            }

            tableOptionPojos.add(tableOptionPojo);
        }
        return tableOptionPojos;
    }
}
