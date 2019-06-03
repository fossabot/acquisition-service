package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDataSourceTabInfoExample;
import com.acquisition.entity.CjDwCrtTabDdlInfo;
import com.acquisition.entity.Result;
import com.acquisition.entity.pojo.CjDwCrtDdlColPojo;
import com.acquisition.mapper.CjDataSourceTabColInfoMapper;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.service.ICjDwCrtTabDdlInfoService;
import com.acquisition.util.*;
import com.acquisition.service.ICjOdsCrtTabDdlInfoService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.acquisition.entity.CjDataSourceTabColInfo;
import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjOdsCrtTabDdlInfo;
import com.acquisition.entity.Result;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.service.ICjOdsCrtTabDdlInfoService;
import com.alibaba.fastjson.JSONObject;
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

    @PostMapping(value = "/getDWCreateTabList")
    public String getDWCreateTabList() {
        return Result.ok(JSONObject.toJSON(cjDataSourceTabInfoService.findAllByOdsHiveAndDwHive(Constant.ODS_CRT_HIVE, Constant.DW_NO_CRT_HIVE)));
    }

    @PostMapping(value = "/dWCreateTable")
    public String dWCreateTable(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        data = jsonObject.getString("data");
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = JSONObject.parseArray(data, CjDataSourceTabInfo.class);
        String businessSystemNameShortName;
        String dataSourceSchema;
        String dataSourceTable;
        String dwTableName;
        String colName;
        String colType;
        String colComment;
//        //遍历每张表，生成DW建表语句
        for (CjDataSourceTabInfo cjDataSourceTabInfo:cjDataSourceTabInfos){
            businessSystemNameShortName=cjDataSourceTabInfo.getBusinessSystemNameShortName();
            dataSourceSchema=cjDataSourceTabInfo.getDataSourceSchema();
            dataSourceTable=cjDataSourceTabInfo.getDataSourceTable();
            dwTableName="d_nct_"+dataSourceSchema+"_"+dataSourceTable;
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
            //生成DW建表语句成功，设置状态表中的相应状态字段
            cjDataSourceTabInfo.setDataFlagForCrtDwDll(Constant.DW_CRT_DDL);
//            Connection conn = null;
//            PreparedStatement ps;
//            try {
//                conn = instance.getConnection();
//                ps = conn.prepareStatement(dwddl.toString());
//                ps.execute();  //executeQuery()方法支持的是增删改查等DML语句，对于DDL 需要调用execute()来执行.
            //DW建表成功，设置状态表中的相应状态字段
            cjDataSourceTabInfo.setDataFlagForCrtDwHive(Constant.DW_CRT_HIVE);

// } catch (Exception e) {
//                e.printStackTrace();
//            }
            //将状态改变更新到数据库
            CjDataSourceTabInfoExample cjDataSourceTabInfoExample=new CjDataSourceTabInfoExample();
            CjDataSourceTabInfoExample.Criteria criteria = cjDataSourceTabInfoExample.createCriteria();
            //where条件使用业务系统缩写、数据模式和表名做限制
            criteria.andBusinessSystemNameShortNameEqualTo(businessSystemNameShortName);
            criteria.andDataSourceSchemaEqualTo(dataSourceSchema);
            criteria.andDataSourceTableEqualTo(dataSourceTable);
            cjDataSourceTabInfoService.updateByExampleSelective(cjDataSourceTabInfo,cjDataSourceTabInfoExample);

            /**
             * 将dw建表语句存入mysql中
             */

            CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo=new CjDwCrtTabDdlInfo();
            cjDwCrtTabDdlInfo.setBusinessSystemId(cjDataSourceTabInfo.getBusinessSystemId());
            cjDwCrtTabDdlInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
            cjDwCrtTabDdlInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
            cjDwCrtTabDdlInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
            cjDwCrtTabDdlInfo.setOdsDataTable(businessSystemNameShortName+"_"+dataSourceTable);
            cjDwCrtTabDdlInfo.setDwDataTable(dwTableName);
            cjDwCrtTabDdlInfo.setDwDataTableDdlInfo(dwddl.toString());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjDwCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
            cjDwCrtTabDdlInfoService.save(cjDwCrtTabDdlInfo);
            dwddl.setLength(0);
        }
        return Result.ok("建表成功");
    }

    /**
     * @return 返回已经导入清单，但没有在ODS建表的表
     */
    @RequestMapping(value = "/getODSTable")
    @ResponseBody
    public String getODSTable() {
        return cjDataSourceTabInfoService.findAllByColsAndOds();
    }

    /**
     * @return 获取前端传来的需要去ODS创建的表信息
     */
    @PostMapping("/createODSTable")
    public String createODSTable(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("data");
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = JSONObject.parseArray(odsTableList, CjDataSourceTabInfo.class);
        saveDDLAndCreateTable(cjDataSourceTabInfos);
        return Result.ok("sucess");
    }

    public String saveDDLAndCreateTable(List<CjDataSourceTabInfo> CjDataSourceTabInfos) {
        String colName = "";
        String colComment = "";
        StringBuffer odsDDL = new StringBuffer();
        CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo = new CjOdsCrtTabDdlInfo();

        //遍历从前端获取到表的列表，拼接字段，创建 Hive DDL
        for (CjDataSourceTabInfo cjDataSourceTabInfo : CjDataSourceTabInfos) {
            odsDDL.append("create table is not exists sdata_full."
                    + cjDataSourceTabInfo.getBusinessSystemNameShortName().toLowerCase()
                    + "_" + cjDataSourceTabInfo.getDataSourceSchema().toLowerCase() + "\n");
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

            cjOdsCrtTabDdlInfo.setBusinessSystemId(cjDataSourceTabInfo.getBusinessSystemId());
            cjOdsCrtTabDdlInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
            cjOdsCrtTabDdlInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
            cjOdsCrtTabDdlInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
            cjOdsCrtTabDdlInfo.setOdsDataSchema("sdata_full");
            cjOdsCrtTabDdlInfo.setOdsDataTable(cjDataSourceTabInfo.getBusinessSystemNameShortName().toLowerCase() + "_" + cjDataSourceTabInfo.getDataSourceTable().toLowerCase());
            cjOdsCrtTabDdlInfo.setOdsDataTableDdlInfo(odsDDL.toString());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjOdsCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
            cjOdsCrtTabDdlInfo.setLastModifyBy("admin");

            //保存DDL
            if (cjOdsCrtTabDdlInfoService.saveDDLAndCreateTable(cjOdsCrtTabDdlInfo)){
                cjDataSourceTabInfoService.updateODSFlg("1","1");
            }
            odsDDL.setLength(0);
        }
        return createTableInHive();
    }


    /**
     * 在Hive中建表
     *
     * @return 返回创建成功的状态
     */
    public String createTableInHive() {
        return Result.ok("Hive 表创建成功！");
    }
}
