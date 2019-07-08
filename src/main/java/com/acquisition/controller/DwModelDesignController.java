package com.acquisition.controller;

import com.acquisition.entity.*;
import com.acquisition.entity.dto.CjDwCrtTabDdlInfoDto;
import com.acquisition.entity.dto.CjDwTableColInfoDto;
import com.acquisition.entity.pojo.TableOptionPojo;
import com.acquisition.entity.vo.DwModelDesign;
import com.acquisition.service.*;
import com.acquisition.util.Constant;
import com.acquisition.util.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yili.pool.pool.GroupPoolFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
            resultMap.put("odsDataTable", odsDataTable);
            result.success(JSON.toJSON(resultMap));
        }
        return result;
    }
    @ApiOperation("按在用区表名查表")
    @GetMapping("/getTabByUsingName")
    public Result getTabByUsingName(@RequestParam(value = "dwDataTable") String dwDataTable) {
        Result result = new Result();
        List<CjDwTableColInfo> cjDwTableColInfos = cjDwTableColInfoService.selectColInfoByTopicAndTab(Constant.DW_USEING_DOMAIN, dwDataTable);
        if(cjDwTableColInfos.isEmpty()) {
            result.setCode(500);
            result.setMsg("在用区无此表");
        } else {
            String odsDataTable = cjDwCrtTabDdlInfoService.findOdsDataTableByDwDataTable(dwDataTable);
            CjOdsTableLoadModeInfo cjOdsTableLoadModeInfo = cjOdsTableLoadModeInfoService.findByOdsDataTable(odsDataTable);
            String odsTablePartitionColName = cjOdsTableLoadModeInfo.getOdsTablePartitionColName();
            String odsTablePrimaryCol = cjOdsTableLoadModeInfo.getOdsTablePrimaryColName();
            String[] odsTablePrimaryCols = cjOdsTableLoadModeInfo.getOdsTablePrimaryColSeqStr().split(",");
            List<String> dWPrimaryCols = cjDwTableColInfoService.findPrimaryCol(Constant.DW_USEING_DOMAIN, dwDataTable, odsTablePrimaryCols);
            String dWPrimaryCol = String.join(",", dWPrimaryCols);
            List<CjOdsTableColInfo> cjOdsTableColInfos = cjOdsTableColInfoService.findByColOrder(cjOdsTableLoadModeInfo.getBusinessSystemNameShortName(), cjOdsTableLoadModeInfo.getDataSourceSchema(), cjOdsTableLoadModeInfo.getDataSourceTable());

            List<DwModelDesign> dwModelDesigns = new ArrayList<>();
            for(int i=0;i<(cjOdsTableColInfos.size()>cjDwTableColInfos.size() ? cjOdsTableColInfos.size() : cjDwTableColInfos.size());i++){
                DwModelDesign dwModelDesign = new DwModelDesign();
                if(i<cjOdsTableColInfos.size()){
                    dwModelDesign.setSrcSchema(cjOdsTableColInfos.get(i).getOdsDataSchema());
                    dwModelDesign.setSrcTableComment(cjOdsTableColInfos.get(i).getOdsTableComment());
                    dwModelDesign.setSrcTableName(cjOdsTableColInfos.get(i).getOdsDataTable());
                    dwModelDesign.setSrcColName(cjOdsTableColInfos.get(i).getOdsTableColName());
                    dwModelDesign.setSrcColType(cjOdsTableColInfos.get(i).getOdsTableColType());
                    dwModelDesign.setSrcColComment(cjOdsTableColInfos.get(i).getOdsTableColComment());
                }
                if(i<cjDwTableColInfos.size()){
                    dwModelDesign.setTarTableName(cjDwTableColInfos.get(i).getDwDataTable());
                    dwModelDesign.setTarTableComment(cjDwTableColInfos.get(i).getDwTableComment());
                    dwModelDesign.setTarColName(cjDwTableColInfos.get(i).getDwTableColName());
                    dwModelDesign.setTarColType(cjDwTableColInfos.get(i).getDwTableColType());
                    dwModelDesign.setTarColComment(cjDwTableColInfos.get(i).getDwTableColComment());
                }
                dwModelDesigns.add(dwModelDesign);
            }

            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("dwModelDesigns", dwModelDesigns);
            resultMap.put("odsDataTable", odsDataTable);
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
