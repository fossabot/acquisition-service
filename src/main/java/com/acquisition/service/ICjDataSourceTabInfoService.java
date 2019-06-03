package com.acquisition.service;


import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDataSourceTabInfoExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public interface ICjDataSourceTabInfoService {
    List<CjDataSourceTabInfo> findAllByOdsHiveAndDwHive(String dataFlagForGetCols,String dataFlagForCrtOdsDll);
    String updateByExampleSelective(CjDataSourceTabInfo record, CjDataSourceTabInfoExample example);
    List<CjDataSourceTabInfo> findAllByColsAndOds();
    void updcrtDwFlagByObject(CjDataSourceTabInfo cjDataSourceTabInfo);
<<<<<<< HEAD
    String findAllByColsAndOds();
    void updateODSFlg(String dataFlagForCrtOdsDll ,String dataFlagForCrtOdsHive);
    List<CjDataSourceTabInfo> findAllCjVGetPrepareCrtDwTabList();
    List<CjDataSourceTabInfo> findAllCjVGetPrepareScriptForDwTabList();
=======
    void updateODSFlg(String dataFlagForCrtOdsDll ,
                      String dataFlagForCrtOdsHive,
                      String businessSystemNameShortName,
                      String dataSourceSchema,
                      String dataSourceTable);
>>>>>>> 12bafe74b2af5d107ceda580e7ff4d0bc9791939
}
