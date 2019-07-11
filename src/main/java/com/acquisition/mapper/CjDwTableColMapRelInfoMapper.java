package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjDwTableColMapRelInfo;
import com.acquisition.entity.CjDwTableColMapRelInfoExample;
import com.acquisition.entity.CjDwTableColMapRelInfoKey;
import org.apache.ibatis.annotations.Param;

public interface CjDwTableColMapRelInfoMapper {
    int countByExample(CjDwTableColMapRelInfoExample example);

    int deleteByExample(CjDwTableColMapRelInfoExample example);

    int deleteByPrimaryKey(CjDwTableColMapRelInfoKey key);

    int insert(CjDwTableColMapRelInfo record);

    int insertSelective(CjDwTableColMapRelInfo record);

    List<CjDwTableColMapRelInfo> selectByExample(CjDwTableColMapRelInfoExample example);

    CjDwTableColMapRelInfo selectByPrimaryKey(CjDwTableColMapRelInfoKey key);

    int updateByExampleSelective(@Param("record") CjDwTableColMapRelInfo record, @Param("example") CjDwTableColMapRelInfoExample example);

    int updateByExample(@Param("record") CjDwTableColMapRelInfo record, @Param("example") CjDwTableColMapRelInfoExample example);

    int updateByPrimaryKeySelective(CjDwTableColMapRelInfo record);

    int updateByPrimaryKey(CjDwTableColMapRelInfo record);

    int insertBatch(List<CjDwTableColMapRelInfo> list);

    List<CjDwTableColMapRelInfo> selectByDwTab(String dwDataTable);
}