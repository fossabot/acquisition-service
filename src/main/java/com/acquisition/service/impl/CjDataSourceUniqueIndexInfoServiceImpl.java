package com.acquisition.service.impl;

import com.acquisition.entity.CjDataSourceUniqueIndexInfo;
import com.acquisition.mapper.CjDataSourceUniqueIndexInfoMapper;
import com.acquisition.service.CjDataSourceUniqueIndexInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CjDataSourceUniqueIndexInfoServiceImpl implements CjDataSourceUniqueIndexInfoService {


    @Resource(name = "cjDataSourceUniqueIndexInfoMapper")
    public CjDataSourceUniqueIndexInfoMapper cjDataSourceUniqueIndexInfoMapper;

    @Override
    public int insertBatch(List<CjDataSourceUniqueIndexInfo> list) {

        cjDataSourceUniqueIndexInfoMapper.deleteBatch(list);
        
        return cjDataSourceUniqueIndexInfoMapper.insertBatch(list);
    }

    @Override
    public List<CjDataSourceUniqueIndexInfo> findUniqueIndexByTable(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable) {
        return cjDataSourceUniqueIndexInfoMapper.selectUniqueIndexByTable(businessSystemNameShortName,dataSourceSchema,dataSourceTable);
    }
}