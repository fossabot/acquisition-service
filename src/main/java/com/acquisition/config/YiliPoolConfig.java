package com.acquisition.config;

import com.acquisition.entity.CjDataSourceConnDefine;
import com.acquisition.job.DatabaseType;
import com.acquisition.service.ICjDataSourceConnDefineService;
import com.yili.pool.pool.GroupPoolFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yxk
 * @Description: 分组连接池配置
 * @create 2019/6/2
 * @since 1.0.0
 */
@Configuration
public class YiliPoolConfig implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(YiliPoolConfig.class);

    @Resource(name = "cjDataSourceConnDefineServiceImpl")
    ICjDataSourceConnDefineService iCjDataSourceConnDefineService;


    @Override
    public void run(String... args) throws Exception {
        List<CjDataSourceConnDefine> allconninfo = iCjDataSourceConnDefineService.selectByExample();
        for (CjDataSourceConnDefine dta : allconninfo) {
            GroupPoolFactory groupPoolFactory = GroupPoolFactory.getInstance((dta.getBusinessSystemNameShortName() + dta.getDataSourceSchema()));
            if (dta.getDataBaseType().equals("mysql") || dta.getDataBaseType().equals("sqlserver")) {
                groupPoolFactory.setConfigurationParameter(
                        DatabaseType.AdapterDatabaseType(dta.getDataBaseType()),
                        dta.getConnIp(), dta.getConnPort(), (dta.getDataBaseType().equals("sqlserver") ? dta.getDataSourceSchema() : ""),
                        dta.getLoginName(), dta.getLoginPassword());
            } else if (dta.getDataBaseType().equals("oracle") || dta.getDataBaseType().equals("hive")) {
                groupPoolFactory.setConfigurationParameter(
                        DatabaseType.AdapterDatabaseType(dta.getDataBaseType()),
                        dta.getConnIp(), dta.getConnPort(), dta.getBusinessSystemNameShortName(),
                        dta.getLoginName(), dta.getLoginPassword(), (dta.getDataBaseType().equals("oracle") ? dta.getDbInstance() : dta.getHiveQueue()));
            }
        }
        LOG.info("YILIGroupPool创建成功");
    }
}
