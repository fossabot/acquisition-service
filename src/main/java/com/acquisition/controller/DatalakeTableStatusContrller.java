package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.Page;
import com.acquisition.entity.PageGeorge;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public Result getSysList(){
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
        public Result getStatusList(Page reqParams){
            Result result = new Result();
            PageHelper.startPage(reqParams.getPagenum(),reqParams.getPagesize());
            PageInfo<CjDataSourceTabInfo> page = new PageInfo(iCjDataSourceTabInfoService.findSumOfTables());
            result.setData(iCjDataSourceTabInfoService.findSumOfTables());
            result.setMsg("查询成功！！！");
            result.setCode(200);
            result.setData(page);
            return  result;
    }

    /**
     * @return 返回筛选后的数据
     */
    @PostMapping(value = "/getStatusBySys")
    public Result getStatusBySys(@RequestBody PageGeorge<CjDataSourceTabInfo> reqParams){
        Result result = new Result();
        PageHelper.startPage(reqParams.getPagenum(),reqParams.getPagesize());
        PageInfo<CjDataSourceTabInfo> page = new PageInfo(
                iCjDataSourceTabInfoService.findSumOfTablesBySys(reqParams.query.getBusinessSystemNameShortName()));
        result.setData(page);
        result.setMsg("查询成功！！！");
        result.setCode(200);
        return  result;
    }

    /**
     * 导出成excle
     */
    @PostMapping(value = "/exportExcle")
    public Result exportExcle(){
        Result result = new Result();
        HSSFWorkbook webbook = new HSSFWorkbook();
        HSSFSheet sheet = webbook.createSheet("入湖报告！！！");

        return result;
    }
}
