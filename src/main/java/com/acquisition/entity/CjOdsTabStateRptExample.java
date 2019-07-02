package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjOdsTabStateRptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjOdsTabStateRptExample() {
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

        public Criteria andBusinessSystemNameShortNameIsNull() {
            addCriterion("business_system_name_short_name is null");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameIsNotNull() {
            addCriterion("business_system_name_short_name is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameEqualTo(String value) {
            addCriterion("business_system_name_short_name =", value, "businessSystemNameShortName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameNotEqualTo(String value) {
            addCriterion("business_system_name_short_name <>", value, "businessSystemNameShortName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameGreaterThan(String value) {
            addCriterion("business_system_name_short_name >", value, "businessSystemNameShortName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("business_system_name_short_name >=", value, "businessSystemNameShortName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameLessThan(String value) {
            addCriterion("business_system_name_short_name <", value, "businessSystemNameShortName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameLessThanOrEqualTo(String value) {
            addCriterion("business_system_name_short_name <=", value, "businessSystemNameShortName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameLike(String value) {
            addCriterion("business_system_name_short_name like", value, "businessSystemNameShortName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameNotLike(String value) {
            addCriterion("business_system_name_short_name not like", value, "businessSystemNameShortName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameIn(List<String> values) {
            addCriterion("business_system_name_short_name in", values, "businessSystemNameShortName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameNotIn(List<String> values) {
            addCriterion("business_system_name_short_name not in", values, "businessSystemNameShortName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameBetween(String value1, String value2) {
            addCriterion("business_system_name_short_name between", value1, value2, "businessSystemNameShortName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameShortNameNotBetween(String value1, String value2) {
            addCriterion("business_system_name_short_name not between", value1, value2, "businessSystemNameShortName");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaIsNull() {
            addCriterion("data_source_schema is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaIsNotNull() {
            addCriterion("data_source_schema is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaEqualTo(String value) {
            addCriterion("data_source_schema =", value, "dataSourceSchema");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaNotEqualTo(String value) {
            addCriterion("data_source_schema <>", value, "dataSourceSchema");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaGreaterThan(String value) {
            addCriterion("data_source_schema >", value, "dataSourceSchema");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_schema >=", value, "dataSourceSchema");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaLessThan(String value) {
            addCriterion("data_source_schema <", value, "dataSourceSchema");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaLessThanOrEqualTo(String value) {
            addCriterion("data_source_schema <=", value, "dataSourceSchema");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaLike(String value) {
            addCriterion("data_source_schema like", value, "dataSourceSchema");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaNotLike(String value) {
            addCriterion("data_source_schema not like", value, "dataSourceSchema");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaIn(List<String> values) {
            addCriterion("data_source_schema in", values, "dataSourceSchema");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaNotIn(List<String> values) {
            addCriterion("data_source_schema not in", values, "dataSourceSchema");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaBetween(String value1, String value2) {
            addCriterion("data_source_schema between", value1, value2, "dataSourceSchema");
            return (Criteria) this;
        }

        public Criteria andDataSourceSchemaNotBetween(String value1, String value2) {
            addCriterion("data_source_schema not between", value1, value2, "dataSourceSchema");
            return (Criteria) this;
        }

        public Criteria andReportDtIsNull() {
            addCriterion("report_dt is null");
            return (Criteria) this;
        }

        public Criteria andReportDtIsNotNull() {
            addCriterion("report_dt is not null");
            return (Criteria) this;
        }

        public Criteria andReportDtEqualTo(String value) {
            addCriterion("report_dt =", value, "reportDt");
            return (Criteria) this;
        }

        public Criteria andReportDtNotEqualTo(String value) {
            addCriterion("report_dt <>", value, "reportDt");
            return (Criteria) this;
        }

        public Criteria andReportDtGreaterThan(String value) {
            addCriterion("report_dt >", value, "reportDt");
            return (Criteria) this;
        }

        public Criteria andReportDtGreaterThanOrEqualTo(String value) {
            addCriterion("report_dt >=", value, "reportDt");
            return (Criteria) this;
        }

        public Criteria andReportDtLessThan(String value) {
            addCriterion("report_dt <", value, "reportDt");
            return (Criteria) this;
        }

        public Criteria andReportDtLessThanOrEqualTo(String value) {
            addCriterion("report_dt <=", value, "reportDt");
            return (Criteria) this;
        }

        public Criteria andReportDtLike(String value) {
            addCriterion("report_dt like", value, "reportDt");
            return (Criteria) this;
        }

        public Criteria andReportDtNotLike(String value) {
            addCriterion("report_dt not like", value, "reportDt");
            return (Criteria) this;
        }

        public Criteria andReportDtIn(List<String> values) {
            addCriterion("report_dt in", values, "reportDt");
            return (Criteria) this;
        }

        public Criteria andReportDtNotIn(List<String> values) {
            addCriterion("report_dt not in", values, "reportDt");
            return (Criteria) this;
        }

        public Criteria andReportDtBetween(String value1, String value2) {
            addCriterion("report_dt between", value1, value2, "reportDt");
            return (Criteria) this;
        }

        public Criteria andReportDtNotBetween(String value1, String value2) {
            addCriterion("report_dt not between", value1, value2, "reportDt");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdIsNull() {
            addCriterion("business_system_ID is null");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdIsNotNull() {
            addCriterion("business_system_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdEqualTo(String value) {
            addCriterion("business_system_ID =", value, "businessSystemId");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdNotEqualTo(String value) {
            addCriterion("business_system_ID <>", value, "businessSystemId");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdGreaterThan(String value) {
            addCriterion("business_system_ID >", value, "businessSystemId");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("business_system_ID >=", value, "businessSystemId");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdLessThan(String value) {
            addCriterion("business_system_ID <", value, "businessSystemId");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdLessThanOrEqualTo(String value) {
            addCriterion("business_system_ID <=", value, "businessSystemId");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdLike(String value) {
            addCriterion("business_system_ID like", value, "businessSystemId");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdNotLike(String value) {
            addCriterion("business_system_ID not like", value, "businessSystemId");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdIn(List<String> values) {
            addCriterion("business_system_ID in", values, "businessSystemId");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdNotIn(List<String> values) {
            addCriterion("business_system_ID not in", values, "businessSystemId");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdBetween(String value1, String value2) {
            addCriterion("business_system_ID between", value1, value2, "businessSystemId");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemIdNotBetween(String value1, String value2) {
            addCriterion("business_system_ID not between", value1, value2, "businessSystemId");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsIsNull() {
            addCriterion("data_source_tab_nums is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsIsNotNull() {
            addCriterion("data_source_tab_nums is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsEqualTo(String value) {
            addCriterion("data_source_tab_nums =", value, "dataSourceTabNums");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsNotEqualTo(String value) {
            addCriterion("data_source_tab_nums <>", value, "dataSourceTabNums");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsGreaterThan(String value) {
            addCriterion("data_source_tab_nums >", value, "dataSourceTabNums");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_tab_nums >=", value, "dataSourceTabNums");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsLessThan(String value) {
            addCriterion("data_source_tab_nums <", value, "dataSourceTabNums");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsLessThanOrEqualTo(String value) {
            addCriterion("data_source_tab_nums <=", value, "dataSourceTabNums");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsLike(String value) {
            addCriterion("data_source_tab_nums like", value, "dataSourceTabNums");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsNotLike(String value) {
            addCriterion("data_source_tab_nums not like", value, "dataSourceTabNums");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsIn(List<String> values) {
            addCriterion("data_source_tab_nums in", values, "dataSourceTabNums");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsNotIn(List<String> values) {
            addCriterion("data_source_tab_nums not in", values, "dataSourceTabNums");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsBetween(String value1, String value2) {
            addCriterion("data_source_tab_nums between", value1, value2, "dataSourceTabNums");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabNumsNotBetween(String value1, String value2) {
            addCriterion("data_source_tab_nums not between", value1, value2, "dataSourceTabNums");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsIsNull() {
            addCriterion("ods_tab_nums is null");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsIsNotNull() {
            addCriterion("ods_tab_nums is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsEqualTo(String value) {
            addCriterion("ods_tab_nums =", value, "odsTabNums");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsNotEqualTo(String value) {
            addCriterion("ods_tab_nums <>", value, "odsTabNums");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsGreaterThan(String value) {
            addCriterion("ods_tab_nums >", value, "odsTabNums");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsGreaterThanOrEqualTo(String value) {
            addCriterion("ods_tab_nums >=", value, "odsTabNums");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsLessThan(String value) {
            addCriterion("ods_tab_nums <", value, "odsTabNums");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsLessThanOrEqualTo(String value) {
            addCriterion("ods_tab_nums <=", value, "odsTabNums");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsLike(String value) {
            addCriterion("ods_tab_nums like", value, "odsTabNums");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsNotLike(String value) {
            addCriterion("ods_tab_nums not like", value, "odsTabNums");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsIn(List<String> values) {
            addCriterion("ods_tab_nums in", values, "odsTabNums");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsNotIn(List<String> values) {
            addCriterion("ods_tab_nums not in", values, "odsTabNums");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsBetween(String value1, String value2) {
            addCriterion("ods_tab_nums between", value1, value2, "odsTabNums");
            return (Criteria) this;
        }

        public Criteria andOdsTabNumsNotBetween(String value1, String value2) {
            addCriterion("ods_tab_nums not between", value1, value2, "odsTabNums");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsIsNull() {
            addCriterion("dw_tab_nums is null");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsIsNotNull() {
            addCriterion("dw_tab_nums is not null");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsEqualTo(String value) {
            addCriterion("dw_tab_nums =", value, "dwTabNums");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsNotEqualTo(String value) {
            addCriterion("dw_tab_nums <>", value, "dwTabNums");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsGreaterThan(String value) {
            addCriterion("dw_tab_nums >", value, "dwTabNums");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsGreaterThanOrEqualTo(String value) {
            addCriterion("dw_tab_nums >=", value, "dwTabNums");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsLessThan(String value) {
            addCriterion("dw_tab_nums <", value, "dwTabNums");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsLessThanOrEqualTo(String value) {
            addCriterion("dw_tab_nums <=", value, "dwTabNums");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsLike(String value) {
            addCriterion("dw_tab_nums like", value, "dwTabNums");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsNotLike(String value) {
            addCriterion("dw_tab_nums not like", value, "dwTabNums");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsIn(List<String> values) {
            addCriterion("dw_tab_nums in", values, "dwTabNums");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsNotIn(List<String> values) {
            addCriterion("dw_tab_nums not in", values, "dwTabNums");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsBetween(String value1, String value2) {
            addCriterion("dw_tab_nums between", value1, value2, "dwTabNums");
            return (Criteria) this;
        }

        public Criteria andDwTabNumsNotBetween(String value1, String value2) {
            addCriterion("dw_tab_nums not between", value1, value2, "dwTabNums");
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