package com.acquisition.service.impl;

import com.acquisition.entity.CjOdsTableLoadModeInfo;
import com.acquisition.entity.CjOdsTableLoadModeInfoExample;
import com.acquisition.entity.CjOdsTableLoadModeInfoKey;
import com.acquisition.mapper.CjOdsTableLoadModeInfoMapper;
import com.acquisition.service.CjOdsTableLoadModeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/6/26.
 */
@Service
public class CjOdsTableLoadModeInfoServiceImpl implements CjOdsTableLoadModeInfoService {

    @Resource(name = "cjOdsTableLoadModeInfoMapper")
    CjOdsTableLoadModeInfoMapper cjOdsTableLoadModeInfoMapper;

    @Override
    public int insertBatch(List<CjOdsTableLoadModeInfo> cjOdsTableLoadModeInfos) {
        cjOdsTableLoadModeInfoMapper.deleteBatch(cjOdsTableLoadModeInfos);
        return cjOdsTableLoadModeInfoMapper.insertBatch(cjOdsTableLoadModeInfos);
    }

    @Override
    public List<CjOdsTableLoadModeInfo> findByExample(CjOdsTableLoadModeInfoExample example) {
        return cjOdsTableLoadModeInfoMapper.selectByExample(example);
    }

    @Override
    public CjOdsTableLoadModeInfo findByPrimaryKey(CjOdsTableLoadModeInfoKey key) {
        return cjOdsTableLoadModeInfoMapper.selectByPrimaryKey(key);
    }

    @Override
    public CjOdsTableLoadModeInfo findByOdsDataTable(String odsDataTable) {
        return cjOdsTableLoadModeInfoMapper.selectByOdsDataTable(odsDataTable);
    }
}
