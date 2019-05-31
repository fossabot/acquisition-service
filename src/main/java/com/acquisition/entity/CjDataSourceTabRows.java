package com.acquisition.entity;

public class CjDataSourceTabRows extends CjDataSourceTabRowsKey {
    private String businessSystemId;

    private String dataSourceTabRows;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId == null ? null : businessSystemId.trim();
    }

    public String getDataSourceTabRows() {
        return dataSourceTabRows;
    }

    public void setDataSourceTabRows(String dataSourceTabRows) {
        this.dataSourceTabRows = dataSourceTabRows == null ? null : dataSourceTabRows.trim();
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