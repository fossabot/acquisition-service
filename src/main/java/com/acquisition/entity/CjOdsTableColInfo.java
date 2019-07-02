package com.acquisition.entity;

public class CjOdsTableColInfo extends CjOdsTableColInfoKey {
    private String businessSystemId;

    private String odsDataSchema;

    private String odsTableComment;

    private String odsTableColOrder;

    private String odsTableColType;

    private String odsTableColComment;

    private String odsTablePartitionFlag;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId == null ? null : businessSystemId.trim();
    }

    public String getOdsDataSchema() {
        return odsDataSchema;
    }

    public void setOdsDataSchema(String odsDataSchema) {
        this.odsDataSchema = odsDataSchema == null ? null : odsDataSchema.trim();
    }

    public String getOdsTableComment() {
        return odsTableComment;
    }

    public void setOdsTableComment(String odsTableComment) {
        this.odsTableComment = odsTableComment == null ? null : odsTableComment.trim();
    }

    public String getOdsTableColOrder() {
        return odsTableColOrder;
    }

    public void setOdsTableColOrder(String odsTableColOrder) {
        this.odsTableColOrder = odsTableColOrder == null ? null : odsTableColOrder.trim();
    }

    public String getOdsTableColType() {
        return odsTableColType;
    }

    public void setOdsTableColType(String odsTableColType) {
        this.odsTableColType = odsTableColType == null ? null : odsTableColType.trim();
    }

    public String getOdsTableColComment() {
        return odsTableColComment;
    }

    public void setOdsTableColComment(String odsTableColComment) {
        this.odsTableColComment = odsTableColComment == null ? null : odsTableColComment.trim();
    }

    public String getOdsTablePartitionFlag() {
        return odsTablePartitionFlag;
    }

    public void setOdsTablePartitionFlag(String odsTablePartitionFlag) {
        this.odsTablePartitionFlag = odsTablePartitionFlag == null ? null : odsTablePartitionFlag.trim();
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