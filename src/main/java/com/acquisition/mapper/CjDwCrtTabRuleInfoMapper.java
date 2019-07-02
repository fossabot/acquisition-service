package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjDwCrtTabRuleInfo;
import com.acquisition.entity.CjDwCrtTabRuleInfoExample;
import org.apache.ibatis.annotations.Param;

public interface CjDwCrtTabRuleInfoMapper {
    int countByExample(CjDwCrtTabRuleInfoExample example);

    int deleteByExample(CjDwCrtTabRuleInfoExample example);

    int deleteByPrimaryKey(String ruleName);

    int insert(CjDwCrtTabRuleInfo record);

    int insertSelective(CjDwCrtTabRuleInfo record);

    List<CjDwCrtTabRuleInfo> selectByExample(CjDwCrtTabRuleInfoExample example);

    CjDwCrtTabRuleInfo selectByPrimaryKey(String ruleName);

    int updateByExampleSelective(@Param("record") CjDwCrtTabRuleInfo record, @Param("example") CjDwCrtTabRuleInfoExample example);

    int updateByExample(@Param("record") CjDwCrtTabRuleInfo record, @Param("example") CjDwCrtTabRuleInfoExample example);

    int updateByPrimaryKeySelective(CjDwCrtTabRuleInfo record);

    int updateByPrimaryKey(CjDwCrtTabRuleInfo record);
}