package com.acquisition.entity;

public class CjDataSourceTabColInfoKey {
    private String businessSystemNameShortName;

    private String dataSourceSchema;

    private String dataSourceTable;

    private String dataSourceColName;

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

    public String getDataSourceColName() {
        return dataSourceColName;
    }

    public void setDataSourceColName(String dataSourceColName) {
        this.dataSourceColName = dataSourceColName == null ? null : dataSourceColName.trim();
    }
}