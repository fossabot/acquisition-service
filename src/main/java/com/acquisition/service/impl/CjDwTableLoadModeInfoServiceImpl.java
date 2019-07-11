package com.acquisition.service.impl;

import com.acquisition.entity.CjDwTableLoadModeInfo;
import com.acquisition.entity.CjDwTableLoadModeInfoExample;
import com.acquisition.mapper.CjDwTableColMapRelInfoMapper;
import com.acquisition.mapper.CjDwTableLoadModeInfoMapper;
import com.acquisition.service.CjDwTableLoadModeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangdongmao on 2019/7/10.
 */
@Service
public class CjDwTableLoadModeInfoServiceImpl implements CjDwTableLoadModeInfoService {

    @Resource(name = "cjDwTableLoadModeInfoMapper")
    CjDwTableLoadModeInfoMapper cjDwTableLoadModeInfoMapper;
    @Override
    public int saveByOne(CjDwTableLoadModeInfo cjDwTableLoadModeInfo, CjDwTableLoadModeInfoExample cjDwTableLoadModeInfoExample) {
        cjDwTableLoadModeInfoMapper.deleteByExample(cjDwTableLoadModeInfoExample);
        return cjDwTableLoadModeInfoMapper.insertByOne(cjDwTableLoadModeInfo);
    }

    @Override
    public CjDwTableLoadModeInfo findByDwDataTable(String dwDataTable) {
        return cjDwTableLoadModeInfoMapper.selectByDwDataTable(dwDataTable);
    }
}
