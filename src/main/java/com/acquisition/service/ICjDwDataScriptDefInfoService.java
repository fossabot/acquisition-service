package com.acquisition.service;

import com.acquisition.entity.CjDwDataScriptDefInfo;
import com.acquisition.entity.CjDwDataScriptDefInfoKey;
import org.springframework.stereotype.Service;

/**
 * Created by zhangdongmao on 2019/5/29.
 */

public interface ICjDwDataScriptDefInfoService {
    String save(CjDwDataScriptDefInfo cjDwDataScriptDefInfo);
    String deleteByPrimaryKey(CjDwDataScriptDefInfoKey key);
}
