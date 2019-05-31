package com.acquisition.service.impl;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjOdsCrtTabDdlInfo;
import com.acquisition.mapper.CjOdsCrtTabDdlInfoMapper;
import com.acquisition.service.ICjOdsCrtTabDdlInfoService;
import org.springframework.stereotype.Service;
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

    @Override
    public boolean saveDDLAndCreateTable(CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo) {
        if (cjOdsCrtTabDdlInfoMapper.insert(cjOdsCrtTabDdlInfo) > 0){
            return true;
        }
        return false;
    }

}
