package com.acquisition.entity;

public class CjOdsCrtTabRuleInfo {
    private String ruleName;

    private String ruleComment;

    private String ruleCatalog;

    private String ruleType;

    private String ruleCol1;

    private String ruleCol2;

    private String ruleCol3;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public String getRuleComment() {
        return ruleComment;
    }

    public void setRuleComment(String ruleComment) {
        this.ruleComment = ruleComment == null ? null : ruleComment.trim();
    }

    public String getRuleCatalog() {
        return ruleCatalog;
    }

    public void setRuleCatalog(String ruleCatalog) {
        this.ruleCatalog = ruleCatalog == null ? null : ruleCatalog.trim();
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType == null ? null : ruleType.trim();
    }

    public String getRuleCol1() {
        return ruleCol1;
    }

    public void setRuleCol1(String ruleCol1) {
        this.ruleCol1 = ruleCol1 == null ? null : ruleCol1.trim();
    }

    public String getRuleCol2() {
        return ruleCol2;
    }

    public void setRuleCol2(String ruleCol2) {
        this.ruleCol2 = ruleCol2 == null ? null : ruleCol2.trim();
    }

    public String getRuleCol3() {
        return ruleCol3;
    }

    public void setRuleCol3(String ruleCol3) {
        this.ruleCol3 = ruleCol3 == null ? null : ruleCol3.trim();
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