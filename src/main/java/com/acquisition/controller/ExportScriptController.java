package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDwDataScriptDefInfo;
import com.acquisition.entity.CjOdsDataScriptDefInfo;
import com.acquisition.entity.Page;
import com.acquisition.service.*;
import com.acquisition.util.Result;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public Result getOdsTabList(Page reqParams){
        Result result = new Result();
        PageHelper.startPage(reqParams.getPagenum(),reqParams.getPagesize());
        List<CjDataSourceTabInfo> cjDataSourceTabInfo = cjDataSourceTabInfoService.findOdsScriptTableInfo();
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(cjDataSourceTabInfo);
        result.setMsg("获取ODS表清单成功！！！");
        return result.success(page);
    }

    /**
     * 获取要保存DW脚本的表信息
     */
    @RequestMapping(value = "/getDwTabList")
    public Result getDwTabList(Page reqParams){
        Result result = new Result();
        PageHelper.startPage(reqParams.getPagenum(),reqParams.getPagesize());
        List<CjDataSourceTabInfo> dwScriptTableInfos = cjDataSourceTabInfoService.findDwScriptTableInfo();
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(dwScriptTableInfos);
        result.setMsg("获取DW表清单成功！！！");
        return result.success(page);
    }

    /**
     * 保存ODS脚本到本地文件夹
     */
    @RequestMapping(value = "/exportOdsScript")
    public void exportOdsScript(@RequestBody String data,
                                  HttpServletResponse response){
        OutputStream output  = null;
        String ddl = new String();
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("params");
        List<CjOdsDataScriptDefInfo> cjDataSourceTabInfos = JSONObject.parseArray(odsTableList, CjOdsDataScriptDefInfo.class);

//        File path= new File("/data/acquisition/data/scripts");
        File path= new File("data\\");
        if (!path.exists()){
            path.mkdir();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
        String filename = "/ODS初始化" +  df.format(new Date()) + ".txt";
        String file= path.getPath() + filename;

        try {
            output = new FileOutputStream(file);
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
            //实现前端下载文件功能
            ServletOutputStream servletOutputStream = response.getOutputStream();
            response.setContentType("application/octet-stream");
            response.setHeader("Access-Control-Expose-Headers","FileName");
            response.setHeader("FileName",URLEncoder.encode(filename,"UTF-8"));
            FileInputStream fileInputStream = new FileInputStream(file);
            servletOutputStream.write(IOUtils.toByteArray(fileInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 保存DW脚本到本地文件夹
     */
    @RequestMapping(value = "/exportDwScript")
    public void exportDwScript(@RequestBody String data,
                                 HttpServletResponse response){
        OutputStream output  = null;
        String ddl = "";
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("params");
        List<CjDwDataScriptDefInfo> cjDwDataScriptDefInfos = JSONObject.parseArray(odsTableList, CjDwDataScriptDefInfo.class);

//      File path = new File("/data/acquisition/data/scripts");
        File path = new File("data\\");
        if (!path.exists()){
            path.mkdir();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
        String filename = "/DW初始化" + df.format(new Date()) + ".sql";
        String file= path.getPath() + filename;

        try {
            output = new FileOutputStream(file);
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
            //实现前端下载文件功能
            ServletOutputStream servletOutputStream = response.getOutputStream();
            response.setContentType("application/octet-stream");
            response.setHeader("Access-Control-Expose-Headers","FileName");
            response.setHeader("FileName",URLEncoder.encode(filename,"UTF-8"));
            FileInputStream fileInputStream = new FileInputStream(file);
            servletOutputStream.write(IOUtils.toByteArray(fileInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 返回要导出表的筛选列表
     */
    @RequestMapping(value = "/getFilterList")
    public Result getFilterList(){
        Result result = new Result();
        List<CjDataSourceTabInfo> sysAndSchemaList = cjDataSourceTabInfoService.findOdsExportTableInfoByFilterList();

        Map<String,List<String>> listLinkedHashMap = new LinkedHashMap<>();
        for (CjDataSourceTabInfo tabInfo : sysAndSchemaList){
            if (listLinkedHashMap.get(tabInfo.getBusinessSystemNameShortName()) != null){
                listLinkedHashMap.get(tabInfo.getBusinessSystemNameShortName()).add(tabInfo.getDataSourceSchema());
            }else {
                List<String> list = new ArrayList();
                list.add(tabInfo.getDataSourceSchema());
                listLinkedHashMap.put(tabInfo.getBusinessSystemNameShortName(),list);
            }
        }

        result.setData(listLinkedHashMap);
        return result;
    }

    /**
     * 返回筛选结果
     */
    @RequestMapping(value = "/getFilterResults")
    public Result getFilterResults(){
        Result result = new Result();


        return result;
    }
}
