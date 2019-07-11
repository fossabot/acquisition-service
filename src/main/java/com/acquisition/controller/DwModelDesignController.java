package com.acquisition.controller;

import com.acquisition.entity.*;
import com.acquisition.entity.dto.CjDwCrtTabDdlInfoDto;
import com.acquisition.entity.dto.CjDwTableColInfoDto;
import com.acquisition.entity.pojo.TableOptionPojo;
import com.acquisition.entity.vo.CjDwTableColMapRelInfoVo;
import com.acquisition.entity.vo.DwModelAndMapRel;
import com.acquisition.entity.vo.DwModelDesign;
import com.acquisition.mapper.CjDwTableColMapRelInfoMapper;
import com.acquisition.service.*;
import com.acquisition.util.Constant;
import com.acquisition.util.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yili.pool.pool.GroupPoolFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hibernate.boot.model.source.internal.hbm.CommaSeparatedStringHelper.split;

/**
 * Created by zhangdongmao on 2019/7/2.
 */
@Api(tags = "dwModelDesign", description = "DW模型设计")
@RequestMapping("dwModelDesign")
@RestController
public class DwModelDesignController {

    @Resource(name = "cjDwTableColInfoServiceImpl")
    CjDwTableColInfoService cjDwTableColInfoService;

    @Resource(name = "cjOdsTableColInfoServiceImpl")
    CjOdsTableColInfoService cjOdsTableColInfoService;

    @Resource(name = "cjDwCrtTabDdlInfoServiceImpl")
    CjDwCrtTabDdlInfoService cjDwCrtTabDdlInfoService;

    @Resource(name = "cjDwCrtTabRuleInfoServiceImpl")
    CjDwCrtTabRuleInfoService cjDwCrtTabRuleInfoService;

    @Resource(name = "cjOdsTableLoadModeInfoServiceImpl")
    CjOdsTableLoadModeInfoService cjOdsTableLoadModeInfoService;

    @Resource(name = "cjDwOdsMapInitInfoServiceImpl")
    CjDwOdsMapInitInfoService cjDwOdsMapInitInfoService;

    @Resource(name = "cjDwTableMapRelInfoServiceImpl")
    CjDwTableMapRelInfoService cjDwTableMapRelInfoService;

    @Resource(name = "cjDwTableColMapRelInfoServiceImpl")
    CjDwTableColMapRelInfoService cjDwTableColMapRelInfoService;

    @Resource(name = "cjDwTableLoadModeInfoServiceImpl")
    CjDwTableLoadModeInfoService cjDwTableLoadModeInfoService;

    @ApiOperation("按备用区表名查表")
    @GetMapping("/getTabByBakName")
    public Result getTabByBakName(@RequestParam(value = "dwDataTable") String dwDataTable) {
        Result result = new Result();
        List<CjDwTableColInfo> cjDwTableColInfos = cjDwTableColInfoService.selectColInfoByTopicAndTab(Constant.DW_BAK_DOMAIN, dwDataTable);
        if(cjDwTableColInfos.isEmpty()) {
            result.setCode(500);
            result.setMsg("备用区无此表");
        } else {
            String odsDataTable = cjDwCrtTabDdlInfoService.findOdsDataTableByDwDataTable(dwDataTable);
            CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo = cjOdsTableLoadModeInfoService.findByOdsDataTable(odsDataTable);
            String odsTablePartitionColNameSource = cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource();
            if (odsTablePartitionColNameSource != null) {
                CjDwTableColInfo cjDwTableColInfo = new CjDwTableColInfo();
                BeanUtils.copyProperties(cjDwTableColInfos.get(0), cjDwTableColInfo);
                cjDwTableColInfo.setDwTableColName(Constant.DW_PARTITION_KEY);
                cjDwTableColInfo.setDwTableColType(Constant.DW_PARTITION_DATATYPE);
                cjDwTableColInfo.setDwTableColOrder(cjDwTableColInfos.size() + 1 + "");
                cjDwTableColInfo.setDwTableColComment(Constant.DW_PARTITION_COMMENT);
                cjDwTableColInfo.setDwTablePartitionFlag(Constant.DW_PARTITION_FLAG);
                cjDwTableColInfos.add(cjDwTableColInfo);
            }
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("cjDwTableColInfos", cjDwTableColInfos);
            resultMap.put("odsDataTable", odsDataTable);
            result.success(JSON.toJSON(resultMap));
        }
        return result;
    }

