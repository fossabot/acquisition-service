package com.acquisition.controller;

import com.acquisition.entity.*;
import com.acquisition.entity.excel.EtuInfo;
import com.acquisition.entity.pojo.CjDwCrtDdlColPojo;
import com.acquisition.service.*;
import com.acquisition.util.Constant;
import com.acquisition.util.PinyinUtil;
import com.acquisition.util.Result;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Api(value = "generateScript",description = "ods/dw脚本生成页面")
@RestController
@RequestMapping(value = "/generateScript")
public class GenerateScriptController {

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    public ICjDataSourceTabInfoService cjDataSourceTabInfoService;

    @Resource(name = "cjDataSourceTabColInfoServiceImpl")
    public ICjDataSourceTabColInfoService cjDataSourceTabColInfoService;

    @Resource(name = "cjDwDataScriptDefInfoServiceImpl")
    public CjDwDataScriptDefInfoService cjDwDataScriptDefInfoService;


    @Resource(name = "cjOdsDataScriptDefInfoServiceImpl")
    public ICjOdsDataScriptDefInfoService iCjOdsDataScriptDefInfoService;

    @Resource(name = "cjDataSourceConnDefineServiceImpl")
    public ICjDataSourceConnDefineService iCjDataSourceConnDefineService;

    @Resource(name = "cjOdsTableLoadModeInfoServiceImpl")
    public CjOdsTableLoadModeInfoService cjOdsTableLoadModeInfoService;

    @Resource(name = "cjOdsTableColInfoServiceImpl")
    public CjOdsTableColInfoService cjOdsTableColInfoService;

    @Resource(name = "cjDataSourceTabColInfoServiceImpl")
    public ICjDataSourceTabColInfoService iCjDataSourceTabColInfoService;

    /**
    * @Author: zhangdongmao
    * @Date: 2019/6/10
    * @Description:  获取DW脚本生成页面筛选框里的值
    * @Param: * @param null 1
    * @return:
    */
    @ApiOperation("dw脚本生成页面获取筛选列表接口")
    @GetMapping(value = "/getDwSystemFilterList")
    public Result getDwSystemFilterList() {
        Result result=new Result();
        List<String> systems = cjDataSourceTabInfoService.findDistSystemFromCjVGetPrepareScriptForDwTabList();
        return result.success(systems);
    }

    /**
     * @Author: zhangdongmao
     * @Date: 2019/6/10
     * @Description:  获取ODS脚本生成页面筛选框里的值
     * @Param: * @param null 1
     * @return:
     */
    @ApiOperation("ods脚本生成页面获取筛选列表接口")
    @GetMapping(value = "/getOdsSystemFilterList")
    public Result getOdsSystemFilterList() {
        Result result=new Result();
        List<String> systems = cjDataSourceTabInfoService.findDistSystemFromCjVGetPrepareScriptForOdsTabList();
        return result.success(systems);
    }

