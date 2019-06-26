package com.acquisition.entity;

public class CjOdsTableLoadModeInfo extends CjOdsTableLoadModeInfoKey {
    private String businessSystemId;

    private String odsDataSchema;

    private String odsDataLoadMode;

    private String odsTablePartitionColName;

    private String odsTablePartitionUnit;

    private String odsTablePrimaryColName;

    private String odsTableIncrementColName;

    private String odsTableSplitColName;

    private String odsTablePartitionColNameSource;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId == null ? null : businessSystemId.trim();
    }

    public String getOdsDataSchema() {
        return odsDataSchema;
    }

    public void setOdsDataSchema(String odsDataSchema) {
        this.odsDataSchema = odsDataSchema == null ? null : odsDataSchema.trim();
    }

    public String getOdsDataLoadMode() {
        return odsDataLoadMode;
    }

    public void setOdsDataLoadMode(String odsDataLoadMode) {
        this.odsDataLoadMode = odsDataLoadMode == null ? null : odsDataLoadMode.trim();
    }

    public String getOdsTablePartitionColName() {
        return odsTablePartitionColName;
    }

    public void setOdsTablePartitionColName(String odsTablePartitionColName) {
        this.odsTablePartitionColName = odsTablePartitionColName == null ? null : odsTablePartitionColName.trim();
    }

    public String getOdsTablePartitionUnit() {
        return odsTablePartitionUnit;
    }

    public void setOdsTablePartitionUnit(String odsTablePartitionUnit) {
        this.odsTablePartitionUnit = odsTablePartitionUnit == null ? null : odsTablePartitionUnit.trim();
    }

    public String getOdsTablePrimaryColName() {
        return odsTablePrimaryColName;
    }

    public void setOdsTablePrimaryColName(String odsTablePrimaryColName) {
        this.odsTablePrimaryColName = odsTablePrimaryColName == null ? null : odsTablePrimaryColName.trim();
    }

    public String getOdsTableIncrementColName() {
        return odsTableIncrementColName;
    }

    public void setOdsTableIncrementColName(String odsTableIncrementColName) {
        this.odsTableIncrementColName = odsTableIncrementColName == null ? null : odsTableIncrementColName.trim();
    }

    public String getOdsTableSplitColName() {
        return odsTableSplitColName;
    }

    public void setOdsTableSplitColName(String odsTableSplitColName) {
        this.odsTableSplitColName = odsTableSplitColName == null ? null : odsTableSplitColName.trim();
    }

    public String getOdsTablePartitionColNameSource() {
        return odsTablePartitionColNameSource;
    }

    public void setOdsTablePartitionColNameSource(String odsTablePartitionColNameSource) {
        this.odsTablePartitionColNameSource = odsTablePartitionColNameSource == null ? null : odsTablePartitionColNameSource.trim();
    }

    public String getLastModifyDt() {
        return lastModifyDt;
    }

    public void setLastModifyDt(String lastModifyDt) {
        this.lastModifyDt = lastModifyDt == null ? null : lastModifyDt.trim();
    }

    public String getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(String lastModifyBy) {
        this.lastModifyBy = lastModifyBy == null ? null : lastModifyBy.trim();
    }
}