    @ApiOperation("按ODS表名查表")
    @GetMapping("/getOdsTabInfoByName")
    public Result getOdsTabInfoByName(@RequestParam(value = "odsDataTable") String odsDataTable,@RequestParam(value = "dwDataTable") String dwDataTable) {
        Result result = new Result();
        List<CjOdsTableColInfo> cjOdsTableColInfos = cjOdsTableColInfoService.findFieldByodsDataTable(odsDataTable);
        if(cjOdsTableColInfos.isEmpty()) {
            result.setCode(500);
            result.setMsg("ODS无此表");
        } else {
            String sourceSchema;
            List<CjDwTableColInfo> cjDwTableColInfos = cjDwTableColInfoService.selectColInfoByTopicAndTab(Constant.DW_USEING_DOMAIN, dwDataTable);
            CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo = cjOdsTableLoadModeInfoService.findByOdsDataTable(odsDataTable);
            String odsDataLoadMode = cjOdsTableLoadModeInfo.getOdsDataLoadMode();
            String businessSystemNameShortName = cjOdsTableLoadModeInfo.getBusinessSystemNameShortName();
            if(odsDataLoadMode.equals(Constant.ODS_FULL_EXTRACT)){
                sourceSchema = Constant.ODS_HIVE_FULL_SCHEMA;
            }else {
                sourceSchema = Constant.ODS_HIVE_INCREMENT_SCHEMA;
            }
            List<CjDwTableColMapRelInfoVo> cjDwTableColMapRelInfoVos = new ArrayList<>();
            for(int i=0;i<(cjOdsTableColInfos.size()>cjDwTableColInfos.size() ? cjOdsTableColInfos.size() : cjDwTableColInfos.size());i++){
                CjDwTableColMapRelInfoVo cjDwTableColMapRelInfoVo = new CjDwTableColMapRelInfoVo();
                if(i<cjOdsTableColInfos.size()){
                    cjDwTableColMapRelInfoVo.setSourceTableSchema(sourceSchema);
                    cjDwTableColMapRelInfoVo.setSourceTableName(cjOdsTableColInfos.get(i).getOdsDataTable());
                    cjDwTableColMapRelInfoVo.setSourceTableComment(cjOdsTableColInfos.get(i).getOdsTableComment());
                    cjDwTableColMapRelInfoVo.setSourceTableColName(cjOdsTableColInfos.get(i).getOdsTableColName());
                    cjDwTableColMapRelInfoVo.setSourceTableColType(cjOdsTableColInfos.get(i).getOdsTableColType());
                }
                if(i<cjDwTableColInfos.size()){
                    cjDwTableColMapRelInfoVo.setDwDataTable(cjDwTableColInfos.get(i).getDwDataTable());
                    cjDwTableColMapRelInfoVo.setTargetTableComment(cjDwTableColInfos.get(i).getDwTableComment());
                    cjDwTableColMapRelInfoVo.setTargetTableColName(cjDwTableColInfos.get(i).getDwTableColName());
                    cjDwTableColMapRelInfoVo.setTargetTableColType(cjDwTableColInfos.get(i).getDwTableColType());
                    cjDwTableColMapRelInfoVo.setTargetTableColComment(cjDwTableColInfos.get(i).getDwTableColComment());
                    cjDwTableColMapRelInfoVo.setTargetTableColOrder(cjDwTableColInfos.get(i).getDwTableColOrder());
                    switch (cjDwTableColMapRelInfoVo.getTargetTableColName()){
                        case Constant.DW_DEFAULT_COL_2:
                            cjDwTableColMapRelInfoVo.setSourceTargetMappDefine("'"+businessSystemNameShortName+"'");
                            break;
                        case Constant.DW_DEFAULT_COL_3:
                            cjDwTableColMapRelInfoVo.setSourceTargetMappDefine("'"+odsDataTable+"'");
                            break;
                        case Constant.DW_DEFAULT_COL_4:
                            cjDwTableColMapRelInfoVo.setSourceTargetMappDefine("current_timestamp");
                            break;
                        case Constant.DW_DEFAULT_COL_5:
                            cjDwTableColMapRelInfoVo.setSourceTargetMappDefine("date_format('${TX_DATE}','yyyyMMdd')");
                            break;
                        case Constant.DW_PARTITION_KEY:
                            String odsTablePartitionColNameSource = cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource();
                            String odsTablePartitionUnit = cjOdsTableLoadModeInfo.getOdsTablePartitionUnit();
                            if(odsTablePartitionUnit != null){
                                if(odsTablePartitionUnit.equals(Constant.ODS_PARTITION_UNIT)){
                                    cjDwTableColMapRelInfoVo.setSourceTargetMappDefine("date_format('"+odsTablePartitionColNameSource+"','yyyyMM')");
                                } else {
                                    cjDwTableColMapRelInfoVo.setSourceTargetMappDefine("date_format('"+odsTablePartitionColNameSource+"','yyyyMMdd')");
                                }
                            }
                            break;
                    }
                }
                cjDwTableColMapRelInfoVos.add(cjDwTableColMapRelInfoVo);
            }


//            List<CjDwTableColMapRelInfo> cjDwTableColMapRelInfos = new ArrayList<>();
//            for(CjOdsTableColInfo cjOdsTableColInfo: cjDwTableColInfos){
//                CjDwTableColMapRelInfo cjDwTableColMapRelInfo = new CjDwTableColMapRelInfo();
//                cjDwTableColMapRelInfo.setSourceTableSchema(sourceSchema);
//                cjDwTableColMapRelInfo.setSourceTableName(cjOdsTableColInfo.getOdsDataTable());
//                cjDwTableColMapRelInfo.setSourceTableColName(cjOdsTableColInfo.getOdsTableColName());
//                cjDwTableColMapRelInfo.setSourceTableColType(cjOdsTableColInfo.getOdsTableColType());
//                cjDwTableColMapRelInfo.setSourceTableColComment(cjOdsTableColInfo.getOdsTableColComment());
//                cjDwTableColMapRelInfos.add(cjDwTableColMapRelInfo);
//            }
            result.success(cjDwTableColMapRelInfoVos);
        }
        return result;
    }

