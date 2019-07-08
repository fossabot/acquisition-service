package com.acquisition.service.impl;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjOdsDataScriptDefInfo;
import com.acquisition.mapper.CjDataSourceTabInfoMapper;
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
    public String selectScriptInfo(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable, String odsDataScriptType) {
        return  cjOdsDataScriptDefInfoMapper.selectScriptInfo(
                businessSystemNameShortName,dataSourceSchema,
                dataSourceTable,odsDataScriptType);
    }


    @Override
    public int insertBatch(List<CjOdsDataScriptDefInfo> list) {
        return cjOdsDataScriptDefInfoMapper.insertBatch(list);
    }
}