    @ApiOperation("dw脚本生成页面按系统名筛选接口")
    @PostMapping(value = "/getDwListByFilter")
    public Result getDwListByFilter(@RequestBody Page reqParams) {
        Result result=new Result();
        PageHelper.startPage(reqParams.getPagenum(),reqParams.getPagesize());
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findCjVGetPrepareScriptForDwTabListBySystem(reqParams.getQuery().get(0));
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(cjDataSourceTabInfos);
        return result.success(page);
    }
    @ApiOperation("ods脚本生成页面按系统名筛选接口")
    @PostMapping(value = "/getOdsListByFilter")
    public Result getOdsListByFilter(@RequestBody Page reqParams) {
        Result result=new Result();
        PageHelper.startPage(reqParams.getPagenum(),reqParams.getPagesize());
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findCjVGetPrepareScriptForOdsTabListBySystem(reqParams.getQuery().get(0));
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(cjDataSourceTabInfos);
        return result.success(page);
    }
    /**
    * @Author: zhangdongmao
    * @Date: 2019/6/4
    * @Description:  获取DW脚本生成列表
    * @Param: * @param null 1
    * @return:
    */
    @ApiOperation("获取dw脚本生成页面表清单")
    @GetMapping(value = "/getDwTabList")
    public Result getDwTabList(Page reqParams) {
        Result result=new Result();
        PageHelper.startPage(reqParams.getPagenum(),reqParams.getPagesize());
        List<CjDataSourceTabInfo> allCjVGetPrepareScriptForDwTabList = cjDataSourceTabInfoService.findAllCjVGetPrepareScriptForDwTabList();
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(allCjVGetPrepareScriptForDwTabList);
        return result.success(page);
    }
    /**
     * @Author: zhangdongmao
     * @Date: 2019/6/4
     * @Description:  生成并保存DW初始化脚本
     * @Param: * @param null 1
     * @return:
     */
    @ApiOperation("生成dw初始化脚本")
    @PostMapping(value = "/generateDwInitScript")
    public Result generateDwInitScript(@RequestBody String data) {
        Result result=new Result();
        JSONObject jsonObject = JSONObject.parseObject(data);
        data = jsonObject.getString("params");
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = JSONObject.parseArray(data, CjDataSourceTabInfo.class);

        for (CjDataSourceTabInfo cjDataSourceTabInfo:cjDataSourceTabInfos){
            String odsColName;
            String dwColName;
            String dataSourceSchema = cjDataSourceTabInfo.getDataSourceSchema();
            String businessSystemNameShortName = cjDataSourceTabInfo.getBusinessSystemNameShortName();
            String dataSourceTable = cjDataSourceTabInfo.getDataSourceTable();
            String dwTableName="d_nct_"+businessSystemNameShortName.toLowerCase()+"_"+dataSourceSchema.toLowerCase()+"_"+dataSourceTable.toLowerCase();
            String odsTableName=businessSystemNameShortName.toLowerCase()+"_"+dataSourceSchema.toLowerCase()+"_"+dataSourceTable.toLowerCase();
            Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
            Matcher m = p.matcher(dwTableName);
            if (m.find()) {
                dwTableName= PinyinUtil.getPinYin(dwTableName);
            }
            p = Pattern.compile("[\u4e00-\u9fa5]");
            m = p.matcher(odsTableName);
            if (m.find()) {
                odsTableName= PinyinUtil.getPinYin(odsTableName);
            }
            StringBuffer dwInitScript=new StringBuffer();

            //通过系统名、数据模式、表名获取表的字段信息
            List<CjDwCrtDdlColPojo> cjDwCrtDdlColPojos = cjDataSourceTabColInfoService.selectCjDwCrtDdlColPojoBySysAndSchemaAndTab(businessSystemNameShortName, dataSourceSchema, dataSourceTable);

            if(cjDwCrtDdlColPojos != null && cjDwCrtDdlColPojos.size()>0){
                dwInitScript.append("set hive.exec.dynamic.partition=true;\n");
                dwInitScript.append("set hive.exec.dynamic.partition.mode=nonstrict;\n");
                dwInitScript.append("set hive.exec.max.dynamic.partitions.pernode = 10000;\n");
                dwInitScript.append("insert overwrite table "+Constant.DW_HIVE_SCHEMA+"."+dwTableName+"\n");
                dwInitScript.append("select\n");
                for(int i=0;i<cjDwCrtDdlColPojos.size();i++) {
                    odsColName=cjDwCrtDdlColPojos.get(i).getDataSourceColName().toLowerCase();
                    //判断colName中是否包含中文，若包含，则colName转为全拼，源colName赋值给colComment
                    p = Pattern.compile("[\u4e00-\u9fa5]");
                    m = p.matcher(odsColName);
                    if (m.find()) {
                        odsColName= PinyinUtil.getPinYin(odsColName);
                    }
                    dwColName=odsColName;
                    if(dwColName.equals("src_table_name")){
                        dwColName = "src_table_name_dl";
                    }
                    dwInitScript.append("`" + odsColName + "`    as    " + dwColName + ",\n");
                }


                dwInitScript.append("''    as src_sys_row_id,\n");
                dwInitScript.append("'"+cjDataSourceTabInfo.getBusinessSystemNameShortName().toLowerCase()+"'    "+"as src_sys_cd,\n");
                dwInitScript.append("'"+businessSystemNameShortName.toLowerCase()+"_"+dataSourceTable.toLowerCase()+"'    as src_table_name,\n");
                dwInitScript.append("cast( current_timestamp() as string)    as etl_dt,\n");
                dwInitScript.append("cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt\n");
                dwInitScript.append("from "+Constant.ODS_HIVE_FULL_SCHEMA+"."+odsTableName);
                CjDwDataScriptDefInfo cjDwDataScriptDefInfo=new CjDwDataScriptDefInfo();
                cjDwDataScriptDefInfo.setBusinessSystemId(cjDataSourceTabInfo.getBusinessSystemId());
                cjDwDataScriptDefInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
                cjDwDataScriptDefInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
                cjDwDataScriptDefInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
                cjDwDataScriptDefInfo.setOdsDataTable(odsTableName);
                cjDwDataScriptDefInfo.setDwDataTable(dwTableName);
                cjDwDataScriptDefInfo.setDwDataScriptType("init");
                cjDwDataScriptDefInfo.setDwDataHivesqlDefine(dwInitScript.toString());
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                cjDwDataScriptDefInfo.setLastModifyDt(df.format(new Date()));

                CjDwDataScriptDefInfoKey key = new CjDwDataScriptDefInfoKey();
                key.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
                key.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
                key.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
                key.setDwDataTable(dwTableName);
                key.setOdsDataTable(odsTableName);
                cjDwDataScriptDefInfoService.deleteByPrimaryKey(key);
                if(cjDwDataScriptDefInfoService.save(cjDwDataScriptDefInfo).equals("保存成功")){
                    //生成DW建表语句成功，设置状态表中的相应状态字段
                    cjDataSourceTabInfo.setDataFlagForCrtDwScript(Constant.DW_CRT_SCRIPT);
                    //将状态改变更新到数据库
                    CjDataSourceTabInfoExample cjDataSourceTabInfoExample=new CjDataSourceTabInfoExample();
                    CjDataSourceTabInfoExample.Criteria criteria = cjDataSourceTabInfoExample.createCriteria();
                    //where条件使用业务系统缩写、数据模式和表名做限制
                    criteria.andBusinessSystemNameShortNameEqualTo(businessSystemNameShortName);
                    criteria.andDataSourceSchemaEqualTo(dataSourceSchema);
                    criteria.andDataSourceTableEqualTo(dataSourceTable);
                    cjDataSourceTabInfoService.updateByExampleSelective(cjDataSourceTabInfo,cjDataSourceTabInfoExample);
                }
                dwInitScript.setLength(0);
            }

        }

        result.setCode(200);
        result.setMsg("DW脚本初始化成功！");
        return result;
    }

