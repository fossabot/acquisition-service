package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.Page;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public Result getStatusBySys(@RequestBody CjDataSourceTabInfo data){
        Result result = new Result();
        result.setData(iCjDataSourceTabInfoService.findSumOfTablesBySys(
                data.getBusinessSystemNameShortName()));
        result.setMsg("查询成功！！！");
        result.setCode(200);
        return  result;
    }
}
