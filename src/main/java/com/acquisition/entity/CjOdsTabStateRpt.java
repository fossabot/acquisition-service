package com.acquisition.entity;

public class CjOdsTabStateRpt extends CjOdsTabStateRptKey {
    private String businessSystemId;

    private String dataSourceTabNums;

    private String odsTabNums;

    private String dwTabNums;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId == null ? null : businessSystemId.trim();
    }

    public String getDataSourceTabNums() {
        return dataSourceTabNums;
    }

    public void setDataSourceTabNums(String dataSourceTabNums) {
        this.dataSourceTabNums = dataSourceTabNums == null ? null : dataSourceTabNums.trim();
    }

    public String getOdsTabNums() {
        return odsTabNums;
    }

    public void setOdsTabNums(String odsTabNums) {
        this.odsTabNums = odsTabNums == null ? null : odsTabNums.trim();
    }

    public String getDwTabNums() {
        return dwTabNums;
    }

    public void setDwTabNums(String dwTabNums) {
        this.dwTabNums = dwTabNums == null ? null : dwTabNums.trim();
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