    /**
     * @return 返回生成ODS脚本状态
     */
    @ApiOperation("获取ods脚本生成页面表清单接口")
    @GetMapping(value = "/getODSTableInfo")
    @ResponseBody
    public Result getODSTableInfo(Page reqParams){
        Result result = new Result();
        PageHelper.startPage(reqParams.getPagenum(),reqParams.getPagesize());
        List<CjDataSourceTabInfo> odsTableInfos = cjDataSourceTabInfoService.findODSTableInfo();
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(odsTableInfos);
        return result.success(page);
    }

    /**
     * @return 获取前端的数据，解析所需要的字段
     */
    @ApiOperation("生成ods初始化脚本")
    @PostMapping(value = "/generateSqoopScript")
    @ResponseBody
    public Result generateSqoopScript(@RequestBody String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("params");
        List<CjDataSourceTabInfo> tabInfoList = JSONObject.parseArray(odsTableList, CjDataSourceTabInfo.class);
        return spliceSqoopScript(tabInfoList);
    }

    /**
     * @return 拼接Sqoop脚本，并保存到数据库
     */
    public Result spliceSqoopScript(List<CjDataSourceTabInfo>  tabInfos){
        Result result =  new Result();
        CjDataSourceConnDefine cjDataSourceConnDefine;
        String businessSystemId="";

        String sqoopInitScriptOracle = "sh /home/infa/zwj/ods_import_new_etl.sh url username password ";
        String sqoopInitScriptSqlMyl = "sh /home/infa/zwj/ods_import.sh url username password ";
        String columns = "";
        String str2 = " no no init \"\" \"\" ";
        StringBuffer scripts = new StringBuffer();
        CjOdsDataScriptDefInfo cjOdsDataScriptDefInfo = new CjOdsDataScriptDefInfo();

        //拼接Sqooop脚本
        for (CjDataSourceTabInfo table : tabInfos) {
            CjDataSourceConnDefine cjDataSourceConnDefine1 = iCjDataSourceConnDefineService.selectDataBaseType(table.getBusinessSystemNameShortName(), table.getDataSourceSchema());
            //判断系统名连接数
            if (cjDataSourceConnDefine1.getDataBaseType().equals("sqlserver") || cjDataSourceConnDefine1.getDataBaseType().equals("mysql")){
                scripts.append(sqoopInitScriptSqlMyl + table.getBusinessSystemNameShortName() + "~"
                        + table.getDataSourceSchema()+ " "
                        + table.getDataSourceTable() + str2 + "\"");
            }else {
                scripts.append(sqoopInitScriptOracle + table.getBusinessSystemNameShortName() + " "
                        + table.getDataSourceSchema()+ "."
                        + table.getDataSourceTable() + str2 + "\"");
            }

            List<CjDataSourceTabColInfo> infoList = cjDataSourceTabColInfoService
                    .findBySystemAndSchemaAndTab(
                            table.getBusinessSystemNameShortName(),
                            table.getDataSourceSchema(),
                            table.getDataSourceTable());

            for (int i = 0; i < infoList.size(); i++){
                columns = infoList.get(i).getDataSourceColName();
                //判断colName中是否包含中文，若包含，则colName转为全拼，源colName赋值给colComment
                Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
                Matcher m = p.matcher(columns);
                if (m.find()) {
                    columns=PinyinUtil.getPinYin(columns);
                }
                if (i == infoList.size() - 1 ){
                    columns = columns + "\"";
                    scripts.append(columns);
                }else {
                    columns = columns + ",";
                    scripts.append(columns);
                }
            }
//            String odsTableName=table.getBusinessSystemNameShortName().toLowerCase()+"_"+table.getDataSourceSchema().toLowerCase()+"_"+table.getDataSourceTable().toLowerCase();
//            Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
//            Matcher m = p.matcher(odsTableName);
//            if (m.find()) {
//                odsTableName= PinyinUtil.getPinYin(odsTableName);
//            }
            if(table.getBusinessSystemId()==null){
                cjDataSourceConnDefine = iCjDataSourceConnDefineService.selectDataBaseType(table.getBusinessSystemNameShortName(), table.getDataSourceSchema());
                businessSystemId = cjDataSourceConnDefine.getBusinessSystemId();
            }else {
                businessSystemId = table.getBusinessSystemId();
            }
            cjOdsDataScriptDefInfo.setBusinessSystemId(businessSystemId);
            cjOdsDataScriptDefInfo.setBusinessSystemNameShortName(table.getBusinessSystemNameShortName());
            cjOdsDataScriptDefInfo.setDataSourceSchema(table.getDataSourceSchema());
            cjOdsDataScriptDefInfo.setDataSourceTable(table.getDataSourceTable());
            cjOdsDataScriptDefInfo.setOdsDataTable(table.getDataSourceTable());
            cjOdsDataScriptDefInfo.setOdsDataScriptType("init");
            cjOdsDataScriptDefInfo.setOdsDataSqoopDefine(scripts.toString());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjOdsDataScriptDefInfo.setLastModifyDt(df.format(new Date()));
            cjOdsDataScriptDefInfo.setLastModifyBy("admin");

            //保存脚本到数据库
            iCjOdsDataScriptDefInfoService.saveSqoopScripts(cjOdsDataScriptDefInfo);
            //更新状态
            cjDataSourceTabInfoService.updateODSScriptStatus(
                    "1",
                    table.getBusinessSystemNameShortName(),
                    table.getDataSourceSchema(),
                    table.getDataSourceTable()
            );
            scripts.setLength(0);
        }

        result.setCode(200);
        result.setMsg("ODS脚本初始化成功！");
        return result;
    }


