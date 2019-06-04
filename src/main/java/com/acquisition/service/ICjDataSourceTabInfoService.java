package com.acquisition.service;


import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDataSourceTabInfoExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */

public interface ICjDataSourceTabInfoService {
    List<CjDataSourceTabInfo> findAllByOdsHiveAndDwHive(String dataFlagForGetCols,String dataFlagForCrtOdsDll);
    String updateByExampleSelective(CjDataSourceTabInfo record, CjDataSourceTabInfoExample example);
    List<CjDataSourceTabInfo> findAllByColsAndOds();
    void updcrtDwFlagByObject(CjDataSourceTabInfo cjDataSourceTabInfo);
    void updateODSFlg(String dataFlagForCrtOdsDll ,String dataFlagForCrtOdsHive);
    List<CjDataSourceTabInfo> findAllCjVGetPrepareCrtDwTabList();
    List<CjDataSourceTabInfo> findAllCjVGetPrepareScriptForDwTabList();

    void updateODSFlg(String dataFlagForCrtOdsDll ,
                      String dataFlagForCrtOdsHive,
                      String businessSystemNameShortName,
                      String dataSourceSchema,
                      String dataSourceTable);
    List<CjDataSourceTabInfo> findByExample(CjDataSourceTabInfoExample example);

    List<CjDataSourceTabInfo> findODSTaableInfo();

    int updateODSScriptStatus(String dataFlagForCrtOdsScript ,
                              String businessSystemNameShortName,
                              String dataSourceSchema,
                              String dataSourceTable);

}
