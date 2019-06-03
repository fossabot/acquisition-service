package com.acquisition.service;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjOdsDataScriptDefInfo;
import org.springframework.stereotype.Service;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public interface ICjOdsDataScriptDefInfoService {
    int saveSqoopScripts(CjOdsDataScriptDefInfo cjOdsDataScriptDefInfo);
}
