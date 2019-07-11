package com.acquisition.service.impl;

import com.acquisition.entity.CjDwTableMapRelInfo;
import com.acquisition.entity.CjDwTableMapRelInfoExample;
import com.acquisition.mapper.CjDwTableColInfoMapper;
import com.acquisition.mapper.CjDwTableMapRelInfoMapper;
import com.acquisition.service.CjDwTableMapRelInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/7/9.
 */
@Service
public class CjDwTableMapRelInfoServiceImpl implements CjDwTableMapRelInfoService {

    @Resource(name = "cjDwTableMapRelInfoMapper")
    CjDwTableMapRelInfoMapper cjDwTableMapRelInfoMapper;

    @Override
    public int insertBatch(List<CjDwTableMapRelInfo> list,CjDwTableMapRelInfoExample example) {
        cjDwTableMapRelInfoMapper.deleteByExample(example);
        return cjDwTableMapRelInfoMapper.insertBatch(list);
    }

    @Override
    public List<CjDwTableMapRelInfo> findByExample(CjDwTableMapRelInfoExample example) {
        return cjDwTableMapRelInfoMapper.selectByExample(example);
    }

    @Override
    public List<CjDwTableMapRelInfo> findBydwDataTableOrderByGroupUnit(String dwDataTable) {
        return cjDwTableMapRelInfoMapper.selectBydwDataTableOrderByGroupUnit(dwDataTable);
    }
}
