package com.acquisition.entity;

public class CjOdsTableColInfoKey {
    private String businessSystemNameShortName;

    private String dataSourceSchema;

    private String dataSourceTable;

    private String odsDataTable;

    private String odsTableColName;

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

    public String getOdsTableColName() {
        return odsTableColName;
    }

    public void setOdsTableColName(String odsTableColName) {
        this.odsTableColName = odsTableColName == null ? null : odsTableColName.trim();
    }
}