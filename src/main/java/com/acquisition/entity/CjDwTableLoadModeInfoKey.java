package com.acquisition.entity;

public class CjDwTableLoadModeInfoKey {
    private String dwDataTable;

    private String dwTablePartitionColName;

    public String getDwDataTable() {
        return dwDataTable;
    }

    public void setDwDataTable(String dwDataTable) {
        this.dwDataTable = dwDataTable == null ? null : dwDataTable.trim();
    }

    public String getDwTablePartitionColName() {
        return dwTablePartitionColName;
    }

    public void setDwTablePartitionColName(String dwTablePartitionColName) {
        this.dwTablePartitionColName = dwTablePartitionColName == null ? null : dwTablePartitionColName.trim();
    }
}