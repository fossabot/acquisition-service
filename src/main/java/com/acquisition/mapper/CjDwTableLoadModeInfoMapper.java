package com.acquisition.mapper;

import com.acquisition.entity.CjDwTableLoadModeInfo;
import com.acquisition.entity.CjDwTableLoadModeInfoExample;
import com.acquisition.entity.CjDwTableLoadModeInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CjDwTableLoadModeInfoMapper {
    int countByExample(CjDwTableLoadModeInfoExample example);

    int deleteByExample(CjDwTableLoadModeInfoExample example);

    int deleteByPrimaryKey(CjDwTableLoadModeInfoKey key);

    int insert(CjDwTableLoadModeInfo record);

    int insertSelective(CjDwTableLoadModeInfo record);

    List<CjDwTableLoadModeInfo> selectByExample(CjDwTableLoadModeInfoExample example);

    CjDwTableLoadModeInfo selectByPrimaryKey(CjDwTableLoadModeInfoKey key);

    int updateByExampleSelective(@Param("record") CjDwTableLoadModeInfo record, @Param("example") CjDwTableLoadModeInfoExample example);

    int updateByExample(@Param("record") CjDwTableLoadModeInfo record, @Param("example") CjDwTableLoadModeInfoExample example);

    int updateByPrimaryKeySelective(CjDwTableLoadModeInfo record);

    int updateByPrimaryKey(CjDwTableLoadModeInfo record);

    int insertByOne(CjDwTableLoadModeInfo record);

    CjDwTableLoadModeInfo selectByDwDataTable(String dwDataTable);
}