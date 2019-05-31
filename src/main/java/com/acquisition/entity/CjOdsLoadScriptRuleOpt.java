package com.acquisition.entity;

public class CjOdsLoadScriptRuleOpt extends CjOdsLoadScriptRuleOptKey {
    private String optimizeComment;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getOptimizeComment() {
        return optimizeComment;
    }

    public void setOptimizeComment(String optimizeComment) {
        this.optimizeComment = optimizeComment == null ? null : optimizeComment.trim();
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