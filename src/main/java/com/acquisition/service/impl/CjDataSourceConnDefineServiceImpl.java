package com.acquisition.service.impl;

import com.acquisition.entity.CjDataSourceConnDefine;
import com.acquisition.entity.CjDataSourceConnDefineExample;
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
        List<CjDataSourceConnDefine> ff =cjDataSourceConnDefineMapper.selectByExample();
         return ff;
    }

    @Override
    public CjDataSourceConnDefine selectBySystemAndSchema(String businessSystemNameShortName, String dataSourceSchema) {
        return cjDataSourceConnDefineMapper.selectBySystemAndSchema(businessSystemNameShortName,dataSourceSchema);
    }


}

