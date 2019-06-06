package com.acquisition.mapper;

import com.acquisition.entity.CjDataSourceSystemInfo;
import com.acquisition.entity.CjDataSourceSystemInfoExample;
import com.acquisition.entity.CjDataSourceSystemInfoKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CjDataSourceSystemInfoMapper {
    int countByExample(CjDataSourceSystemInfoExample example);

    int deleteByExample(CjDataSourceSystemInfoExample example);

    int deleteByPrimaryKey(CjDataSourceSystemInfoKey key);

    int insert(CjDataSourceSystemInfo record);

    int insertSelective(CjDataSourceSystemInfo record);

    List<CjDataSourceSystemInfo> selectByExample(CjDataSourceSystemInfoExample example);

    CjDataSourceSystemInfo selectByPrimaryKey(CjDataSourceSystemInfoKey key);

    int updateByExampleSelective(@Param("record") CjDataSourceSystemInfo record, @Param("example") CjDataSourceSystemInfoExample example);

    int updateByExample(@Param("record") CjDataSourceSystemInfo record, @Param("example") CjDataSourceSystemInfoExample example);

    int updateByPrimaryKeySelective(CjDataSourceSystemInfo record);

    int updateByPrimaryKey(CjDataSourceSystemInfo record);

    int insertBatch(List<CjDataSourceSystemInfo> list);

    List<CjDataSourceSystemInfo> selectInfo();

    int deleteBySystemName(@Param("systemid") String systemid);
}