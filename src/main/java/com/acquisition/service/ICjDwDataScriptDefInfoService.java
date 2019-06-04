package com.acquisition.service;

import com.acquisition.entity.CjDwDataScriptDefInfo;
import org.springframework.stereotype.Service;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public interface ICjDwDataScriptDefInfoService {
    String save(CjDwDataScriptDefInfo cjDwDataScriptDefInfo);
}
