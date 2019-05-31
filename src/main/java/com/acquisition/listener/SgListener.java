package com.acquisition.listener;

import com.acquisition.util.SgDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by zhangdongmao on 2019/4/25.
 */
@Component
public class SgListener implements ApplicationRunner {
    @Autowired
    SgDataSource sgDataSource;
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SgListener.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
                sgDataSource.getConnections();
            } catch (Exception e) {
            e.printStackTrace();
                LOGGER.error(e.toString());
            }
    }
}
