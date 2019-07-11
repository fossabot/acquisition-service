package com.acquisition.entity;

public class CjDwTableColMapRelInfo extends CjDwTableColMapRelInfoKey {
    private String sourceTableSchema;

    private String targetTableColOrder;

    private String sourceTableColType;

    private String targetTableColType;

    private String sourceTableColComment;

    private String targetTableColComment;

    private String sourceTargetMappDefine;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getSourceTableSchema() {
        return sourceTableSchema;
    }

    public void setSourceTableSchema(String sourceTableSchema) {
        this.sourceTableSchema = sourceTableSchema == null ? null : sourceTableSchema.trim();
    }

    public String getTargetTableColOrder() {
        return targetTableColOrder;
    }

    public void setTargetTableColOrder(String targetTableColOrder) {
        this.targetTableColOrder = targetTableColOrder == null ? null : targetTableColOrder.trim();
    }

    public String getSourceTableColType() {
        return sourceTableColType;
    }

    public void setSourceTableColType(String sourceTableColType) {
        this.sourceTableColType = sourceTableColType == null ? null : sourceTableColType.trim();
    }

    public String getTargetTableColType() {
        return targetTableColType;
    }

    public void setTargetTableColType(String targetTableColType) {
        this.targetTableColType = targetTableColType == null ? null : targetTableColType.trim();
    }

    public String getSourceTableColComment() {
        return sourceTableColComment;
    }

    public void setSourceTableColComment(String sourceTableColComment) {
        this.sourceTableColComment = sourceTableColComment == null ? null : sourceTableColComment.trim();
    }

    public String getTargetTableColComment() {
        return targetTableColComment;
    }

    public void setTargetTableColComment(String targetTableColComment) {
        this.targetTableColComment = targetTableColComment == null ? null : targetTableColComment.trim();
    }

    public String getSourceTargetMappDefine() {
        return sourceTargetMappDefine;
    }

    public void setSourceTargetMappDefine(String sourceTargetMappDefine) {
        this.sourceTargetMappDefine = sourceTargetMappDefine == null ? null : sourceTargetMappDefine.trim();
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