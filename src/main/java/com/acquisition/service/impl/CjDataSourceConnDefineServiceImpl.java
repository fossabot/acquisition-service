package com.acquisition.service.impl;

import com.acquisition.entity.CjDataSourceConnDefine;
import com.acquisition.entity.CjDataSourceConnDefineExample;
import com.acquisition.entity.ViewSourceSystemEntity;
import com.acquisition.mapper.CjDataSourceConnDefineMapper;
import com.acquisition.service.ICjDataSourceConnDefineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjDataSourceConnDefineServiceImpl implements ICjDataSourceConnDefineService {

    @Resource(name = "cjDataSourceConnDefineMapper")
    public CjDataSourceConnDefineMapper cjDataSourceConnDefineMapper;

    @Override
    public List<CjDataSourceConnDefine> selectByExample() {
        return cjDataSourceConnDefineMapper.selectByExample();
    }

    @Override
    public List<ViewSourceSystemEntity> selectViewContet() {
        return cjDataSourceConnDefineMapper.selectViewContet();
    }

    @Override
    public List<String> selectDistinctName() {
        return cjDataSourceConnDefineMapper.selectDistinctName();
    }

}

