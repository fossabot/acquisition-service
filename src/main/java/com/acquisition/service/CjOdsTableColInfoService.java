package com.acquisition.service;

import com.acquisition.entity.CjOdsTableColInfo;
import com.acquisition.entity.CjOdsTableColInfoExample;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/6/27.
 */
public interface CjOdsTableColInfoService {

    int insertBatch(List<CjOdsTableColInfo> list);

    int deleteBatch(List<CjOdsTableColInfo> list);

    int deleteByExample(CjOdsTableColInfoExample example);
}
