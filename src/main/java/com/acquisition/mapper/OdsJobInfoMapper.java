package com.acquisition.mapper;

import java.util.List;

import com.acquisition.entity.OdsJobInfo;
import com.acquisition.entity.OdsJobInfoExample;
import org.apache.ibatis.annotations.Param;

public interface OdsJobInfoMapper {
    int countByExample(OdsJobInfoExample example);

    int deleteByExample(OdsJobInfoExample example);

    int deleteByPrimaryKey(String jobPk);

    int insert(OdsJobInfo record);

    int insertSelective(OdsJobInfo record);

    List<OdsJobInfo> selectByExample(OdsJobInfoExample example);

    OdsJobInfo selectByPrimaryKey(String jobPk);

    int updateByExampleSelective(@Param("record") OdsJobInfo record, @Param("example") OdsJobInfoExample example);

    int updateByExample(@Param("record") OdsJobInfo record, @Param("example") OdsJobInfoExample example);

    int updateByPrimaryKeySelective(OdsJobInfo record);

    int updateByPrimaryKey(OdsJobInfo record);
}