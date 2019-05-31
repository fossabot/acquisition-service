package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjDwLoadScriptRuleOpt;
import com.acquisition.entity.CjDwLoadScriptRuleOptExample;
import com.acquisition.entity.CjDwLoadScriptRuleOptKey;
import org.apache.ibatis.annotations.Param;

public interface CjDwLoadScriptRuleOptMapper {
    int countByExample(CjDwLoadScriptRuleOptExample example);

    int deleteByExample(CjDwLoadScriptRuleOptExample example);

    int deleteByPrimaryKey(CjDwLoadScriptRuleOptKey key);

    int insert(CjDwLoadScriptRuleOpt record);

    int insertSelective(CjDwLoadScriptRuleOpt record);

    List<CjDwLoadScriptRuleOpt> selectByExample(CjDwLoadScriptRuleOptExample example);

    CjDwLoadScriptRuleOpt selectByPrimaryKey(CjDwLoadScriptRuleOptKey key);

    int updateByExampleSelective(@Param("record") CjDwLoadScriptRuleOpt record, @Param("example") CjDwLoadScriptRuleOptExample example);

    int updateByExample(@Param("record") CjDwLoadScriptRuleOpt record, @Param("example") CjDwLoadScriptRuleOptExample example);

    int updateByPrimaryKeySelective(CjDwLoadScriptRuleOpt record);

    int updateByPrimaryKey(CjDwLoadScriptRuleOpt record);
}