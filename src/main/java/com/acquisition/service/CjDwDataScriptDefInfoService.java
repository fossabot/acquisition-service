package com.acquisition.service;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDwDataScriptDefInfo;
import com.acquisition.entity.CjDwDataScriptDefInfoKey;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */

public interface CjDwDataScriptDefInfoService {
    String save(CjDwDataScriptDefInfo cjDwDataScriptDefInfo);
    String deleteByPrimaryKey(CjDwDataScriptDefInfoKey key);
    String selectDdlInfo(String businessSystemNameShortName,
                         String dataSourceSchema,
                         String dataSourceTable
    );
}
