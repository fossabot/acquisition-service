package com.acquisition.repository;

import com.acquisition.entity.CjDwCrtTabDdlInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by zhangdongmao on 2019/5/30.
 */
@Mapper
public interface CjDwCrtTabDdlInfoRepository {
    @Insert("insert into datalake_meta.cj_dw_crt_tab_ddl_info (business_system_ID,business_system_name_short_name,data_source_schema,data_source_table,ods_data_table,dw_data_table,dw_data_table_ddl_info,last_modify_dt,last_modify_by) values (#{businessSystemId},#{businessSystemNameShortName},data_source_schema=#{dataSourceSchema},#{dataSourceTable},#{odsDataTable},#{dwDataTable},#{dwDataTableDdlInfo},#{lastModifyDt},#{lastModifyBy})")
    void insertByObject(CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo);
}
