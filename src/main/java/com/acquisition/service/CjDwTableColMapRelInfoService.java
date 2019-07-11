package com.acquisition.service;

import com.acquisition.entity.CjDwTableColMapRelInfo;
import com.acquisition.entity.CjDwTableColMapRelInfoExample;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/7/9.
 */
public interface CjDwTableColMapRelInfoService {
    int insertBatch(List<CjDwTableColMapRelInfo> list, CjDwTableColMapRelInfoExample example);
    List<CjDwTableColMapRelInfo> findByDwTab(String dwDataTable);

}
