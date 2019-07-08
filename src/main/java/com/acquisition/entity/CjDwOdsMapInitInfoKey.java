package com.acquisition.entity;

public class CjDwOdsMapInitInfoKey {
    private String odsDataTable;

    private String dwSpareTable;

    private String dwDataTable;

    public String getOdsDataTable() {
        return odsDataTable;
    }

    public void setOdsDataTable(String odsDataTable) {
        this.odsDataTable = odsDataTable == null ? null : odsDataTable.trim();
    }

    public String getDwSpareTable() {
        return dwSpareTable;
    }

    public void setDwSpareTable(String dwSpareTable) {
        this.dwSpareTable = dwSpareTable == null ? null : dwSpareTable.trim();
    }

    public String getDwDataTable() {
        return dwDataTable;
    }

    public void setDwDataTable(String dwDataTable) {
        this.dwDataTable = dwDataTable == null ? null : dwDataTable.trim();
    }
}