package com.acquisition.service.impl;


import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDataSourceTabInfoExample;
import com.acquisition.mapper.CjDataSourceTabInfoMapper;
import com.acquisition.service.ICjDataSourceTabInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjDataSourceTabInfoServiceImpl implements ICjDataSourceTabInfoService {


    @Resource(name = "cjDataSourceTabInfoMapper")
    public CjDataSourceTabInfoMapper cjDataSourceTabInfoMapper;

    /**
     * @return 返回ODS中未创建的表
     */
    @Override
    public List<CjDataSourceTabInfo> findAllByColsAndOds() {
        return cjDataSourceTabInfoMapper.selectBySystemAndSchema();
    }

    /**
     * @param dataFlagForCrtOdsDll  已生成ODS DDL 1
     * @param dataFlagForCrtOdsHive ODS已建表 1
     * @return 返回更改状态
     */
    @Override
    public void updateODSFlg(String dataFlagForCrtOdsDll,
                             String dataFlagForCrtOdsHive,
                             String businessSystemNameShortName,
                             String dataSourceSchema,
                             String dataSourceTable) {
        cjDataSourceTabInfoMapper.updateDataFlagForCrtOdsDll(
                dataFlagForCrtOdsDll, dataFlagForCrtOdsHive,
                businessSystemNameShortName, dataSourceSchema, dataSourceTable);
    }

    @Override
    public List<CjDataSourceTabInfo> findByExample(CjDataSourceTabInfoExample example) {
//        return cjDataSourceTabInfoMapper.;
        return new ArrayList<>();
    }

    @Override
    public List<CjDataSourceTabInfo> findODSTableInfo() {
        return cjDataSourceTabInfoMapper.selectODSTableInfo();
    }

    @Override
    public int updateODSScriptStatus(String dataFlagForCrtOdsScript,
                                     String businessSystemNameShortName,
                                     String dataSourceSchema,
                                     String dataSourceTable) {
        return cjDataSourceTabInfoMapper.updateOdsScriptDefStatus(
                dataFlagForCrtOdsScript,
                businessSystemNameShortName,
                dataSourceSchema,
                dataSourceTable
        );

    }

    @Override
    public int insertBatch(List<CjDataSourceTabInfo> list) {
        int i = 0;
        for (CjDataSourceTabInfo tabInfo : list) {
            try {
                cjDataSourceTabInfoMapper.insertBatch(tabInfo);
                i++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return i;
    }

    @Override
    public int deleteBySystemName(String systemname) {
        return cjDataSourceTabInfoMapper.deleteBySystemName(systemname);
    }

    @Override
    public List<CjDataSourceTabInfo> findDistSystemAndSchemaFromCjVGetPrepareCrtDwTabList() {
        return cjDataSourceTabInfoMapper.selectDistSystemAndSchemaFromCjVGetPrepareCrtDwTabList();
    }

    @Override
    public List<CjDataSourceTabInfo> findDistSystemAndSchemaFromCjVGetPrepareCrtOdsTabList() {
        return cjDataSourceTabInfoMapper.selectDistSystemAndSchemaFromCjVGetPrepareCrtOdsTabList();
    }

    @Override
    public List<CjDataSourceTabInfo> findFromCjVGetPrepareCrtOdsTabListBySystemAndSchema(String businessSystemNameShortName,String dataSourceSchema) {
        return cjDataSourceTabInfoMapper.selectFromCjVGetPrepareCrtOdsTabListBySystemAndSchema(businessSystemNameShortName,dataSourceSchema);
    }

    @Override
    public List<CjDataSourceTabInfo> findFromCjVGetPrepareCrtDwTabListBySystemAndSchema(String businessSystemNameShortName,String dataSourceSchema) {
        return cjDataSourceTabInfoMapper.selectFromCjVGetPrepareCrtDwTabListBySystemAndSchema(businessSystemNameShortName,dataSourceSchema);
    }

    @Override
    public List<String> findDistSystemFromCjVGetPrepareScriptForDwTabList() {
        return cjDataSourceTabInfoMapper.selectDistSystemFromCjVGetPrepareScriptForDwTabList();
    }

    @Override
    public List<String> findDistSystemFromCjVGetPrepareScriptForOdsTabList() {
        return cjDataSourceTabInfoMapper.selectDistSystemFromCjVGetPrepareScriptForOdsTabList();
    }

    @Override
    public List<String> findSumOfTables() {
        return cjDataSourceTabInfoMapper.selectSumOfTables();
    }

    @Override
    public List<String> findSumOfTablesBySys(String sys) {
        return cjDataSourceTabInfoMapper.selectSumOfTablesBySys(sys);
    }

    @Override
    public List<String> findSysList() {
        return cjDataSourceTabInfoMapper.selectSysList();
    }

    @Override
    public List<CjDataSourceTabInfo> findAllCjVGetPrepareCrtDwTabList() {
        return cjDataSourceTabInfoMapper.selectAllCjVGetPrepareCrtDwTabList();
    }

    @Override
    public List<CjDataSourceTabInfo> findAllCjVGetPrepareScriptForDwTabList() {
        return cjDataSourceTabInfoMapper.selectAllCjVGetPrepareScriptForDwTabList();
    }

    @Override
    public List<CjDataSourceTabInfo> findAllByOdsHiveAndDwHive(String dataFlagForGetCols, String dataFlagForCrtOdsDll) {
        return cjDataSourceTabInfoMapper.selectAllByOdsHiveAndDwHive(dataFlagForGetCols, dataFlagForCrtOdsDll);
    }

    @Override
    public String updateByExampleSelective(CjDataSourceTabInfo record, CjDataSourceTabInfoExample example) {
        if (cjDataSourceTabInfoMapper.updateByExampleSelective(record, example) > 0) {
            return "更新成功";
        }
        return "更新失败";
    }

    @Override
    public void updcrtDwFlagByObject(CjDataSourceTabInfo cjDataSourceTabInfo) {

    }

    @Override
    public void updateODSFlg(String dataFlagForCrtOdsDll, String dataFlagForCrtOdsHive) {

    }

    @Override
    public List<CjDataSourceTabInfo> findOdsScriptTableInfo() {
        return cjDataSourceTabInfoMapper.selectOdsExportTableInfo();
    }

    @Override
    public List<CjDataSourceTabInfo> findDwScriptTableInfo() {
        return cjDataSourceTabInfoMapper.selectDwExportTableInfo();
    }


}
