package com.acquisition.mapper;

import java.util.List;


import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDataSourceTabInfoExample;
import com.acquisition.entity.CjDataSourceTabInfoKey;
import org.apache.ibatis.annotations.Param;

public interface CjDataSourceTabInfoMapper {
    List<CjDataSourceTabInfo> selectAll();
    List<CjDataSourceTabInfo> selectAllByOdsHiveAndDwHive(@Param("dataFlagForCrtOdsHive") String dataFlagForCrtOdsHive,@Param("dataFlagForCrtDwHive") String dataFlagForCrtDwHive);
    int updateCrtDwFlagByObject(CjDataSourceTabInfo cjDataSourceTabInfo);
    int countByExample(CjDataSourceTabInfoExample example);

    int deleteByExample(CjDataSourceTabInfoExample example);

    int deleteByPrimaryKey(CjDataSourceTabInfoKey key);

    int insert(CjDataSourceTabInfo record);

    int insertSelective(CjDataSourceTabInfo record);

    List<CjDataSourceTabInfo> selectByExample(CjDataSourceTabInfoExample example);

    CjDataSourceTabInfo selectByPrimaryKey(CjDataSourceTabInfoKey key);

    int updateByExampleSelective(@Param("record") CjDataSourceTabInfo record, @Param("example") CjDataSourceTabInfoExample example);

    int updateByExample(@Param("record") CjDataSourceTabInfo record, @Param("example") CjDataSourceTabInfoExample example);

    int updateByPrimaryKeySelective(CjDataSourceTabInfo record);

    int updateByPrimaryKey(CjDataSourceTabInfo record);

    List<CjDataSourceTabInfo> selectAll(String dataFlagForGetCols, String dataFlagForCrtOdsDll);
    List<CjDataSourceTabInfo> selectBySystemAndSchema();
    int updateDataFlagForCrtOdsDll(@Param("dataFlagForCrtOdsDll") String dataFlagForGetCols,
                                   @Param("dataFlagForCrtOdsHive") String dataFlagForCrtOdsHive
    );

}