    @ApiOperation("保存映射关系")
    @PostMapping("/saveMapRel")
    public Result saveMapRel(@RequestBody String data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("保存成功");
        //解析数据

        JSONObject jsonObject = JSONObject.parseObject(data);
        String dwDataLoadModel = jsonObject.getString("dwDataLoadModel");
        String sourceParimaryKey = jsonObject.getString("sourceParimaryKey");
        String targetParimaryKey = jsonObject.getString("targetParimaryKey");
        List<DwModelAndMapRel> dwModelAndMapRels = JSONArray.parseArray(jsonObject.getString("modelList"),DwModelAndMapRel.class);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(new Date());
        String tableSchema = dwModelAndMapRels.get(0).getCjDwTableColMapRelInfoVos().get(0).getSourceTableSchema();
        if(!dwDataLoadModel.equals(Constant.DW_POLICY_F3)){
            if(tableSchema.equals(Constant.ODS_HIVE_INCREMENT_SCHEMA)){
                dwDataLoadModel = Constant.DW_POLICY_F2;
            } else if(tableSchema.equals(Constant.ODS_HIVE_FULL_SCHEMA)) {
                dwDataLoadModel = Constant.DW_POLICY_F1;
            }
        }

        //获取dwDataTable的值
        String dwDataTable = dwModelAndMapRels.get(0).getCjDwTableColMapRelInfoVos().get(0).getDwDataTable();
        List<CjDwTableColMapRelInfo> cjDwTableColMapRelInfos = new ArrayList<>();
        List<CjDwTableMapRelInfo> dwTableMapRelInfos = new ArrayList<>();
        for(int i = 0; i<dwModelAndMapRels.size(); i++){
            List<CjDwTableColMapRelInfoVo> cjDwTableColMapRelInfoVos = dwModelAndMapRels.get(i).getCjDwTableColMapRelInfoVos();
            //取出每一组的源库名和源表名
            String sourceTableName = cjDwTableColMapRelInfoVos.get(0).getSourceTableName();
            String sourceTableSchema = cjDwTableColMapRelInfoVos.get(0).getSourceTableSchema();
            //生成dw字段映射表的实例
            for(CjDwTableColMapRelInfoVo cjDwTableColMapRelInfoVo: cjDwTableColMapRelInfoVos){
                CjDwTableColMapRelInfo cjDwTableColMapRelInfo = new CjDwTableColMapRelInfo();
                cjDwTableColMapRelInfo.setSourceTableSchema(sourceTableSchema);
                cjDwTableColMapRelInfo.setSourceTableName(sourceTableName);
                //sourceTableColName字段在数据库中不可为空
                if(cjDwTableColMapRelInfoVo.getSourceTableColName() != null){
                    cjDwTableColMapRelInfo.setSourceTableColName(cjDwTableColMapRelInfoVo.getSourceTableColName());
                } else {
                    cjDwTableColMapRelInfo.setSourceTableColName("");
                }
                cjDwTableColMapRelInfo.setSourceTableColType(cjDwTableColMapRelInfoVo.getSourceTableColType());
                cjDwTableColMapRelInfo.setSourceTableColComment(cjDwTableColMapRelInfoVo.getSourceTableColComment());
                cjDwTableColMapRelInfo.setDwDataTable(dwDataTable);
                cjDwTableColMapRelInfo.setTargetTableColName(cjDwTableColMapRelInfoVo.getTargetTableColName());
                cjDwTableColMapRelInfo.setTargetTableColOrder(cjDwTableColMapRelInfoVo.getTargetTableColOrder());
                cjDwTableColMapRelInfo.setTargetTableColType(cjDwTableColMapRelInfoVo.getTargetTableColType());
                cjDwTableColMapRelInfo.setTargetTableColComment(cjDwTableColMapRelInfoVo.getTargetTableColComment());
                cjDwTableColMapRelInfo.setSourceTargetMappDefine(cjDwTableColMapRelInfoVo.getSourceTargetMappDefine());
                //设置分组序号
                cjDwTableColMapRelInfo.setDataSqlGroupUnit(i+"");
                cjDwTableColMapRelInfo.setLastModifyDt(format);
                cjDwTableColMapRelInfos.add(cjDwTableColMapRelInfo);
            }
            //生成dw表级映射关系表的实例
            List<CjDwTableMapRelInfo> cjDwTableMapRelInfos = dwModelAndMapRels.get(i).getCjDwTableMapRelInfos();
            for (CjDwTableMapRelInfo cjDwTableMapRelInfo: cjDwTableMapRelInfos) {
                cjDwTableMapRelInfo.setDataSqlGroupUnit(i+"");
                cjDwTableMapRelInfo.setDwDataTable(dwDataTable);
                cjDwTableMapRelInfo.setLastModifyDt(format);
                dwTableMapRelInfos.add(cjDwTableMapRelInfo);
            }
        }
        //设置dw加载策略表实例
        CjDwTableLoadModeInfo cjDwTableLoadModeInfo = new CjDwTableLoadModeInfo();
        cjDwTableLoadModeInfo.setDataSourceTabPrimaryCol(sourceParimaryKey);
        cjDwTableLoadModeInfo.setDwTabPrimaryCol(targetParimaryKey);
        cjDwTableLoadModeInfo.setDwDataTable(dwDataTable);
        cjDwTableLoadModeInfo.setDwDataLoadMode(dwDataLoadModel);
        cjDwTableLoadModeInfo.setLastModifyDt(format);
        List<String> partitionCol = cjDwTableColInfoService.findPartitionCol(Constant.DW_USEING_DOMAIN, dwDataTable);
        String partitionCols = String.join(",", partitionCol);
        cjDwTableLoadModeInfo.setDwTablePartitionColName(partitionCols);


        //保存dw表级映射表的数据
        if(!dwTableMapRelInfos.isEmpty()){
            CjDwTableMapRelInfoExample cjDwTableMapRelInfoExample = new CjDwTableMapRelInfoExample();
            CjDwTableMapRelInfoExample.Criteria criteria = cjDwTableMapRelInfoExample.createCriteria();
            criteria.andDwDataTableEqualTo(dwDataTable);
            cjDwTableMapRelInfoService.insertBatch(dwTableMapRelInfos,cjDwTableMapRelInfoExample);
        }
        //保存dw字段级映射表的数据
        if(!cjDwTableColMapRelInfos.isEmpty()){
            CjDwTableColMapRelInfoExample cjDwTableColMapRelInfoExample = new CjDwTableColMapRelInfoExample();
            CjDwTableColMapRelInfoExample.Criteria criteria = cjDwTableColMapRelInfoExample.createCriteria();
            criteria.andDwDataTableEqualTo(dwDataTable);
            cjDwTableColMapRelInfoService.insertBatch(cjDwTableColMapRelInfos,cjDwTableColMapRelInfoExample);
        }

        CjDwTableLoadModeInfoExample cjDwTableLoadModeInfoExample = new CjDwTableLoadModeInfoExample();
        CjDwTableLoadModeInfoExample.Criteria criteria = cjDwTableLoadModeInfoExample.createCriteria();
        criteria.andDwDataTableEqualTo(dwDataTable);
        cjDwTableLoadModeInfoService.saveByOne(cjDwTableLoadModeInfo,cjDwTableLoadModeInfoExample);
        return result;
    }

