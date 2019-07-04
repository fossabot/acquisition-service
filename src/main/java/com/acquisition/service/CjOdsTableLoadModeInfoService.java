package com.acquisition.service;

import com.acquisition.entity.CjOdsTableLoadModeInfo;
import com.acquisition.entity.CjOdsTableLoadModeInfoExample;
import com.acquisition.entity.CjOdsTableLoadModeInfoKey;
import com.acquisition.entity.excel.EtuInfo;

import java.util.List;


/**
 * Created by zhangdongmao on 2019/6/26.
 */
public interface CjOdsTableLoadModeInfoService {
    int insertBatch(List<CjOdsTableLoadModeInfo> cjOdsTableLoadModeInfos);

    List<CjOdsTableLoadModeInfo> findByExample(CjOdsTableLoadModeInfoExample example);

    CjOdsTableLoadModeInfo findByPrimaryKey(CjOdsTableLoadModeInfoKey key);

    CjOdsTableLoadModeInfo findAll(EtuInfo etuEnt);

    CjOdsTableLoadModeInfo findByOdsDataTable(String odsDataTable);
}
