package com.acquisition.service;

import com.acquisition.entity.CjDwCrtTabDdlInfo;
import com.acquisition.entity.CjDwCrtTabDdlInfoExample;
import com.acquisition.entity.CjDwTableColInfo;
import com.acquisition.entity.CjDwTableColInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/7/1.
 */
public interface CjDwTableColInfoService {

    int insertBatch(List<CjDwTableColInfo> list);

    List<CjDwTableColInfo> selectByExample(CjDwTableColInfoExample example);

    List<CjDwTableColInfo> selectColInfoByTopicAndTab(String dwTableBelongDomain, String dwDataTable);

    List<String> findPrimaryCol(String dwTableBelongDomain, String dwDataTable, String[] array);
}
