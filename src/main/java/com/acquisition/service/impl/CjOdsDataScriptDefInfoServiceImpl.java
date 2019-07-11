package com.acquisition.service.impl;

import com.acquisition.entity.CjOdsDataScriptDefInfo;
import com.acquisition.entity.CjOdsDataScriptDefInfoKey;
import com.acquisition.mapper.CjOdsDataScriptDefInfoMapper;
import com.acquisition.service.ICjOdsDataScriptDefInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjOdsDataScriptDefInfoServiceImpl implements ICjOdsDataScriptDefInfoService {

    @Resource(name = "cjOdsDataScriptDefInfoMapper")
    CjOdsDataScriptDefInfoMapper cjOdsDataScriptDefInfoMapper;

    @Override
    public int saveSqoopScripts(CjOdsDataScriptDefInfo cjOdsDataScriptDefInfo) {
        cjOdsDataScriptDefInfoMapper.deleteByPrimaryKey(cjOdsDataScriptDefInfo);
        return cjOdsDataScriptDefInfoMapper.insert(cjOdsDataScriptDefInfo);
    }

    @Override
    public String selectSchedulScript(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable, String odsDataTable, String odsDataScriptType) {
        return  cjOdsDataScriptDefInfoMapper.selectSchedulScript(
                businessSystemNameShortName,dataSourceSchema,
                dataSourceTable,odsDataTable,odsDataScriptType);
    }


    @Override
    public int insertBatch(List<CjOdsDataScriptDefInfo> list) {
        return cjOdsDataScriptDefInfoMapper.insertBatch(list);
    }

    @Override
    public int deleteByPrimaryKey(CjOdsDataScriptDefInfoKey key) {
        return cjOdsDataScriptDefInfoMapper.deleteByPrimaryKey(key);
    }

    @Override
    public CjOdsDataScriptDefInfo findByPrimaryKey(CjOdsDataScriptDefInfoKey key) {
        return cjOdsDataScriptDefInfoMapper.selectByPrimaryKey(key);
    }
}
