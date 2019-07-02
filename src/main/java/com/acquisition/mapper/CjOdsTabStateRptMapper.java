package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjOdsTabStateRpt;
import com.acquisition.entity.CjOdsTabStateRptExample;
import com.acquisition.entity.CjOdsTabStateRptKey;
import org.apache.ibatis.annotations.Param;

public interface CjOdsTabStateRptMapper {
    int countByExample(CjOdsTabStateRptExample example);

    int deleteByExample(CjOdsTabStateRptExample example);

    int deleteByPrimaryKey(CjOdsTabStateRptKey key);

    int insert(CjOdsTabStateRpt record);

    int insertSelective(CjOdsTabStateRpt record);

    List<CjOdsTabStateRpt> selectByExample(CjOdsTabStateRptExample example);

    CjOdsTabStateRpt selectByPrimaryKey(CjOdsTabStateRptKey key);

    int updateByExampleSelective(@Param("record") CjOdsTabStateRpt record, @Param("example") CjOdsTabStateRptExample example);

    int updateByExample(@Param("record") CjOdsTabStateRpt record, @Param("example") CjOdsTabStateRptExample example);

    int updateByPrimaryKeySelective(CjOdsTabStateRpt record);

    int updateByPrimaryKey(CjOdsTabStateRpt record);
}