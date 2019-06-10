package com.acquisition.service;

import com.acquisition.entity.CjDataSourceSystemInfo;
import com.acquisition.entity.pojo.CjDwCrtDdlColPojo;
import org.springframework.stereotype.Service;
import com.acquisition.entity.CjDataSourceTabColInfo;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */

public interface ICjDataSourceTabColInfoService {

    List<CjDwCrtDdlColPojo> selectCjDwCrtDdlColPojoBySysAndSchemaAndTab(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable);

    List<CjDataSourceTabColInfo> findBySystemAndSchemaAndTab(
            String businessSystemNameShortName,
            String dataSourceSchema,
            String dataSourceTable
    );

    int insertBatch(List<CjDataSourceTabColInfo> list);

    List<CjDataSourceTabColInfo> findListOnlyTable(List<CjDataSourceSystemInfo> list);

    int deleteBySystemName(String systemname, String schema);

    List<CjDataSourceTabColInfo> selectByTable(String systemname, String schema, String tablename);

}
