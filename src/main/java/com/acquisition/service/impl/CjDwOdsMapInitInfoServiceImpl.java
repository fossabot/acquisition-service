package com.acquisition.service.impl;

import com.acquisition.entity.CjDwOdsMapInitInfo;
import com.acquisition.mapper.CjDataSourceTabInfoMapper;
import com.acquisition.mapper.CjDwOdsMapInitInfoMapper;
import com.acquisition.service.CjDwOdsMapInitInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangdongmao on 2019/7/5.
 */
@Service
public class CjDwOdsMapInitInfoServiceImpl implements CjDwOdsMapInitInfoService {

    @Resource(name = "cjDwOdsMapInitInfoMapper")
    public CjDwOdsMapInitInfoMapper cjDwOdsMapInitInfoMapper;

    @Override
    public int saveByOne(CjDwOdsMapInitInfo cjDwOdsMapInitInfo) {
        return cjDwOdsMapInitInfoMapper.insert(cjDwOdsMapInitInfo);
    }
}
