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
     * 在Hive中建表
     * @return 返回创建成功的状态
     */
    public String createTableInHive(){
        return Result.ok("Hive 表创建成功！");
    }
    @Override
    public boolean saveDDLAndCreateTable(CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo) {
        cjOdsCrtTabDdlInfoMapper.deleteByPrimaryKey(cjOdsCrtTabDdlInfo);
        if (cjOdsCrtTabDdlInfoMapper.insert(cjOdsCrtTabDdlInfo) > 0){
            return true;
        }
        return false;
    }

    @Override
    public int insertBatch(List<CjOdsCrtTabDdlInfo> list) {
        for (CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo:list){
            System.out.println(cjOdsCrtTabDdlInfo.getBusinessSystemNameShortName()+":"+
            cjOdsCrtTabDdlInfo.getDataSourceSchema()+":"+
            cjOdsCrtTabDdlInfo.getOdsDataTable());
        }
        cjOdsCrtTabDdlInfoMapper.deleteBatch(list);
        return cjOdsCrtTabDdlInfoMapper.insertBatch(list);
    }

    @Override
    public List selectByParams(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable, String odsDataTable) {
        return cjOdsCrtTabDdlInfoMapper.selectByParams(
                businessSystemNameShortName,
                dataSourceSchema,
                dataSourceTable,
                odsDataTable
        );
    }
}
