package com.acquisition.entity.pojo;

public class CjDwCrtDdlColPojo {
    private String businessSystemId;

    private String businessSystemNameShortName;

    private String dataSourceSchema;

    private String dataSourceTable;

    private String dataSourceTableComment;

    private String dataSourceColPrimarykeyFlag;

    private String dataSourceColIsnullFlag;

    private String dataSourceColName;

    private String dataSourceColDatatype;

    private String dataSourceColLen;

    private String dataSourceColPrecision;

    private String dataSourceColScale;

    private String dataSourceColComment;

    private String colMapper;

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId == null ? null : businessSystemId.trim();
    }

    public String getDataSourceTable() {
        return dataSourceTable;
    }

    public void setDataSourceTable(String dataSourceTable) {
        this.dataSourceTable = dataSourceTable;
    }

    public String getBusinessSystemNameShortName() {
        return businessSystemNameShortName;
    }

    public void setBusinessSystemNameShortName(String businessSystemNameShortName) {
        this.businessSystemNameShortName = businessSystemNameShortName;
    }

    public String getDataSourceColName() {
        return dataSourceColName;
    }

    public void setDataSourceColName(String dataSourceColName) {
        this.dataSourceColName = dataSourceColName;
    }

    public String getDataSourceSchema() {
        return dataSourceSchema;
    }

    public void setDataSourceSchema(String dataSourceSchema) {
        this.dataSourceSchema = dataSourceSchema;
    }

    public String getColMapper() {
        return colMapper;
    }

    public void setColMapper(String colMapper) {
        this.colMapper = colMapper;
    }

    public String getDataSourceTableComment() {
        return dataSourceTableComment;
    }

    public void setDataSourceTableComment(String dataSourceTableComment) {
        this.dataSourceTableComment = dataSourceTableComment == null ? null : dataSourceTableComment.trim();
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

}