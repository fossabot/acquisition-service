package com.acquisition.entity;

public class CjDwTableColMapRelInfoKey {
    private String dwDataTable;

    private String dataSqlGroupUnit;

    private String sourceTableName;

    private String sourceTableColName;

    private String targetTableColName;

    public String getDwDataTable() {
        return dwDataTable;
    }

    public void setDwDataTable(String dwDataTable) {
        this.dwDataTable = dwDataTable == null ? null : dwDataTable.trim();
    }

    public String getDataSqlGroupUnit() {
        return dataSqlGroupUnit;
    }

    public void setDataSqlGroupUnit(String dataSqlGroupUnit) {
        this.dataSqlGroupUnit = dataSqlGroupUnit == null ? null : dataSqlGroupUnit.trim();
    }

    public String getSourceTableName() {
        return sourceTableName;
    }

    public void setSourceTableName(String sourceTableName) {
        this.sourceTableName = sourceTableName == null ? null : sourceTableName.trim();
    }

    public String getSourceTableColName() {
        return sourceTableColName;
    }

    public void setSourceTableColName(String sourceTableColName) {
        this.sourceTableColName = sourceTableColName == null ? null : sourceTableColName.trim();
    }

    public String getTargetTableColName() {
        return targetTableColName;
    }

    public void setTargetTableColName(String targetTableColName) {
        this.targetTableColName = targetTableColName == null ? null : targetTableColName.trim();
    }
}