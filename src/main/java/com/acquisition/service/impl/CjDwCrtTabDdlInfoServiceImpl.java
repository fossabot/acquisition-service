package com.acquisition.service.impl;

import com.acquisition.entity.CjDataSourceTabColInfo;
import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDwCrtTabDdlInfo;
import com.acquisition.repository.CjDataSourceTabColInfoRepository;
import com.acquisition.repository.CjDataSourceTableInfoRepository;
import com.acquisition.repository.CjDwCrtTabDdlInfoRepository;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.service.ICjDwCrtTabDdlInfoService;
import com.acquisition.service.ICjOdsCrtTabDdlInfoService;
import com.acquisition.util.*;
import com.yili.pool.pool.GroupPoolFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjDwCrtTabDdlInfoServiceImpl implements ICjDwCrtTabDdlInfoService{
    /*@Autowired
    CjDataSourceTabColInfoRepository cjDataSourceTabColInfoRepository;
    @Autowired
    CjDwCrtTabDdlInfoRepository cjDwCrtTabDdlInfoRepository;
    @Autowired
    ICjDataSourceTabInfoService iCjDataSourceTabInfoService;
    @Autowired
    ICjOdsCrtTabDdlInfoService iCjOdsCrtTabDdlInfoService;
    @Autowired
    ICjDwCrtTabDdlInfoService iCjDwCrtTabDdlInfoService;*/
    private final static Logger LOGGER = LoggerFactory.getLogger(CjDwCrtTabDdlInfoServiceImpl.class);

    /**
    * @Author: zhangdongmao
    * @Date: 2019/5/30
    * @Description:  生成DW建表语句
    * @Param: * @param null 1
    * @return:
    */
    @Override
    public String createDwTable(List<CjDataSourceTabInfo> cjDataSourceTabInfoList) {
      /*  String businessSystemNameShortName;
        String dataSourceSchema;
        String dataSourceTable;
        String dwTableName;
        String colName;
        String colType;
        String colComment;
//        GroupPoolFactory instance = GroupPoolFactory.getInstance("DATALAKE");
//        instance.setConfigurationParameter("org.apache.hive.jdbc.HiveDriver","","192.168.0.95","10000","","hive","hive");
        //遍历每张表，生成DW建表语句
        for (CjDataSourceTabInfo cjDataSourceTabInfo:cjDataSourceTabInfoList){
            businessSystemNameShortName=cjDataSourceTabInfo.getBusinessSystemNameShortName();
            dataSourceSchema=cjDataSourceTabInfo.getDataSourceSchema();
            dataSourceTable=cjDataSourceTabInfo.getDataSourceTable();
            dwTableName="d_nct_"+dataSourceTable;
            //使用StringBuffer拼接DW建表语句
            StringBuffer dwddl=new StringBuffer();
            dwddl.append("create table data_lake."+dwTableName+"\n");
            dwddl.append("("+"\n");
            //通过系统名、数据模式、表名获取表的字段信息
            List<CjDataSourceTabColInfo> cjDataSourceTabColInfos = cjDataSourceTabColInfoRepository.selectAllBySysAndSchemaAndTab(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
            for(int i=0;i<cjDataSourceTabColInfos.size();i++){
                colName=cjDataSourceTabColInfos.get(i).getDataSourceColName().toLowerCase();
                colType=cjDataSourceTabColInfos.get(i).getDataSourceColDatatype().toLowerCase();
                colComment=cjDataSourceTabColInfos.get(i).getDataSourceColComment();
                if(colComment==null){
                    colComment="";
                }
                if(i<cjDataSourceTabColInfos.size()-1){
                    dwddl.append("    `"+colName+"`    "+"string"+"    "+"comment '"+colComment+"'"+",\n");
                }else {
                    dwddl.append("    `"+colName+"`    "+"string"+"    "+"comment '"+colName+"'"+"\n");
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
            iCjDataSourceTabInfoService.updcrtDwFlagByObject(cjDataSourceTabInfo);
            *//**
             * 将dw建表语句存入mysql中
             *//*

            CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo=new CjDwCrtTabDdlInfo();
            cjDwCrtTabDdlInfo.setBusinessSystemId(cjDataSourceTabInfo.getBusinessSystemId());
            cjDwCrtTabDdlInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
            cjDwCrtTabDdlInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
            cjDwCrtTabDdlInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
//            cjDwCrtTabDdlInfo.setOdsDataTable(iCjOdsCrtTabDdlInfoService.GetODSTableName(businessSystemNameShortName,dataSourceSchema,dataSourceTable));
            cjDwCrtTabDdlInfo.setOdsDataTable(businessSystemNameShortName+"_"+dataSourceTable);
            cjDwCrtTabDdlInfo.setDwDataTable(dwTableName);
//            System.out.println(dwddl.toString());
            cjDwCrtTabDdlInfo.setDwDataTableDdlInfo(dwddl.toString());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjDwCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
            iCjDwCrtTabDdlInfoService.insertByObject(cjDwCrtTabDdlInfo);
        }
        return null;*/
        return null;
    }

    @Override
    public void insertByObject(CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo) {
       /* try {
            cjDwCrtTabDdlInfoRepository.insertByObject(cjDwCrtTabDdlInfo);
        }catch (Exception e){
            e.printStackTrace();
        }*/

    }


}
