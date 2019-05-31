package com.acquisition.repository;

import com.acquisition.entity.CjDataSourceTabColInfo;
import com.acquisition.entity.CjDataSourceTabInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Mapper
public interface CjDataSourceTabColInfoRepository {
    @Select("select * from datalake_meta.cj_data_source_tab_col_info where business_system_name_short_name=#{businessSystemNameShortName} and data_source_schema=#{dataSourceSchema} and data_source_table=#{dataSourceTable} order by data_source_col_order asc")
    List<CjDataSourceTabColInfo> selectAllBySysAndSchemaAndTab(@Param("businessSystemNameShortName") String businessSystemNameShortName, @Param("dataSourceSchema") String dataSourceSchema, @Param("dataSourceTable") String dataSourceTable);

}
