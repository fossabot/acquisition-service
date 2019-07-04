package com.acquisition.entity;

public class CjDwTableColInfoKey {
    private String dwBusinessTopicDomain;

    private String dwDataSchema;

    private String dwDataTable;

    private String dwTableColName;

    public String getDwBusinessTopicDomain() {
        return dwBusinessTopicDomain;
    }

    public void setDwBusinessTopicDomain(String dwBusinessTopicDomain) {
        this.dwBusinessTopicDomain = dwBusinessTopicDomain == null ? null : dwBusinessTopicDomain.trim();
    }

    public String getDwDataSchema() {
        return dwDataSchema;
    }

    public void setDwDataSchema(String dwDataSchema) {
        this.dwDataSchema = dwDataSchema == null ? null : dwDataSchema.trim();
    }

    public String getDwDataTable() {
        return dwDataTable;
    }

    public void setDwDataTable(String dwDataTable) {
        this.dwDataTable = dwDataTable == null ? null : dwDataTable.trim();
    }

    public String getDwTableColName() {
        return dwTableColName;
    }

    public void setDwTableColName(String dwTableColName) {
        this.dwTableColName = dwTableColName == null ? null : dwTableColName.trim();
    }
}