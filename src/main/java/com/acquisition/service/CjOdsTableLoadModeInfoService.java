package com.acquisition.service;

import com.acquisition.entity.CjOdsTableLoadModeInfo;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/6/26.
 */
public interface CjOdsTableLoadModeInfoService {
    int insertBatch(List<CjOdsTableLoadModeInfo> cjOdsTableLoadModeInfos);

}
