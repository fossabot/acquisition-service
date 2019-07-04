package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabColInfo;
import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.PageGeorge;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(tags = "enterHuOverview",description = "入湖总览")
@RequestMapping("enterHuOverview")
@RestController
public class EnterHuOverviewController {

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    ICjDataSourceTabInfoService iCjDataSourceTabInfoService;

    @Resource(name = "cjDataSourceTabColInfoServiceImpl")
    ICjDataSourceTabColInfoService iCjDataSourceTabColInfoService;


    @ApiOperation(" 获取去重的SystemName")
    @GetMapping("/getSystemName")
    public Result getSystemName() {
        List<String> list = iCjDataSourceTabInfoService.selectDistSystemName();
        return new Result().success(list);
    }


    @ApiOperation(" 获取去重的Schema")
    @ApiImplicitParam(name = "systemname", value = "系统名", dataType = "String", required = true)
    @GetMapping("/getSchema")
    public Result getSchema(@RequestParam(value = "systemname", defaultValue = "") String systemname) {
        List<String> list = iCjDataSourceTabInfoService.selectDistSchema(systemname);
        return new Result().success(list);
    }


    @ApiOperation("获取表信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "systemname", value = "系统名", required = false, dataType = "String"),
            @ApiImplicitParam(name = "schema", value = "schema", required = false, dataType = "String"),
            @ApiImplicitParam(name = "tablename", value = "表明", required = false, dataType = "String"),
    })
    @GetMapping("/getSysNameAndSchemaAndTableName")
    public Result getSysNameAndSchemaAndTableName(@RequestParam(value = "systemname", required = false) String systemname, @RequestParam(value = "schema", required = false) String schema, @RequestParam(value = "tablename", required = false) String tablename, PageGeorge reqParams) {
        PageHelper.startPage(reqParams.getPagenum(), reqParams.getPagesize());
        List<CjDataSourceTabInfo> list = iCjDataSourceTabInfoService.selectBySysNameAndSchemaAndTableName(systemname, schema, tablename);
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(list);
        return new Result().success(page);
    }


    @ApiOperation("根据表名获取表的详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "systemname", value = "系统名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "schema", value = "schema", required = true, dataType = "String"),
            @ApiImplicitParam(name = "tablename", value = "表名", required = true, dataType = "String"),
    })
    @GetMapping("/getByTableInfo")
    public Result selectByTable(@RequestParam(value = "systemname") String systemname, @RequestParam(value = "schema") String schema, @RequestParam(value = "tablename") String tablename) {
        List<CjDataSourceTabColInfo> list = iCjDataSourceTabColInfoService.selectByTable(systemname, schema, tablename);
        return new Result().success(list);
    }

}
