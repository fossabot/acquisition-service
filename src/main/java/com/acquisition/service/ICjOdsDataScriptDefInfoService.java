package com.acquisition.service;

import com.acquisition.entity.CjOdsDataScriptDefInfo;
import com.acquisition.entity.CjOdsDataScriptDefInfoKey;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */

public interface ICjOdsDataScriptDefInfoService {
    int saveSqoopScripts(CjOdsDataScriptDefInfo cjOdsDataScriptDefInfo);

    String selectSchedulScript(String businessSystemNameShortName ,String dataSourceSchema,String dataSourceTable,String odsDataTable, String odsDataScriptType);


    int insertBatch(List<CjOdsDataScriptDefInfo> list);

    int deleteByPrimaryKey(CjOdsDataScriptDefInfoKey key);

    CjOdsDataScriptDefInfo findByPrimaryKey(CjOdsDataScriptDefInfoKey key);
}
