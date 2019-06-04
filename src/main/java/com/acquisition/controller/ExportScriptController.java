package com.acquisition.controller;

import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zhangdongmao on 2019/6/3.
 */
@RestController
@RequestMapping(value = "/exportScript")
public class ExportScriptController {

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    public ICjDataSourceTabInfoService cjDataSourceTabInfoService;

    public Result getDwTabList(){
        Result result = new Result();
//        cjDataSourceTabInfoService.
        return result;
    }
}
