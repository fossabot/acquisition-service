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

        cjDataSourceTabRowsMapper.deleteBatch(list);

        return cjDataSourceTabRowsMapper.insertBatch(list);
    }
}