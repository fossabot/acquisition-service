package com.acquisition.controller;

import com.acquisition.entity.*;
import com.acquisition.entity.pojo.CjDwCrtDdlColPojo;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.service.ICjDwDataScriptDefInfoService;
import com.acquisition.util.Constant;
import com.acquisition.service.ICjOdsDataScriptDefInfoService;
import com.acquisition.util.Result;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
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


    @GetMapping(value = "/getODSSystemFilterList")
    public Result getODSSystemFilterList() {
        Result result = new Result();
        List<String> systems = cjDataSourceTabInfoService.findDistSystemFromCjVGetPrepareScriptForOdsTabList();
        return result.success(systems);
    }

    @GetMapping(value = "/getDWSystemFilterList")
    public Result getDWSystemFilterList() {
        Result result = new Result();
        List<String> systems = cjDataSourceTabInfoService.findDistSystemFromCjVGetPrepareScriptForDwTabList();
        return result.success(systems);
    }
    /**
    * @Author: zhangdongmao
    * @Date: 2019/6/4
    * @Description:  获取DW脚本生成列表
    * @Param: * @param null 1
    * @return:
    */
    @GetMapping(value = "/getDwTabList")
    public Result getDwTabList() {
        Result result=new Result();
        List<CjDataSourceTabInfo> allCjVGetPrepareScriptForDwTabList = cjDataSourceTabInfoService.findAllCjVGetPrepareScriptForDwTabList();
        return result.success(allCjVGetPrepareScriptForDwTabList);
    }
    /** 
    * @Author: zhangdongmao
    * @Date: 2019/6/4 
    * @Description:  生成并保存DW初始化脚本
    * @Param: * @param null 1 
    * @return:
    */
    @PostMapping(value = "/generateDwInitScript")
    public Result generateDwInitScript(@RequestBody String data) {
        Result result=new Result();
        JSONObject jsonObject = JSONObject.parseObject(data);
        System.out.println(jsonObject);
        data = jsonObject.getString("params");
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = JSONObject.parseArray(data, CjDataSourceTabInfo.class);

        for (CjDataSourceTabInfo cjDataSourceTabInfo:cjDataSourceTabInfos){
            String dataSourceSchema = cjDataSourceTabInfo.getDataSourceSchema();
            String businessSystemNameShortName = cjDataSourceTabInfo.getBusinessSystemNameShortName();
            String dataSourceTable = cjDataSourceTabInfo.getDataSourceTable();
            String dwTableName="d_nct_"+dataSourceSchema.toLowerCase()+"_"+dataSourceTable.toLowerCase();
            String odsTableName=businessSystemNameShortName.toLowerCase()+"_"+dataSourceTable.toLowerCase();
            StringBuffer dwInitScript=new StringBuffer();
            String colName;
            //通过系统名、数据模式、表名获取表的字段信息
            List<CjDwCrtDdlColPojo> cjDwCrtDdlColPojos = cjDataSourceTabColInfoService.selectCjDwCrtDdlColPojoBySysAndSchemaAndTab(businessSystemNameShortName, dataSourceSchema, dataSourceTable);

            dwInitScript.append("set hive.exec.dynamic.partition=true;\n");
            dwInitScript.append("set hive.exec.dynamic.partition.mode=nonstrict;\n");
            dwInitScript.append("set hive.exec.max.dynamic.partitions.pernode = 10000;\n");
            dwInitScript.append("insert overwrite table data_lake."+dwTableName+"\n");
            for(int i=0;i<cjDwCrtDdlColPojos.size();i++) {
                colName=cjDwCrtDdlColPojos.get(i).getDataSourceColName().toLowerCase();
                dwInitScript.append("`" + colName + "`    as    " + colName + ",\n");
            }

            dwInitScript.append("row_id    as src_sys_row_id,\n");
            dwInitScript.append(cjDataSourceTabInfo.getBusinessSystemNameShortName().toLowerCase()+"    "+"as src_sys_cd,\n");
            dwInitScript.append("'"+businessSystemNameShortName.toLowerCase()+"_"+dataSourceTable.toLowerCase()+"'    as src_table_name,\n");
            dwInitScript.append("cast( current_timestamp() as string)    as etl_dt,\n");
            dwInitScript.append("cast(date_format('${TX_DATE}','yyyyMMdd') as string)    as data_dt,\n");
            dwInitScript.append("data_dt    as partition_key\n");
            dwInitScript.append("from sdata_full."+odsTableName);
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
            System.out.println(cjDataSourceTabInfo.getBusinessSystemNameShortName()+":"+cjDataSourceTabInfo.getDataSourceSchema()+":"+cjDataSourceTabInfo.getDataSourceTable()+":"+dwTableName+":"+odsTableName);
            cjDwDataScriptDefInfoService.deleteByPrimaryKey(key);
            if(cjDwDataScriptDefInfoService.save(cjDwDataScriptDefInfo).equals("保存成功")){
                //生成DW建表语句成功，设置状态表中的相应状态字段
                cjDataSourceTabInfo.setDataFlagForCrtDwScript(Constant.DW_CRT_SCRPIT);
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
    @GetMapping(value = "/getODSTableInfo")
    @ResponseBody
    public Result getODSTableInfo(){
        Result result = new Result();
        return result.success(cjDataSourceTabInfoService.findODSTableInfo());
    }

    /**
     * @return 获取前端的数据，解析所需要的字段
     */
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
        String str1 = "sh /home/infa/datalake_function/ods_import_new_etl.sh url username password ";
        String columns = "";
        String str2 = " no no init ";
        StringBuffer scripts = new StringBuffer();
        CjOdsDataScriptDefInfo cjOdsDataScriptDefInfo = new CjOdsDataScriptDefInfo();

        //拼接Sqooop脚本
        for (CjDataSourceTabInfo table : tabInfos) {
            scripts.append(str1 + table.getBusinessSystemNameShortName() + " "
                    + table.getDataSourceSchema()+ "."
                    + table.getDataSourceTable() + str2 + "\"");

            List<CjDataSourceTabColInfo> infoList = cjDataSourceTabColInfoService
                    .findBySystemAndSchemaAndTab(
                            table.getBusinessSystemNameShortName(),
                            table.getDataSourceSchema(),
                            table.getDataSourceTable());

            for (int i = 0; i < infoList.size(); i++){
                if (i == infoList.size() - 1 ){
                    columns = infoList.get(i).getDataSourceColName() + "\"";
                    scripts.append(columns);
                }else {
                    columns = infoList.get(i).getDataSourceColName() + ",";
                    scripts.append(columns);
                }
            }

            cjOdsDataScriptDefInfo.setBusinessSystemId(table.getBusinessSystemId());
            cjOdsDataScriptDefInfo.setBusinessSystemNameShortName(table.getBusinessSystemNameShortName());
            cjOdsDataScriptDefInfo.setDataSourceSchema(table.getDataSourceSchema());
            cjOdsDataScriptDefInfo.setDataSourceTable(table.getDataSourceTable());
            cjOdsDataScriptDefInfo.setOdsDataTable(table.getDataSourceTable());
            cjOdsDataScriptDefInfo.setOdsDataScriptType("init");
            cjOdsDataScriptDefInfo.setOdsDataSqoopDefine(scripts.toString());
//            cjOdsDataScriptDefInfo.setOdsDataHivesqlDefine();
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
