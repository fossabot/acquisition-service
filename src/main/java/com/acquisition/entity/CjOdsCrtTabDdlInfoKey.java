package com.acquisition.entity;

public class CjOdsCrtTabDdlInfoKey {
    private String businessSystemNameShortName;

    private String dataSourceSchema;

    private String dataSourceTable;

    private String odsDataSchema;

    private String odsDataTable;

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

    public String getOdsDataSchema() {
        return odsDataSchema;
    }

    public void setOdsDataSchema(String odsDataSchema) {
        this.odsDataSchema = odsDataSchema == null ? null : odsDataSchema.trim();
    }

    public String getOdsDataTable() {
        return odsDataTable;
    }

    public void setOdsDataTable(String odsDataTable) {
        this.odsDataTable = odsDataTable == null ? null : odsDataTable.trim();
    }
}