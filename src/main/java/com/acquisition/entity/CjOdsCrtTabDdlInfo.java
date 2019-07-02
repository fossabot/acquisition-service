package com.acquisition.entity;

public class CjOdsCrtTabDdlInfo extends CjOdsCrtTabDdlInfoKey {
    private String businessSystemId;

    private String odsDataTableDdlInfo;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId == null ? null : businessSystemId.trim();
    }

    public String getOdsDataTableDdlInfo() {
        return odsDataTableDdlInfo;
    }

    public void setOdsDataTableDdlInfo(String odsDataTableDdlInfo) {
        this.odsDataTableDdlInfo = odsDataTableDdlInfo == null ? null : odsDataTableDdlInfo.trim();
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