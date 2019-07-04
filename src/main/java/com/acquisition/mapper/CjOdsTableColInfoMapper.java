package com.acquisition.mapper;

import com.acquisition.entity.CjOdsTableColInfo;
import com.acquisition.entity.CjOdsTableColInfoExample;
import com.acquisition.entity.CjOdsTableColInfoKey;
import java.util.List;

import com.acquisition.entity.CjOdsTableLoadModeInfo;
import com.acquisition.entity.excel.EtuInfo;
import org.apache.ibatis.annotations.Param;

public interface CjOdsTableColInfoMapper {
    int countByExample(CjOdsTableColInfoExample example);

    int deleteByExample(CjOdsTableColInfoExample example);

    int deleteByPrimaryKey(CjOdsTableColInfoKey key);

    int insert(CjOdsTableColInfo record);

    int insertSelective(CjOdsTableColInfo record);

    List<CjOdsTableColInfo> selectByExample(CjOdsTableColInfoExample example);

    CjOdsTableColInfo selectByPrimaryKey(CjOdsTableColInfoKey key);

    int updateByExampleSelective(@Param("record") CjOdsTableColInfo record, @Param("example") CjOdsTableColInfoExample example);

    int updateByExample(@Param("record") CjOdsTableColInfo record, @Param("example") CjOdsTableColInfoExample example);

    int updateByPrimaryKeySelective(CjOdsTableColInfo record);

    int updateByPrimaryKey(CjOdsTableColInfo record);

    int insertBatch(List<CjOdsTableColInfo> list);

    int deleteBatch(List<CjOdsTableColInfo> list);

    List<String> selectFieldByOrder(@Param("businessSystemNameShortName") String businessSystemNameShortName, @Param("dataSourceSchema") String dataSourceSchema, @Param("dataSourceTable") String dataSourceTable);
}