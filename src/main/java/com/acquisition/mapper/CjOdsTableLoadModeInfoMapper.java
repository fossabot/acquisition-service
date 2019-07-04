package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjOdsTableLoadModeInfo;
import com.acquisition.entity.CjOdsTableLoadModeInfoExample;
import com.acquisition.entity.CjOdsTableLoadModeInfoKey;
import org.apache.ibatis.annotations.Param;

public interface CjOdsTableLoadModeInfoMapper {
    int countByExample(CjOdsTableLoadModeInfoExample example);

    int deleteByExample(CjOdsTableLoadModeInfoExample example);

    int deleteByPrimaryKey(CjOdsTableLoadModeInfoKey key);

    int insert(CjOdsTableLoadModeInfo record);

    int insertSelective(CjOdsTableLoadModeInfo record);

    List<CjOdsTableLoadModeInfo> selectByExample(CjOdsTableLoadModeInfoExample example);

    CjOdsTableLoadModeInfo selectByPrimaryKey(CjOdsTableLoadModeInfoKey key);

    int updateByExampleSelective(@Param("record") CjOdsTableLoadModeInfo record, @Param("example") CjOdsTableLoadModeInfoExample example);

    int updateByExample(@Param("record") CjOdsTableLoadModeInfo record, @Param("example") CjOdsTableLoadModeInfoExample example);

    int updateByPrimaryKeySelective(CjOdsTableLoadModeInfo record);

    int updateByPrimaryKey(CjOdsTableLoadModeInfo record);

    int insertBatch(List<CjOdsTableLoadModeInfo> list);

    int deleteBatch(List<CjOdsTableLoadModeInfo> list);

    CjOdsTableLoadModeInfo selectByOdsDataTable(@Param("odsDataTable") String odsDataTable);
}