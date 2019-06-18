package com.acquisition.service.impl;


import com.acquisition.config.YiliPoolConfig;
import com.acquisition.entity.CjDataSourceSystemInfo;
import com.acquisition.entity.pojo.CjDwCrtDdlColPojo;
import com.acquisition.mapper.CjDataSourceTabColInfoMapper;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.entity.CjDataSourceTabColInfo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjDataSourceTabColInfoServiceImpl implements ICjDataSourceTabColInfoService {

    private static final Logger LOG = LoggerFactory.getLogger(CjDataSourceTabColInfoServiceImpl.class);
    @Resource(name = "cjDataSourceTabColInfoMapper")
    public CjDataSourceTabColInfoMapper cjDataSourceTabColInfoMapper;

    /**
     * @param businessSystemNameShortName 源系统缩写
     * @param dataSourceSchema            schema名
     * @param dataSourceTable             表名
     * @return 返回指定表的字段详情
     */

    @Override
    public List<CjDwCrtDdlColPojo> selectCjDwCrtDdlColPojoBySysAndSchemaAndTab(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable) {
        return cjDataSourceTabColInfoMapper.selectCjDwCrtDdlColPojoBySysAndSchemaAndTab(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
    }

    public List<CjDataSourceTabColInfo> findBySystemAndSchemaAndTab(
            String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable) {
        return cjDataSourceTabColInfoMapper.selectAllBySysAndSchemaAndTab(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
    }


    @Override
    public int insertBatch(List<CjDataSourceTabColInfo> list) {
        return cjDataSourceTabColInfoMapper.insertBatch(list);
    }


    @Override
    public List<CjDataSourceTabColInfo> findListOnlyTable(List<CjDataSourceSystemInfo> list) {
        return cjDataSourceTabColInfoMapper.findListOnlyTable(list);
    }

    @Override
    public int deleteBySystemName(String systemname, String schema) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LOG.info(df.format(new Date())+"----调用了删除字段方法");
        return cjDataSourceTabColInfoMapper.deleteBySystemName(systemname, schema);
    }

    @Override
    public List<CjDataSourceTabColInfo> selectByTable(String systemname, String schema, String tablename) {
        return cjDataSourceTabColInfoMapper.selectByTable(systemname, schema, tablename);
    }


}