    @ApiOperation(value = "初始化ods加载脚本", notes = "List<EtuInfo>", produces = "application/json")
    @PostMapping("/initOdsLoad")
    public Result initOdsLoad(@RequestBody List<EtuInfo> reqParmsEtu){
        // 返回结果
        Result result = new Result();
        // 存储生成sqoop脚本后的对象
        List<CjOdsDataScriptDefInfo> cjOdsDataScriptDefInfos = new ArrayList<>();
        // 判断传入参数是否为空
        if (!reqParmsEtu.isEmpty()){
            // 遍历每个EtuInfo
            for (EtuInfo etuEnt:reqParmsEtu){
                    CjOdsTableLoadModeInfo odsTableLoadModeInfo = cjOdsTableLoadModeInfoService.findAll(etuEnt);
                    // 创建sqoop脚本
                    String odsInitSqoopScript = createSqoopInitShell(odsTableLoadModeInfo);
                    // 创建CjOdsDataScriptDefInfo实体类
                    CjOdsDataScriptDefInfo cjOdsDataScriptDefInfo = new CjOdsDataScriptDefInfo();
                    cjOdsDataScriptDefInfo.setBusinessSystemId(odsTableLoadModeInfo.getBusinessSystemId());
                    cjOdsDataScriptDefInfo.setBusinessSystemNameShortName(odsTableLoadModeInfo.getBusinessSystemNameShortName());
                    cjOdsDataScriptDefInfo.setDataSourceSchema(odsTableLoadModeInfo.getDataSourceSchema());
                    cjOdsDataScriptDefInfo.setDataSourceTable(odsTableLoadModeInfo.getDataSourceTable());
                    cjOdsDataScriptDefInfo.setOdsDataTable(odsTableLoadModeInfo.getOdsDataTable());
                    cjOdsDataScriptDefInfo.setOdsDataScriptType("init");
                    cjOdsDataScriptDefInfo.setOdsDataSqoopDefine(odsInitSqoopScript);
                    cjOdsDataScriptDefInfo.setLastModifyDt(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    cjOdsDataScriptDefInfo.setLastModifyBy(odsTableLoadModeInfo.getLastModifyBy());
                    // 持久化实体类
                    cjOdsDataScriptDefInfos.add(cjOdsDataScriptDefInfo);
            }
            iCjOdsDataScriptDefInfoService.insertBatch(cjOdsDataScriptDefInfos);
        }
        result.setCode(200);
        result.setMsg("初始化脚本初始化成功！");
        return result;
    }

    @ApiOperation(value = "创建ods加载脚本", notes = "List<EtuInfo>", produces = "application/json")
    @PostMapping("/createOdsLoad")
    public Result createOdsLoad(@RequestBody List<EtuInfo> reqParmsEtu){
        // 返回结果
        Result result = new Result();
        // 初始化sqoop
        String SqoopScript = null;
        // 初始化hive
        String HiveScript = null;

        // 保存CjOdsDataScriptDefInfo实体类
        List<CjOdsDataScriptDefInfo> cjOdsDataScriptDefInfos = new ArrayList();
        for(EtuInfo etuEnt : reqParmsEtu){
            CjOdsTableLoadModeInfo odsTableLoadModeInfo = cjOdsTableLoadModeInfoService.findAll(etuEnt);
            // 创建CjOdsDataScriptDefInfo实体类
            CjOdsDataScriptDefInfo cjOdsDataScriptDefInfo = new CjOdsDataScriptDefInfo();
            cjOdsDataScriptDefInfo.setBusinessSystemId(odsTableLoadModeInfo.getBusinessSystemId());
            cjOdsDataScriptDefInfo.setBusinessSystemNameShortName(odsTableLoadModeInfo.getBusinessSystemNameShortName());
            cjOdsDataScriptDefInfo.setDataSourceSchema(odsTableLoadModeInfo.getDataSourceSchema());
            cjOdsDataScriptDefInfo.setDataSourceTable(odsTableLoadModeInfo.getDataSourceTable());
            cjOdsDataScriptDefInfo.setOdsDataTable(odsTableLoadModeInfo.getOdsDataTable());
            cjOdsDataScriptDefInfo.setOdsDataScriptType(odsTableLoadModeInfo.getOdsDataLoadMode());
            cjOdsDataScriptDefInfo.setLastModifyDt(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date()));
            cjOdsDataScriptDefInfo.setLastModifyBy(odsTableLoadModeInfo.getLastModifyBy());

            // 全量
            // 只有无分区的情况
            if("full".equals(odsTableLoadModeInfo.getOdsDataLoadMode())){
                // 创建脚本
                 SqoopScript = createSqoopShell(odsTableLoadModeInfo);
                cjOdsDataScriptDefInfo.setOdsDataSqoopDefine(SqoopScript);
                // 持久化
                cjOdsDataScriptDefInfos.add(cjOdsDataScriptDefInfo);
            }else{
                // 增量
                // 创建hive脚本
                HiveScript = createHiveShell(odsTableLoadModeInfo);
                // 创建sqoop脚本
                SqoopScript = createSqoopShell(odsTableLoadModeInfo);

                cjOdsDataScriptDefInfo.setOdsDataHivesqlDefine(HiveScript);
                cjOdsDataScriptDefInfo.setOdsDataSqoopDefine(SqoopScript);
                cjOdsDataScriptDefInfos.add(cjOdsDataScriptDefInfo);
            }

        }
        // 持久化每个对象
        iCjOdsDataScriptDefInfoService.insertBatch(cjOdsDataScriptDefInfos);
        result.setCode(200);
        result.setMsg("ok！");
        return result;
    }
    /**
     *
     * @param cjOdsTableLoadModeInfo sqoop生成脚本所需字段数据
     * @return sqoop脚本
     */
    private String createSqoopInitShell(CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo){
        // 返回结果
        Result result = new Result();
        // 拼接shell
        StringBuffer odsInitSqoopScript = new StringBuffer();
        String shellOrder = null;
        String dataBaseType;
        String systemAndSchemaAndTab;
        try {
            // 判断数据库类型
            CjDataSourceConnDefine connDefine = iCjDataSourceConnDefineService.
                    selectDataBaseType(cjOdsTableLoadModeInfo.getBusinessSystemNameShortName(), cjOdsTableLoadModeInfo.getDataSourceSchema());
            dataBaseType = connDefine.getDataBaseType();
            if(dataBaseType.equals(Constant.DATABASE_SQLSERVER) || dataBaseType.equals(Constant.DATABASE_MYSQL)){
                shellOrder = "ods_import.sh";
                systemAndSchemaAndTab = cjOdsTableLoadModeInfo.getBusinessSystemNameShortName()+"~"+cjOdsTableLoadModeInfo.getDataSourceSchema()+" "+cjOdsTableLoadModeInfo.getDataSourceTable();
            }else {
                shellOrder = "ods_import_new_etl.sh";
                systemAndSchemaAndTab = cjOdsTableLoadModeInfo.getBusinessSystemNameShortName()+" "+cjOdsTableLoadModeInfo.getDataSourceSchema()+"."+cjOdsTableLoadModeInfo.getDataSourceTable();
            }
            String location = "/home/infa/zwj/"+ shellOrder + " url username password ";
            odsInitSqoopScript.append("sh ").append(location);
            odsInitSqoopScript.append(systemAndSchemaAndTab);
        } catch (NullPointerException e) {
            result.error(400,e.toString());
        }
        // 是否为分区
        if(null == cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource() || cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource().isEmpty()) {
            odsInitSqoopScript.append(" no "+cjOdsTableLoadModeInfo.getOdsTableSplitColName()+" init \"\" \"\" ");
        } else {
            odsInitSqoopScript.append(" "+cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource()+" "+cjOdsTableLoadModeInfo.getOdsTableSplitColName()
                    +" init_big \"\" \"\" ");
        }
        // 字段按规则排序
        List<String> colNames = iCjDataSourceTabColInfoService.findFieldByOrder(cjOdsTableLoadModeInfo.getBusinessSystemNameShortName(),
                cjOdsTableLoadModeInfo.getDataSourceSchema(), cjOdsTableLoadModeInfo.getDataSourceTable());
        // 去掉拼接字符串最后一个逗号
        StringJoiner fields = new StringJoiner(",");
        for(String colName:colNames){
            // 不拼接etl_date和data_dt
            if (!colName.equals(Constant.ODS_ETL_DT_COL) && !colName.equals(Constant.ODS_PARTITION_KEY)){
                fields.add(colName);
            }
        }
        odsInitSqoopScript.append("\"").append(fields).append("\"");
        return odsInitSqoopScript.toString();
    }


