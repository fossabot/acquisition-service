package com.acquisition.controller;

import com.acquisition.entity.CjDwDataScriptDefInfo;
import com.acquisition.entity.CjOdsDataScriptDefInfo;
import com.acquisition.service.*;
import com.acquisition.util.Result;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/6/3.
 */
@RestController
@RequestMapping(value = "/exportScript")
public class ExportScriptController {

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    public ICjDataSourceTabInfoService cjDataSourceTabInfoService;

    @Resource(name = "cjOdsDataScriptDefInfoServiceImpl")
    public ICjOdsDataScriptDefInfoService iCjOdsDataScriptDefInfoService;

    @Resource(name = "cjDwDataScriptDefInfoServiceImpl")
    public ICjDwDataScriptDefInfoService iCjDwDataScriptDefInfoService;

    /**
     * 获取要保存ODS脚本的表信息
     */
    @RequestMapping(value = "/getOdsTabList")
    public Result getOdsTabList(){
        Result result = new Result();
        result.setMsg("获取ODS表清单成功！！！");
        return result.success(cjDataSourceTabInfoService.findOdsScriptTableInfo());
    }

    /**
     * 获取要保存DW脚本的表信息
     */
    @RequestMapping(value = "/getDwTabList")
    public Result getDwTabList(){
        Result result = new Result();
        result.setMsg("获取DW表清单成功！！！");
        return result.success(cjDataSourceTabInfoService.findDwScriptTableInfo());
    }

    /**
     * 保存ODS脚本到本地文件夹
     */
    @RequestMapping(value = "/exportOdsScript")
    public Result exportOdsScript(@RequestBody String data){
        Result result = new Result();
        OutputStream output  = null;
        String ddl = new String();
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("params");
        List<CjOdsDataScriptDefInfo> cjDataSourceTabInfos = JSONObject.parseArray(odsTableList, CjOdsDataScriptDefInfo.class);

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
            File filename = new File("D:\\Java\\acquisition-service\\data\\ODS初始化" + df.format(new Date()));
            //判断文件是否存在，不存在则新建
            if (!filename.exists()){
                filename.createNewFile();
            }
            output = new FileOutputStream(filename);
            //遍历获取表的元数据并获取脚本信息,写到文件中
            for (CjOdsDataScriptDefInfo table : cjDataSourceTabInfos){
                ddl = iCjOdsDataScriptDefInfoService.selectScriptInfo(
                        table.getBusinessSystemNameShortName(),
                        table.getDataSourceSchema(),
                        table.getDataSourceTable()
                );
                if (ddl == null){
                    continue;
                }
                output.write(ddl.concat("\n").getBytes());
            }
            if (filename.length() == 0){
                filename.delete();
            }
        } catch (IOException e) {
            result.setCode(500);
            result.setMsg("文件写入异常！！！");
            return result;
        }finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        result.setCode(200);
        result.setMsg("ODS脚本保存成功！！！");
        return result;
    }


    /**
     * 保存DW脚本到本地文件夹
     */
    @RequestMapping(value = "/exportDwScript")
    public Result exportDwScript(@RequestBody String data){
        Result result = new Result();
        OutputStream output  = null;
        String ddl = new String();
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("params");
        List<CjDwDataScriptDefInfo> cjDwDataScriptDefInfos = JSONObject.parseArray(odsTableList, CjDwDataScriptDefInfo.class);

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
            File filename = new File("D:\\Java\\acquisition-service\\data\\DW初始化" + df.format(new Date()) + ".sql");
            //判断文件是否存在，不存在则新建
            if (!filename.exists()){
                filename.createNewFile();
            }
            output = new FileOutputStream(filename);
            //遍历获取表的元数据
            for (CjDwDataScriptDefInfo table : cjDwDataScriptDefInfos){
                ddl = iCjDwDataScriptDefInfoService.selectDdlInfo(
                        table.getBusinessSystemNameShortName(),
                        table.getDataSourceSchema(),
                        table.getDataSourceTable()
                );
                if (ddl == null){
                    continue;
                }
                output.write(ddl.concat(";\n\n\n").getBytes());
            }
            if (filename.length() == 0){
                filename.delete();
            }
        } catch (IOException e) {
            result.setCode(500);
            result.setMsg("文件写入异常！！！");
            return result;
        }finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        result.setCode(200);
        result.setMsg("DW脚本保存成功！！！");
        return result;
    }
}
