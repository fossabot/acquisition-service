package com.acquisition.service;

import org.springframework.stereotype.Service;
import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjOdsCrtTabDdlInfo;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public interface ICjOdsCrtTabDdlInfoService {

    String GetODSTableName(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable);
    String getODSTableInfo(List<CjDataSourceTabInfo> CjDataSourceTabInfos);
    String saveDDLAndCreateTable(List<CjDataSourceTabInfo> CjDataSourceTabInfos);
    boolean saveDDLAndCreateTable(CjOdsCrtTabDdlInfo CjDataSourceTabInfos);
}
