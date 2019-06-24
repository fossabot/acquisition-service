package com.acquisition.controller;

import com.acquisition.entity.*;
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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    public ICjDwDataScriptDefInfoService cjDwDataScriptDefInfoService;

    @Resource(name = "cjOdsDataScriptDefInfoServiceImpl")
    public ICjOdsDataScriptDefInfoService iCjOdsDataScriptDefInfoService;

    @Resource(name = "cjDataSourceConnDefineServiceImpl")
    public ICjDataSourceConnDefineService iCjDataSourceConnDefineService;

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
            dwInitScript.append("from "+Constant.ODS_HIVE_SCHEMA+"."+odsTableName);
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
        String str1 = "sh /home/infa/zwj/ods_import_new_etl.sh url username password ";
        String columns = "";
        String str2 = " no no init \"\" \"\" ";
        StringBuffer scripts = new StringBuffer();
        CjOdsDataScriptDefInfo cjOdsDataScriptDefInfo = new CjOdsDataScriptDefInfo();

        //拼接Sqooop脚本
        for (CjDataSourceTabInfo table : tabInfos) {
            //判断系统名连接数
            if (Integer.parseInt(iCjDataSourceConnDefineService.selectSystemName(table.getBusinessSystemNameShortName())) > 1){
                scripts.append(str1 + table.getBusinessSystemNameShortName() + "~"
                        + table.getDataSourceSchema()+ " "
                        + table.getDataSourceTable() + str2 + "\"");
            }else {
                scripts.append(str1 + table.getBusinessSystemNameShortName() + " "
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
}
