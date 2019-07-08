package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjDwOdsMapInitInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjDwOdsMapInitInfoExample() {
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

        public Criteria andOdsDataTableIsNull() {
            addCriterion("ods_data_table is null");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableIsNotNull() {
            addCriterion("ods_data_table is not null");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableEqualTo(String value) {
            addCriterion("ods_data_table =", value, "odsDataTable");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableNotEqualTo(String value) {
            addCriterion("ods_data_table <>", value, "odsDataTable");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableGreaterThan(String value) {
            addCriterion("ods_data_table >", value, "odsDataTable");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableGreaterThanOrEqualTo(String value) {
            addCriterion("ods_data_table >=", value, "odsDataTable");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableLessThan(String value) {
            addCriterion("ods_data_table <", value, "odsDataTable");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableLessThanOrEqualTo(String value) {
            addCriterion("ods_data_table <=", value, "odsDataTable");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableLike(String value) {
            addCriterion("ods_data_table like", value, "odsDataTable");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableNotLike(String value) {
            addCriterion("ods_data_table not like", value, "odsDataTable");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableIn(List<String> values) {
            addCriterion("ods_data_table in", values, "odsDataTable");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableNotIn(List<String> values) {
            addCriterion("ods_data_table not in", values, "odsDataTable");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableBetween(String value1, String value2) {
            addCriterion("ods_data_table between", value1, value2, "odsDataTable");
            return (Criteria) this;
        }

        public Criteria andOdsDataTableNotBetween(String value1, String value2) {
            addCriterion("ods_data_table not between", value1, value2, "odsDataTable");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableIsNull() {
            addCriterion("dw_spare_table is null");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableIsNotNull() {
            addCriterion("dw_spare_table is not null");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableEqualTo(String value) {
            addCriterion("dw_spare_table =", value, "dwSpareTable");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableNotEqualTo(String value) {
            addCriterion("dw_spare_table <>", value, "dwSpareTable");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableGreaterThan(String value) {
            addCriterion("dw_spare_table >", value, "dwSpareTable");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableGreaterThanOrEqualTo(String value) {
            addCriterion("dw_spare_table >=", value, "dwSpareTable");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableLessThan(String value) {
            addCriterion("dw_spare_table <", value, "dwSpareTable");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableLessThanOrEqualTo(String value) {
            addCriterion("dw_spare_table <=", value, "dwSpareTable");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableLike(String value) {
            addCriterion("dw_spare_table like", value, "dwSpareTable");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableNotLike(String value) {
            addCriterion("dw_spare_table not like", value, "dwSpareTable");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableIn(List<String> values) {
            addCriterion("dw_spare_table in", values, "dwSpareTable");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableNotIn(List<String> values) {
            addCriterion("dw_spare_table not in", values, "dwSpareTable");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableBetween(String value1, String value2) {
            addCriterion("dw_spare_table between", value1, value2, "dwSpareTable");
            return (Criteria) this;
        }

        public Criteria andDwSpareTableNotBetween(String value1, String value2) {
            addCriterion("dw_spare_table not between", value1, value2, "dwSpareTable");
            return (Criteria) this;
        }

        public Criteria andDwDataTableIsNull() {
            addCriterion("dw_data_table is null");
            return (Criteria) this;
        }

        public Criteria andDwDataTableIsNotNull() {
            addCriterion("dw_data_table is not null");
            return (Criteria) this;
        }

        public Criteria andDwDataTableEqualTo(String value) {
            addCriterion("dw_data_table =", value, "dwDataTable");
            return (Criteria) this;
        }

        public Criteria andDwDataTableNotEqualTo(String value) {
            addCriterion("dw_data_table <>", value, "dwDataTable");
            return (Criteria) this;
        }

        public Criteria andDwDataTableGreaterThan(String value) {
            addCriterion("dw_data_table >", value, "dwDataTable");
            return (Criteria) this;
        }

        public Criteria andDwDataTableGreaterThanOrEqualTo(String value) {
            addCriterion("dw_data_table >=", value, "dwDataTable");
            return (Criteria) this;
        }

        public Criteria andDwDataTableLessThan(String value) {
            addCriterion("dw_data_table <", value, "dwDataTable");
            return (Criteria) this;
        }

        public Criteria andDwDataTableLessThanOrEqualTo(String value) {
            addCriterion("dw_data_table <=", value, "dwDataTable");
            return (Criteria) this;
        }

        public Criteria andDwDataTableLike(String value) {
            addCriterion("dw_data_table like", value, "dwDataTable");
            return (Criteria) this;
        }

        public Criteria andDwDataTableNotLike(String value) {
            addCriterion("dw_data_table not like", value, "dwDataTable");
            return (Criteria) this;
        }

        public Criteria andDwDataTableIn(List<String> values) {
            addCriterion("dw_data_table in", values, "dwDataTable");
            return (Criteria) this;
        }

        public Criteria andDwDataTableNotIn(List<String> values) {
            addCriterion("dw_data_table not in", values, "dwDataTable");
            return (Criteria) this;
        }

        public Criteria andDwDataTableBetween(String value1, String value2) {
            addCriterion("dw_data_table between", value1, value2, "dwDataTable");
            return (Criteria) this;
        }

        public Criteria andDwDataTableNotBetween(String value1, String value2) {
            addCriterion("dw_data_table not between", value1, value2, "dwDataTable");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainIsNull() {
            addCriterion("dw_business_topic_domain is null");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainIsNotNull() {
            addCriterion("dw_business_topic_domain is not null");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainEqualTo(String value) {
            addCriterion("dw_business_topic_domain =", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainNotEqualTo(String value) {
            addCriterion("dw_business_topic_domain <>", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainGreaterThan(String value) {
            addCriterion("dw_business_topic_domain >", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainGreaterThanOrEqualTo(String value) {
            addCriterion("dw_business_topic_domain >=", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainLessThan(String value) {
            addCriterion("dw_business_topic_domain <", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainLessThanOrEqualTo(String value) {
            addCriterion("dw_business_topic_domain <=", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainLike(String value) {
            addCriterion("dw_business_topic_domain like", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainNotLike(String value) {
            addCriterion("dw_business_topic_domain not like", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainIn(List<String> values) {
            addCriterion("dw_business_topic_domain in", values, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainNotIn(List<String> values) {
            addCriterion("dw_business_topic_domain not in", values, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainBetween(String value1, String value2) {
            addCriterion("dw_business_topic_domain between", value1, value2, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainNotBetween(String value1, String value2) {
            addCriterion("dw_business_topic_domain not between", value1, value2, "dwBusinessTopicDomain");
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