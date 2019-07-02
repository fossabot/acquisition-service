package com.acquisition.entity;

public class CjDwCrtTabDdlInfoKey {
    private String businessSystemNameShortName;

    private String dataSourceSchema;

    private String dataSourceTable;

    private String odsDataTable;

    private String dwDataTable;

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

    public String getOdsDataTable() {
        return odsDataTable;
    }

    public void setOdsDataTable(String odsDataTable) {
        this.odsDataTable = odsDataTable == null ? null : odsDataTable.trim();
    }

    public String getDwDataTable() {
        return dwDataTable;
    }

    public void setDwDataTable(String dwDataTable) {
        this.dwDataTable = dwDataTable == null ? null : dwDataTable.trim();
    }
}