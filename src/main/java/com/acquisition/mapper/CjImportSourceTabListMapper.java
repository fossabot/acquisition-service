package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjImportSourceTabList;
import com.acquisition.entity.CjImportSourceTabListExample;
import com.acquisition.entity.CjImportSourceTabListKey;
import org.apache.ibatis.annotations.Param;

public interface CjImportSourceTabListMapper {
    int countByExample(CjImportSourceTabListExample example);

    int deleteByExample(CjImportSourceTabListExample example);

    int deleteByPrimaryKey(CjImportSourceTabListKey key);

    int insert(CjImportSourceTabList record);

    int insertSelective(CjImportSourceTabList record);

    List<CjImportSourceTabList> selectByExample(CjImportSourceTabListExample example);

    CjImportSourceTabList selectByPrimaryKey(CjImportSourceTabListKey key);

    int updateByExampleSelective(@Param("record") CjImportSourceTabList record, @Param("example") CjImportSourceTabListExample example);

    int updateByExample(@Param("record") CjImportSourceTabList record, @Param("example") CjImportSourceTabListExample example);

    int updateByPrimaryKeySelective(CjImportSourceTabList record);

    int updateByPrimaryKey(CjImportSourceTabList record);
}