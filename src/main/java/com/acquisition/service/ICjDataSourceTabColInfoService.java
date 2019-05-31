package com.acquisition.service;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.pojo.CjDwCrtDdlColPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public interface ICjDataSourceTabColInfoService {
    String findBySystemAndSchema(String businessSystemNameShortName, String dataSourceSchema ,String dataSourceTable);
    List<CjDwCrtDdlColPojo> selectCjDwCrtDdlColPojoBySysAndSchemaAndTab(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable);
}
