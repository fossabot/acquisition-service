package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjOdsCrtTabRuleInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjOdsCrtTabRuleInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRuleNameIsNull() {
            addCriterion("rule_name is null");
            return (Criteria) this;
        }

        public Criteria andRuleNameIsNotNull() {
            addCriterion("rule_name is not null");
            return (Criteria) this;
        }

        public Criteria andRuleNameEqualTo(String value) {
            addCriterion("rule_name =", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotEqualTo(String value) {
            addCriterion("rule_name <>", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameGreaterThan(String value) {
            addCriterion("rule_name >", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("rule_name >=", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLessThan(String value) {
            addCriterion("rule_name <", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLessThanOrEqualTo(String value) {
            addCriterion("rule_name <=", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLike(String value) {
            addCriterion("rule_name like", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotLike(String value) {
            addCriterion("rule_name not like", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameIn(List<String> values) {
            addCriterion("rule_name in", values, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotIn(List<String> values) {
            addCriterion("rule_name not in", values, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameBetween(String value1, String value2) {
            addCriterion("rule_name between", value1, value2, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotBetween(String value1, String value2) {
            addCriterion("rule_name not between", value1, value2, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleCommentIsNull() {
            addCriterion("rule_comment is null");
            return (Criteria) this;
        }

        public Criteria andRuleCommentIsNotNull() {
            addCriterion("rule_comment is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCommentEqualTo(String value) {
            addCriterion("rule_comment =", value, "ruleComment");
            return (Criteria) this;
        }

        public Criteria andRuleCommentNotEqualTo(String value) {
            addCriterion("rule_comment <>", value, "ruleComment");
            return (Criteria) this;
        }

        public Criteria andRuleCommentGreaterThan(String value) {
            addCriterion("rule_comment >", value, "ruleComment");
            return (Criteria) this;
        }

        public Criteria andRuleCommentGreaterThanOrEqualTo(String value) {
            addCriterion("rule_comment >=", value, "ruleComment");
            return (Criteria) this;
        }

        public Criteria andRuleCommentLessThan(String value) {
            addCriterion("rule_comment <", value, "ruleComment");
            return (Criteria) this;
        }

        public Criteria andRuleCommentLessThanOrEqualTo(String value) {
            addCriterion("rule_comment <=", value, "ruleComment");
            return (Criteria) this;
        }

        public Criteria andRuleCommentLike(String value) {
            addCriterion("rule_comment like", value, "ruleComment");
            return (Criteria) this;
        }

        public Criteria andRuleCommentNotLike(String value) {
            addCriterion("rule_comment not like", value, "ruleComment");
            return (Criteria) this;
        }

        public Criteria andRuleCommentIn(List<String> values) {
            addCriterion("rule_comment in", values, "ruleComment");
            return (Criteria) this;
        }

        public Criteria andRuleCommentNotIn(List<String> values) {
            addCriterion("rule_comment not in", values, "ruleComment");
            return (Criteria) this;
        }

        public Criteria andRuleCommentBetween(String value1, String value2) {
            addCriterion("rule_comment between", value1, value2, "ruleComment");
            return (Criteria) this;
        }

        public Criteria andRuleCommentNotBetween(String value1, String value2) {
            addCriterion("rule_comment not between", value1, value2, "ruleComment");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogIsNull() {
            addCriterion("rule_catalog is null");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogIsNotNull() {
            addCriterion("rule_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogEqualTo(String value) {
            addCriterion("rule_catalog =", value, "ruleCatalog");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogNotEqualTo(String value) {
            addCriterion("rule_catalog <>", value, "ruleCatalog");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogGreaterThan(String value) {
            addCriterion("rule_catalog >", value, "ruleCatalog");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("rule_catalog >=", value, "ruleCatalog");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogLessThan(String value) {
            addCriterion("rule_catalog <", value, "ruleCatalog");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogLessThanOrEqualTo(String value) {
            addCriterion("rule_catalog <=", value, "ruleCatalog");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogLike(String value) {
            addCriterion("rule_catalog like", value, "ruleCatalog");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogNotLike(String value) {
            addCriterion("rule_catalog not like", value, "ruleCatalog");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogIn(List<String> values) {
            addCriterion("rule_catalog in", values, "ruleCatalog");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogNotIn(List<String> values) {
            addCriterion("rule_catalog not in", values, "ruleCatalog");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogBetween(String value1, String value2) {
            addCriterion("rule_catalog between", value1, value2, "ruleCatalog");
            return (Criteria) this;
        }

        public Criteria andRuleCatalogNotBetween(String value1, String value2) {
            addCriterion("rule_catalog not between", value1, value2, "ruleCatalog");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIsNull() {
            addCriterion("rule_type is null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIsNotNull() {
            addCriterion("rule_type is not null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeEqualTo(String value) {
            addCriterion("rule_type =", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotEqualTo(String value) {
            addCriterion("rule_type <>", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeGreaterThan(String value) {
            addCriterion("rule_type >", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rule_type >=", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeLessThan(String value) {
            addCriterion("rule_type <", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeLessThanOrEqualTo(String value) {
            addCriterion("rule_type <=", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeLike(String value) {
            addCriterion("rule_type like", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotLike(String value) {
            addCriterion("rule_type not like", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIn(List<String> values) {
            addCriterion("rule_type in", values, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotIn(List<String> values) {
            addCriterion("rule_type not in", values, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeBetween(String value1, String value2) {
            addCriterion("rule_type between", value1, value2, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotBetween(String value1, String value2) {
            addCriterion("rule_type not between", value1, value2, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleCol1IsNull() {
            addCriterion("rule_col_1 is null");
            return (Criteria) this;
        }

        public Criteria andRuleCol1IsNotNull() {
            addCriterion("rule_col_1 is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCol1EqualTo(String value) {
            addCriterion("rule_col_1 =", value, "ruleCol1");
            return (Criteria) this;
        }

        public Criteria andRuleCol1NotEqualTo(String value) {
            addCriterion("rule_col_1 <>", value, "ruleCol1");
            return (Criteria) this;
        }

        public Criteria andRuleCol1GreaterThan(String value) {
            addCriterion("rule_col_1 >", value, "ruleCol1");
            return (Criteria) this;
        }

        public Criteria andRuleCol1GreaterThanOrEqualTo(String value) {
            addCriterion("rule_col_1 >=", value, "ruleCol1");
            return (Criteria) this;
        }

        public Criteria andRuleCol1LessThan(String value) {
            addCriterion("rule_col_1 <", value, "ruleCol1");
            return (Criteria) this;
        }

        public Criteria andRuleCol1LessThanOrEqualTo(String value) {
            addCriterion("rule_col_1 <=", value, "ruleCol1");
            return (Criteria) this;
        }

        public Criteria andRuleCol1Like(String value) {
            addCriterion("rule_col_1 like", value, "ruleCol1");
            return (Criteria) this;
        }

        public Criteria andRuleCol1NotLike(String value) {
            addCriterion("rule_col_1 not like", value, "ruleCol1");
            return (Criteria) this;
        }

        public Criteria andRuleCol1In(List<String> values) {
            addCriterion("rule_col_1 in", values, "ruleCol1");
            return (Criteria) this;
        }

        public Criteria andRuleCol1NotIn(List<String> values) {
            addCriterion("rule_col_1 not in", values, "ruleCol1");
            return (Criteria) this;
        }

        public Criteria andRuleCol1Between(String value1, String value2) {
            addCriterion("rule_col_1 between", value1, value2, "ruleCol1");
            return (Criteria) this;
        }

        public Criteria andRuleCol1NotBetween(String value1, String value2) {
            addCriterion("rule_col_1 not between", value1, value2, "ruleCol1");
            return (Criteria) this;
        }

        public Criteria andRuleCol2IsNull() {
            addCriterion("rule_col_2 is null");
            return (Criteria) this;
        }

        public Criteria andRuleCol2IsNotNull() {
            addCriterion("rule_col_2 is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCol2EqualTo(String value) {
            addCriterion("rule_col_2 =", value, "ruleCol2");
            return (Criteria) this;
        }

        public Criteria andRuleCol2NotEqualTo(String value) {
            addCriterion("rule_col_2 <>", value, "ruleCol2");
            return (Criteria) this;
        }

        public Criteria andRuleCol2GreaterThan(String value) {
            addCriterion("rule_col_2 >", value, "ruleCol2");
            return (Criteria) this;
        }

        public Criteria andRuleCol2GreaterThanOrEqualTo(String value) {
            addCriterion("rule_col_2 >=", value, "ruleCol2");
            return (Criteria) this;
        }

        public Criteria andRuleCol2LessThan(String value) {
            addCriterion("rule_col_2 <", value, "ruleCol2");
            return (Criteria) this;
        }

        public Criteria andRuleCol2LessThanOrEqualTo(String value) {
            addCriterion("rule_col_2 <=", value, "ruleCol2");
            return (Criteria) this;
        }

        public Criteria andRuleCol2Like(String value) {
            addCriterion("rule_col_2 like", value, "ruleCol2");
            return (Criteria) this;
        }

        public Criteria andRuleCol2NotLike(String value) {
            addCriterion("rule_col_2 not like", value, "ruleCol2");
            return (Criteria) this;
        }

        public Criteria andRuleCol2In(List<String> values) {
            addCriterion("rule_col_2 in", values, "ruleCol2");
            return (Criteria) this;
        }

        public Criteria andRuleCol2NotIn(List<String> values) {
            addCriterion("rule_col_2 not in", values, "ruleCol2");
            return (Criteria) this;
        }

        public Criteria andRuleCol2Between(String value1, String value2) {
            addCriterion("rule_col_2 between", value1, value2, "ruleCol2");
            return (Criteria) this;
        }

        public Criteria andRuleCol2NotBetween(String value1, String value2) {
            addCriterion("rule_col_2 not between", value1, value2, "ruleCol2");
            return (Criteria) this;
        }

        public Criteria andRuleCol3IsNull() {
            addCriterion("rule_col_3 is null");
            return (Criteria) this;
        }

        public Criteria andRuleCol3IsNotNull() {
            addCriterion("rule_col_3 is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCol3EqualTo(String value) {
            addCriterion("rule_col_3 =", value, "ruleCol3");
            return (Criteria) this;
        }

        public Criteria andRuleCol3NotEqualTo(String value) {
            addCriterion("rule_col_3 <>", value, "ruleCol3");
            return (Criteria) this;
        }

        public Criteria andRuleCol3GreaterThan(String value) {
            addCriterion("rule_col_3 >", value, "ruleCol3");
            return (Criteria) this;
        }

        public Criteria andRuleCol3GreaterThanOrEqualTo(String value) {
            addCriterion("rule_col_3 >=", value, "ruleCol3");
            return (Criteria) this;
        }

        public Criteria andRuleCol3LessThan(String value) {
            addCriterion("rule_col_3 <", value, "ruleCol3");
            return (Criteria) this;
        }

        public Criteria andRuleCol3LessThanOrEqualTo(String value) {
            addCriterion("rule_col_3 <=", value, "ruleCol3");
            return (Criteria) this;
        }

        public Criteria andRuleCol3Like(String value) {
            addCriterion("rule_col_3 like", value, "ruleCol3");
            return (Criteria) this;
        }

        public Criteria andRuleCol3NotLike(String value) {
            addCriterion("rule_col_3 not like", value, "ruleCol3");
            return (Criteria) this;
        }

        public Criteria andRuleCol3In(List<String> values) {
            addCriterion("rule_col_3 in", values, "ruleCol3");
            return (Criteria) this;
        }

        public Criteria andRuleCol3NotIn(List<String> values) {
            addCriterion("rule_col_3 not in", values, "ruleCol3");
            return (Criteria) this;
        }

        public Criteria andRuleCol3Between(String value1, String value2) {
            addCriterion("rule_col_3 between", value1, value2, "ruleCol3");
            return (Criteria) this;
        }

        public Criteria andRuleCol3NotBetween(String value1, String value2) {
            addCriterion("rule_col_3 not between", value1, value2, "ruleCol3");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtIsNull() {
            addCriterion("last_modify_dt is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtIsNotNull() {
            addCriterion("last_modify_dt is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtEqualTo(String value) {
            addCriterion("last_modify_dt =", value, "lastModifyDt");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtNotEqualTo(String value) {
            addCriterion("last_modify_dt <>", value, "lastModifyDt");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtGreaterThan(String value) {
            addCriterion("last_modify_dt >", value, "lastModifyDt");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtGreaterThanOrEqualTo(String value) {
            addCriterion("last_modify_dt >=", value, "lastModifyDt");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtLessThan(String value) {
            addCriterion("last_modify_dt <", value, "lastModifyDt");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtLessThanOrEqualTo(String value) {
            addCriterion("last_modify_dt <=", value, "lastModifyDt");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtLike(String value) {
            addCriterion("last_modify_dt like", value, "lastModifyDt");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtNotLike(String value) {
            addCriterion("last_modify_dt not like", value, "lastModifyDt");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtIn(List<String> values) {
            addCriterion("last_modify_dt in", values, "lastModifyDt");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtNotIn(List<String> values) {
            addCriterion("last_modify_dt not in", values, "lastModifyDt");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtBetween(String value1, String value2) {
            addCriterion("last_modify_dt between", value1, value2, "lastModifyDt");
            return (Criteria) this;
        }

        public Criteria andLastModifyDtNotBetween(String value1, String value2) {
            addCriterion("last_modify_dt not between", value1, value2, "lastModifyDt");
            return (Criteria) this;
        }

        public Criteria andLastModifyByIsNull() {
            addCriterion("last_modify_by is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyByIsNotNull() {
            addCriterion("last_modify_by is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyByEqualTo(String value) {
            addCriterion("last_modify_by =", value, "lastModifyBy");
            return (Criteria) this;
        }

        public Criteria andLastModifyByNotEqualTo(String value) {
            addCriterion("last_modify_by <>", value, "lastModifyBy");
            return (Criteria) this;
        }

        public Criteria andLastModifyByGreaterThan(String value) {
            addCriterion("last_modify_by >", value, "lastModifyBy");
            return (Criteria) this;
        }

        public Criteria andLastModifyByGreaterThanOrEqualTo(String value) {
            addCriterion("last_modify_by >=", value, "lastModifyBy");
            return (Criteria) this;
        }

        public Criteria andLastModifyByLessThan(String value) {
            addCriterion("last_modify_by <", value, "lastModifyBy");
            return (Criteria) this;
        }

        public Criteria andLastModifyByLessThanOrEqualTo(String value) {
            addCriterion("last_modify_by <=", value, "lastModifyBy");
            return (Criteria) this;
        }

        public Criteria andLastModifyByLike(String value) {
            addCriterion("last_modify_by like", value, "lastModifyBy");
            return (Criteria) this;
        }

        public Criteria andLastModifyByNotLike(String value) {
            addCriterion("last_modify_by not like", value, "lastModifyBy");
            return (Criteria) this;
        }

        public Criteria andLastModifyByIn(List<String> values) {
            addCriterion("last_modify_by in", values, "lastModifyBy");
            return (Criteria) this;
        }

        public Criteria andLastModifyByNotIn(List<String> values) {
            addCriterion("last_modify_by not in", values, "lastModifyBy");
            return (Criteria) this;
        }

        public Criteria andLastModifyByBetween(String value1, String value2) {
            addCriterion("last_modify_by between", value1, value2, "lastModifyBy");
            return (Criteria) this;
        }

        public Criteria andLastModifyByNotBetween(String value1, String value2) {
            addCriterion("last_modify_by not between", value1, value2, "lastModifyBy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}