    @ApiOperation("按在用区表名查表")
    @GetMapping("/getTabByUsingName")
    public Result getTabByUsingName(@RequestParam(value = "dwDataTable") String dwDataTable) {
        Result result = new Result();
        //查询表的字段信息
        List<CjDwTableColInfo> cjDwTableColInfos = cjDwTableColInfoService.selectColInfoByTopicAndTab(Constant.DW_USEING_DOMAIN, dwDataTable);
        if(cjDwTableColInfos.isEmpty()) {
            result.setCode(500);
            result.setMsg("在用区无此表");
        } else {
            String sourceSchema;
            String dwDataLoadModel;
            String odsDataTable = cjDwCrtTabDdlInfoService.findOdsDataTableByDwDataTable(dwDataTable);
            CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo = cjOdsTableLoadModeInfoService.findByOdsDataTable(odsDataTable);
            String odsTablePartitionColName = cjOdsTableLoadModeInfo.getOdsTablePartitionColName();
            String odsTablePrimaryCol = cjOdsTableLoadModeInfo.getOdsTablePrimaryColName();
            String odsDataLoadMode = cjOdsTableLoadModeInfo.getOdsDataLoadMode();

            String businessSystemNameShortName = cjOdsTableLoadModeInfo.getBusinessSystemNameShortName().toLowerCase();
            if(odsDataLoadMode.equals(Constant.ODS_FULL_EXTRACT)){
                sourceSchema = Constant.ODS_HIVE_FULL_SCHEMA;
                dwDataLoadModel = Constant.DW_POLICY_F1;
            }else {
                sourceSchema = Constant.ODS_HIVE_INCREMENT_SCHEMA;
                dwDataLoadModel = Constant.DW_POLICY_F2;
            }
            String[] odsTablePrimaryCols = cjOdsTableLoadModeInfo.getOdsTablePrimaryColSeqStr().split(",");

            String dwBusinessTopicDomain = dwDataTable.split("_")[1];
            String policy = cjDwCrtTabRuleInfoService.findPolicyByTopic(dwBusinessTopicDomain);

            if (policy == null) {
                return result.error(500, "无此主题域");
            } else if(policy.equals(Constant.DW_POLICY_F3)){
                dwDataLoadModel = policy;
            }

            List<String> dWPrimaryCols = cjDwTableColInfoService.findPrimaryCol(Constant.DW_USEING_DOMAIN, dwDataTable, odsTablePrimaryCols);
            String dWPrimaryCol = String.join(",", dWPrimaryCols);
            List<CjOdsTableColInfo> cjOdsTableColInfos = cjOdsTableColInfoService.findByColOrder(cjOdsTableLoadModeInfo.getBusinessSystemNameShortName(), cjOdsTableLoadModeInfo.getDataSourceSchema(), cjOdsTableLoadModeInfo.getDataSourceTable());

            List<CjDwTableColMapRelInfoVo> cjDwTableColMapRelInfoVos = new ArrayList<>();
            for(int i=0;i<(cjOdsTableColInfos.size()>cjDwTableColInfos.size() ? cjOdsTableColInfos.size() : cjDwTableColInfos.size());i++){
                CjDwTableColMapRelInfoVo cjDwTableColMapRelInfoVo = new CjDwTableColMapRelInfoVo();
                if(i<cjOdsTableColInfos.size()){
                    cjDwTableColMapRelInfoVo.setSourceTableSchema(sourceSchema);
                    cjDwTableColMapRelInfoVo.setSourceTableName(cjOdsTableColInfos.get(i).getOdsDataTable());
                    cjDwTableColMapRelInfoVo.setSourceTableComment(cjOdsTableColInfos.get(i).getOdsTableComment());
                    cjDwTableColMapRelInfoVo.setSourceTableColName(cjOdsTableColInfos.get(i).getOdsTableColName());
                    cjDwTableColMapRelInfoVo.setSourceTableColType(cjOdsTableColInfos.get(i).getOdsTableColType());
                }
                if(i<cjDwTableColInfos.size()){
                    cjDwTableColMapRelInfoVo.setDwDataTable(cjDwTableColInfos.get(i).getDwDataTable());
                    cjDwTableColMapRelInfoVo.setTargetTableComment(cjDwTableColInfos.get(i).getDwTableComment());
                    cjDwTableColMapRelInfoVo.setTargetTableColName(cjDwTableColInfos.get(i).getDwTableColName());
                    cjDwTableColMapRelInfoVo.setTargetTableColType(cjDwTableColInfos.get(i).getDwTableColType());
                    cjDwTableColMapRelInfoVo.setTargetTableColComment(cjDwTableColInfos.get(i).getDwTableColComment());
                    cjDwTableColMapRelInfoVo.setTargetTableColOrder(cjDwTableColInfos.get(i).getDwTableColOrder());
                    switch (cjDwTableColMapRelInfoVo.getTargetTableColName()){
                        case Constant.DW_DEFAULT_COL_2:
                            cjDwTableColMapRelInfoVo.setSourceTargetMappDefine("'"+businessSystemNameShortName+"'");
                            break;
                        case Constant.DW_DEFAULT_COL_3:
                            cjDwTableColMapRelInfoVo.setSourceTargetMappDefine("'"+odsDataTable+"'");
                            break;
                        case Constant.DW_DEFAULT_COL_4:
                            cjDwTableColMapRelInfoVo.setSourceTargetMappDefine("current_timestamp");
                            break;
                        case Constant.DW_DEFAULT_COL_5:
                            cjDwTableColMapRelInfoVo.setSourceTargetMappDefine("date_format('${TX_DATE}','yyyyMMdd')");
                            break;
                        case Constant.DW_PARTITION_KEY:
                            String odsTablePartitionColNameSource = cjOdsTableLoadModeInfo.getOdsTablePartitionColNameSource();
                            String odsTablePartitionUnit = cjOdsTableLoadModeInfo.getOdsTablePartitionUnit();
                            if(odsTablePartitionUnit.equals(Constant.ODS_PARTITION_UNIT)){
                                cjDwTableColMapRelInfoVo.setSourceTargetMappDefine("date_format('"+odsTablePartitionColNameSource+"','yyyyMM')");
                            } else {
                                cjDwTableColMapRelInfoVo.setSourceTargetMappDefine("date_format('"+odsTablePartitionColNameSource+"','yyyyMMdd')");
                            }
                            break;
                    }
                }
                cjDwTableColMapRelInfoVos.add(cjDwTableColMapRelInfoVo);
            }

            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("cjDwTableColMapRelInfoVos", cjDwTableColMapRelInfoVos);
            resultMap.put("odsDataTable", odsDataTable);
            resultMap.put("dwDataLoadModel", dwDataLoadModel);
            resultMap.put("dWPrimaryCol", dWPrimaryCol);
            resultMap.put("odsTablePartitionColName", odsTablePartitionColName);
            resultMap.put("odsTablePrimaryCol", odsTablePrimaryCol);
            result.success(JSON.toJSON(resultMap));
        }
        return result;
    }

