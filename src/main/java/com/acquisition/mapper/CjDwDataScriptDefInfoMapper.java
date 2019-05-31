package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjDwDataScriptDefInfo;
import com.acquisition.entity.CjDwDataScriptDefInfoExample;
import com.acquisition.entity.CjDwDataScriptDefInfoKey;
import org.apache.ibatis.annotations.Param;

public interface CjDwDataScriptDefInfoMapper {
    int countByExample(CjDwDataScriptDefInfoExample example);

    int deleteByExample(CjDwDataScriptDefInfoExample example);

    int deleteByPrimaryKey(CjDwDataScriptDefInfoKey key);

    int insert(CjDwDataScriptDefInfo record);

    int insertSelective(CjDwDataScriptDefInfo record);

    List<CjDwDataScriptDefInfo> selectByExample(CjDwDataScriptDefInfoExample example);

    CjDwDataScriptDefInfo selectByPrimaryKey(CjDwDataScriptDefInfoKey key);

    int updateByExampleSelective(@Param("record") CjDwDataScriptDefInfo record, @Param("example") CjDwDataScriptDefInfoExample example);

    int updateByExample(@Param("record") CjDwDataScriptDefInfo record, @Param("example") CjDwDataScriptDefInfoExample example);

    int updateByPrimaryKeySelective(CjDwDataScriptDefInfo record);

    int updateByPrimaryKey(CjDwDataScriptDefInfo record);
}