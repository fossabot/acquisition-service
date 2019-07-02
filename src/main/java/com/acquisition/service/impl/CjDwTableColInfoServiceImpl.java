package com.acquisition.service.impl;

import com.acquisition.entity.CjDwCrtTabDdlInfo;
import com.acquisition.entity.CjDwCrtTabDdlInfoExample;
import com.acquisition.entity.CjDwTableColInfo;
import com.acquisition.entity.CjDwTableColInfoExample;
import com.acquisition.mapper.CjDwTableColInfoMapper;
import com.acquisition.service.CjDwTableColInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/7/1.
 */
@Service
public class CjDwTableColInfoServiceImpl implements CjDwTableColInfoService{

    @Resource(name = "cjDwTableColInfoMapper")
    CjDwTableColInfoMapper cjDwTableColInfoMapper;

    @Override
    public int insertBatch(List<CjDwTableColInfo> list) {
        CjDwTableColInfoExample cjDwTableColInfoExample = new CjDwTableColInfoExample();
        CjDwTableColInfoExample.Criteria criteria = cjDwTableColInfoExample.createCriteria();
        criteria.andDwBusinessTopicDomainEqualTo(list.get(0).getDwBusinessTopicDomain());
        criteria.andDwDataSchemaEqualTo(list.get(0).getDwDataSchema());
        criteria.andDwDataTableEqualTo(list.get(0).getDwDataTable());
        cjDwTableColInfoMapper.deleteByExample(cjDwTableColInfoExample);
        return cjDwTableColInfoMapper.insertBatch(list);
    }

    @Override
    public List<CjDwTableColInfo> selectByExample(CjDwTableColInfoExample example) {
        return cjDwTableColInfoMapper.selectByExample(example);
    }

    @Override
    public List<CjDwTableColInfo> selectColInfoByTopicAndTab(String dwBusinessTopicDomain, String dwDataTable) {
        return cjDwTableColInfoMapper.selectColInfoByTopicAndTab(dwBusinessTopicDomain,dwDataTable);
    }
}
