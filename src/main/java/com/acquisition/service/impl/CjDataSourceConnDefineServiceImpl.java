package com.acquisition.service.impl;

import com.acquisition.entity.CjDataSourceConnDefine;
import com.acquisition.entity.CjDataSourceConnDefineExample;
import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.ViewSourceSystemEntity;
import com.acquisition.mapper.CjDataSourceConnDefineMapper;
import com.acquisition.mapper.CjDataSourceTabInfoMapper;
import com.acquisition.mapper.CjOdsCrtTabDdlInfoMapper;
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
    @Resource(name = "cjDataSourceTabInfoMapper")
    public CjDataSourceTabInfoMapper cjDataSourceTabInfoMapper;

    @Override
    public List<CjDataSourceConnDefine> selectByExample() {
        return cjDataSourceConnDefineMapper.selectByExample();
    }

   /* @Override
    public CjDataSourceConnDefine selectBySystemAndSchema(String businessSystemNameShortName, String dataSourceSchema) {
        return null;
    }*/

    @Override
    public List<ViewSourceSystemEntity> selectViewContet() {
        return cjDataSourceConnDefineMapper.selectViewContet();
    }

    @Override
    public List<String> selectDistinctName() {
        return cjDataSourceConnDefineMapper.selectDistinctName();
    }

    @Override
    public List<CjDataSourceConnDefine> findListBySystemID(String[] ides) {
        return cjDataSourceConnDefineMapper.findListBySystemID(ides);
    }

    @Override
    public String selectBySystemID(String syid) {
        return cjDataSourceConnDefineMapper.selectBySystemID(syid);
    }

    @Override
    public String selectSystemName(String businessSystemNameShortName) {
        return cjDataSourceConnDefineMapper.selectSystemName(businessSystemNameShortName);
    }

    @Override
    public CjDataSourceConnDefine selectDataBaseType(String sysname, String schema) {
        return cjDataSourceConnDefineMapper.selectDataBaseType(sysname, schema);
    }

}

