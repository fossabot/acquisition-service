package com.acquisition.service.impl;

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
        return cjDwTableColInfoMapper.insertBatch(list);
    }

    @Override
    public List<CjDwTableColInfo> selectByExample(CjDwTableColInfoExample example) {
        return cjDwTableColInfoMapper.selectByExample(example);
    }

    @Override
    public List<CjDwTableColInfo> selectColInfoByTopicAndTab(String dwTableBelongDomain, String dwDataTable) {
        return cjDwTableColInfoMapper.selectColInfoByTopicAndTab(dwTableBelongDomain,dwDataTable);
    }

    @Override
    public List<String> findPrimaryCol(String dwTableBelongDomain, String dwDataTable, String[] array) {
        return cjDwTableColInfoMapper.selectPrimaryCol(dwTableBelongDomain,dwDataTable,array);
    }

    @Override
    public List<String> findPartitionCol(String dwTableBelongDomain, String dwDataTable) {
        return cjDwTableColInfoMapper.selectPartitionCol(dwTableBelongDomain,dwDataTable);
    }
}