    @ApiOperation("dw在用区字段保存接口")
    @PostMapping("/saveDWUsingCols")
    public Result saveDWUsingCols(@RequestBody String data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("保存成功");
        JSONObject jsonObject = JSONObject.parseObject(data);
        String dwDataTable = jsonObject.getString("dwDataTable");
        List<CjDwTableColInfoDto> cjDwTableColInfoDtos = JSONObject.parseArray(jsonObject.getString("cjDwTableColInfoDtos"), CjDwTableColInfoDto.class);
        String dwBusinessTopicDomain = dwDataTable.split("_")[1];
        String policy = cjDwCrtTabRuleInfoService.findPolicyByTopic(dwBusinessTopicDomain);
        if (policy == null) {
            return result.error(500, "无此主题域");
        }

        List<CjDwTableColInfo> cjDwTableColInfos = new ArrayList<>();
        for (CjDwTableColInfoDto cjDwTableColInfoDto : cjDwTableColInfoDtos) {
            CjDwTableColInfo cjDwTableColInfo = new CjDwTableColInfo();
            cjDwTableColInfo.setDwBusinessTopicDomain(dwBusinessTopicDomain);
            cjDwTableColInfo.setDwTableBelongDomain(Constant.DW_USEING_DOMAIN);
            cjDwTableColInfo.setDwDataSchema(Constant.DW_HIVE_SCHEMA);
            cjDwTableColInfo.setDwDataTable(dwDataTable);
            cjDwTableColInfo.setDwTableComment(cjDwTableColInfoDto.getDwTableComment());
            cjDwTableColInfo.setDwTableColOrder(cjDwTableColInfoDto.getDwTableColOrder());
            cjDwTableColInfo.setDwTableColName(cjDwTableColInfoDto.getDwTableColName());
            cjDwTableColInfo.setDwTableColType(cjDwTableColInfoDto.getDwTableColType());
            cjDwTableColInfo.setDwTableColComment(cjDwTableColInfoDto.getDwTableColComment());
            cjDwTableColInfo.setDwTablePartitionFlag(cjDwTableColInfoDto.getDwTablePartitionFlag());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjDwTableColInfo.setLastModifyDt(df.format(new Date()));
            cjDwTableColInfos.add(cjDwTableColInfo);
        }
        cjDwTableColInfoService.insertBatch(cjDwTableColInfos);
        return result;
    }

    @ApiOperation("dw在用区初始化脚本生成接口")
    @GetMapping("/saveInitScript")
    public Result saveInitScript(@RequestParam(value = "dwDataTable") String dwDataTable) {
        System.out.println(dwDataTable);
        Result result = new Result();
        result.setCode(200);
        result.setMsg("生成成功");
        generateInitScript(dwDataTable);
        return result;
    }

