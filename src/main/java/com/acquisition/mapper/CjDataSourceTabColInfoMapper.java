package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjDataSourceTabColInfo;
import com.acquisition.entity.CjDataSourceTabColInfoExample;
import com.acquisition.entity.CjDataSourceTabColInfoKey;
import org.apache.ibatis.annotations.Param;

public interface CjDataSourceTabColInfoMapper {
    int countByExample(CjDataSourceTabColInfoExample example);

    int deleteByExample(CjDataSourceTabColInfoExample example);

    int deleteByPrimaryKey(CjDataSourceTabColInfoKey key);

    int insert(CjDataSourceTabColInfo record);

    int insertSelective(CjDataSourceTabColInfo record);

    List<CjDataSourceTabColInfo> selectByExample(CjDataSourceTabColInfoExample example);

    CjDataSourceTabColInfo selectByPrimaryKey(CjDataSourceTabColInfoKey key);

    int updateByExampleSelective(@Param("record") CjDataSourceTabColInfo record, @Param("example") CjDataSourceTabColInfoExample example);

    int updateByExample(@Param("record") CjDataSourceTabColInfo record, @Param("example") CjDataSourceTabColInfoExample example);

    int updateByPrimaryKeySelective(CjDataSourceTabColInfo record);

    int updateByPrimaryKey(CjDataSourceTabColInfo record);
}