package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDwDataScriptDefInfo;
import com.acquisition.entity.CjOdsDataScriptDefInfo;
import com.acquisition.entity.CjOdsDataScriptDefInfoKey;
import com.acquisition.service.CjDwDataScriptDefInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.service.ICjOdsDataScriptDefInfoService;
import com.acquisition.util.Constant;
import com.acquisition.util.CreateTableUtil;
import com.acquisition.util.Result;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.util.IOUtils;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "exportScript",description = "初始化ODS/DW脚本导出")
@RestController
@RequestMapping(value = "/exportScript")
public class ExportScriptController {

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    public ICjDataSourceTabInfoService cjDataSourceTabInfoService;

    @Resource(name = "cjOdsDataScriptDefInfoServiceImpl")
    public ICjOdsDataScriptDefInfoService iCjOdsDataScriptDefInfoService;

    @Resource(name = "cjDwDataScriptDefInfoServiceImpl")
    public CjDwDataScriptDefInfoService cjDwDataScriptDefInfoService;

    /**
     * 获取要保存ODS脚本的表信息
     */
    @ApiOperation("获取ODS脚本导出清单")
    @GetMapping(value = "/getOdsTabList")
    public Result getOdsTabList(@RequestParam("schema") String schema) {
        Result result = new Result();
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findOdsScriptTableInfo(schema);
        result.setMsg("获取ODS表清单成功！！！");
        return result.success(cjDataSourceTabInfos);
    }

    /**
     * 获取要保存DW脚本的表信息
     */
    @ApiOperation("获取DW脚本导出清单")
    @GetMapping(value = "/getDwTabList")
    public Result getDwTabList(@RequestParam("schema") String schema) {
        Result result = new Result();
        List<CjDataSourceTabInfo> dwScriptTableInfos = cjDataSourceTabInfoService.findDwScriptTableInfo(schema);
        result.setMsg("获取DW表清单成功！！！");
        return result.success(dwScriptTableInfos);
    }

