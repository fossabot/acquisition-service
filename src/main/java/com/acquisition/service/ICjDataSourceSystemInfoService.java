package com.acquisition.service;

import com.acquisition.entity.CjDataSourceSystemInfo;
import com.acquisition.entity.CjDataSourceSystemInfoExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
public interface ICjDataSourceSystemInfoService {

    int insertBatch(List<CjDataSourceSystemInfo> list);

    List<CjDataSourceSystemInfo> selectInfo();

    int deleteBySystemName(String systemid);

    List<String> findDistBusinessSystemNameShortName();

    List<CjDataSourceSystemInfo> findByExample(CjDataSourceSystemInfoExample example);
    String selectDistDataBaseType(String sysname);
}
