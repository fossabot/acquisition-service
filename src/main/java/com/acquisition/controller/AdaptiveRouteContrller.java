package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceConnDefine;
import com.acquisition.service.ICjDataSourceConnDefineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yxk
 * @Description: 通配Contrller
 * @create 2019/5/30
 * @since 1.0.0
 */
@Controller
public class AdaptiveRouteContrller {

    @Resource(name = "cjDataSourceConnDefineServiceImpl")
    ICjDataSourceConnDefineService iCjDataSourceConnDefineService;

   @RequestMapping(value = "/{index}")
    public String index(@PathVariable("index") String index) {
        return index;
    }


    @RequestMapping(value = "/kp")
    @ResponseBody
    public List<CjDataSourceConnDefine> index() {
        List<CjDataSourceConnDefine> ff= iCjDataSourceConnDefineService.selectByExample();
        return ff;
    }



    @RequestMapping(value = "/oop")
    @ResponseBody
    public String oop(@RequestParam("str") String str) {
        List<CjDataSourceConnDefine> ff= iCjDataSourceConnDefineService.selectByExample();
        return "";
    }


}
