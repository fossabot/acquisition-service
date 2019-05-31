package com.acquisition.service;

import com.acquisition.entity.CjDataSourceTabColInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public interface ICjDataSourceTabColInfoService {
    List<CjDataSourceTabColInfo> findBySystemAndSchema(
            String businessSystemNameShortName,
            String dataSourceSchema,
            String dataSourceTable
    );
}
