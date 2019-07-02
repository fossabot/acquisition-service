package com.acquisition.mapper;


import com.acquisition.entity.CjDataSourceTabRows;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据源表行数统计信息表
 * 
 * @author yuxk
 * @date 2019-06-25 09:53:08
 */
public interface CjDataSourceTabRowsMapper {

    int insertBatch(List<CjDataSourceTabRows> list);

    int deleteBatch(List<CjDataSourceTabRows> list);

    Integer selectTabSizeBytable(@Param("businessSystemNameShortName") String businessSystemNameShortName, @Param("dataSourceSchema") String dataSourceSchema, @Param("dataSourceTable") String dataSourceTable);

}
