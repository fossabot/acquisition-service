package com.acquisition.service;


import com.acquisition.entity.CjDataSourceTabRows;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据源表行数统计信息表
 *
 * @author yuxk
 * @date 2019-06-25 09:53:08
 */
public interface CjDataSourceTabRowsService {

    int insertBatch(List<CjDataSourceTabRows> list);

    Integer findTabSizeBytable(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable);
}

