package com.acquisition.entity;

public class CjOdsLoadScriptRuleOptKey {
    private String businessSystemNameShortName;

    private String dataSourceSchema;

    private String odsDataTable;

    private String optimizeType;

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

    public String getOdsDataTable() {
        return odsDataTable;
    }

    public void setOdsDataTable(String odsDataTable) {
        this.odsDataTable = odsDataTable == null ? null : odsDataTable.trim();
    }

    public String getOptimizeType() {
        return optimizeType;
    }

    public void setOptimizeType(String optimizeType) {
        this.optimizeType = optimizeType == null ? null : optimizeType.trim();
    }
}