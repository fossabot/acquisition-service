package com.acquisition.entity;

public class CjDataSourceTabColInfo extends CjDataSourceTabColInfoKey {
    private String businessSystemId;

    private String dataSourceTableComment;

    private String dataSourceColOrder;

    private String dataSourceColPrimarykeyFlag;

    private String dataSourceColIsnullFlag;

    private String dataSourceColDatatype;

    private String dataSourceColLen;

    private String dataSourceColPrecision;

    private String dataSourceColScale;

    private String dataSourceColComment;

    private String dataSourceColDatalakeFlag;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId == null ? null : businessSystemId.trim();
    }

    public String getDataSourceTableComment() {
        return dataSourceTableComment;
    }

    public void setDataSourceTableComment(String dataSourceTableComment) {
        this.dataSourceTableComment = dataSourceTableComment == null ? null : dataSourceTableComment.trim();
    }

    public String getDataSourceColOrder() {
        return dataSourceColOrder;
    }

    public void setDataSourceColOrder(String dataSourceColOrder) {
        this.dataSourceColOrder = dataSourceColOrder == null ? null : dataSourceColOrder.trim();
    }

    public String getDataSourceColPrimarykeyFlag() {
        return dataSourceColPrimarykeyFlag;
    }

    public void setDataSourceColPrimarykeyFlag(String dataSourceColPrimarykeyFlag) {
        this.dataSourceColPrimarykeyFlag = dataSourceColPrimarykeyFlag == null ? null : dataSourceColPrimarykeyFlag.trim();
    }

    public String getDataSourceColIsnullFlag() {
        return dataSourceColIsnullFlag;
    }

    public void setDataSourceColIsnullFlag(String dataSourceColIsnullFlag) {
        this.dataSourceColIsnullFlag = dataSourceColIsnullFlag == null ? null : dataSourceColIsnullFlag.trim();
    }

    public String getDataSourceColDatatype() {
        return dataSourceColDatatype;
    }

    public void setDataSourceColDatatype(String dataSourceColDatatype) {
        this.dataSourceColDatatype = dataSourceColDatatype == null ? null : dataSourceColDatatype.trim();
    }

    public String getDataSourceColLen() {
        return dataSourceColLen;
    }

    public void setDataSourceColLen(String dataSourceColLen) {
        this.dataSourceColLen = dataSourceColLen == null ? null : dataSourceColLen.trim();
    }

    public String getDataSourceColPrecision() {
        return dataSourceColPrecision;
    }

    public void setDataSourceColPrecision(String dataSourceColPrecision) {
        this.dataSourceColPrecision = dataSourceColPrecision == null ? null : dataSourceColPrecision.trim();
    }

    public String getDataSourceColScale() {
        return dataSourceColScale;
    }

    public void setDataSourceColScale(String dataSourceColScale) {
        this.dataSourceColScale = dataSourceColScale == null ? null : dataSourceColScale.trim();
    }

    public String getDataSourceColComment() {
        return dataSourceColComment;
    }

    public void setDataSourceColComment(String dataSourceColComment) {
        this.dataSourceColComment = dataSourceColComment == null ? null : dataSourceColComment.trim();
    }

    public String getDataSourceColDatalakeFlag() {
        return dataSourceColDatalakeFlag;
    }

    public void setDataSourceColDatalakeFlag(String dataSourceColDatalakeFlag) {
        this.dataSourceColDatalakeFlag = dataSourceColDatalakeFlag == null ? null : dataSourceColDatalakeFlag.trim();
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