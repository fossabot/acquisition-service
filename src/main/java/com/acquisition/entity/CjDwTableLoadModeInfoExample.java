package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjDwTableLoadModeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjDwTableLoadModeInfoExample() {
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

        public Criteria andDwTablePartitionColNameIsNull() {
            addCriterion("dw_table_partition_col_name is null");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameIsNotNull() {
            addCriterion("dw_table_partition_col_name is not null");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameEqualTo(String value) {
            addCriterion("dw_table_partition_col_name =", value, "dwTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameNotEqualTo(String value) {
            addCriterion("dw_table_partition_col_name <>", value, "dwTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameGreaterThan(String value) {
            addCriterion("dw_table_partition_col_name >", value, "dwTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameGreaterThanOrEqualTo(String value) {
            addCriterion("dw_table_partition_col_name >=", value, "dwTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameLessThan(String value) {
            addCriterion("dw_table_partition_col_name <", value, "dwTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameLessThanOrEqualTo(String value) {
            addCriterion("dw_table_partition_col_name <=", value, "dwTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameLike(String value) {
            addCriterion("dw_table_partition_col_name like", value, "dwTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameNotLike(String value) {
            addCriterion("dw_table_partition_col_name not like", value, "dwTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameIn(List<String> values) {
            addCriterion("dw_table_partition_col_name in", values, "dwTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameNotIn(List<String> values) {
            addCriterion("dw_table_partition_col_name not in", values, "dwTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameBetween(String value1, String value2) {
            addCriterion("dw_table_partition_col_name between", value1, value2, "dwTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionColNameNotBetween(String value1, String value2) {
            addCriterion("dw_table_partition_col_name not between", value1, value2, "dwTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColIsNull() {
            addCriterion("data_source_tab_primary_col is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColIsNotNull() {
            addCriterion("data_source_tab_primary_col is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColEqualTo(String value) {
            addCriterion("data_source_tab_primary_col =", value, "dataSourceTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColNotEqualTo(String value) {
            addCriterion("data_source_tab_primary_col <>", value, "dataSourceTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColGreaterThan(String value) {
            addCriterion("data_source_tab_primary_col >", value, "dataSourceTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_tab_primary_col >=", value, "dataSourceTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColLessThan(String value) {
            addCriterion("data_source_tab_primary_col <", value, "dataSourceTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColLessThanOrEqualTo(String value) {
            addCriterion("data_source_tab_primary_col <=", value, "dataSourceTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColLike(String value) {
            addCriterion("data_source_tab_primary_col like", value, "dataSourceTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColNotLike(String value) {
            addCriterion("data_source_tab_primary_col not like", value, "dataSourceTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColIn(List<String> values) {
            addCriterion("data_source_tab_primary_col in", values, "dataSourceTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColNotIn(List<String> values) {
            addCriterion("data_source_tab_primary_col not in", values, "dataSourceTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColBetween(String value1, String value2) {
            addCriterion("data_source_tab_primary_col between", value1, value2, "dataSourceTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDataSourceTabPrimaryColNotBetween(String value1, String value2) {
            addCriterion("data_source_tab_primary_col not between", value1, value2, "dataSourceTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColIsNull() {
            addCriterion("dw_tab_primary_col is null");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColIsNotNull() {
            addCriterion("dw_tab_primary_col is not null");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColEqualTo(String value) {
            addCriterion("dw_tab_primary_col =", value, "dwTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColNotEqualTo(String value) {
            addCriterion("dw_tab_primary_col <>", value, "dwTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColGreaterThan(String value) {
            addCriterion("dw_tab_primary_col >", value, "dwTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColGreaterThanOrEqualTo(String value) {
            addCriterion("dw_tab_primary_col >=", value, "dwTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColLessThan(String value) {
            addCriterion("dw_tab_primary_col <", value, "dwTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColLessThanOrEqualTo(String value) {
            addCriterion("dw_tab_primary_col <=", value, "dwTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColLike(String value) {
            addCriterion("dw_tab_primary_col like", value, "dwTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColNotLike(String value) {
            addCriterion("dw_tab_primary_col not like", value, "dwTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColIn(List<String> values) {
            addCriterion("dw_tab_primary_col in", values, "dwTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColNotIn(List<String> values) {
            addCriterion("dw_tab_primary_col not in", values, "dwTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColBetween(String value1, String value2) {
            addCriterion("dw_tab_primary_col between", value1, value2, "dwTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwTabPrimaryColNotBetween(String value1, String value2) {
            addCriterion("dw_tab_primary_col not between", value1, value2, "dwTabPrimaryCol");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeIsNull() {
            addCriterion("dw_data_load_mode is null");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeIsNotNull() {
            addCriterion("dw_data_load_mode is not null");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeEqualTo(String value) {
            addCriterion("dw_data_load_mode =", value, "dwDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeNotEqualTo(String value) {
            addCriterion("dw_data_load_mode <>", value, "dwDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeGreaterThan(String value) {
            addCriterion("dw_data_load_mode >", value, "dwDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeGreaterThanOrEqualTo(String value) {
            addCriterion("dw_data_load_mode >=", value, "dwDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeLessThan(String value) {
            addCriterion("dw_data_load_mode <", value, "dwDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeLessThanOrEqualTo(String value) {
            addCriterion("dw_data_load_mode <=", value, "dwDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeLike(String value) {
            addCriterion("dw_data_load_mode like", value, "dwDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeNotLike(String value) {
            addCriterion("dw_data_load_mode not like", value, "dwDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeIn(List<String> values) {
            addCriterion("dw_data_load_mode in", values, "dwDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeNotIn(List<String> values) {
            addCriterion("dw_data_load_mode not in", values, "dwDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeBetween(String value1, String value2) {
            addCriterion("dw_data_load_mode between", value1, value2, "dwDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andDwDataLoadModeNotBetween(String value1, String value2) {
            addCriterion("dw_data_load_mode not between", value1, value2, "dwDataLoadMode");
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