package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDataSourceTabInfoExample;
import com.acquisition.entity.CjDwCrtTabDdlInfo;
import com.acquisition.entity.pojo.CjDwCrtDdlColPojo;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.service.ICjDwCrtTabDdlInfoService;
import com.acquisition.util.*;
import com.acquisition.service.ICjOdsCrtTabDdlInfoService;
import com.alibaba.fastjson.JSONObject;
import com.acquisition.entity.CjDataSourceTabColInfo;
import com.acquisition.entity.CjOdsCrtTabDdlInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by zhangdongmao on 2019/5/29.
 */
@RestController
@RequestMapping(value = "/hiveCreateTable")
public class HiveCreateTableController {

    @Resource(name = "cjDataSourceTabColInfoServiceImpl")
    public ICjDataSourceTabColInfoService cjDataSourceTabColInfoService;

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    public ICjDataSourceTabInfoService cjDataSourceTabInfoService;

    @Resource(name = "cjOdsCrtTabDdlInfoServiceImpl")
    public ICjOdsCrtTabDdlInfoService cjOdsCrtTabDdlInfoService;

    @Resource(name = "cjDwCrtTabDdlInfoServiceImpl")
    public ICjDwCrtTabDdlInfoService cjDwCrtTabDdlInfoService;

    @GetMapping(value = "/getDWCreateTabList")
    public Result getDWCreateTabList() {
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService
                .findAllCjVGetPrepareCrtDwTabList();
        Result result=new Result();
        result.success(cjDataSourceTabInfos);
        return result;
    }

