package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabColInfo;
import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.Page;
import com.acquisition.entity.PageGeorge;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yxk
 * @Description: 入湖总览
 * @create 2019/6/10
 * @since 1.0.0
 */
@RequestMapping("enterHuOverview")
@RestController
public class EnterHuOverview {

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    ICjDataSourceTabInfoService iCjDataSourceTabInfoService;

    @Resource(name = "cjDataSourceTabColInfoServiceImpl")
    ICjDataSourceTabColInfoService iCjDataSourceTabColInfoService;


    /**
     * 获取去重的SystemName
     *
     * @return
     */
    @RequestMapping("/getSystemName")
    public Result getSystemName() {
        List<String> list = iCjDataSourceTabInfoService.selectDistSystemName();
        return new Result().success(list);
    }


    /**
     * 获取去重的Schema
     *
     * @param systemname
     * @return
     */
    @RequestMapping("/getSchema")
    public Result getSchema(@RequestParam(value = "systemname", defaultValue = "") String systemname) {
        List<String> list = iCjDataSourceTabInfoService.selectDistSchema(systemname);
        return new Result().success(list);
    }


    /**
     * 获取表信息列表
     *
     * @param systemname
     * @param schema
     * @param tablename
     * @return
     */
    @RequestMapping("/getSysNameAndSchemaAndTableName")
    public Result getSysNameAndSchemaAndTableName(@RequestParam(value = "systemname", required = false) String systemname, @RequestParam(value = "schema", required = false) String schema, @RequestParam(value = "tablename", required = false) String tablename, PageGeorge reqParams) {
        PageHelper.startPage(reqParams.getPagenum(), reqParams.getPagesize());
        List<CjDataSourceTabInfo> list = iCjDataSourceTabInfoService.selectBySysNameAndSchemaAndTableName(systemname, schema, tablename);
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(list);
        return new Result().success(page);
    }


    /**
     * 根据表明获取表的详细信息
     *
     * @param tablename
     * @return
     */
    @RequestMapping("/getByTableInfo")
    public Result selectByTable(@RequestParam(value = "systemname") String systemname, @RequestParam(value = "schema") String schema, @RequestParam(value = "tablename") String tablename) {
        List<CjDataSourceTabColInfo> list = iCjDataSourceTabColInfoService.selectByTable(systemname, schema, tablename);
        return new Result().success(list);
    }


}
