package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjOdsCrtTabRuleInfo;
import com.acquisition.entity.CjOdsCrtTabRuleInfoExample;
import org.apache.ibatis.annotations.Param;

public interface CjOdsCrtTabRuleInfoMapper {
    int countByExample(CjOdsCrtTabRuleInfoExample example);

    int deleteByExample(CjOdsCrtTabRuleInfoExample example);

    int deleteByPrimaryKey(String ruleName);

    int insert(CjOdsCrtTabRuleInfo record);

    int insertSelective(CjOdsCrtTabRuleInfo record);

    List<CjOdsCrtTabRuleInfo> selectByExample(CjOdsCrtTabRuleInfoExample example);

    CjOdsCrtTabRuleInfo selectByPrimaryKey(String ruleName);

    int updateByExampleSelective(@Param("record") CjOdsCrtTabRuleInfo record, @Param("example") CjOdsCrtTabRuleInfoExample example);

    int updateByExample(@Param("record") CjOdsCrtTabRuleInfo record, @Param("example") CjOdsCrtTabRuleInfoExample example);

    int updateByPrimaryKeySelective(CjOdsCrtTabRuleInfo record);

    int updateByPrimaryKey(CjOdsCrtTabRuleInfo record);
}