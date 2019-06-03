package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.util.Result;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@RestController
@RequestMapping(value = "/generateScript")
public class GenerateScriptController {
    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    public ICjDataSourceTabInfoService cjDataSourceTabInfoService;

    @GetMapping(value = "/getDwTabList")
    public Result generateDwInitScript() {
        Result result=new Result();
        List<CjDataSourceTabInfo> allCjVGetPrepareScriptForDwTabList = cjDataSourceTabInfoService.findAllCjVGetPrepareScriptForDwTabList();
        return result.success(allCjVGetPrepareScriptForDwTabList);
    }
}
