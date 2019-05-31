package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjDataSourceTabRows;
import com.acquisition.entity.CjDataSourceTabRowsExample;
import com.acquisition.entity.CjDataSourceTabRowsKey;
import org.apache.ibatis.annotations.Param;

public interface CjDataSourceTabRowsMapper {
    int countByExample(CjDataSourceTabRowsExample example);

    int deleteByExample(CjDataSourceTabRowsExample example);

    int deleteByPrimaryKey(CjDataSourceTabRowsKey key);

    int insert(CjDataSourceTabRows record);

    int insertSelective(CjDataSourceTabRows record);

    List<CjDataSourceTabRows> selectByExample(CjDataSourceTabRowsExample example);

    CjDataSourceTabRows selectByPrimaryKey(CjDataSourceTabRowsKey key);

    int updateByExampleSelective(@Param("record") CjDataSourceTabRows record, @Param("example") CjDataSourceTabRowsExample example);

    int updateByExample(@Param("record") CjDataSourceTabRows record, @Param("example") CjDataSourceTabRowsExample example);

    int updateByPrimaryKeySelective(CjDataSourceTabRows record);

    int updateByPrimaryKey(CjDataSourceTabRows record);
}