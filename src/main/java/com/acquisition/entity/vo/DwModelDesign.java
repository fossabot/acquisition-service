package com.acquisition.entity.vo;

import lombok.Data;

/**
 * Created by zhangdongmao on 2019/7/8.
 */
@Data
public class DwModelDesign {

    private String srcSchema;

    private String srcTableName;

    private String srcTableComment;

    private String srcColName;

    private String srcColComment;

    private String srcColType;

    private String tarTableName;

    private String tarTableComment;

    private String tarColName;

    private String tarColComment;

    private String tarColType;

    private String mappingRule;
}
