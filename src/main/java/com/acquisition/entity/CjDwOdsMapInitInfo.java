package com.acquisition.entity;

public class CjDwOdsMapInitInfo extends CjDwOdsMapInitInfoKey {
    private String dwBusinessTopicDomain;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getDwBusinessTopicDomain() {
        return dwBusinessTopicDomain;
    }

    public void setDwBusinessTopicDomain(String dwBusinessTopicDomain) {
        this.dwBusinessTopicDomain = dwBusinessTopicDomain == null ? null : dwBusinessTopicDomain.trim();
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