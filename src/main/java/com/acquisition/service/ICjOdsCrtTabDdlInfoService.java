package com.acquisition.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public interface ICjOdsCrtTabDdlInfoService {
    String GetODSTableName(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable);
}
