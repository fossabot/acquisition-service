package com.acquisition.mapper;

import com.acquisition.entity.CjDwTableColInfo;
import com.acquisition.entity.CjDwTableColInfoExample;
import com.acquisition.entity.CjDwTableColInfoKey;
import java.util.List;

import com.acquisition.entity.CjOdsTableColInfo;
import org.apache.ibatis.annotations.Param;

public interface CjDwTableColInfoMapper {
    int countByExample(CjDwTableColInfoExample example);

    int deleteByExample(CjDwTableColInfoExample example);

    int deleteByPrimaryKey(CjDwTableColInfoKey key);

    int insert(CjDwTableColInfo record);

    int insertSelective(CjDwTableColInfo record);

    List<CjDwTableColInfo> selectByExample(CjDwTableColInfoExample example);

    List<CjDwTableColInfo> selectColInfoByTopicAndTab(@Param("dwTableBelongDomain") String dwTableBelongDomain, @Param("dwDataTable") String dwDataTable);

    CjDwTableColInfo selectByPrimaryKey(CjDwTableColInfoKey key);

    int updateByExampleSelective(@Param("record") CjDwTableColInfo record, @Param("example") CjDwTableColInfoExample example);

    int updateByExample(@Param("record") CjDwTableColInfo record, @Param("example") CjDwTableColInfoExample example);

    int updateByPrimaryKeySelective(CjDwTableColInfo record);

    int updateByPrimaryKey(CjDwTableColInfo record);

    int insertBatch(List<CjDwTableColInfo> list);

    List<String> selectPrimaryCol(@Param("dwTableBelongDomain") String dwTableBelongDomain, @Param("dwDataTable") String dwDataTable, @Param("array") String[] array);

    List<String> selectPartitionCol(@Param("dwTableBelongDomain") String dwTableBelongDomain, @Param("dwDataTable") String dwDataTable);

}