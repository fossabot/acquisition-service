package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDataSourceTabInfoExample;
import com.acquisition.entity.CjDwDataScriptDefInfo;
import com.acquisition.entity.pojo.CjDwCrtDdlColPojo;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.service.ICjDwDataScriptDefInfoService;
import com.acquisition.util.Constant;
import com.acquisition.util.Result;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @GetMapping(value = "/getDwTabList")
    public Result getDwTabList() {
        Result result=new Result();
        List<CjDataSourceTabInfo> allCjVGetPrepareScriptForDwTabList = cjDataSourceTabInfoService.findAllCjVGetPrepareScriptForDwTabList();
        return result.success(allCjVGetPrepareScriptForDwTabList);
    }
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
            String odsTableName=businessSystemNameShortName.toLowerCase()+"_"+dataSourceSchema.toLowerCase()+"_"+dataSourceTable.toLowerCase();
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
                if(i<cjDwCrtDdlColPojos.size()-1) {
                    dwInitScript.append("`" + colName + "`    as    " + colName + ",\n");
                }else {
                    dwInitScript.append("`" + colName + "`    as    " + colName+"\n");
                }
            }
            dwInitScript.append("from sdata_full."+odsTableName);
            System.out.println(dwInitScript);
            CjDwDataScriptDefInfo cjDwDataScriptDefInfo=new CjDwDataScriptDefInfo();
            cjDwDataScriptDefInfo.setBusinessSystemId(cjDataSourceTabInfo.getBusinessSystemId());
            cjDwDataScriptDefInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
            cjDwDataScriptDefInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
            cjDwDataScriptDefInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
            cjDwDataScriptDefInfo.setOdsDataTable(cjDataSourceTabInfo.getDataSourceTable());
            cjDwDataScriptDefInfo.setDwDataTable(dwTableName);
            cjDwDataScriptDefInfo.setDwDataScriptType("初始化脚本");
            cjDwDataScriptDefInfo.setDwDataHivesqlDefine(dwInitScript.toString());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjDwDataScriptDefInfo.setLastModifyDt(df.format(new Date()));
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
        return result.success("生成初始化脚本成功");
    }

}
