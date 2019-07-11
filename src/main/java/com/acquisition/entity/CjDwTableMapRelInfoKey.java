package com.acquisition.entity;

public class CjDwTableMapRelInfoKey {
    private String dwDataTable;

    private String dataSqlGroupUnit;

    private String sourceTableName;

    private String tableJoinType;

    private String joinTableName;

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

    public String getTableJoinType() {
        return tableJoinType;
    }

    public void setTableJoinType(String tableJoinType) {
        this.tableJoinType = tableJoinType == null ? null : tableJoinType.trim();
    }

    public String getJoinTableName() {
        return joinTableName;
    }

    public void setJoinTableName(String joinTableName) {
        this.joinTableName = joinTableName == null ? null : joinTableName.trim();
    }
}