package com.acquisition.mapper;

import com.acquisition.entity.CjDwTableMapRelInfo;
import com.acquisition.entity.CjDwTableMapRelInfoExample;
import com.acquisition.entity.CjDwTableMapRelInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CjDwTableMapRelInfoMapper {
    int countByExample(CjDwTableMapRelInfoExample example);

    int deleteByExample(CjDwTableMapRelInfoExample example);

    int deleteByPrimaryKey(CjDwTableMapRelInfoKey key);

    int insert(CjDwTableMapRelInfo record);

    int insertSelective(CjDwTableMapRelInfo record);

    List<CjDwTableMapRelInfo> selectByExample(CjDwTableMapRelInfoExample example);

    CjDwTableMapRelInfo selectByPrimaryKey(CjDwTableMapRelInfoKey key);

    int updateByExampleSelective(@Param("record") CjDwTableMapRelInfo record, @Param("example") CjDwTableMapRelInfoExample example);

    int updateByExample(@Param("record") CjDwTableMapRelInfo record, @Param("example") CjDwTableMapRelInfoExample example);

    int updateByPrimaryKeySelective(CjDwTableMapRelInfo record);

    int updateByPrimaryKey(CjDwTableMapRelInfo record);

    int insertBatch(List<CjDwTableMapRelInfo> list);

    List<CjDwTableMapRelInfo> selectBydwDataTableOrderByGroupUnit(String dwDataTable);

}