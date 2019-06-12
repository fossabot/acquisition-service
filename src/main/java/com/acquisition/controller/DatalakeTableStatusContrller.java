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
import java.net.URLEncoder;
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
    public void exportExcle(@RequestBody List<ExclePropertyModel> dataList,
                              HttpServletResponse response) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmss");

        //      File path = new File("/data/acquisition/data/scripts");
        File path = new File("data\\");
        if (!path.exists()) {
            path.mkdir();
        }
        String filename = "/入湖报告" + dateFormat.format(new Date()) + ".xlsx";
        String file = path.getPath() + filename;
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            ExcelWriter excelWriter = new ExcelWriter(outputStream, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0, ExclePropertyModel.class);
            sheet1.setSheetName("入湖报告");
            excelWriter.write(dataList, sheet1);
            excelWriter.finish();

            //实现前端下载
            ServletOutputStream servletOutputStream = response.getOutputStream();
            response.setHeader("Access-Control-Expose-Headers","FileName");
            response.setHeader("FileName",URLEncoder.encode(filename,"UTF-8"));
            FileInputStream fileInputStream = new FileInputStream(file);
            servletOutputStream.write(IOUtils.toByteArray(fileInputStream));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            try {
                outputStream.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
