package com.acquisition.service.impl;

import com.acquisition.entity.CjDwTableColMapRelInfo;
import com.acquisition.entity.CjDwTableColMapRelInfoExample;
import com.acquisition.mapper.CjDwTableColMapRelInfoMapper;
import com.acquisition.service.CjDwTableColMapRelInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/7/9.
 */
@Service
public class CjDwTableColMapRelInfoServiceImpl implements CjDwTableColMapRelInfoService {

    @Resource(name = "cjDwTableColMapRelInfoMapper")
    CjDwTableColMapRelInfoMapper cjDwTableColMapRelInfoMapper;

    @Override
    public int insertBatch(List<CjDwTableColMapRelInfo> list, CjDwTableColMapRelInfoExample example) {
        cjDwTableColMapRelInfoMapper.deleteByExample(example);
        return cjDwTableColMapRelInfoMapper.insertBatch(list);
    }

    @Override
    public List<CjDwTableColMapRelInfo> findByDwTab(String dwDataTable) {
        return cjDwTableColMapRelInfoMapper.selectByDwTab(dwDataTable);
    }
}
