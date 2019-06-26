package com.acquisition.service.impl;

import com.acquisition.entity.CjOdsTableLoadModeInfo;
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
}
