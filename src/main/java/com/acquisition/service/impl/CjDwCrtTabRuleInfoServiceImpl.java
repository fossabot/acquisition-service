package com.acquisition.service.impl;

import com.acquisition.mapper.CjDwCrtTabRuleInfoMapper;
import com.acquisition.service.CjDwCrtTabRuleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjDwCrtTabRuleInfoServiceImpl implements CjDwCrtTabRuleInfoService {

    @Resource(name="cjDwCrtTabRuleInfoMapper")
    CjDwCrtTabRuleInfoMapper cjDwCrtTabRuleInfoMapper;
    @Override
    public String findPolicyByTopic(String topic) {
        return cjDwCrtTabRuleInfoMapper.selectPolicyByTopic(topic);
    }
}
