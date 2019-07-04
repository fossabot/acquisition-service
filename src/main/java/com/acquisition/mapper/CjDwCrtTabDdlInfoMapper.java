package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.*;
import org.apache.ibatis.annotations.Param;

public interface CjDwCrtTabDdlInfoMapper {
    int countByExample(CjDwCrtTabDdlInfoExample example);

    int deleteByExample(CjDwCrtTabDdlInfoExample example);

    int deleteByPrimaryKey(CjDwCrtTabDdlInfoKey key);

    int insert(CjDwCrtTabDdlInfo record);

    int insertSelective(CjDwCrtTabDdlInfo record);

    List<CjDwCrtTabDdlInfo> selectByExample(CjDwCrtTabDdlInfoExample example);

    CjDwCrtTabDdlInfo selectByPrimaryKey(CjDwCrtTabDdlInfoKey key);

    int updateByExampleSelective(@Param("record") CjDwCrtTabDdlInfo record, @Param("example") CjDwCrtTabDdlInfoExample example);

    int updateByExample(@Param("record") CjDwCrtTabDdlInfo record, @Param("example") CjDwCrtTabDdlInfoExample example);

    int updateByPrimaryKeySelective(CjDwCrtTabDdlInfo record);

    int updateByPrimaryKey(CjDwCrtTabDdlInfo record);

    int insertBatch(List<CjDwCrtTabDdlInfo> list);

    int deleteBatch(List<CjDwCrtTabDdlInfo> list);

    String selectOdsDataTableByDwDataTable(@Param("dwDataTable") String dwDataTable);

    CjDwCrtTabDdlInfo selectByDwDataTable(@Param("dwDataTable") String dwDataTable);

    int insertByOne(CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo);

}