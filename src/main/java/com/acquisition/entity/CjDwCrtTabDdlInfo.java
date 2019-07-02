package com.acquisition.entity;

public class CjDwCrtTabDdlInfo extends CjDwCrtTabDdlInfoKey {
    private String businessSystemId;

    private String dwDataTableDdlInfo;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId == null ? null : businessSystemId.trim();
    }

    public String getDwDataTableDdlInfo() {
        return dwDataTableDdlInfo;
    }

    public void setDwDataTableDdlInfo(String dwDataTableDdlInfo) {
        this.dwDataTableDdlInfo = dwDataTableDdlInfo == null ? null : dwDataTableDdlInfo.trim();
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