package com.acquisition.service.impl;

import com.acquisition.service.ICjOdsCrtTabDdlInfoService;
import org.springframework.stereotype.Service;
import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjOdsCrtTabDdlInfo;
import com.acquisition.entity.Result;
import com.acquisition.mapper.CjOdsCrtTabDdlInfoMapper;
import javax.annotation.Resource;
import java.util.List;


/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjOdsCrtTabDdlInfoServiceImpl implements ICjOdsCrtTabDdlInfoService {

    @Resource(name = "cjOdsCrtTabDdlInfoMapper")
    CjOdsCrtTabDdlInfoMapper cjOdsCrtTabDdlInfoMapper;

    @Override
    public String GetODSTableName(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable) {
      /*  String odsTableName = "";
        odsTableName = cjOdsCrtTabDdlInfoRepository.selectODSTableNameBySystemAndSchemaAndTable(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
        return odsTableName;*/
      return null;
    }

    @Override
    public String getODSTableInfo(List<CjDataSourceTabInfo> CjDataSourceTabInfos) {
        return null;
    }

    /**
     * @return
     */

    @Override
    public String saveDDLAndCreateTable(List<CjDataSourceTabInfo> CjDataSourceTabInfos) {
       /* String sysName;
        String schemaName;
        String tableName;
        String colName;
        String colComment;

        StringBuffer odsDDL = new StringBuffer();
        CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo = new CjOdsCrtTabDdlInfo();

        //遍历从前端获取到表的列表，拼接字段，创建 Hive DDL
        for(CjDataSourceTabInfo cjDataSourceTabInfo : CjDataSourceTabInfos){
            sysName = cjDataSourceTabInfo.getBusinessSystemNameShortName();
            schemaName = cjDataSourceTabInfo.getDataSourceSchema();
            tableName = cjDataSourceTabInfo.getDataSourceTable();

            odsDDL.append("create table sdata_full." + sysName.toLowerCase() + "_" +tableName.toLowerCase() +"\n");
            odsDDL.append("("+"\n");

            List<CjDataSourceTabColInfo> infoList = cjDataSourceTabColInfoRepository
                    .selectAllBySysAndSchemaAndTab(sysName,schemaName,tableName);

            for(int i = 0; i < infoList.size(); i++){
                colName = infoList.get(i).getDataSourceColName().toLowerCase();
                colComment=infoList.get(i).getDataSourceColComment();

                if(colComment == null){
                    colComment="";
                }
                if(i < infoList.size() - 1){
                    odsDDL.append("    `"+colName+"`    "+"string"+"    "+"comment '"+colComment+"'"+",\n");
                }else {
                    odsDDL.append("    `"+colName+"`    "+"string"+"    "+"comment '"+colName+"'"+"\n");
                }
            }
            odsDDL.append(")"+"\n");
            odsDDL.append("row format delimited fields terminated by '\\001' lines terminated by '\\n'");

            cjOdsCrtTabDdlInfo.setBusinessSystemId(cjDataSourceTabInfo.getBusinessSystemId());
            cjOdsCrtTabDdlInfo.getBusinessSystemNameShortName(sysName);
            System.out.println("business_system_name_short_name" + sysName);
            cjOdsCrtTabDdlInfo.setDataSourceSchema(schemaName);
            cjOdsCrtTabDdlInfo.setDataSourceTable(tableName);
            cjOdsCrtTabDdlInfo.setOdsDataSchema("sdata_full");
            cjOdsCrtTabDdlInfo.setOdsDataTable(sysName + "_" + tableName);
            cjOdsCrtTabDdlInfo.setOdsDataTableDdlInfo(odsDDL.toString());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjOdsCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
            cjOdsCrtTabDdlInfo.setLastModifyBy("admin");
            cjOdsCrtTabDdlInfoRepository.insertByObject(cjOdsCrtTabDdlInfo);
        }
        return createTableInHive();*/
       return null;
    }

    /**
     * 在Hive中建表
     * @return 返回创建成功的状态
     */
    public String createTableInHive(){
        return Result.ok("Hive 表创建成功！");
    }
    @Override
    public boolean saveDDLAndCreateTable(CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo) {
        if (cjOdsCrtTabDdlInfoMapper.insert(cjOdsCrtTabDdlInfo) > 0){
            return true;
        }
        return false;
    }

}
