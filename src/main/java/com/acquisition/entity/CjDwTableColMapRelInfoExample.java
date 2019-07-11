package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjDwTableColMapRelInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjDwTableColMapRelInfoExample() {
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

        public Criteria andDataSqlGroupUnitIsNull() {
            addCriterion("data_sql_group_unit is null");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitIsNotNull() {
            addCriterion("data_sql_group_unit is not null");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitEqualTo(String value) {
            addCriterion("data_sql_group_unit =", value, "dataSqlGroupUnit");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitNotEqualTo(String value) {
            addCriterion("data_sql_group_unit <>", value, "dataSqlGroupUnit");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitGreaterThan(String value) {
            addCriterion("data_sql_group_unit >", value, "dataSqlGroupUnit");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitGreaterThanOrEqualTo(String value) {
            addCriterion("data_sql_group_unit >=", value, "dataSqlGroupUnit");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitLessThan(String value) {
            addCriterion("data_sql_group_unit <", value, "dataSqlGroupUnit");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitLessThanOrEqualTo(String value) {
            addCriterion("data_sql_group_unit <=", value, "dataSqlGroupUnit");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitLike(String value) {
            addCriterion("data_sql_group_unit like", value, "dataSqlGroupUnit");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitNotLike(String value) {
            addCriterion("data_sql_group_unit not like", value, "dataSqlGroupUnit");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitIn(List<String> values) {
            addCriterion("data_sql_group_unit in", values, "dataSqlGroupUnit");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitNotIn(List<String> values) {
            addCriterion("data_sql_group_unit not in", values, "dataSqlGroupUnit");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitBetween(String value1, String value2) {
            addCriterion("data_sql_group_unit between", value1, value2, "dataSqlGroupUnit");
            return (Criteria) this;
        }

        public Criteria andDataSqlGroupUnitNotBetween(String value1, String value2) {
            addCriterion("data_sql_group_unit not between", value1, value2, "dataSqlGroupUnit");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameIsNull() {
            addCriterion("source_table_name is null");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameIsNotNull() {
            addCriterion("source_table_name is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameEqualTo(String value) {
            addCriterion("source_table_name =", value, "sourceTableName");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameNotEqualTo(String value) {
            addCriterion("source_table_name <>", value, "sourceTableName");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameGreaterThan(String value) {
            addCriterion("source_table_name >", value, "sourceTableName");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("source_table_name >=", value, "sourceTableName");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameLessThan(String value) {
            addCriterion("source_table_name <", value, "sourceTableName");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameLessThanOrEqualTo(String value) {
            addCriterion("source_table_name <=", value, "sourceTableName");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameLike(String value) {
            addCriterion("source_table_name like", value, "sourceTableName");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameNotLike(String value) {
            addCriterion("source_table_name not like", value, "sourceTableName");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameIn(List<String> values) {
            addCriterion("source_table_name in", values, "sourceTableName");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameNotIn(List<String> values) {
            addCriterion("source_table_name not in", values, "sourceTableName");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameBetween(String value1, String value2) {
            addCriterion("source_table_name between", value1, value2, "sourceTableName");
            return (Criteria) this;
        }

        public Criteria andSourceTableNameNotBetween(String value1, String value2) {
            addCriterion("source_table_name not between", value1, value2, "sourceTableName");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameIsNull() {
            addCriterion("source_table_col_name is null");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameIsNotNull() {
            addCriterion("source_table_col_name is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameEqualTo(String value) {
            addCriterion("source_table_col_name =", value, "sourceTableColName");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameNotEqualTo(String value) {
            addCriterion("source_table_col_name <>", value, "sourceTableColName");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameGreaterThan(String value) {
            addCriterion("source_table_col_name >", value, "sourceTableColName");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameGreaterThanOrEqualTo(String value) {
            addCriterion("source_table_col_name >=", value, "sourceTableColName");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameLessThan(String value) {
            addCriterion("source_table_col_name <", value, "sourceTableColName");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameLessThanOrEqualTo(String value) {
            addCriterion("source_table_col_name <=", value, "sourceTableColName");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameLike(String value) {
            addCriterion("source_table_col_name like", value, "sourceTableColName");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameNotLike(String value) {
            addCriterion("source_table_col_name not like", value, "sourceTableColName");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameIn(List<String> values) {
            addCriterion("source_table_col_name in", values, "sourceTableColName");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameNotIn(List<String> values) {
            addCriterion("source_table_col_name not in", values, "sourceTableColName");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameBetween(String value1, String value2) {
            addCriterion("source_table_col_name between", value1, value2, "sourceTableColName");
            return (Criteria) this;
        }

        public Criteria andSourceTableColNameNotBetween(String value1, String value2) {
            addCriterion("source_table_col_name not between", value1, value2, "sourceTableColName");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameIsNull() {
            addCriterion("target_table_col_name is null");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameIsNotNull() {
            addCriterion("target_table_col_name is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameEqualTo(String value) {
            addCriterion("target_table_col_name =", value, "targetTableColName");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameNotEqualTo(String value) {
            addCriterion("target_table_col_name <>", value, "targetTableColName");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameGreaterThan(String value) {
            addCriterion("target_table_col_name >", value, "targetTableColName");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameGreaterThanOrEqualTo(String value) {
            addCriterion("target_table_col_name >=", value, "targetTableColName");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameLessThan(String value) {
            addCriterion("target_table_col_name <", value, "targetTableColName");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameLessThanOrEqualTo(String value) {
            addCriterion("target_table_col_name <=", value, "targetTableColName");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameLike(String value) {
            addCriterion("target_table_col_name like", value, "targetTableColName");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameNotLike(String value) {
            addCriterion("target_table_col_name not like", value, "targetTableColName");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameIn(List<String> values) {
            addCriterion("target_table_col_name in", values, "targetTableColName");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameNotIn(List<String> values) {
            addCriterion("target_table_col_name not in", values, "targetTableColName");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameBetween(String value1, String value2) {
            addCriterion("target_table_col_name between", value1, value2, "targetTableColName");
            return (Criteria) this;
        }

        public Criteria andTargetTableColNameNotBetween(String value1, String value2) {
            addCriterion("target_table_col_name not between", value1, value2, "targetTableColName");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaIsNull() {
            addCriterion("source_table_schema is null");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaIsNotNull() {
            addCriterion("source_table_schema is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaEqualTo(String value) {
            addCriterion("source_table_schema =", value, "sourceTableSchema");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaNotEqualTo(String value) {
            addCriterion("source_table_schema <>", value, "sourceTableSchema");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaGreaterThan(String value) {
            addCriterion("source_table_schema >", value, "sourceTableSchema");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("source_table_schema >=", value, "sourceTableSchema");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaLessThan(String value) {
            addCriterion("source_table_schema <", value, "sourceTableSchema");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaLessThanOrEqualTo(String value) {
            addCriterion("source_table_schema <=", value, "sourceTableSchema");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaLike(String value) {
            addCriterion("source_table_schema like", value, "sourceTableSchema");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaNotLike(String value) {
            addCriterion("source_table_schema not like", value, "sourceTableSchema");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaIn(List<String> values) {
            addCriterion("source_table_schema in", values, "sourceTableSchema");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaNotIn(List<String> values) {
            addCriterion("source_table_schema not in", values, "sourceTableSchema");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaBetween(String value1, String value2) {
            addCriterion("source_table_schema between", value1, value2, "sourceTableSchema");
            return (Criteria) this;
        }

        public Criteria andSourceTableSchemaNotBetween(String value1, String value2) {
            addCriterion("source_table_schema not between", value1, value2, "sourceTableSchema");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderIsNull() {
            addCriterion("target_table_col_order is null");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderIsNotNull() {
            addCriterion("target_table_col_order is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderEqualTo(String value) {
            addCriterion("target_table_col_order =", value, "targetTableColOrder");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderNotEqualTo(String value) {
            addCriterion("target_table_col_order <>", value, "targetTableColOrder");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderGreaterThan(String value) {
            addCriterion("target_table_col_order >", value, "targetTableColOrder");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderGreaterThanOrEqualTo(String value) {
            addCriterion("target_table_col_order >=", value, "targetTableColOrder");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderLessThan(String value) {
            addCriterion("target_table_col_order <", value, "targetTableColOrder");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderLessThanOrEqualTo(String value) {
            addCriterion("target_table_col_order <=", value, "targetTableColOrder");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderLike(String value) {
            addCriterion("target_table_col_order like", value, "targetTableColOrder");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderNotLike(String value) {
            addCriterion("target_table_col_order not like", value, "targetTableColOrder");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderIn(List<String> values) {
            addCriterion("target_table_col_order in", values, "targetTableColOrder");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderNotIn(List<String> values) {
            addCriterion("target_table_col_order not in", values, "targetTableColOrder");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderBetween(String value1, String value2) {
            addCriterion("target_table_col_order between", value1, value2, "targetTableColOrder");
            return (Criteria) this;
        }

        public Criteria andTargetTableColOrderNotBetween(String value1, String value2) {
            addCriterion("target_table_col_order not between", value1, value2, "targetTableColOrder");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeIsNull() {
            addCriterion("source_table_col_type is null");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeIsNotNull() {
            addCriterion("source_table_col_type is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeEqualTo(String value) {
            addCriterion("source_table_col_type =", value, "sourceTableColType");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeNotEqualTo(String value) {
            addCriterion("source_table_col_type <>", value, "sourceTableColType");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeGreaterThan(String value) {
            addCriterion("source_table_col_type >", value, "sourceTableColType");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeGreaterThanOrEqualTo(String value) {
            addCriterion("source_table_col_type >=", value, "sourceTableColType");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeLessThan(String value) {
            addCriterion("source_table_col_type <", value, "sourceTableColType");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeLessThanOrEqualTo(String value) {
            addCriterion("source_table_col_type <=", value, "sourceTableColType");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeLike(String value) {
            addCriterion("source_table_col_type like", value, "sourceTableColType");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeNotLike(String value) {
            addCriterion("source_table_col_type not like", value, "sourceTableColType");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeIn(List<String> values) {
            addCriterion("source_table_col_type in", values, "sourceTableColType");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeNotIn(List<String> values) {
            addCriterion("source_table_col_type not in", values, "sourceTableColType");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeBetween(String value1, String value2) {
            addCriterion("source_table_col_type between", value1, value2, "sourceTableColType");
            return (Criteria) this;
        }

        public Criteria andSourceTableColTypeNotBetween(String value1, String value2) {
            addCriterion("source_table_col_type not between", value1, value2, "sourceTableColType");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeIsNull() {
            addCriterion("target_table_col_type is null");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeIsNotNull() {
            addCriterion("target_table_col_type is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeEqualTo(String value) {
            addCriterion("target_table_col_type =", value, "targetTableColType");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeNotEqualTo(String value) {
            addCriterion("target_table_col_type <>", value, "targetTableColType");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeGreaterThan(String value) {
            addCriterion("target_table_col_type >", value, "targetTableColType");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeGreaterThanOrEqualTo(String value) {
            addCriterion("target_table_col_type >=", value, "targetTableColType");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeLessThan(String value) {
            addCriterion("target_table_col_type <", value, "targetTableColType");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeLessThanOrEqualTo(String value) {
            addCriterion("target_table_col_type <=", value, "targetTableColType");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeLike(String value) {
            addCriterion("target_table_col_type like", value, "targetTableColType");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeNotLike(String value) {
            addCriterion("target_table_col_type not like", value, "targetTableColType");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeIn(List<String> values) {
            addCriterion("target_table_col_type in", values, "targetTableColType");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeNotIn(List<String> values) {
            addCriterion("target_table_col_type not in", values, "targetTableColType");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeBetween(String value1, String value2) {
            addCriterion("target_table_col_type between", value1, value2, "targetTableColType");
            return (Criteria) this;
        }

        public Criteria andTargetTableColTypeNotBetween(String value1, String value2) {
            addCriterion("target_table_col_type not between", value1, value2, "targetTableColType");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentIsNull() {
            addCriterion("source_table_col_comment is null");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentIsNotNull() {
            addCriterion("source_table_col_comment is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentEqualTo(String value) {
            addCriterion("source_table_col_comment =", value, "sourceTableColComment");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentNotEqualTo(String value) {
            addCriterion("source_table_col_comment <>", value, "sourceTableColComment");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentGreaterThan(String value) {
            addCriterion("source_table_col_comment >", value, "sourceTableColComment");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentGreaterThanOrEqualTo(String value) {
            addCriterion("source_table_col_comment >=", value, "sourceTableColComment");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentLessThan(String value) {
            addCriterion("source_table_col_comment <", value, "sourceTableColComment");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentLessThanOrEqualTo(String value) {
            addCriterion("source_table_col_comment <=", value, "sourceTableColComment");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentLike(String value) {
            addCriterion("source_table_col_comment like", value, "sourceTableColComment");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentNotLike(String value) {
            addCriterion("source_table_col_comment not like", value, "sourceTableColComment");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentIn(List<String> values) {
            addCriterion("source_table_col_comment in", values, "sourceTableColComment");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentNotIn(List<String> values) {
            addCriterion("source_table_col_comment not in", values, "sourceTableColComment");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentBetween(String value1, String value2) {
            addCriterion("source_table_col_comment between", value1, value2, "sourceTableColComment");
            return (Criteria) this;
        }

        public Criteria andSourceTableColCommentNotBetween(String value1, String value2) {
            addCriterion("source_table_col_comment not between", value1, value2, "sourceTableColComment");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentIsNull() {
            addCriterion("target_table_col_comment is null");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentIsNotNull() {
            addCriterion("target_table_col_comment is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentEqualTo(String value) {
            addCriterion("target_table_col_comment =", value, "targetTableColComment");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentNotEqualTo(String value) {
            addCriterion("target_table_col_comment <>", value, "targetTableColComment");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentGreaterThan(String value) {
            addCriterion("target_table_col_comment >", value, "targetTableColComment");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentGreaterThanOrEqualTo(String value) {
            addCriterion("target_table_col_comment >=", value, "targetTableColComment");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentLessThan(String value) {
            addCriterion("target_table_col_comment <", value, "targetTableColComment");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentLessThanOrEqualTo(String value) {
            addCriterion("target_table_col_comment <=", value, "targetTableColComment");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentLike(String value) {
            addCriterion("target_table_col_comment like", value, "targetTableColComment");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentNotLike(String value) {
            addCriterion("target_table_col_comment not like", value, "targetTableColComment");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentIn(List<String> values) {
            addCriterion("target_table_col_comment in", values, "targetTableColComment");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentNotIn(List<String> values) {
            addCriterion("target_table_col_comment not in", values, "targetTableColComment");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentBetween(String value1, String value2) {
            addCriterion("target_table_col_comment between", value1, value2, "targetTableColComment");
            return (Criteria) this;
        }

        public Criteria andTargetTableColCommentNotBetween(String value1, String value2) {
            addCriterion("target_table_col_comment not between", value1, value2, "targetTableColComment");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineIsNull() {
            addCriterion("source_target_mapp_define is null");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineIsNotNull() {
            addCriterion("source_target_mapp_define is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineEqualTo(String value) {
            addCriterion("source_target_mapp_define =", value, "sourceTargetMappDefine");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineNotEqualTo(String value) {
            addCriterion("source_target_mapp_define <>", value, "sourceTargetMappDefine");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineGreaterThan(String value) {
            addCriterion("source_target_mapp_define >", value, "sourceTargetMappDefine");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineGreaterThanOrEqualTo(String value) {
            addCriterion("source_target_mapp_define >=", value, "sourceTargetMappDefine");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineLessThan(String value) {
            addCriterion("source_target_mapp_define <", value, "sourceTargetMappDefine");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineLessThanOrEqualTo(String value) {
            addCriterion("source_target_mapp_define <=", value, "sourceTargetMappDefine");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineLike(String value) {
            addCriterion("source_target_mapp_define like", value, "sourceTargetMappDefine");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineNotLike(String value) {
            addCriterion("source_target_mapp_define not like", value, "sourceTargetMappDefine");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineIn(List<String> values) {
            addCriterion("source_target_mapp_define in", values, "sourceTargetMappDefine");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineNotIn(List<String> values) {
            addCriterion("source_target_mapp_define not in", values, "sourceTargetMappDefine");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineBetween(String value1, String value2) {
            addCriterion("source_target_mapp_define between", value1, value2, "sourceTargetMappDefine");
            return (Criteria) this;
        }

        public Criteria andSourceTargetMappDefineNotBetween(String value1, String value2) {
            addCriterion("source_target_mapp_define not between", value1, value2, "sourceTargetMappDefine");
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