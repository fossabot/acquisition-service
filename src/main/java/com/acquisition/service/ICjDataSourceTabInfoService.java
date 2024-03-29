package com.acquisition.service;


import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDataSourceTabInfoExample;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */

public interface ICjDataSourceTabInfoService {
    List<CjDataSourceTabInfo> findAllByOdsHiveAndDwHive(String dataFlagForGetCols, String dataFlagForCrtOdsDll);

    String updateByExampleSelective(CjDataSourceTabInfo record, CjDataSourceTabInfoExample example);

    List<CjDataSourceTabInfo> findAllByColsAndOds();

    void updcrtDwFlagByObject(CjDataSourceTabInfo cjDataSourceTabInfo);

    void updateODSFlg(String dataFlagForCrtOdsDll, String dataFlagForCrtOdsHive);

    List<CjDataSourceTabInfo> findAllCjVGetPrepareCrtDwTabList();

    List<CjDataSourceTabInfo> findAllCjVGetPrepareScriptForDwTabList();

    void updateODSFlg(String dataFlagForCrtOdsDll,
                      String dataFlagForCrtOdsHive,
                      String businessSystemNameShortName,
                      String dataSourceSchema,
                      String dataSourceTable);

    List<CjDataSourceTabInfo> findByExample(CjDataSourceTabInfoExample example);

    List<CjDataSourceTabInfo> findODSTableInfo();

    int updateODSScriptStatus(String dataFlagForCrtOdsScript,
                              String businessSystemNameShortName,
                              String dataSourceSchema,
                              String dataSourceTable);

    List<CjDataSourceTabInfo> findOdsScriptTableInfo(String schema);

    List<CjDataSourceTabInfo> findDwScriptTableInfo(String schema);

    int insertBatch(List<CjDataSourceTabInfo> list);

    int deleteBySystemName(String systemname);

    List<CjDataSourceTabInfo> findDistSystemAndSchemaFromCjVGetPrepareCrtDwTabList();

    List<CjDataSourceTabInfo> findDistSystemAndSchemaFromCjVGetPrepareCrtOdsTabList();

    List<CjDataSourceTabInfo> findFromCjVGetPrepareCrtOdsTabListBySystemAndSchema(String businessSystemNameShortName, String dataSourceSchema);

    List<CjDataSourceTabInfo> findFromCjVGetPrepareCrtDwTabListBySystemAndSchema(String businessSystemNameShortName, String dataSourceSchema);

    List<String> findDistSystemFromCjVGetPrepareScriptForDwTabList();

    List<String> findDistSystemFromCjVGetPrepareScriptForOdsTabList();

    List<CjDataSourceTabInfo> findCjVGetPrepareScriptForDwTabListBySystem(String businessSystemNameShortName);

    List<CjDataSourceTabInfo> findCjVGetPrepareScriptForOdsTabListBySystem(String businessSystemNameShortName);

    List<String> findSumOfTables();

    List<String> findSumOfTablesBySys(String sys);

    List<String> findSysList();

    List<String> selectDistSystemName();

    List<String> selectDistSchema(String systemname);

    List<CjDataSourceTabInfo> selectBySysNameAndSchemaAndTableName(String systemname, String schema, String tablename);

    List<CjDataSourceTabInfo> findOdsExportTableInfoByFilterList(String flag);
}
