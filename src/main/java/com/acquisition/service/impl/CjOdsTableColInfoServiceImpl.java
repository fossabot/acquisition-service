package com.acquisition.service.impl;

import com.acquisition.entity.CjOdsTableColInfo;
import com.acquisition.entity.CjOdsTableColInfoExample;
import com.acquisition.entity.excel.EtuInfo;
import com.acquisition.mapper.CjOdsTableColInfoMapper;
import com.acquisition.service.CjOdsTableColInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/6/27.
 */
@Service
public class CjOdsTableColInfoServiceImpl implements CjOdsTableColInfoService {

    @Resource(name="cjOdsTableColInfoMapper")
    CjOdsTableColInfoMapper cjOdsTableColInfoMapper;


    @Override
    public int insertBatch(List<CjOdsTableColInfo> list) {
        CjOdsTableColInfoExample cjOdsTableColInfoExample = new CjOdsTableColInfoExample();
        CjOdsTableColInfoExample.Criteria criteria = cjOdsTableColInfoExample.createCriteria();
        criteria.andBusinessSystemNameShortNameEqualTo(list.get(0).getBusinessSystemNameShortName());
        criteria.andDataSourceSchemaEqualTo(list.get(0).getDataSourceSchema());
        criteria.andDataSourceTableEqualTo(list.get(0).getDataSourceTable());
        cjOdsTableColInfoMapper.deleteByExample(cjOdsTableColInfoExample);
        return cjOdsTableColInfoMapper.insertBatch(list);
    }

    @Override
    public int deleteBatch(List<CjOdsTableColInfo> list) {
        return cjOdsTableColInfoMapper.deleteBatch(list);
    }

    @Override
    public int deleteByExample(CjOdsTableColInfoExample example) {
        return cjOdsTableColInfoMapper.deleteByExample(example);
    }

    @Override
    public List<String> findFieldByOrder(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable) {
        return cjOdsTableColInfoMapper.selectFieldByOrder(businessSystemNameShortName,dataSourceSchema,dataSourceTable);
    }


}
