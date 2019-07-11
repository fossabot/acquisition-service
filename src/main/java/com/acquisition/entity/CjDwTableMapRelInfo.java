package com.acquisition.entity;

public class CjDwTableMapRelInfo extends CjDwTableMapRelInfoKey {
    private String sourceTableSchema;

    private String sourceTableAliasName;

    private String joinTableSchema;

    private String joinTableAliasName;

    private String joinTableCondition;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getSourceTableSchema() {
        return sourceTableSchema;
    }

    public void setSourceTableSchema(String sourceTableSchema) {
        this.sourceTableSchema = sourceTableSchema == null ? null : sourceTableSchema.trim();
    }

    public String getSourceTableAliasName() {
        return sourceTableAliasName;
    }

    public void setSourceTableAliasName(String sourceTableAliasName) {
        this.sourceTableAliasName = sourceTableAliasName == null ? null : sourceTableAliasName.trim();
    }

    public String getJoinTableSchema() {
        return joinTableSchema;
    }

    public void setJoinTableSchema(String joinTableSchema) {
        this.joinTableSchema = joinTableSchema == null ? null : joinTableSchema.trim();
    }

    public String getJoinTableAliasName() {
        return joinTableAliasName;
    }

    public void setJoinTableAliasName(String joinTableAliasName) {
        this.joinTableAliasName = joinTableAliasName == null ? null : joinTableAliasName.trim();
    }

    public String getJoinTableCondition() {
        return joinTableCondition;
    }

    public void setJoinTableCondition(String joinTableCondition) {
        this.joinTableCondition = joinTableCondition == null ? null : joinTableCondition.trim();
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