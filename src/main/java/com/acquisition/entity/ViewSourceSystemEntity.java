package com.acquisition.entity;

import lombok.Data;

/**
 * Created by zhangdongmao on 2019/6/3.
 */
@Data
public class ViewSourceSystemEntity {

    private String business_system_ID;
    private String business_system_name_short_name;
    private String status;
    private String data_base_type;

    public String getBusiness_system_ID() {
        return business_system_ID;
    }

    public void setBusiness_system_ID(String business_system_ID) {
        this.business_system_ID = business_system_ID;
    }

    public String getBusiness_system_name_short_name() {
        return business_system_name_short_name;
    }

    public void setBusiness_system_name_short_name(String business_system_name_short_name) {
        this.business_system_name_short_name = business_system_name_short_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData_base_type() {
        return data_base_type;
    }

    public void setData_base_type(String data_base_type) {
        this.data_base_type = data_base_type;
    }
}