    /**
     * 保存ODS脚本到本地文件夹
     */
    @ApiOperation("导出ODS初始化脚本")
    @PostMapping(value = "/exportOdsInitScript")
    public void exportOdsInitScript(@RequestBody String data,
                                HttpServletResponse response) {
        OutputStream output = null;
        String ddl;
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("params");
        List<CjOdsDataScriptDefInfo> cjDataSourceTabInfos = JSONObject.parseArray(odsTableList, CjOdsDataScriptDefInfo.class);

        File path = new File("/data/acquisition/data/scripts");
//        File path= new File("data\\");
        if (!path.exists()) {
            path.mkdir();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
        String filename = "/ODS初始化" + df.format(new Date()) + ".txt";
        String file = path.getPath() + filename;

        try {
            output = new FileOutputStream(file);
            //遍历获取表的元数据并获取脚本信息,写到文件中
            for (CjOdsDataScriptDefInfo table : cjDataSourceTabInfos) {
                String businessSystemNameShortName = table.getBusinessSystemNameShortName();
                String dataSourceSchema = table.getDataSourceSchema();
                String dataSourceTable = table.getDataSourceTable();
                String odsTableName = CreateTableUtil.getOdsTableName(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
                CjOdsDataScriptDefInfoKey key = new CjOdsDataScriptDefInfo();
                key.setBusinessSystemNameShortName(table.getBusinessSystemNameShortName());
                key.setDataSourceSchema(table.getDataSourceSchema());
                key.setDataSourceTable(table.getDataSourceTable());
                key.setOdsDataScriptType(Constant.ODS_INIT_EXTRACT);
                key.setOdsDataTable(odsTableName);
                ddl = iCjOdsDataScriptDefInfoService.findByPrimaryKey(key).getOdsDataSqoopDefine();
                if (ddl == null) {
                    continue;
                }
                output.write(ddl.concat("\n").getBytes());
            }
            //实现前端下载文件功能
            ServletOutputStream servletOutputStream = response.getOutputStream();
            response.setContentType("application/octet-stream");
            response.setHeader("Access-Control-Expose-Headers", "FileName");
            response.setHeader("FileName", URLEncoder.encode(filename, "UTF-8"));
            FileInputStream fileInputStream = new FileInputStream(file);
            servletOutputStream.write(IOUtils.toByteArray(fileInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 保存ODS脚本到本地文件夹
     */
    @ApiOperation("导出ODS调度脚本")
    @PostMapping(value = "/exportOdsSchedulScript")
    public void exportOdsSchedulScript(@RequestBody String data,
                                HttpServletResponse response) {
        OutputStream output = null;
        String ddl;
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("params");
        List<CjOdsDataScriptDefInfo> cjDataSourceTabInfos = JSONObject.parseArray(odsTableList, CjOdsDataScriptDefInfo.class);

        File path = new File("/data/acquisition/data/scripts");
//        File path= new File("data\\");
        if (!path.exists()) {
            path.mkdir();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
        String filename = "/ODS调度" + df.format(new Date()) + ".txt";
        String file = path.getPath() + filename;

        try {
            output = new FileOutputStream(file);
            //遍历获取表的元数据并获取脚本信息,写到文件中
            for (CjOdsDataScriptDefInfo table : cjDataSourceTabInfos) {
                String businessSystemNameShortName = table.getBusinessSystemNameShortName();
                String dataSourceSchema = table.getDataSourceSchema();
                String dataSourceTable = table.getDataSourceTable();
                String odsTableName = CreateTableUtil.getOdsTableName(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
                CjOdsDataScriptDefInfoKey key = new CjOdsDataScriptDefInfo();
                key.setBusinessSystemNameShortName(table.getBusinessSystemNameShortName());
                key.setDataSourceSchema(table.getDataSourceSchema());
                key.setDataSourceTable(table.getDataSourceTable());
                key.setOdsDataScriptType(Constant.ODS_INIT_EXTRACT);
                key.setOdsDataTable(odsTableName);
                ddl = iCjOdsDataScriptDefInfoService.selectSchedulScript(table.getBusinessSystemNameShortName(),
                        table.getDataSourceSchema(),table.getDataSourceTable(),odsTableName,Constant.ODS_INIT_EXTRACT);
                if (ddl == null) {
                    continue;
                }
                output.write(ddl.concat("\n").getBytes());
            }
            //实现前端下载文件功能
            ServletOutputStream servletOutputStream = response.getOutputStream();
            response.setContentType("application/octet-stream");
            response.setHeader("Access-Control-Expose-Headers", "FileName");
            response.setHeader("FileName", URLEncoder.encode(filename, "UTF-8"));
            FileInputStream fileInputStream = new FileInputStream(file);
            servletOutputStream.write(IOUtils.toByteArray(fileInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
    @ApiOperation("导出dw脚本")
    @PostMapping(value = "/exportDwScript")
    public void exportDwScript(@RequestBody String data,
                               HttpServletResponse response) {
        OutputStream output = null;
        String ddl = "";
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("params");
        List<CjDwDataScriptDefInfo> cjDwDataScriptDefInfos = JSONObject.parseArray(odsTableList, CjDwDataScriptDefInfo.class);

        File path = new File("/data/acquisition/data/scripts");
//        File path = new File("data\\");
        if (!path.exists()) {
            path.mkdir();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
        String filename = "/DW初始化" + df.format(new Date()) + ".sql";
        String file = path.getPath() + filename;

        try {
            output = new FileOutputStream(file);
            //遍历获取表的元数据
            for (CjDwDataScriptDefInfo table : cjDwDataScriptDefInfos) {
                ddl = cjDwDataScriptDefInfoService.selectDdlInfo(
                        table.getBusinessSystemNameShortName(),
                        table.getDataSourceSchema(),
                        table.getDataSourceTable()
                );
                if (ddl == null) {
                    continue;
                }
                output.write(ddl.concat(";\n\n\n").getBytes());
            }
            //实现前端下载文件功能
            ServletOutputStream servletOutputStream = response.getOutputStream();
            response.setContentType("application/octet-stream");
            response.setHeader("Access-Control-Expose-Headers", "FileName");
            response.setHeader("FileName", URLEncoder.encode(filename, "UTF-8"));
            FileInputStream fileInputStream = new FileInputStream(file);
            servletOutputStream.write(IOUtils.toByteArray(fileInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 返回要导出表的筛选列表
     *
     * @param flag 1=ods 0=dw
     * @return
     */
    @GetMapping(value = "/getFilterList")
    public Result getFilterList(@RequestParam("flag") String flag) {
        Result result = new Result();
        List<CjDataSourceTabInfo> sysAndSchemaList = cjDataSourceTabInfoService.findOdsExportTableInfoByFilterList(flag);

        Map<String, List<String>> listLinkedHashMap = new LinkedHashMap<>();
        for (CjDataSourceTabInfo tabInfo : sysAndSchemaList) {
            if (listLinkedHashMap.get(tabInfo.getBusinessSystemNameShortName()) != null) {
                listLinkedHashMap.get(tabInfo.getBusinessSystemNameShortName()).add(tabInfo.getDataSourceSchema());
            } else {
                List<String> list = new ArrayList();
                list.add(tabInfo.getDataSourceSchema());
                listLinkedHashMap.put(tabInfo.getBusinessSystemNameShortName(), list);
            }
        }

        result.setData(listLinkedHashMap);
        return result;
    }

    /**
     * 返回筛选结果
     */
    @RequestMapping(value = "/getFilterResults")
    public Result getFilterResults() {
        Result result = new Result();


        return result;
    }
}
