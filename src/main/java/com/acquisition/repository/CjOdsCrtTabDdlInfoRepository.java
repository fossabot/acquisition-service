package com.acquisition.repository;


import com.acquisition.entity.CjOdsCrtTabDdlInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zhangdongmao on 2019/5/30.
 */
@Mapper
public interface CjOdsCrtTabDdlInfoRepository {
    @Select("select distinct ods_data_table from datalake_meta.cj_ods_crt_tab_ddl_info where business_system_name_short_name=#{businessSystemNameShortName} and data_source_schema=#{dataSourceSchema} and data_source_table=#{dataSourceTable}")
    String selectODSTableNameBySystemAndSchemaAndTable(@Param("businessSystemNameShortName") String businessSystemNameShortName, @Param("dataSourceSchema") String dataSourceSchema, @Param("dataSourceTable") String dataSourceTable);

    @Insert("insert into datalake_meta.cj_ods_crt_tab_ddl_info " +
            "(business_system_ID,business_system_name_short_name,data_source_schema,data_source_table," +
            "ods_data_schema,ods_data_table,ods_data_table_ddl_info,last_modify_dt,last_modify_by) "  +
            "values(#{businessSystemId},#{businessSystemNameShortName},#{dataSourceSchema}," +
            "#{dataSourceTable},#{odsDataSchema},#{odsDataTable},#{odsDataTableDdlInfo}," +
            "#{lastModifyDt},#{lastModifyBy}) ")
    void insertByObject(CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo);


}
