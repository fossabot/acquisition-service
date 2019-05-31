package com.acquisition.service.impl;


import com.acquisition.entity.CjDataSourceTabColInfo;
import com.acquisition.mapper.CjDataSourceTabColInfoMapper;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjDataSourceTabColInfoServiceImpl implements ICjDataSourceTabColInfoService {

    @Resource(name = "cjDataSourceTabColInfoMapper")
    public CjDataSourceTabColInfoMapper cjDataSourceTabColInfoMapper;

    /**
     * @param businessSystemNameShortName 源系统缩写
     * @param dataSourceSchema schema名
     * @param dataSourceTable 表名
     * @return 返回指定表的字段详情
     */
    @Override
    public List<CjDataSourceTabColInfo> findBySystemAndSchema(
            String businessSystemNameShortName, String dataSourceSchema , String dataSourceTable) {
       return cjDataSourceTabColInfoMapper.selectAllBySysAndSchemaAndTab(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
    }

}
