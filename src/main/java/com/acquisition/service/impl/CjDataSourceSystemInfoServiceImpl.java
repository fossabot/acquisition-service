package com.acquisition.service.impl;

import com.acquisition.entity.CjDataSourceSystemInfo;
import com.acquisition.entity.CjDataSourceSystemInfoExample;
import com.acquisition.mapper.CjDataSourceSystemInfoMapper;
import com.acquisition.service.ICjDataSourceSystemInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yxk
 * @Description: 定义信息表
 * @create 2019/6/3
 * @since 1.0.0
 */
@Service
public class CjDataSourceSystemInfoServiceImpl implements ICjDataSourceSystemInfoService {

    @Resource(name = "cjDataSourceSystemInfoMapper")
    public CjDataSourceSystemInfoMapper cjDataSourceSystemInfoMapper;

    @Override
    public int insertBatch(List<CjDataSourceSystemInfo> list) {
        return cjDataSourceSystemInfoMapper.insertBatch(list);
    }

    @Override
    public List<CjDataSourceSystemInfo> selectInfo() {
        return cjDataSourceSystemInfoMapper.selectInfo();
    }

    @Override
    public int deleteBySystemName(String systemid) {
        return cjDataSourceSystemInfoMapper.deleteBySystemName(systemid);
    }

    @Override
    public List<String> findDistBusinessSystemNameShortName() {
        return cjDataSourceSystemInfoMapper.selectDistBusinessSystemNameShortName();
    }

    @Override
    public List<CjDataSourceSystemInfo> findByExample(CjDataSourceSystemInfoExample example) {
        return cjDataSourceSystemInfoMapper.selectByExample(example);
    }

    @Override
    public String selectDistDataBaseType(String sysname) {
        return cjDataSourceSystemInfoMapper.selectDistDataBaseType(sysname);
    }
}
