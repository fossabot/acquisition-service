package com.acquisition.entity;

public class CjDwTableLoadModeInfo extends CjDwTableLoadModeInfoKey {
    private String dataSourceTabPrimaryCol;

    private String dwTabPrimaryCol;

    private String dwDataLoadMode;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getDataSourceTabPrimaryCol() {
        return dataSourceTabPrimaryCol;
    }

    public void setDataSourceTabPrimaryCol(String dataSourceTabPrimaryCol) {
        this.dataSourceTabPrimaryCol = dataSourceTabPrimaryCol == null ? null : dataSourceTabPrimaryCol.trim();
    }

    public String getDwTabPrimaryCol() {
        return dwTabPrimaryCol;
    }

    public void setDwTabPrimaryCol(String dwTabPrimaryCol) {
        this.dwTabPrimaryCol = dwTabPrimaryCol == null ? null : dwTabPrimaryCol.trim();
    }

    public String getDwDataLoadMode() {
        return dwDataLoadMode;
    }

    public void setDwDataLoadMode(String dwDataLoadMode) {
        this.dwDataLoadMode = dwDataLoadMode == null ? null : dwDataLoadMode.trim();
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