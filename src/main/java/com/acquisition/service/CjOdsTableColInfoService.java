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

    /**
     *
     * @param businessSystemNameShortName 系统缩写
     * @param dataSourceSchema schema
     * @param dataSourceTable 源表名称
     * @return 返回排序好的字段
     */
    List<String> findFieldByOrder(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable);

    /**
     *
     * @param businessSystemNameShortName 系统缩写
     * @param dataSourceSchema schema
     * @param dataSourceTable 源表名称
     * @return 返回OdsDataTable表名称
     */
    String findOdsDataTable(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable);

}
