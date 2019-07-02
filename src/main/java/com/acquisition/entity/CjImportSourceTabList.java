package com.acquisition.entity;

public class CjImportSourceTabList extends CjImportSourceTabListKey {
    private String importDataBatch;

    private String businessSystemId;

    private String dataSourceTableFlag;

    private String importDataFileName;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getImportDataBatch() {
        return importDataBatch;
    }

    public void setImportDataBatch(String importDataBatch) {
        this.importDataBatch = importDataBatch == null ? null : importDataBatch.trim();
    }

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId == null ? null : businessSystemId.trim();
    }

    public String getDataSourceTableFlag() {
        return dataSourceTableFlag;
    }

    public void setDataSourceTableFlag(String dataSourceTableFlag) {
        this.dataSourceTableFlag = dataSourceTableFlag == null ? null : dataSourceTableFlag.trim();
    }

    public String getImportDataFileName() {
        return importDataFileName;
    }

    public void setImportDataFileName(String importDataFileName) {
        this.importDataFileName = importDataFileName == null ? null : importDataFileName.trim();
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