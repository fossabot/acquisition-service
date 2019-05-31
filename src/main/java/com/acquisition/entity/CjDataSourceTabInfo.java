package com.acquisition.entity;

public class CjDataSourceTabInfo extends CjDataSourceTabInfoKey {
    private String businessSystemId;

    private String dataSourceTableComment;

    private String dataFlagForGetCols;

    private String dataFlagForGetRows;

    private String dataFlagForCrtOdsDll;

    private String dataFlagForCrtOdsHive;

    private String dataFlagForCrtDwDll;

    private String dataFlagForCrtDwHive;

    private String dataFlagForCrtOdsScript;

    private String dataFlagForCrtDwScript;

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

    public String getDataFlagForGetCols() {
        return dataFlagForGetCols;
    }

    public void setDataFlagForGetCols(String dataFlagForGetCols) {
        this.dataFlagForGetCols = dataFlagForGetCols == null ? null : dataFlagForGetCols.trim();
    }

    public String getDataFlagForGetRows() {
        return dataFlagForGetRows;
    }

    public void setDataFlagForGetRows(String dataFlagForGetRows) {
        this.dataFlagForGetRows = dataFlagForGetRows == null ? null : dataFlagForGetRows.trim();
    }

    public String getDataFlagForCrtOdsDll() {
        return dataFlagForCrtOdsDll;
    }

    public void setDataFlagForCrtOdsDll(String dataFlagForCrtOdsDll) {
        this.dataFlagForCrtOdsDll = dataFlagForCrtOdsDll == null ? null : dataFlagForCrtOdsDll.trim();
    }

    public String getDataFlagForCrtOdsHive() {
        return dataFlagForCrtOdsHive;
    }

    public void setDataFlagForCrtOdsHive(String dataFlagForCrtOdsHive) {
        this.dataFlagForCrtOdsHive = dataFlagForCrtOdsHive == null ? null : dataFlagForCrtOdsHive.trim();
    }

    public String getDataFlagForCrtDwDll() {
        return dataFlagForCrtDwDll;
    }

    public void setDataFlagForCrtDwDll(String dataFlagForCrtDwDll) {
        this.dataFlagForCrtDwDll = dataFlagForCrtDwDll == null ? null : dataFlagForCrtDwDll.trim();
    }

    public String getDataFlagForCrtDwHive() {
        return dataFlagForCrtDwHive;
    }

    public void setDataFlagForCrtDwHive(String dataFlagForCrtDwHive) {
        this.dataFlagForCrtDwHive = dataFlagForCrtDwHive == null ? null : dataFlagForCrtDwHive.trim();
    }

    public String getDataFlagForCrtOdsScript() {
        return dataFlagForCrtOdsScript;
    }

    public void setDataFlagForCrtOdsScript(String dataFlagForCrtOdsScript) {
        this.dataFlagForCrtOdsScript = dataFlagForCrtOdsScript == null ? null : dataFlagForCrtOdsScript.trim();
    }

    public String getDataFlagForCrtDwScript() {
        return dataFlagForCrtDwScript;
    }

    public void setDataFlagForCrtDwScript(String dataFlagForCrtDwScript) {
        this.dataFlagForCrtDwScript = dataFlagForCrtDwScript == null ? null : dataFlagForCrtDwScript.trim();
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