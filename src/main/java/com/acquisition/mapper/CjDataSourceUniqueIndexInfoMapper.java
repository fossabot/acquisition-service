package com.acquisition.mapper;


import com.acquisition.entity.CjDataSourceUniqueIndexInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CjDataSourceUniqueIndexInfoMapper {


    int insertBatch(List<CjDataSourceUniqueIndexInfo> list);

    int deleteBatch(List<CjDataSourceUniqueIndexInfo> list);

    List<CjDataSourceUniqueIndexInfo> selectUniqueIndexByTable(@Param("businessSystemNameShortName") String businessSystemNameShortName, @Param("dataSourceSchema") String dataSourceSchema, @Param("dataSourceTable") String dataSourceTable);

}
