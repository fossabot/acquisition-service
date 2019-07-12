package com.acquisition.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjOdsCrtTabDdlInfo;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */

public interface ICjOdsCrtTabDdlInfoService {

    String GetODSTableName(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable);
    String getODSTableInfo(List<CjDataSourceTabInfo> CjDataSourceTabInfos);
    boolean saveDDLAndCreateTable(CjOdsCrtTabDdlInfo CjDataSourceTabInfos);
    int insertBatch(List<CjOdsCrtTabDdlInfo> list);
    List selectByParams(String businessSystemNameShortName, String dataSourceSchema ,String dataSourceTable, String  odsDataTable);
}
