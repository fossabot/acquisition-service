package com.acquisition.mapper;

import java.util.List;


import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDataSourceTabInfoExample;
import com.acquisition.entity.CjDataSourceTabInfoKey;
import org.apache.ibatis.annotations.Param;

public interface CjDataSourceTabInfoMapper {
    List<CjDataSourceTabInfo> selectAll();
    List<CjDataSourceTabInfo> selectAllByOdsHiveAndDwHive(@Param("dataFlagForCrtOdsHive") String dataFlagForCrtOdsHive,@Param("dataFlagForCrtDwHive") String dataFlagForCrtDwHive);
    int updateCrtDwFlagByObject(CjDataSourceTabInfo cjDataSourceTabInfo);
    int countByExample(CjDataSourceTabInfoExample example);

    int deleteByExample(CjDataSourceTabInfoExample example);

    int deleteByPrimaryKey(CjDataSourceTabInfoKey key);

    int insert(CjDataSourceTabInfo record);

    int insertSelective(CjDataSourceTabInfo record);

    List<CjDataSourceTabInfo> selectByExample(CjDataSourceTabInfoExample example);

    CjDataSourceTabInfo selectByPrimaryKey(CjDataSourceTabInfoKey key);

    int updateByExampleSelective(@Param("record") CjDataSourceTabInfo record, @Param("example") CjDataSourceTabInfoExample example);

    int updateByExample(@Param("record") CjDataSourceTabInfo record, @Param("example") CjDataSourceTabInfoExample example);

    int updateByPrimaryKeySelective(CjDataSourceTabInfo record);

    int updateByPrimaryKey(CjDataSourceTabInfo record);

    List<CjDataSourceTabInfo> selectAll(String dataFlagForGetCols, String dataFlagForCrtOdsDll);
    List<CjDataSourceTabInfo> selectBySystemAndSchema();
    int updateDataFlagForCrtOdsDll(@Param("dataFlagForCrtOdsDll") String dataFlagForGetCols,
                                   @Param("dataFlagForCrtOdsHive") String dataFlagForCrtOdsHive,
                                   @Param("businessSystemNameShortName") String businessSystemNameShortName,
                                   @Param("dataSourceSchema") String dataSourceSchema,
                                   @Param("dataSourceTable") String dataSourceTable
    );
    List<CjDataSourceTabInfo> selectAllCjVGetPrepareScriptForDwTabList();
    List<CjDataSourceTabInfo> selectAllCjVGetPrepareCrtDwTabList();
    List<CjDataSourceTabInfo> selectODSTableInfo();
    int updateOdsScriptDefStatus(@Param("dataFlagForCrtOdsScript") String dataFlagForCrtOdsScript,
                                 @Param("businessSystemNameShortName") String businessSystemNameShortName,
                                 @Param("dataSourceSchema") String dataSourceSchema,
                                 @Param("dataSourceTable") String dataSourceTable
    );
    List<CjDataSourceTabInfo> selectOdsExportTableInfo();
    List<CjDataSourceTabInfo> selectDwExportTableInfo();

    int insertBatch(CjDataSourceTabInfo list);
    int deleteBySystemName(@Param("systemname") String systemname);

    List<CjDataSourceTabInfo> selectDistSystemAndSchemaFromCjVGetPrepareCrtDwTabList();
    List<CjDataSourceTabInfo> selectDistSystemAndSchemaFromCjVGetPrepareCrtOdsTabList();

    List<CjDataSourceTabInfo> selectFromCjVGetPrepareCrtOdsTabListBySystemAndSchema(@Param("businessSystemNameShortName") String businessSystemNameShortName,@Param("dataSourceSchema") String dataSourceSchema);
    List<CjDataSourceTabInfo> selectFromCjVGetPrepareCrtDwTabListBySystemAndSchema(@Param("businessSystemNameShortName") String businessSystemNameShortName,@Param("dataSourceSchema") String dataSourceSchema);

    List<String> selectDistSystemFromCjVGetPrepareScriptForDwTabList();
    List<String> selectDistSystemFromCjVGetPrepareScriptForOdsTabList();


    List<CjDataSourceTabInfo> selectCjVGetPrepareScriptForDwTabListBySystem(@Param("businessSystemNameShortName") String businessSystemNameShortName);
    List<CjDataSourceTabInfo> selectCjVGetPrepareScriptForOdsTabListBySystem(@Param("businessSystemNameShortName") String businessSystemNameShortName);

    List<String> selectSysList();
    List<String> selectSumOfTables();
    List<String> selectSumOfTablesBySys(@Param(value = "businessSystemNameShortName") String businessSystemNameShortName);
    List<String> selectDistSystemName();

    List<String> selectDistSchema(@Param("systemname") String systemname);

    List<CjDataSourceTabInfo> selectBySysNameAndSchemaAndTableName(@Param("systemname") String systemname, @Param("schema") String schema, @Param("tablename") String tablename);

    List<CjDataSourceTabInfo> selectOdsExportTableInfoByFilterList();

}