package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.CjDataSourceConnDefine;
import com.acquisition.entity.CjDataSourceConnDefineExample;
import com.acquisition.entity.CjDataSourceConnDefineKey;
import com.acquisition.entity.ViewSourceSystemEntity;
import org.apache.ibatis.annotations.Param;

public interface CjDataSourceConnDefineMapper {

    int countByExample(CjDataSourceConnDefineExample example);

    int deleteByExample(CjDataSourceConnDefineExample example);

    int deleteByPrimaryKey(CjDataSourceConnDefineKey key);

    int insert(CjDataSourceConnDefine record);

    int insertSelective(CjDataSourceConnDefine record);

    List<CjDataSourceConnDefine> selectByExample();

    CjDataSourceConnDefine selectByPrimaryKey(CjDataSourceConnDefineKey key);

    int updateByExampleSelective(@Param("record") CjDataSourceConnDefine record, @Param("example") CjDataSourceConnDefineExample example);

    int updateByExample(@Param("record") CjDataSourceConnDefine record, @Param("example") CjDataSourceConnDefineExample example);

    int updateByPrimaryKeySelective(CjDataSourceConnDefine record);

    int updateByPrimaryKey(CjDataSourceConnDefine record);

    List<ViewSourceSystemEntity> selectViewContet();

    List<String> selectDistinctName();

    List<CjDataSourceConnDefine> findListBySystemID(String[] arr);

    String selectBySystemID(@Param("syid")String syid);

    String selectSystemName(@Param("businessSystemNameShortName") String businessSystemNameShortName);
}