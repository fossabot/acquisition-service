package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabColInfo;
import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjOdsCrtTabDdlInfo;
import com.acquisition.entity.CjOdsDataScriptDefInfo;
import com.acquisition.service.ICjDataSourceConnDefineService;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.service.ICjOdsDataScriptDefInfoService;
import com.acquisition.util.Result;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Resource(name = "cjOdsDataScriptDefInfoServiceImpl")
    public ICjOdsDataScriptDefInfoService iCjOdsDataScriptDefInfoService;

    @GetMapping(value = "/getDwTabList")
    public Result generateDwInitScript() {
        Result result=new Result();
        List<CjDataSourceTabInfo> allCjVGetPrepareScriptForDwTabList = cjDataSourceTabInfoService.findAllCjVGetPrepareScriptForDwTabList();
        return result.success(allCjVGetPrepareScriptForDwTabList);
    }

    /**
     * @return 返回生成ODS脚本状态
     */
    @GetMapping(value = "/getODSTableInfo")
    @ResponseBody
    public Result getODSTableInfo(){
        Result result = new Result();
        return result.success(cjDataSourceTabInfoService.findODSTaableInfo());
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
//            saveSqoopScrtpts(scripts);
            scripts.setLength(0);
        }

        return result.success(200);
    }

    /**
     * 保存Sqoop脚本到本地文件夹
     */
    public void saveSqoopScrtpts(StringBuffer scripts){
        try {
            OutputStream output  = new FileOutputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
