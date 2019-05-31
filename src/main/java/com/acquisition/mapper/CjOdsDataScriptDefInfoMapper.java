package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjOdsDataScriptDefInfo;
import com.acquisition.entity.CjOdsDataScriptDefInfoExample;
import com.acquisition.entity.CjOdsDataScriptDefInfoKey;
import org.apache.ibatis.annotations.Param;

public interface CjOdsDataScriptDefInfoMapper {
    int countByExample(CjOdsDataScriptDefInfoExample example);

    int deleteByExample(CjOdsDataScriptDefInfoExample example);

    int deleteByPrimaryKey(CjOdsDataScriptDefInfoKey key);

    int insert(CjOdsDataScriptDefInfo record);

    int insertSelective(CjOdsDataScriptDefInfo record);

    List<CjOdsDataScriptDefInfo> selectByExample(CjOdsDataScriptDefInfoExample example);

    CjOdsDataScriptDefInfo selectByPrimaryKey(CjOdsDataScriptDefInfoKey key);

    int updateByExampleSelective(@Param("record") CjOdsDataScriptDefInfo record, @Param("example") CjOdsDataScriptDefInfoExample example);

    int updateByExample(@Param("record") CjOdsDataScriptDefInfo record, @Param("example") CjOdsDataScriptDefInfoExample example);

    int updateByPrimaryKeySelective(CjOdsDataScriptDefInfo record);

    int updateByPrimaryKey(CjOdsDataScriptDefInfo record);
}