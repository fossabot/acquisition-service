package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.Page;
import com.acquisition.entity.PageGeorge;
import com.acquisition.entity.ExclePropertyModel;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.util.Result;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.util.IOUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author : Francis Du
 * @Date : Create in 11:19 2019/6/10
 * Modified By :
 */
@RestController
@RequestMapping(value = "/tableStatus")
public class DatalakeTableStatusContrller {

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    ICjDataSourceTabInfoService iCjDataSourceTabInfoService;

    /**
     * @return 返回系统缩写列表
     */
    @GetMapping(value = "/getSysList")
    public Result getSysList() {
        Result result = new Result();
        result.setMsg("查询成功！！！");
        result.setData(iCjDataSourceTabInfoService.findSysList());
        result.setCode(200);
        return result;
    }

    /**
     * @return
     */
    @GetMapping(value = "/getStatusList")
    public Result getStatusList(Page reqParams) {
        Result result = new Result();
        PageHelper.startPage(reqParams.getPagenum(), reqParams.getPagesize());
        PageInfo<CjDataSourceTabInfo> page = new PageInfo(iCjDataSourceTabInfoService.findSumOfTables());
        result.setData(iCjDataSourceTabInfoService.findSumOfTables());
        result.setMsg("查询成功！！！");
        result.setCode(200);
        result.setData(page);
        return result;
    }

    /**
     * @return 返回筛选后的数据
     */
    @PostMapping(value = "/getStatusBySys")
    public Result getStatusBySys(@RequestBody PageGeorge<CjDataSourceTabInfo> reqParams) {
        Result result = new Result();
        PageHelper.startPage(reqParams.getPagenum(), reqParams.getPagesize());
        PageInfo<CjDataSourceTabInfo> page = new PageInfo(
                iCjDataSourceTabInfoService.findSumOfTablesBySys(reqParams.query.getBusinessSystemNameShortName()));
        result.setData(page);
        result.setMsg("查询成功！！！");
        result.setCode(200);
        return result;
    }

    /**
     * 导出成excle
     * @return 返回excle的二进制流
     */
    @PostMapping(value = "/exportExcle")
    public Result exportExcle(@RequestBody List<ExclePropertyModel> dataList, HttpServletResponse response) throws IOException {
        Result result = new Result();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmss");

        //判断文件夹是否存在，不存在则新建
        String path = "data\\";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        String filename = file.getPath() + "/入湖报告" + dateFormat.format(new Date()) + ".xlsx";
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(filename);
            ExcelWriter excelWriter = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0, ExclePropertyModel.class);
            sheet1.setSheetName("入湖报告");
            excelWriter.write(dataList, sheet1);
            excelWriter.finish();

            ServletOutputStream servletOutputStream = response.getOutputStream();
            response.setHeader("Content-Disposition","attachment;filename=".concat(filename));
            FileInputStream fileInputStream = new FileInputStream(filename);
            servletOutputStream.write(IOUtils.toByteArray(fileInputStream));

        } catch (FileNotFoundException e) {
            result.setCode(500);
            result.setMsg("数据导出失败！！！");
            try {
                outputStream.flush();
            } catch (IOException ex) {
                result.setCode(500);
                result.setMsg("文件流关闭失败！！！");

            }
        } finally {
            try {
                outputStream.flush();
            } catch (IOException e) {
                result.setCode(500);
                result.setMsg("文件流关闭失败！！！");

            }
        }
        result.setCode(200);
        result.setMsg("文件导出成功！！！");
        result.setData(filename);
        return null;
    }
}
