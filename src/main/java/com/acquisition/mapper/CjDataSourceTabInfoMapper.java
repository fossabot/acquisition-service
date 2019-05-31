package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjDataSourceTabInfo;
import org.apache.ibatis.annotations.Param;

public interface CjDataSourceTabInfoMapper {

    List<CjDataSourceTabInfo> selectAll(String dataFlagForGetCols, String dataFlagForCrtOdsDll);
    List<CjDataSourceTabInfo> selectBySystemAndSchema();
    int updateDataFlagForCrtOdsDll(@Param("dataFlagForCrtOdsDll") String dataFlagForGetCols,
                                 @Param("dataFlagForCrtOdsHive") String dataFlagForCrtOdsHive
    );
}