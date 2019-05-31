package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjOdsCrtTabDdlInfo;
import com.acquisition.entity.CjOdsCrtTabDdlInfoExample;
import com.acquisition.entity.CjOdsCrtTabDdlInfoKey;
import org.apache.ibatis.annotations.Param;

public interface CjOdsCrtTabDdlInfoMapper {
    int countByExample(CjOdsCrtTabDdlInfoExample example);

    int deleteByExample(CjOdsCrtTabDdlInfoExample example);

    int deleteByPrimaryKey(CjOdsCrtTabDdlInfoKey key);

    int insert(CjOdsCrtTabDdlInfo record);

    int insertSelective(CjOdsCrtTabDdlInfo record);

    List<CjOdsCrtTabDdlInfo> selectByExample(CjOdsCrtTabDdlInfoExample example);

    CjOdsCrtTabDdlInfo selectByPrimaryKey(CjOdsCrtTabDdlInfoKey key);

    int updateByExampleSelective(@Param("record") CjOdsCrtTabDdlInfo record, @Param("example") CjOdsCrtTabDdlInfoExample example);

    int updateByExample(@Param("record") CjOdsCrtTabDdlInfo record, @Param("example") CjOdsCrtTabDdlInfoExample example);

    int updateByPrimaryKeySelective(CjOdsCrtTabDdlInfo record);

    int updateByPrimaryKey(CjOdsCrtTabDdlInfo record);
}