package com.acquisition.mapper;

import com.acquisition.entity.CjDwOdsMapInitInfo;
import com.acquisition.entity.CjDwOdsMapInitInfoExample;
import com.acquisition.entity.CjDwOdsMapInitInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CjDwOdsMapInitInfoMapper {
    int countByExample(CjDwOdsMapInitInfoExample example);

    int deleteByExample(CjDwOdsMapInitInfoExample example);

    int deleteByPrimaryKey(CjDwOdsMapInitInfoKey key);

    int insert(CjDwOdsMapInitInfo record);

    int insertSelective(CjDwOdsMapInitInfo record);

    List<CjDwOdsMapInitInfo> selectByExample(CjDwOdsMapInitInfoExample example);

    CjDwOdsMapInitInfo selectByPrimaryKey(CjDwOdsMapInitInfoKey key);

    int updateByExampleSelective(@Param("record") CjDwOdsMapInitInfo record, @Param("example") CjDwOdsMapInitInfoExample example);

    int updateByExample(@Param("record") CjDwOdsMapInitInfo record, @Param("example") CjDwOdsMapInitInfoExample example);

    int updateByPrimaryKeySelective(CjDwOdsMapInitInfo record);

    int updateByPrimaryKey(CjDwOdsMapInitInfo record);
}