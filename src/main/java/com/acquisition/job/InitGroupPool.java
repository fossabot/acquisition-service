package com.acquisition.job;

import com.acquisition.entity.CjDataSourceConnDefine;
import com.acquisition.service.ICjDataSourceConnDefineService;
import com.acquisition.service.impl.CjDataSourceConnDefineServiceImpl;
import com.yili.pool.pool.GroupPoolFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yxk
 * @Description: 初始化分组线程池
 * @create 2019/5/30
 * @since 1.0.0
 */
@Component
public class InitGroupPool implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(InitGroupPool.class);

/*    @Resource(name = "cjDataSourceConnDefineServiceImpl")
    private  ICjDataSourceConnDefineService iCjDataSourceConnDefineService;*/

    @Override
    public void run(String... args) throws Exception {
        LOG.info("zhixing");
  /*      ICjDataSourceConnDefineService iCjDataSourceConnDefineService =new CjDataSourceConnDefineServiceImpl();
        List<CjDataSourceConnDefine> listDataSource = iCjDataSourceConnDefineService.selectByExample();
        System.out.println("");*/
    }

    /*@Override
    public void run(ApplicationArguments args) throws Exception {


     *//*   List<CjDataSourceConnDefine> listDataSource = iCjDataSourceConnDefineService.selectByExample();
        GroupPoolFactory groupPoolFactory = GroupPoolFactory.getInstance("");*//*
        //groupPoolFactory.setConfigurationParameter("com.mysql.jdbc.Driver","","10.30.140.125","3306","surgingdb","root","root");
    }*/

}
