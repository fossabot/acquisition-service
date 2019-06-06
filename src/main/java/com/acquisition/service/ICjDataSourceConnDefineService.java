package com.acquisition.service;

import com.acquisition.entity.CjDataSourceConnDefine;
import com.acquisition.entity.ViewSourceSystemEntity;
import com.acquisition.mapper.CjDataSourceConnDefineMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */

public interface ICjDataSourceConnDefineService {
    List<CjDataSourceConnDefine> selectByExample();

    List<ViewSourceSystemEntity> selectViewContet();

    List<String> selectDistinctName();

    List<CjDataSourceConnDefine> findListBySystemID(String[] arr);

    String selectBySystemID(String syid);

    String selectSystemName();

}
