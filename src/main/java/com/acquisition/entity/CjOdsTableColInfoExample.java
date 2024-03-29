package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjOdsTableColInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjOdsTableColInfoExample() {
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

        public Criteria andDataSourceTableIsNull() {
            addCriterion("data_source_table is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableIsNotNull() {
            addCriterion("data_source_table is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableEqualTo(String value) {
            addCriterion("data_source_table =", value, "dataSourceTable");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableNotEqualTo(String value) {
            addCriterion("data_source_table <>", value, "dataSourceTable");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableGreaterThan(String value) {
            addCriterion("data_source_table >", value, "dataSourceTable");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_table >=", value, "dataSourceTable");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableLessThan(String value) {
            addCriterion("data_source_table <", value, "dataSourceTable");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableLessThanOrEqualTo(String value) {
            addCriterion("data_source_table <=", value, "dataSourceTable");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableLike(String value) {
            addCriterion("data_source_table like", value, "dataSourceTable");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableNotLike(String value) {
            addCriterion("data_source_table not like", value, "dataSourceTable");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableIn(List<String> values) {
            addCriterion("data_source_table in", values, "dataSourceTable");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableNotIn(List<String> values) {
            addCriterion("data_source_table not in", values, "dataSourceTable");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableBetween(String value1, String value2) {
            addCriterion("data_source_table between", value1, value2, "dataSourceTable");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableNotBetween(String value1, String value2) {
            addCriterion("data_source_table not between", value1, value2, "dataSourceTable");
            return (Criteria) this;
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

        public Criteria andOdsTableColNameIsNull() {
            addCriterion("ods_table_col_name is null");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameIsNotNull() {
            addCriterion("ods_table_col_name is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameEqualTo(String value) {
            addCriterion("ods_table_col_name =", value, "odsTableColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameNotEqualTo(String value) {
            addCriterion("ods_table_col_name <>", value, "odsTableColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameGreaterThan(String value) {
            addCriterion("ods_table_col_name >", value, "odsTableColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameGreaterThanOrEqualTo(String value) {
            addCriterion("ods_table_col_name >=", value, "odsTableColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameLessThan(String value) {
            addCriterion("ods_table_col_name <", value, "odsTableColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameLessThanOrEqualTo(String value) {
            addCriterion("ods_table_col_name <=", value, "odsTableColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameLike(String value) {
            addCriterion("ods_table_col_name like", value, "odsTableColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameNotLike(String value) {
            addCriterion("ods_table_col_name not like", value, "odsTableColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameIn(List<String> values) {
            addCriterion("ods_table_col_name in", values, "odsTableColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameNotIn(List<String> values) {
            addCriterion("ods_table_col_name not in", values, "odsTableColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameBetween(String value1, String value2) {
            addCriterion("ods_table_col_name between", value1, value2, "odsTableColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableColNameNotBetween(String value1, String value2) {
            addCriterion("ods_table_col_name not between", value1, value2, "odsTableColName");
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

        public Criteria andOdsDataSchemaIsNull() {
            addCriterion("ods_data_schema is null");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaIsNotNull() {
            addCriterion("ods_data_schema is not null");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaEqualTo(String value) {
            addCriterion("ods_data_schema =", value, "odsDataSchema");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaNotEqualTo(String value) {
            addCriterion("ods_data_schema <>", value, "odsDataSchema");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaGreaterThan(String value) {
            addCriterion("ods_data_schema >", value, "odsDataSchema");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("ods_data_schema >=", value, "odsDataSchema");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaLessThan(String value) {
            addCriterion("ods_data_schema <", value, "odsDataSchema");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaLessThanOrEqualTo(String value) {
            addCriterion("ods_data_schema <=", value, "odsDataSchema");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaLike(String value) {
            addCriterion("ods_data_schema like", value, "odsDataSchema");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaNotLike(String value) {
            addCriterion("ods_data_schema not like", value, "odsDataSchema");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaIn(List<String> values) {
            addCriterion("ods_data_schema in", values, "odsDataSchema");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaNotIn(List<String> values) {
            addCriterion("ods_data_schema not in", values, "odsDataSchema");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaBetween(String value1, String value2) {
            addCriterion("ods_data_schema between", value1, value2, "odsDataSchema");
            return (Criteria) this;
        }

        public Criteria andOdsDataSchemaNotBetween(String value1, String value2) {
            addCriterion("ods_data_schema not between", value1, value2, "odsDataSchema");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentIsNull() {
            addCriterion("ods_table_comment is null");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentIsNotNull() {
            addCriterion("ods_table_comment is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentEqualTo(String value) {
            addCriterion("ods_table_comment =", value, "odsTableComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentNotEqualTo(String value) {
            addCriterion("ods_table_comment <>", value, "odsTableComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentGreaterThan(String value) {
            addCriterion("ods_table_comment >", value, "odsTableComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentGreaterThanOrEqualTo(String value) {
            addCriterion("ods_table_comment >=", value, "odsTableComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentLessThan(String value) {
            addCriterion("ods_table_comment <", value, "odsTableComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentLessThanOrEqualTo(String value) {
            addCriterion("ods_table_comment <=", value, "odsTableComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentLike(String value) {
            addCriterion("ods_table_comment like", value, "odsTableComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentNotLike(String value) {
            addCriterion("ods_table_comment not like", value, "odsTableComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentIn(List<String> values) {
            addCriterion("ods_table_comment in", values, "odsTableComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentNotIn(List<String> values) {
            addCriterion("ods_table_comment not in", values, "odsTableComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentBetween(String value1, String value2) {
            addCriterion("ods_table_comment between", value1, value2, "odsTableComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableCommentNotBetween(String value1, String value2) {
            addCriterion("ods_table_comment not between", value1, value2, "odsTableComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderIsNull() {
            addCriterion("ods_table_col_order is null");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderIsNotNull() {
            addCriterion("ods_table_col_order is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderEqualTo(String value) {
            addCriterion("ods_table_col_order =", value, "odsTableColOrder");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderNotEqualTo(String value) {
            addCriterion("ods_table_col_order <>", value, "odsTableColOrder");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderGreaterThan(String value) {
            addCriterion("ods_table_col_order >", value, "odsTableColOrder");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderGreaterThanOrEqualTo(String value) {
            addCriterion("ods_table_col_order >=", value, "odsTableColOrder");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderLessThan(String value) {
            addCriterion("ods_table_col_order <", value, "odsTableColOrder");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderLessThanOrEqualTo(String value) {
            addCriterion("ods_table_col_order <=", value, "odsTableColOrder");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderLike(String value) {
            addCriterion("ods_table_col_order like", value, "odsTableColOrder");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderNotLike(String value) {
            addCriterion("ods_table_col_order not like", value, "odsTableColOrder");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderIn(List<String> values) {
            addCriterion("ods_table_col_order in", values, "odsTableColOrder");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderNotIn(List<String> values) {
            addCriterion("ods_table_col_order not in", values, "odsTableColOrder");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderBetween(String value1, String value2) {
            addCriterion("ods_table_col_order between", value1, value2, "odsTableColOrder");
            return (Criteria) this;
        }

        public Criteria andOdsTableColOrderNotBetween(String value1, String value2) {
            addCriterion("ods_table_col_order not between", value1, value2, "odsTableColOrder");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeIsNull() {
            addCriterion("ods_table_col_type is null");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeIsNotNull() {
            addCriterion("ods_table_col_type is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeEqualTo(String value) {
            addCriterion("ods_table_col_type =", value, "odsTableColType");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeNotEqualTo(String value) {
            addCriterion("ods_table_col_type <>", value, "odsTableColType");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeGreaterThan(String value) {
            addCriterion("ods_table_col_type >", value, "odsTableColType");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ods_table_col_type >=", value, "odsTableColType");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeLessThan(String value) {
            addCriterion("ods_table_col_type <", value, "odsTableColType");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeLessThanOrEqualTo(String value) {
            addCriterion("ods_table_col_type <=", value, "odsTableColType");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeLike(String value) {
            addCriterion("ods_table_col_type like", value, "odsTableColType");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeNotLike(String value) {
            addCriterion("ods_table_col_type not like", value, "odsTableColType");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeIn(List<String> values) {
            addCriterion("ods_table_col_type in", values, "odsTableColType");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeNotIn(List<String> values) {
            addCriterion("ods_table_col_type not in", values, "odsTableColType");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeBetween(String value1, String value2) {
            addCriterion("ods_table_col_type between", value1, value2, "odsTableColType");
            return (Criteria) this;
        }

        public Criteria andOdsTableColTypeNotBetween(String value1, String value2) {
            addCriterion("ods_table_col_type not between", value1, value2, "odsTableColType");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentIsNull() {
            addCriterion("ods_table_col_comment is null");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentIsNotNull() {
            addCriterion("ods_table_col_comment is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentEqualTo(String value) {
            addCriterion("ods_table_col_comment =", value, "odsTableColComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentNotEqualTo(String value) {
            addCriterion("ods_table_col_comment <>", value, "odsTableColComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentGreaterThan(String value) {
            addCriterion("ods_table_col_comment >", value, "odsTableColComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentGreaterThanOrEqualTo(String value) {
            addCriterion("ods_table_col_comment >=", value, "odsTableColComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentLessThan(String value) {
            addCriterion("ods_table_col_comment <", value, "odsTableColComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentLessThanOrEqualTo(String value) {
            addCriterion("ods_table_col_comment <=", value, "odsTableColComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentLike(String value) {
            addCriterion("ods_table_col_comment like", value, "odsTableColComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentNotLike(String value) {
            addCriterion("ods_table_col_comment not like", value, "odsTableColComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentIn(List<String> values) {
            addCriterion("ods_table_col_comment in", values, "odsTableColComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentNotIn(List<String> values) {
            addCriterion("ods_table_col_comment not in", values, "odsTableColComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentBetween(String value1, String value2) {
            addCriterion("ods_table_col_comment between", value1, value2, "odsTableColComment");
            return (Criteria) this;
        }

        public Criteria andOdsTableColCommentNotBetween(String value1, String value2) {
            addCriterion("ods_table_col_comment not between", value1, value2, "odsTableColComment");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagIsNull() {
            addCriterion("ods_table_partition_flag is null");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagIsNotNull() {
            addCriterion("ods_table_partition_flag is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagEqualTo(String value) {
            addCriterion("ods_table_partition_flag =", value, "odsTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagNotEqualTo(String value) {
            addCriterion("ods_table_partition_flag <>", value, "odsTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagGreaterThan(String value) {
            addCriterion("ods_table_partition_flag >", value, "odsTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ods_table_partition_flag >=", value, "odsTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagLessThan(String value) {
            addCriterion("ods_table_partition_flag <", value, "odsTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagLessThanOrEqualTo(String value) {
            addCriterion("ods_table_partition_flag <=", value, "odsTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagLike(String value) {
            addCriterion("ods_table_partition_flag like", value, "odsTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagNotLike(String value) {
            addCriterion("ods_table_partition_flag not like", value, "odsTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagIn(List<String> values) {
            addCriterion("ods_table_partition_flag in", values, "odsTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagNotIn(List<String> values) {
            addCriterion("ods_table_partition_flag not in", values, "odsTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagBetween(String value1, String value2) {
            addCriterion("ods_table_partition_flag between", value1, value2, "odsTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionFlagNotBetween(String value1, String value2) {
            addCriterion("ods_table_partition_flag not between", value1, value2, "odsTablePartitionFlag");
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