    /**
     *
     * @param cjOdsTableLoadModeInfo sqoop生成脚本所需字段数据
     * @return sqoop脚本
     */
    private String createSqoopShell(CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo){
        // 返回结果
        Result result = new Result();
        // 拼接shell
        StringBuffer odsInitSqoopScript = new StringBuffer();
        String shellOrder = null;
        String dataBaseType;
        String systemAndSchemaAndTab;
        // 判断增量还是全量
        String splitFiled = null;

        // 字段按规则排序
        List<String> colNames = iCjDataSourceTabColInfoService.findFieldByOrder(cjOdsTableLoadModeInfo.getBusinessSystemNameShortName(),
                cjOdsTableLoadModeInfo.getDataSourceSchema(), cjOdsTableLoadModeInfo.getDataSourceTable());
        // 去掉拼接字符串最后一个逗号
        StringJoiner fields= new StringJoiner(",");
        for(String colName:colNames){
            // 不拼接etl_date和data_dt
            if (!colName.equals(Constant.ODS_ETL_DT_COL) && !colName.equals(Constant.ODS_PARTITION_KEY)){
                fields.add(colName);
            }
        }

        try {
            // 判断数据库类型
            CjDataSourceConnDefine connDefine = iCjDataSourceConnDefineService.
                    selectDataBaseType(cjOdsTableLoadModeInfo.getBusinessSystemNameShortName(), cjOdsTableLoadModeInfo.getDataSourceSchema());
            dataBaseType = connDefine.getDataBaseType();
            if(dataBaseType.equals(Constant.DATABASE_SQLSERVER) || dataBaseType.equals(Constant.DATABASE_MYSQL)){
                shellOrder = "ods_import.sh";
                systemAndSchemaAndTab = cjOdsTableLoadModeInfo.getBusinessSystemNameShortName()+"~"+cjOdsTableLoadModeInfo.getDataSourceSchema()+" "+cjOdsTableLoadModeInfo.getDataSourceTable();
            }else {
                shellOrder = "ods_import_new_etl.sh";
                systemAndSchemaAndTab = cjOdsTableLoadModeInfo.getBusinessSystemNameShortName()+" "+cjOdsTableLoadModeInfo.getDataSourceSchema()+"."+cjOdsTableLoadModeInfo.getDataSourceTable();
            }
            String location = "/home/infa/zwj/"+ shellOrder + " url username password ";
            odsInitSqoopScript.append("sh ").append(location);
            odsInitSqoopScript.append(systemAndSchemaAndTab);
        } catch (NullPointerException e) {
            result.error(400,e.toString());
        }

        // 判断增量或者是全量
        if ("full".equals(cjOdsTableLoadModeInfo.getOdsDataLoadMode())){
            splitFiled = "no";
        }else{
            splitFiled = cjOdsTableLoadModeInfo.getOdsTableIncrementColName();
        }

        // 是否为分区
        if(null == cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource() || cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource().isEmpty()) {
            odsInitSqoopScript.append(" ").append(splitFiled).append(" ").
                    append(cjOdsTableLoadModeInfo.getOdsTableSplitColName()+" "+cjOdsTableLoadModeInfo.getOdsDataLoadMode()+" \"\" \"\" ");
            odsInitSqoopScript.append("\"").append(fields).append("\"");
        } else {
            odsInitSqoopScript.append(" ").append(splitFiled).append(" ").
                    append(cjOdsTableLoadModeInfo.getOdsTableSplitColName()+" "+cjOdsTableLoadModeInfo.getOdsDataLoadMode()+" \"\" \"\" ");
            odsInitSqoopScript.append("\"").append(fields).append("\"").append(" \"\" \"\" \"true\"");
        }
        return odsInitSqoopScript.toString();
    }


