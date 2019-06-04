package com.acquisition.controller;

import com.acquisition.entity.ViewSourceSystemEntity;
import com.acquisition.service.ICjDataSourceConnDefineService;
import com.acquisition.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@RestController
@RequestMapping(value = "/getSourceMetaData")
public class GetSourceMetaDataController {

    @Resource(name = "cjDataSourceConnDefineServiceImpl")
    ICjDataSourceConnDefineService iCjDataSourceConnDefineService;


    /**
     * 获取配置的参数
     *
     * @return
     */
    @RequestMapping("/getDataInfo")
    public Result getDataSourceInfo() {
        List<ViewSourceSystemEntity> list = iCjDataSourceConnDefineService.selectViewContet();
        return new Result().success(list);
    }


    /**
     * 获取参数，插入元数据
     *
     * @param arg
     * @return
     */
    @RequestMapping("/getConnection")
    public String setStauts(String arg) {

        String[] argArr = arg.split(",");
        for (String str : argArr) {

        }
        return "";
    }

}
