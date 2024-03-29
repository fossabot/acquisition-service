package com.acquisition.service.impl;


import com.acquisition.entity.CjDataSourceTabRows;
import com.acquisition.mapper.CjDataSourceTabRowsMapper;
import com.acquisition.service.CjDataSourceTabRowsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CjDataSourceTabRowsServiceImpl implements CjDataSourceTabRowsService {


    @Resource(name = "cjDataSourceTabRowsMapper")
    public CjDataSourceTabRowsMapper cjDataSourceTabRowsMapper;


    @Override
    public int insertBatch(List<CjDataSourceTabRows> list) {
        return cjDataSourceTabRowsMapper.insertBatch(list);
    }

    @Override
    public Integer findTabSizeBytable(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable) {
        return cjDataSourceTabRowsMapper.selectTabSizeBytable(businessSystemNameShortName,dataSourceSchema,dataSourceTable);
    }
}