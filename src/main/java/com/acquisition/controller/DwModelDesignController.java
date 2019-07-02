package com.acquisition.controller;

import com.acquisition.entity.CjDwCrtTabDdlInfo;
import com.acquisition.entity.CjDwTableColInfo;
import com.acquisition.entity.CjDwTableColInfoExample;
import com.acquisition.service.CjDwCrtTabDdlInfoService;
import com.acquisition.service.CjDwTableColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.util.Constant;
import com.acquisition.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/7/2.
 */
@Api(tags = "dwModelDesign",description = "DW模型设计")
@RequestMapping("dwModelDesign")
@RestController
public class DwModelDesignController {

    @Resource(name = "cjDwTableColInfoServiceImpl")
    CjDwTableColInfoService cjDwTableColInfoService;

    @ApiOperation("按备用区表名查表")
    @GetMapping("/getTabByBakName")
    public Result getTabByBakName(@RequestParam(value = "dwDataTable") String dwDataTable) {
        List<CjDwTableColInfo> list = cjDwTableColInfoService.selectColInfoByTopicAndTab(Constant.DW_BAK_DEFAULT_TOPIC_DOMAIN,dwDataTable);
        return new Result().success(list);
    }
}