    /**
     *
     * @return 拼接hive脚本
     */
    private String createHiveShell(CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo){

        // 拼接hive字符串
        StringBuffer odsHiveScript = new StringBuffer();

        // 查询odsDataTable表名称
        String odsDataTable = cjOdsTableColInfoService.findOdsDataTable(cjOdsTableLoadModeInfo.getBusinessSystemNameShortName(),
                cjOdsTableLoadModeInfo.getDataSourceSchema(),cjOdsTableLoadModeInfo.getDataSourceTable());
        odsHiveScript.append("set hive.exec.dynamic.partition=true;\n");
        odsHiveScript.append("set hive.exec.dynamic.partition.mode=nonstrict;\n");
        odsHiveScript.append("set hive.exec.max.dynamic.partitions.pernode = 10000;\n\r");
        odsHiveScript.append("insert overwrite table ");
        odsHiveScript.append(Constant.ODS_HIVE_FULL_SCHEMA).append(".").append(odsDataTable);

        // 字段按规则排序
        List<String> colNames = cjOdsTableColInfoService.findFieldByOrder(cjOdsTableLoadModeInfo.getBusinessSystemNameShortName(),
                cjOdsTableLoadModeInfo.getDataSourceSchema(), cjOdsTableLoadModeInfo.getDataSourceTable());
        // 去掉拼接字符串最后一个逗号
        StringJoiner fields = new StringJoiner(",");
        for(String colName:colNames){
            // 不拼接etl_date和data_dt
            if (!colName.equals(Constant.ODS_ETL_DT_COL) && !colName.equals(Constant.ODS_PARTITION_KEY)){
                fields.add(colName);
            }
        }

        // 日期判断
        String odsDate = cjOdsTableLoadModeInfo.getOdsTablePartitionUnit();
        if ("month".equals(odsDate)){
            odsDate = "yyyyMM";
        }else{
            odsDate = "yyyyMMdd";
        }

        // 切分ods_table_primary_col_name，可能有多个值
        String[] odsTablePrimaryColNames = cjOdsTableLoadModeInfo.getOdsTablePrimaryColName().split(",");
        StringBuffer condition = new StringBuffer();
        for(String str : odsTablePrimaryColNames){
            condition.append("and a.").append(str).append(" = ").append("b.").append(str).append("\n\t");
        }

        // 增量有分区
        if(null == cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource() || cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource().isEmpty()){
            // 增量无分区
            odsHiveScript.append("\n").append("select\n    ").append(fields).append(",etl_dt").append("\n").append("from\n    ").append(Constant.ODS_HIVE_INCREMENT_SCHEMA).
                    append(".").append(odsDataTable).append("\nwhere").append("\n    data_dt = '${DATA_DT}'\n").append("union all\n").append("select\n    ").
                    append(fields).append(",etl_dt").append("\nfrom\n    ").append(Constant.ODS_HIVE_FULL_SCHEMA).append(".").append(odsDataTable).append(" a\n").
                    append("where not exists\n").append("(\n    select 1 from ").append(Constant.ODS_HIVE_INCREMENT_SCHEMA).append(".").append(odsDataTable).
                    append(" b\n    ").append("where 1 = 1\n    ").append(condition).append("and b.data_dt = '${DATA_DT}'\n").append(");");
        }else{
            // 增量有分区
            odsHiveScript.append(" partition(data_dt)\n").append("select\n    ").append(fields).append(",etl_dt").
                    append(",cast(data_format("+cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource()+",\'").append(odsDate).append("\') as string)\n").
                    append("from\n    ").append(Constant.ODS_HIVE_INCREMENT_SCHEMA).append(".").append(odsDataTable).append("\n").append("where\n    ").
                    append("data_dt = '${DATA_DT}'\n").append("union all\n").append("select\n    ").append(fields).append(",etl_dt").append(",data_dt\n").
                    append("from\n    ").append("(select * from ").append(Constant.ODS_HIVE_FULL_SCHEMA).append(".").append(odsDataTable).append("\n        ").
                    append("where data_dt in\n        ").append("(\n        ").append("select distinct date_format("+cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource()
                    +",\'").append(odsDate).append("\') as data_dt\n        ").append("from ").append(Constant.ODS_HIVE_INCREMENT_SCHEMA).append(".").append(odsDataTable).append(" b\n        ").
                    append("where b.data_dt='${DATA_DT}'\n        ").append(")\n    ").append(")").append("a\n").append("where not exists\n").append("(\n    ").append("select 1 from ").
                    append(Constant.ODS_HIVE_INCREMENT_SCHEMA).append(".").append(odsDataTable).append(" b\n    ").append("where 1 = 1\n    ").
                    append(condition).append("and b.data_dt = '${DATA_DT}'\n").append(");");
        }
        return odsHiveScript.toString();
    }

}
