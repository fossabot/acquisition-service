package com.acquisition.service;

import com.acquisition.entity.CjOdsTableColInfo;
import com.acquisition.entity.CjOdsTableColInfoExample;
import com.acquisition.entity.excel.EtuInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/6/27.
 */
public interface CjOdsTableColInfoService {

    int insertBatch(List<CjOdsTableColInfo> list);

    int deleteBatch(List<CjOdsTableColInfo> list);

    int deleteByExample(CjOdsTableColInfoExample example);

    /**
     * 按cj_ods_table_col_info表中ods_table_col_order字段序号排序
     * @param etuInfo 封装系统源，系统简称和schema的实体类
     * @return 排序好的字段
     */
    List<String> findFieldByOrder(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable);

}
