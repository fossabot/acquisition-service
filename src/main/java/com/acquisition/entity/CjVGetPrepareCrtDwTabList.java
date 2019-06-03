package com.acquisition.entity;

import org.springframework.stereotype.Component;

/**
 * Created by zhangdongmao on 2019/6/3.
 */
@Component
public class CjVGetPrepareCrtDwTabList {
    private String businessSystemId;

    private String dataSourceTableComment;

    private String dataFlagForGetCols;

    private String dataFlagForGetRows;

    private String dataFlagForCrtOdsDll;

    private String dataFlagForCrtOdsHive;

    private String dataFlagForCrtDwDll;

    private String dataFlagForCrtDwHive;

    private String dataFlagForCrtOdsScript;

    private String dataFlagForCrtDwScript;

    private String lastModifyDt;

    private String lastModifyBy;
}
