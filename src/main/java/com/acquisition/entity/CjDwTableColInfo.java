package com.acquisition.entity;

public class CjDwTableColInfo extends CjDwTableColInfoKey {
    private String dwTableBelongDomain;

    private String dwTableComment;

    private String dwTableColOrder;

    private String dwTableColType;

    private String dwTableColComment;

    private String dwTablePartitionFlag;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getDwTableBelongDomain() {
        return dwTableBelongDomain;
    }

    public void setDwTableBelongDomain(String dwTableBelongDomain) {
        this.dwTableBelongDomain = dwTableBelongDomain == null ? null : dwTableBelongDomain.trim();
    }

    public String getDwTableComment() {
        return dwTableComment;
    }

    public void setDwTableComment(String dwTableComment) {
        this.dwTableComment = dwTableComment == null ? null : dwTableComment.trim();
    }

    public String getDwTableColOrder() {
        return dwTableColOrder;
    }

    public void setDwTableColOrder(String dwTableColOrder) {
        this.dwTableColOrder = dwTableColOrder == null ? null : dwTableColOrder.trim();
    }

    public String getDwTableColType() {
        return dwTableColType;
    }

    public void setDwTableColType(String dwTableColType) {
        this.dwTableColType = dwTableColType == null ? null : dwTableColType.trim();
    }

    public String getDwTableColComment() {
        return dwTableColComment;
    }

    public void setDwTableColComment(String dwTableColComment) {
        this.dwTableColComment = dwTableColComment == null ? null : dwTableColComment.trim();
    }

    public String getDwTablePartitionFlag() {
        return dwTablePartitionFlag;
    }

    public void setDwTablePartitionFlag(String dwTablePartitionFlag) {
        this.dwTablePartitionFlag = dwTablePartitionFlag == null ? null : dwTablePartitionFlag.trim();
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