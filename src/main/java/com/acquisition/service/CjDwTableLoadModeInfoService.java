package com.acquisition.service;

import com.acquisition.entity.CjDwTableLoadModeInfo;
import com.acquisition.entity.CjDwTableLoadModeInfoExample;

/**
 * Created by zhangdongmao on 2019/7/10.
 */
public interface CjDwTableLoadModeInfoService {
    int saveByOne(CjDwTableLoadModeInfo cjDwTableLoadModeInfo,CjDwTableLoadModeInfoExample cjDwTableLoadModeInfoExample);
    CjDwTableLoadModeInfo findByDwDataTable(String dwDataTable);




}
