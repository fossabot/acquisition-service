package com.acquisition.entity;

public class CjDwDataScriptDefInfo extends CjDwDataScriptDefInfoKey {
    private String businessSystemId;

    private String dwDataScriptType;

    private String dwDataHivesqlDefine;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId == null ? null : businessSystemId.trim();
    }

    public String getDwDataScriptType() {
        return dwDataScriptType;
    }

    public void setDwDataScriptType(String dwDataScriptType) {
        this.dwDataScriptType = dwDataScriptType == null ? null : dwDataScriptType.trim();
    }

    public String getDwDataHivesqlDefine() {
        return dwDataHivesqlDefine;
    }

    public void setDwDataHivesqlDefine(String dwDataHivesqlDefine) {
        this.dwDataHivesqlDefine = dwDataHivesqlDefine == null ? null : dwDataHivesqlDefine.trim();
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