    @ApiOperation("dw在用区建表接口")
    @PostMapping(value = "/createDwUsingTable", produces = "application/json")
    public Result createDWUsingTable(@RequestBody String data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("建表成功");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONObject jsonObject = JSONObject.parseObject(data);
        String dwUsingDataTable = jsonObject.getString("dwUsingDataTable");
        String dwBakTable = jsonObject.getString("dwBakTable");
        String odsDataTable = jsonObject.getString("odsDataTable");
        List<CjDwTableColInfoDto> cjDwTableColInfoDtos = JSONObject.parseArray(jsonObject.getString("cjDwTableColInfoDtos"), CjDwTableColInfoDto.class);
        String dwBusinessTopicDomain = dwUsingDataTable.split("_")[1];
        String policy = cjDwCrtTabRuleInfoService.findPolicyByTopic(dwBusinessTopicDomain);

        if (policy == null) {
            return result.error(500, "无此主题域");
        }
        CjDwCrtTabDdlInfo dwBakTabDdlInfo = cjDwCrtTabDdlInfoService.findByDwDataTable(dwBakTable);
        CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo = new CjDwCrtTabDdlInfo();

        if (policy.equals(Constant.DW_POLICY_F3)) {
            String dwDdl = generateDwDdl(dwUsingDataTable, cjDwTableColInfoDtos);
            String dwFullDdl = generateDwFullDdl(dwUsingDataTable, cjDwTableColInfoDtos);
            dwDdl = dwDdl + ";\n" + dwFullDdl;
            cjDwCrtTabDdlInfo.setBusinessSystemId(dwBakTabDdlInfo.getBusinessSystemId());
            cjDwCrtTabDdlInfo.setBusinessSystemNameShortName(dwBakTabDdlInfo.getBusinessSystemNameShortName());
            cjDwCrtTabDdlInfo.setDataSourceSchema(dwBakTabDdlInfo.getDataSourceSchema());
            cjDwCrtTabDdlInfo.setDataSourceTable(dwBakTabDdlInfo.getDataSourceTable());
            cjDwCrtTabDdlInfo.setOdsDataTable(dwBakTabDdlInfo.getOdsDataTable());
            cjDwCrtTabDdlInfo.setDwDataTable(dwUsingDataTable);
            cjDwCrtTabDdlInfo.setDwDataTableDdlInfo(dwDdl);
            cjDwCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
        } else {
            String dwDdl = generateDwDdl(dwUsingDataTable, cjDwTableColInfoDtos);
            cjDwCrtTabDdlInfo.setBusinessSystemId(dwBakTabDdlInfo.getBusinessSystemId());
            cjDwCrtTabDdlInfo.setBusinessSystemNameShortName(dwBakTabDdlInfo.getBusinessSystemNameShortName());
            cjDwCrtTabDdlInfo.setDataSourceSchema(dwBakTabDdlInfo.getDataSourceSchema());
            cjDwCrtTabDdlInfo.setDataSourceTable(dwBakTabDdlInfo.getDataSourceTable());
            cjDwCrtTabDdlInfo.setOdsDataTable(dwBakTabDdlInfo.getOdsDataTable());
            cjDwCrtTabDdlInfo.setDwDataTable(dwUsingDataTable);
            cjDwCrtTabDdlInfo.setDwDataTableDdlInfo(dwDdl);
            cjDwCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
        }
        cjDwCrtTabDdlInfoService.saveByOne(cjDwCrtTabDdlInfo);

        CjDwOdsMapInitInfo cjDwOdsMapInitInfo = new CjDwOdsMapInitInfo();
        cjDwOdsMapInitInfo.setOdsDataTable(odsDataTable);
        cjDwOdsMapInitInfo.setDwSpareTable(dwBakTable);
        cjDwOdsMapInitInfo.setDwDataTable(dwUsingDataTable);
        cjDwOdsMapInitInfo.setDwBusinessTopicDomain(dwBusinessTopicDomain);
        cjDwOdsMapInitInfo.setLastModifyDt(df.format(new Date()));
        cjDwOdsMapInitInfoService.saveByOne(cjDwOdsMapInitInfo);

        //如果在用区表和备用区表表名一样，那么建在用区表之前要先删掉已存在的备用区表
        if(dwUsingDataTable.equals(dwBakTable)){
            TableOptionPojo dropTableOption = hiveDropTable(Constant.DW_HIVE_SCHEMA, dwBakTable);
            if(dropTableOption.getResult().equals(Constant.TABLE_OPTION_SUCCESS)){
                TableOptionPojo createTableOption = hiveCreateDwUsingTable(cjDwCrtTabDdlInfo);
                if (createTableOption.getResult().equals(Constant.TABLE_OPTION_FAILED)) {
                    result.setCode(500);
                    result.setMsg("建表失败");
                }
            } else {
                result.setCode(500);
                result.setMsg("删除重名表失败");
            }
        }
        return result;
    }
    /**
    * @Author: zhangdongmao
    * @Date: 2019/7/10
    * @Description:  生成dw初始化脚本
    * @Param: * @param null 1
    * @return:
    */
    public String generateInitScript(String dwDataTable) {
        List<CjDwTableColMapRelInfo> cjDwTableColMapRelInfos = cjDwTableColMapRelInfoService.findByDwTab(dwDataTable);
        CjDwTableLoadModeInfo cjDwTableLoadModeInfo = cjDwTableLoadModeInfoService.findByDwDataTable(dwDataTable);
        String dwPartitionStr = cjDwTableLoadModeInfo.getDwTablePartitionColName();
        StringBuffer dwInitScript = new StringBuffer();
        dwInitScript.append("insert overwrite table "+Constant.DW_HIVE_SCHEMA+"."+dwDataTable +" partition("+dwPartitionStr+")\n");

        MultiValueMap<String,CjDwTableColMapRelInfo> cjDwTableColMapRelInfoMap = new LinkedMultiValueMap<>();
        for(CjDwTableColMapRelInfo cjDwTableColMapRelInfo:cjDwTableColMapRelInfos){
            cjDwTableColMapRelInfoMap.add(cjDwTableColMapRelInfo.getDataSqlGroupUnit(),cjDwTableColMapRelInfo);
        }
        Set<String> keySet = cjDwTableColMapRelInfoMap.keySet();
        //唯一索引可能是由多个字段联合组成的，取字段个数最少的联合唯一索引作为ODS表的唯一索引
        for (String key : keySet) {
            String sourceSchema = "";
            String sourceTable = "";
            dwInitScript.append("select\n");
            List<CjDwTableColMapRelInfo> cjDwTableColMapRelInfosUnit = cjDwTableColMapRelInfoMap.get(key);
            for(CjDwTableColMapRelInfo cjDwTableColMapRelInfo:cjDwTableColMapRelInfosUnit){
                sourceSchema = cjDwTableColMapRelInfo.getSourceTableSchema();
                sourceTable = cjDwTableColMapRelInfo.getSourceTableName();
                if(cjDwTableColMapRelInfo.getSourceTargetMappDefine() != null){
                    dwInitScript.append("    "+cjDwTableColMapRelInfo.getSourceTargetMappDefine()+" as "+cjDwTableColMapRelInfo.getTargetTableColName()+",\n");
                } else {
                    dwInitScript.append("    "+cjDwTableColMapRelInfo.getSourceTableColName()+" as "+cjDwTableColMapRelInfo.getTargetTableColName()+",\n");
                }
            }
            dwInitScript.deleteCharAt(dwInitScript.length()-2);
            dwInitScript.append("from "+sourceSchema+"."+sourceTable+"\n");
            dwInitScript.append("union all\n");
        }
        dwInitScript.delete(dwInitScript.length()-11,dwInitScript.length()-1);
        System.out.println(dwInitScript.toString());
        return dwInitScript.toString();
    }

