package com.acquisition.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @Author : Francis Du
 * @Date : Create in 11:15 2019/6/11
 * Modified By :
 */
public class ExclePropertyModel extends BaseRowModel {

    @ExcelProperty(value = "源系统缩写", index = 0)
    private String businessSystemNameShortName;

    @ExcelProperty(value = "数据模式", index = 1)
    private  String dataSourceSchema;

    @ExcelProperty(value = "总表量", index = 2)
    private String tableCount;

    @ExcelProperty(value = "ODS入湖表量", index = 3)
    private String odsCount;

    @ExcelProperty(value = "DW入湖表量", index = 4)
    private String dwCount;

    @ExcelProperty(value = "统计日期", index = 5)
    private String date;

    public String getBusinessSystemNameShortName() {
        return businessSystemNameShortName;
    }

    public String getDataSourceSchema() {
        return dataSourceSchema;
    }

    public String getTableCount() {
        return tableCount;
    }

    public String getOdsCount() {
        return odsCount;
    }

    public String getDwCount() {
        return dwCount;
    }

    public String getDate() {
        return date;
    }

    public void setBusinessSystemNameShortName(String businessSystemNameShortName) {
        this.businessSystemNameShortName = businessSystemNameShortName;
    }

    public void setDataSourceSchema(String dataSourceSchema) {
        this.dataSourceSchema = dataSourceSchema;
    }

    public void setTableCount(String tableCount) {
        this.tableCount = tableCount;
    }

    public void setOdsCount(String odsCount) {
        this.odsCount = odsCount;
    }

    public void setDwCount(String dwCount) {
        this.dwCount = dwCount;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
