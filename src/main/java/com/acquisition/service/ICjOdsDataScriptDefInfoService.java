package com.acquisition.service;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjOdsDataScriptDefInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */

public interface ICjOdsDataScriptDefInfoService {
    int saveSqoopScripts(CjOdsDataScriptDefInfo cjOdsDataScriptDefInfo);

    String selectScriptInfo(String businessSystemNameShortName ,String dataSourceSchema,String dataSourceTable, String odsDataScriptType);


    int insertBatch(List<CjOdsDataScriptDefInfo> list);


}