    /**
    * @Author: zhangdongmao
    * @Date: 2019/7/10
    * @Description:  生成F3策略表的full表初始化脚本
    * @Param: * @param null 1
    * @return:
    */
    public String generateInitScriptFull(String dwDataTable) {
        List<CjDwTableColMapRelInfo> cjDwTableColMapRelInfos = cjDwTableColMapRelInfoService.findByDwTab(dwDataTable);
        CjDwTableLoadModeInfo cjDwTableLoadModeInfo = cjDwTableLoadModeInfoService.findByDwDataTable(dwDataTable);
        String dwPartitionStr = cjDwTableLoadModeInfo.getDwTablePartitionColName();
        StringBuffer dwInitScript = new StringBuffer();
        dwInitScript.append("insert overwrite table "+Constant.DW_HIVE_SCHEMA+"."+dwDataTable +"_full partition("+dwPartitionStr+")\n");

        MultiValueMap<String,CjDwTableColMapRelInfo> cjDwTableColMapRelInfoMap = new LinkedMultiValueMap<>();
        for(CjDwTableColMapRelInfo cjDwTableColMapRelInfo:cjDwTableColMapRelInfos){
            cjDwTableColMapRelInfoMap.add(cjDwTableColMapRelInfo.getDataSqlGroupUnit(),cjDwTableColMapRelInfo);
        }
        Set<String> keySet = cjDwTableColMapRelInfoMap.keySet();
        //唯一索引可能是由多个字段联合组成的，取字段个数最少的联合唯一索引作为ODS表的唯一索引
        for (String key : keySet) {
            String sourceSchema = "";
            String sourceTable = "";
            dwInitScript.append("select\n");
            List<CjDwTableColMapRelInfo> cjDwTableColMapRelInfosUnit = cjDwTableColMapRelInfoMap.get(key);
            for(CjDwTableColMapRelInfo cjDwTableColMapRelInfo:cjDwTableColMapRelInfosUnit){
                sourceSchema = cjDwTableColMapRelInfo.getSourceTableSchema();
                sourceTable = cjDwTableColMapRelInfo.getSourceTableName();
                if(cjDwTableColMapRelInfo.getSourceTargetMappDefine() != null){
                    dwInitScript.append("    "+cjDwTableColMapRelInfo.getSourceTargetMappDefine()+" as "+cjDwTableColMapRelInfo.getTargetTableColName()+",\n");
                } else {
                    dwInitScript.append("    "+cjDwTableColMapRelInfo.getSourceTableColName()+" as "+cjDwTableColMapRelInfo.getTargetTableColName()+",\n");
                }
            }
            dwInitScript.deleteCharAt(dwInitScript.length()-2);
            dwInitScript.append("from "+sourceSchema+"."+sourceTable+"\n");
            dwInitScript.append("union all\n");
        }
        dwInitScript.delete(dwInitScript.length()-11,dwInitScript.length()-1);
        System.out.println(dwInitScript.toString());
        return dwInitScript.toString();
    }
    /**
    * @Author: zhangdongmao
    * @Date: 2019/7/10
    * @Description:  生成dw F2策略的调度脚本
    * @Param: * @param null 1
    * @return:
    */
    public String generateF2Script(String dwDataTable) {
        //获取字段对应关系
        List<CjDwTableColMapRelInfo> cjDwTableColMapRelInfos = cjDwTableColMapRelInfoService.findByDwTab(dwDataTable);
        //获取dw表抽取策略
        CjDwTableLoadModeInfo cjDwTableLoadModeInfo = cjDwTableLoadModeInfoService.findByDwDataTable(dwDataTable);

        //获取表关联关系

        List<CjDwTableMapRelInfo> cjDwTableMapRelInfos = cjDwTableMapRelInfoService.findBydwDataTableOrderByGroupUnit(dwDataTable);

        LinkedHashMap<String,CjDwTableMapRelInfo> cjDwTableMapRelInfoMap = new LinkedHashMap<>();


        String dwPartitionStr = cjDwTableLoadModeInfo.getDwTablePartitionColName();
        StringBuffer dwInitScript = new StringBuffer();
        dwInitScript.append("insert overwrite table "+Constant.DW_HIVE_SCHEMA+"."+dwDataTable +" partition("+dwPartitionStr+")\n");

        MultiValueMap<String,CjDwTableColMapRelInfo> cjDwTableColMapRelInfoMap = new LinkedMultiValueMap<>();


        for(CjDwTableColMapRelInfo cjDwTableColMapRelInfo:cjDwTableColMapRelInfos){
            cjDwTableColMapRelInfoMap.add(cjDwTableColMapRelInfo.getDataSqlGroupUnit(),cjDwTableColMapRelInfo);
        }
//        for(CjDwTableMapRelInfo cjDwTableMapRelInfo:cjDwTableMapRelInfos){
//            cjDwTableMapRelInfoMap.add(cjDwTableMapRelInfo.getDataSqlGroupUnit(),cjDwTableMapRelInfo);
//        }
        Set<String> keySet = cjDwTableColMapRelInfoMap.keySet();
        //唯一索引可能是由多个字段联合组成的，取字段个数最少的联合唯一索引作为ODS表的唯一索引
        for (String key : keySet) {
            String sourceSchema = "";
            String sourceTable = "";
            dwInitScript.append("select\n");
            List<CjDwTableColMapRelInfo> cjDwTableColMapRelInfosUnit = cjDwTableColMapRelInfoMap.get(key);
            for(CjDwTableColMapRelInfo cjDwTableColMapRelInfo:cjDwTableColMapRelInfosUnit){
                sourceSchema = cjDwTableColMapRelInfo.getSourceTableSchema();
                sourceTable = cjDwTableColMapRelInfo.getSourceTableName();
                if(cjDwTableColMapRelInfo.getSourceTargetMappDefine() != null){
                    dwInitScript.append("    "+cjDwTableColMapRelInfo.getSourceTargetMappDefine()+" as "+cjDwTableColMapRelInfo.getTargetTableColName()+",\n");
                } else {
                    dwInitScript.append("    "+cjDwTableColMapRelInfo.getSourceTableColName()+" as "+cjDwTableColMapRelInfo.getTargetTableColName()+",\n");
                }
            }
            dwInitScript.deleteCharAt(dwInitScript.length()-2);
            dwInitScript.append("from "+sourceSchema+"."+sourceTable+"\n");
            //拼接join条件
//            List<CjDwTableMapRelInfo> cjDwTableMapRelInfosUnit = cjDwTableMapRelInfoMap.get(key);
//            for(CjDwTableMapRelInfo cjDwTableMapRelInfo:cjDwTableMapRelInfosUnit){
//                dwInitScript.append(cjDwTableMapRelInfo)
//            }
            dwInitScript.append("union all\n");
        }
        dwInitScript.delete(dwInitScript.length()-11,dwInitScript.length()-1);
        System.out.println(dwInitScript.toString());
        return dwInitScript.toString();
    }
    /**
    * @Author: zhangdongmao
    * @Date: 2019/7/10
    * @Description:  生成dw在用区建表语句
    * @Param: * @param null 1
    * @return:
    */
    public String generateDwDdl(String dwDataTable, List<CjDwTableColInfoDto> cjDwTableColInfoDtos) {
        String targetTablePartitionColName = "";
        String targetTablePartitionType = "";
        String targetTablePartitionComment = "";
        StringBuffer dwDdl = new StringBuffer();
        dwDdl.append("create external table if not exists " + Constant.DW_HIVE_SCHEMA + "." + dwDataTable);
        dwDdl.append("(" + "\n");

        for (CjDwTableColInfoDto cjDwTableColInfoDto : cjDwTableColInfoDtos) {
            if (cjDwTableColInfoDto.getDwTablePartitionFlag() == null) {
                dwDdl.append("    `" + cjDwTableColInfoDto.getTargetTableColName() + "`    " + cjDwTableColInfoDto.getDwTableColType() + "    " + "comment \"" + cjDwTableColInfoDto.getDwTableColComment() + "\"" + ",\n");
            } else {
                targetTablePartitionColName = cjDwTableColInfoDto.getTargetTableColName();
                targetTablePartitionType = cjDwTableColInfoDto.getDwTableColType();
                targetTablePartitionComment = cjDwTableColInfoDto.getDwTableColComment();
            }
        }
        dwDdl = dwDdl.deleteCharAt(dwDdl.length() - 2);
        dwDdl.append(")" + "\n");
        if (!targetTablePartitionColName.equals("")) {
            dwDdl.append("partitioned by (" + targetTablePartitionColName + " " + targetTablePartitionType + " comment \"" + targetTablePartitionComment + "\")\n");
        }
        dwDdl.append("row format delimited fields terminated by '\\001' lines terminated by '\\n' stored as orc");
        return dwDdl.toString();
    }

