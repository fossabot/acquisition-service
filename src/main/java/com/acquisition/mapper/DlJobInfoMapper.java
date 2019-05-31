package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.DlJobInfo;
import com.acquisition.entity.DlJobInfoExample;
import org.apache.ibatis.annotations.Param;

public interface DlJobInfoMapper {
    int countByExample(DlJobInfoExample example);

    int deleteByExample(DlJobInfoExample example);

    int deleteByPrimaryKey(String jobPk);

    int insert(DlJobInfo record);

    int insertSelective(DlJobInfo record);

    List<DlJobInfo> selectByExample(DlJobInfoExample example);

    DlJobInfo selectByPrimaryKey(String jobPk);

    int updateByExampleSelective(@Param("record") DlJobInfo record, @Param("example") DlJobInfoExample example);

    int updateByExample(@Param("record") DlJobInfo record, @Param("example") DlJobInfoExample example);

    int updateByPrimaryKeySelective(DlJobInfo record);

    int updateByPrimaryKey(DlJobInfo record);
}