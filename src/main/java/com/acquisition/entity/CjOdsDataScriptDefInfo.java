package com.acquisition.entity;

public class CjOdsDataScriptDefInfo extends CjOdsDataScriptDefInfoKey {
    private String businessSystemId;

    private String odsDataScriptType;

    private String odsDataSqoopDefine;

    private String odsDataHivesqlDefine;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId == null ? null : businessSystemId.trim();
    }

    public String getOdsDataScriptType() {
        return odsDataScriptType;
    }

    public void setOdsDataScriptType(String odsDataScriptType) {
        this.odsDataScriptType = odsDataScriptType == null ? null : odsDataScriptType.trim();
    }

    public String getOdsDataSqoopDefine() {
        return odsDataSqoopDefine;
    }

    public void setOdsDataSqoopDefine(String odsDataSqoopDefine) {
        this.odsDataSqoopDefine = odsDataSqoopDefine == null ? null : odsDataSqoopDefine.trim();
    }

    public String getOdsDataHivesqlDefine() {
        return odsDataHivesqlDefine;
    }

    public void setOdsDataHivesqlDefine(String odsDataHivesqlDefine) {
        this.odsDataHivesqlDefine = odsDataHivesqlDefine == null ? null : odsDataHivesqlDefine.trim();
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