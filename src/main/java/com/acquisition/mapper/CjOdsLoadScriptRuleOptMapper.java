package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjOdsLoadScriptRuleOpt;
import com.acquisition.entity.CjOdsLoadScriptRuleOptExample;
import com.acquisition.entity.CjOdsLoadScriptRuleOptKey;
import org.apache.ibatis.annotations.Param;

public interface CjOdsLoadScriptRuleOptMapper {
    int countByExample(CjOdsLoadScriptRuleOptExample example);

    int deleteByExample(CjOdsLoadScriptRuleOptExample example);

    int deleteByPrimaryKey(CjOdsLoadScriptRuleOptKey key);

    int insert(CjOdsLoadScriptRuleOpt record);

    int insertSelective(CjOdsLoadScriptRuleOpt record);

    List<CjOdsLoadScriptRuleOpt> selectByExample(CjOdsLoadScriptRuleOptExample example);

    CjOdsLoadScriptRuleOpt selectByPrimaryKey(CjOdsLoadScriptRuleOptKey key);

    int updateByExampleSelective(@Param("record") CjOdsLoadScriptRuleOpt record, @Param("example") CjOdsLoadScriptRuleOptExample example);

    int updateByExample(@Param("record") CjOdsLoadScriptRuleOpt record, @Param("example") CjOdsLoadScriptRuleOptExample example);

    int updateByPrimaryKeySelective(CjOdsLoadScriptRuleOpt record);

    int updateByPrimaryKey(CjOdsLoadScriptRuleOpt record);
}