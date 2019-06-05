package com.acquisition.entity;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/6/5.
 */

public class SystemSchemaFilterEntity {

    private String businessSystemNameShortName;

    private List<String> dataSourceSchemas;

    public String getBusinessSystemNameShortName() {
        return businessSystemNameShortName;
    }

    public void setBusinessSystemNameShortName(String businessSystemNameShortName) {
        this.businessSystemNameShortName = businessSystemNameShortName;
    }

    public List<String> getDataSourceSchemas() {
        return dataSourceSchemas;
    }

    public void setDataSourceSchemas(List<String> dataSourceSchemas) {
        this.dataSourceSchemas = dataSourceSchemas;
    }
}
