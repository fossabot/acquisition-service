package com.acquisition.service;

import com.acquisition.entity.CjDwTableMapRelInfo;
import com.acquisition.entity.CjDwTableMapRelInfoExample;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/7/9.
 */
public interface CjDwTableMapRelInfoService {
    int insertBatch(List<CjDwTableMapRelInfo> list, CjDwTableMapRelInfoExample example);
    List<CjDwTableMapRelInfo> findByExample(CjDwTableMapRelInfoExample example);
    List<CjDwTableMapRelInfo> findBydwDataTableOrderByGroupUnit(String dwDataTable);

}
