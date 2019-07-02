package com.acquisition.entity;

public class CjDataSourceTabInfoKey {
    private String businessSystemNameShortName;

    private String dataSourceSchema;

    private String dataSourceTable;

    public String getBusinessSystemNameShortName() {
        return businessSystemNameShortName;
    }

    public void setBusinessSystemNameShortName(String businessSystemNameShortName) {
        this.businessSystemNameShortName = businessSystemNameShortName == null ? null : businessSystemNameShortName.trim();
    }

    public String getDataSourceSchema() {
        return dataSourceSchema;
    }

    public void setDataSourceSchema(String dataSourceSchema) {
        this.dataSourceSchema = dataSourceSchema == null ? null : dataSourceSchema.trim();
    }

    public String getDataSourceTable() {
        return dataSourceTable;
    }

    public void setDataSourceTable(String dataSourceTable) {
        this.dataSourceTable = dataSourceTable == null ? null : dataSourceTable.trim();
    }
}