package com.acquisition.service.impl;

import com.acquisition.entity.CjOdsDataScriptDefInfo;
import com.acquisition.mapper.CjOdsDataScriptDefInfoMapper;
import com.acquisition.service.ICjOdsDataScriptDefInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjOdsDataScriptDefInfoServiceImpl implements ICjOdsDataScriptDefInfoService {

    @Resource(name = "cjOdsDataScriptDefInfoMapper")
    CjOdsDataScriptDefInfoMapper cjOdsDataScriptDefInfoMapper;

    @Override
    public int saveSqoopScripts(CjOdsDataScriptDefInfo cjOdsDataScriptDefInfo) {
        return cjOdsDataScriptDefInfoMapper.insert(cjOdsDataScriptDefInfo);
    }
}