    @PostMapping(value = "/dWCreateTable")
    public Result dWCreateTable(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        data = jsonObject.getString("params");
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = JSONObject.parseArray(data, CjDataSourceTabInfo.class);
        String businessSystemNameShortName;
        String dataSourceSchema;
        String dataSourceTable;
        String dwTableName;
        String colName;
        String colType;
        String colComment;
        Result result=new Result();
//        //遍历每张表，生成DW建表语句
        for (CjDataSourceTabInfo cjDataSourceTabInfo:cjDataSourceTabInfos){
            businessSystemNameShortName=cjDataSourceTabInfo.getBusinessSystemNameShortName();
            dataSourceSchema=cjDataSourceTabInfo.getDataSourceSchema();
            dataSourceTable=cjDataSourceTabInfo.getDataSourceTable();
            dwTableName="d_nct_"+dataSourceSchema.toLowerCase()+"_"+dataSourceTable.toLowerCase();
            //使用StringBuffer拼接DW建表语句
            StringBuffer dwddl=new StringBuffer();
            dwddl.append("create table if not exists data_lake."+dwTableName+"\n");
            dwddl.append("("+"\n");
            //通过系统名、数据模式、表名获取表的字段信息
            List<CjDwCrtDdlColPojo> cjDwCrtDdlColPojos = cjDataSourceTabColInfoService.selectCjDwCrtDdlColPojoBySysAndSchemaAndTab(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
            for(int i=0;i<cjDwCrtDdlColPojos.size();i++){
                colName=cjDwCrtDdlColPojos.get(i).getDataSourceColName().toLowerCase();
                colType=cjDwCrtDdlColPojos.get(i).getColMapper().toLowerCase();
                colComment=cjDwCrtDdlColPojos.get(i).getDataSourceColComment();
                if(colComment==null){
                    colComment="";
                }
                if(i<cjDwCrtDdlColPojos.size()-1){
                    dwddl.append("    `"+colName+"`    "+colType+"    "+"comment '"+colComment+"'"+",\n");
                }else {
                    dwddl.append("    `"+colName+"`    "+colType+"    "+"comment '"+colName+"'"+"\n");
                }
            }
            dwddl.append(")"+"\n");
            dwddl.append("row format delimited fields terminated by '\\001' lines terminated by '\\n' stored as orc");

            /**
             * 将dw建表语句存入mysql中
             */

            CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo=new CjDwCrtTabDdlInfo();
            cjDwCrtTabDdlInfo.setBusinessSystemId(cjDataSourceTabInfo.getBusinessSystemId());
            cjDwCrtTabDdlInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
            cjDwCrtTabDdlInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
            cjDwCrtTabDdlInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
            cjDwCrtTabDdlInfo.setOdsDataTable(businessSystemNameShortName.toLowerCase()+"_"+dataSourceSchema.toLowerCase()+"_"+dataSourceTable);
            cjDwCrtTabDdlInfo.setDwDataTable(dwTableName);
            cjDwCrtTabDdlInfo.setDwDataTableDdlInfo(dwddl.toString());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjDwCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
            cjDwCrtTabDdlInfoService.deleteByPrimaryKey(cjDwCrtTabDdlInfo);
            if(cjDwCrtTabDdlInfoService.save(cjDwCrtTabDdlInfo).equals("保存成功")){
                //生成DW建表语句成功，设置状态表中的相应状态字段
                cjDataSourceTabInfo.setDataFlagForCrtDwDll(Constant.DW_CRT_DDL);
                cjDataSourceTabInfo.setDataFlagForCrtDwHive(Constant.DW_CRT_HIVE);
                //将状态改变更新到数据库
                CjDataSourceTabInfoExample cjDataSourceTabInfoExample=new CjDataSourceTabInfoExample();
                CjDataSourceTabInfoExample.Criteria criteria = cjDataSourceTabInfoExample.createCriteria();
                //where条件使用业务系统缩写、数据模式和表名做限制
                criteria.andBusinessSystemNameShortNameEqualTo(businessSystemNameShortName);
                criteria.andDataSourceSchemaEqualTo(dataSourceSchema);
                criteria.andDataSourceTableEqualTo(dataSourceTable);
                cjDataSourceTabInfoService.updateByExampleSelective(cjDataSourceTabInfo,cjDataSourceTabInfoExample);
            }
            dwddl.setLength(0);
        }
        result.setCode(200);
        result.setMsg("建表成功");
        return result;
    }

    /**
     * @return 返回已经导入清单，但没有在ODS建表的表
     */
    @RequestMapping(value = "/getODSTableInfo")
    @ResponseBody
    public Result getODSTable() {
        Result result=new Result();
        return result.success(cjDataSourceTabInfoService.findAllByColsAndOds());
    }

    /**
     * @return 获取前端传来的需要去ODS创建的表信息
     */
    @PostMapping("/createODSTable")
    public Result createODSTable(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("params");
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = JSONObject.parseArray(odsTableList, CjDataSourceTabInfo.class);
        return saveDDLAndCreateTable(cjDataSourceTabInfos);
    }

    /**
     * @return 拼接并保存SQL,返回状态码
     */
    public Result saveDDLAndCreateTable(List<CjDataSourceTabInfo> CjDataSourceTabInfos) {
        String colName = "";
        String colComment = "";
        StringBuffer odsDDL = new StringBuffer();
        Result result=new Result();

        CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo = new CjOdsCrtTabDdlInfo();

        //遍历从前端获取到表的列表，拼接字段，创建 Hive DDL
        for (CjDataSourceTabInfo cjDataSourceTabInfo : CjDataSourceTabInfos) {
            odsDDL.append("create table if not exists sdata_full."
                    + cjDataSourceTabInfo.getBusinessSystemNameShortName().toLowerCase()
                    + "_" + cjDataSourceTabInfo.getDataSourceTable().toLowerCase() + "\n");
            odsDDL.append("(" + "\n");

            List<CjDataSourceTabColInfo> infoList = cjDataSourceTabColInfoService
                    .findBySystemAndSchemaAndTab(cjDataSourceTabInfo.getBusinessSystemNameShortName(),
                            cjDataSourceTabInfo.getDataSourceSchema(),
                            cjDataSourceTabInfo.getDataSourceTable());
            for (int i = 0; i < infoList.size(); i++) {
                colName = infoList.get(i).getDataSourceColName().toLowerCase();
                colComment = infoList.get(i).getDataSourceColComment();
                if (colComment == null) {
                    colComment = "";
                }
                if (i < infoList.size() - 1) {
                    odsDDL.append("    `" + colName + "`    " + "string" + "    " + "comment '" + colComment + "'" + ",\n");
                } else {
                    odsDDL.append("    `" + colName + "`    " + "string" + "    " + "comment '" + colName + "'" + "\n");
                }
            }
            odsDDL.append(")" + "\n");
            odsDDL.append("row format delimited fields terminated by '\\001' lines terminated by '\\n'");

            try {
                createTableInHive(odsDDL.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            cjOdsCrtTabDdlInfo.setBusinessSystemId(cjDataSourceTabInfo.getBusinessSystemId());
            cjOdsCrtTabDdlInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
            cjOdsCrtTabDdlInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
            cjOdsCrtTabDdlInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
            cjOdsCrtTabDdlInfo.setOdsDataSchema("sdata_full");
            cjOdsCrtTabDdlInfo.setOdsDataTable(cjDataSourceTabInfo.getBusinessSystemNameShortName().toLowerCase() + "_"
                            + cjDataSourceTabInfo.getDataSourceTable().toLowerCase());
            cjOdsCrtTabDdlInfo.setOdsDataTableDdlInfo(odsDDL.toString());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjOdsCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
            cjOdsCrtTabDdlInfo.setLastModifyBy("admin");

            //保存DDL
            if (cjOdsCrtTabDdlInfoService.saveDDLAndCreateTable(cjOdsCrtTabDdlInfo)){
                cjDataSourceTabInfoService.updateODSFlg(
                        "1","1",
                        cjDataSourceTabInfo.getBusinessSystemNameShortName(),
                        cjDataSourceTabInfo.getDataSourceSchema(),
                        cjDataSourceTabInfo.getDataSourceTable());
            }
            odsDDL.setLength(0);
        }

        result.setMsg("ODS建表成功！！！");
        result.setCode(200);
        return result;
    }


    /**
     * 在Hive中建表
     *
     * @return 返回创建成功的状态
     */
    public boolean createTableInHive(String sql) {
        if (sql != null){
            //执行sql
            return true;
        }
        return false;
    }
}