    /**
    * @Author: zhangdongmao
    * @Date: 2019/7/10
    * @Description:  生成dw在用区full表建表语句
    * @Param: * @param null 1
    * @return:
    */
    public String generateDwFullDdl(String dwDataTable, List<CjDwTableColInfoDto> cjDwTableColInfoDtos) {
        String targetTablePartitionColName = "";
        String targetTablePartitionType = "";
        String targetTablePartitionComment = "";
        StringBuffer dwDdl = new StringBuffer();
        dwDdl.append("create external table if not exists " + Constant.DW_HIVE_SCHEMA + "." + dwDataTable + "_full");
        dwDdl.append("(" + "\n");

        for (CjDwTableColInfoDto cjDwTableColInfoDto : cjDwTableColInfoDtos) {
            if (cjDwTableColInfoDto.getDwTablePartitionFlag() == null) {
                if (!cjDwTableColInfoDto.getTargetTableColName().equals(Constant.DW_F3_DEFAULT_PARTITION_KEY)) {
                    dwDdl.append("    `" + cjDwTableColInfoDto.getTargetTableColName() + "`    " + cjDwTableColInfoDto.getDwTableColType() + "    " + "comment \"" + cjDwTableColInfoDto.getDwTableColComment() + "\"" + ",\n");
                }
            } else {
                targetTablePartitionColName = cjDwTableColInfoDto.getTargetTableColName();
                targetTablePartitionType = cjDwTableColInfoDto.getDwTableColType();
                targetTablePartitionComment = cjDwTableColInfoDto.getDwTableColComment();
            }
        }
        dwDdl = dwDdl.deleteCharAt(dwDdl.length() - 2);
        dwDdl.append(")" + "\n");
        if (!targetTablePartitionColName.equals("")) {
            dwDdl.append("partitioned by (" + Constant.DW_F3_DEFAULT_PARTITION_KEY + " " + Constant.DW_F3_DEFAULT_PARTITION_KEY_TYPE + " comment \"" + Constant.DW_F3_DEFAULT_PARTITION_KEY_COMMENT + "\"," + targetTablePartitionColName + " " + targetTablePartitionType + " comment \"" + targetTablePartitionComment + "\")\n");
        } else {
            dwDdl.append("partitioned by (" + Constant.DW_F3_DEFAULT_PARTITION_KEY + " " + Constant.DW_F3_DEFAULT_PARTITION_KEY_TYPE + " comment \"" + Constant.DW_F3_DEFAULT_PARTITION_KEY_COMMENT + "\")\n");
        }
        dwDdl.append("row format delimited fields terminated by '\\001' lines terminated by '\\n' stored as orc");
        return dwDdl.toString();
    }

    /**
    * @Author: zhangdongmao
    * @Date: 2019/7/10
    * @Description:  hive建表
    * @Param: * @param null 1
    * @return:
    */
    public TableOptionPojo hiveCreateDwUsingTable(CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo) {
        GroupPoolFactory instance = GroupPoolFactory.getInstance("DATALAKE-");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        TableOptionPojo tableOptionPojo;
        tableOptionPojo = new TableOptionPojo();
        tableOptionPojo.setBusinessSystemNameShortName(cjDwCrtTabDdlInfo.getBusinessSystemNameShortName());
        tableOptionPojo.setDataSourceSchema(cjDwCrtTabDdlInfo.getDataSourceSchema());
        tableOptionPojo.setDataSourceTable(cjDwCrtTabDdlInfo.getDataSourceTable());
        if (cjDwCrtTabDdlInfo.getDwDataTableDdlInfo() != null && cjDwCrtTabDdlInfo.getDwDataTableDdlInfo().length() > 0) {
            String[] dwDdls = cjDwCrtTabDdlInfo.getDwDataTableDdlInfo().split(";");
            for (int i = 0; i < dwDdls.length; i++) {
                try {
                    connection = instance.getConnection();
                    preparedStatement = connection.prepareStatement(dwDdls[i]);
                    preparedStatement.execute();
                    tableOptionPojo.setResult(Constant.TABLE_OPTION_SUCCESS);
                } catch (Exception e) {
                    tableOptionPojo.setResult(Constant.TABLE_OPTION_FAILED);
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        try {
                            preparedStatement.close();
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return tableOptionPojo;
    }

    /**
    * @Author: zhangdongmao
    * @Date: 2019/7/10
    * @Description:  hive删表
    * @Param: * @param null 1
    * @return:
    */
    public TableOptionPojo hiveDropTable(String schema, String tableName) {
        GroupPoolFactory instance = GroupPoolFactory.getInstance(Constant.HIVE_INSTANCE);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        TableOptionPojo tableOptionPojo = new TableOptionPojo();
        String dropTableSql = "drop table if exists "+schema+"."+tableName;
        try {
            connection = instance.getConnection();
            preparedStatement = connection.prepareStatement(dropTableSql);
            preparedStatement.execute();
            tableOptionPojo.setResult(Constant.TABLE_OPTION_SUCCESS);
        } catch (Exception e) {
            tableOptionPojo.setResult(Constant.TABLE_OPTION_FAILED);
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return tableOptionPojo;
    }
}
