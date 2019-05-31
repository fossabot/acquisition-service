package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjDataSourceTabColInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjDataSourceTabColInfoExample() {
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

        public Criteria andDataSourceColNameIsNull() {
            addCriterion("data_source_col_name is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameIsNotNull() {
            addCriterion("data_source_col_name is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameEqualTo(String value) {
            addCriterion("data_source_col_name =", value, "dataSourceColName");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameNotEqualTo(String value) {
            addCriterion("data_source_col_name <>", value, "dataSourceColName");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameGreaterThan(String value) {
            addCriterion("data_source_col_name >", value, "dataSourceColName");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_col_name >=", value, "dataSourceColName");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameLessThan(String value) {
            addCriterion("data_source_col_name <", value, "dataSourceColName");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameLessThanOrEqualTo(String value) {
            addCriterion("data_source_col_name <=", value, "dataSourceColName");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameLike(String value) {
            addCriterion("data_source_col_name like", value, "dataSourceColName");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameNotLike(String value) {
            addCriterion("data_source_col_name not like", value, "dataSourceColName");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameIn(List<String> values) {
            addCriterion("data_source_col_name in", values, "dataSourceColName");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameNotIn(List<String> values) {
            addCriterion("data_source_col_name not in", values, "dataSourceColName");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameBetween(String value1, String value2) {
            addCriterion("data_source_col_name between", value1, value2, "dataSourceColName");
            return (Criteria) this;
        }

        public Criteria andDataSourceColNameNotBetween(String value1, String value2) {
            addCriterion("data_source_col_name not between", value1, value2, "dataSourceColName");
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

        public Criteria andDataSourceTableCommentIsNull() {
            addCriterion("data_source_table_comment is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentIsNotNull() {
            addCriterion("data_source_table_comment is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentEqualTo(String value) {
            addCriterion("data_source_table_comment =", value, "dataSourceTableComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentNotEqualTo(String value) {
            addCriterion("data_source_table_comment <>", value, "dataSourceTableComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentGreaterThan(String value) {
            addCriterion("data_source_table_comment >", value, "dataSourceTableComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_table_comment >=", value, "dataSourceTableComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentLessThan(String value) {
            addCriterion("data_source_table_comment <", value, "dataSourceTableComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentLessThanOrEqualTo(String value) {
            addCriterion("data_source_table_comment <=", value, "dataSourceTableComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentLike(String value) {
            addCriterion("data_source_table_comment like", value, "dataSourceTableComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentNotLike(String value) {
            addCriterion("data_source_table_comment not like", value, "dataSourceTableComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentIn(List<String> values) {
            addCriterion("data_source_table_comment in", values, "dataSourceTableComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentNotIn(List<String> values) {
            addCriterion("data_source_table_comment not in", values, "dataSourceTableComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentBetween(String value1, String value2) {
            addCriterion("data_source_table_comment between", value1, value2, "dataSourceTableComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceTableCommentNotBetween(String value1, String value2) {
            addCriterion("data_source_table_comment not between", value1, value2, "dataSourceTableComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderIsNull() {
            addCriterion("data_source_col_order is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderIsNotNull() {
            addCriterion("data_source_col_order is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderEqualTo(String value) {
            addCriterion("data_source_col_order =", value, "dataSourceColOrder");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderNotEqualTo(String value) {
            addCriterion("data_source_col_order <>", value, "dataSourceColOrder");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderGreaterThan(String value) {
            addCriterion("data_source_col_order >", value, "dataSourceColOrder");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_col_order >=", value, "dataSourceColOrder");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderLessThan(String value) {
            addCriterion("data_source_col_order <", value, "dataSourceColOrder");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderLessThanOrEqualTo(String value) {
            addCriterion("data_source_col_order <=", value, "dataSourceColOrder");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderLike(String value) {
            addCriterion("data_source_col_order like", value, "dataSourceColOrder");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderNotLike(String value) {
            addCriterion("data_source_col_order not like", value, "dataSourceColOrder");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderIn(List<String> values) {
            addCriterion("data_source_col_order in", values, "dataSourceColOrder");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderNotIn(List<String> values) {
            addCriterion("data_source_col_order not in", values, "dataSourceColOrder");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderBetween(String value1, String value2) {
            addCriterion("data_source_col_order between", value1, value2, "dataSourceColOrder");
            return (Criteria) this;
        }

        public Criteria andDataSourceColOrderNotBetween(String value1, String value2) {
            addCriterion("data_source_col_order not between", value1, value2, "dataSourceColOrder");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagIsNull() {
            addCriterion("data_source_col_primarykey_flag is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagIsNotNull() {
            addCriterion("data_source_col_primarykey_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagEqualTo(String value) {
            addCriterion("data_source_col_primarykey_flag =", value, "dataSourceColPrimarykeyFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagNotEqualTo(String value) {
            addCriterion("data_source_col_primarykey_flag <>", value, "dataSourceColPrimarykeyFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagGreaterThan(String value) {
            addCriterion("data_source_col_primarykey_flag >", value, "dataSourceColPrimarykeyFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_col_primarykey_flag >=", value, "dataSourceColPrimarykeyFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagLessThan(String value) {
            addCriterion("data_source_col_primarykey_flag <", value, "dataSourceColPrimarykeyFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagLessThanOrEqualTo(String value) {
            addCriterion("data_source_col_primarykey_flag <=", value, "dataSourceColPrimarykeyFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagLike(String value) {
            addCriterion("data_source_col_primarykey_flag like", value, "dataSourceColPrimarykeyFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagNotLike(String value) {
            addCriterion("data_source_col_primarykey_flag not like", value, "dataSourceColPrimarykeyFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagIn(List<String> values) {
            addCriterion("data_source_col_primarykey_flag in", values, "dataSourceColPrimarykeyFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagNotIn(List<String> values) {
            addCriterion("data_source_col_primarykey_flag not in", values, "dataSourceColPrimarykeyFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagBetween(String value1, String value2) {
            addCriterion("data_source_col_primarykey_flag between", value1, value2, "dataSourceColPrimarykeyFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrimarykeyFlagNotBetween(String value1, String value2) {
            addCriterion("data_source_col_primarykey_flag not between", value1, value2, "dataSourceColPrimarykeyFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagIsNull() {
            addCriterion("data_source_col_isnull_flag is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagIsNotNull() {
            addCriterion("data_source_col_isnull_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagEqualTo(String value) {
            addCriterion("data_source_col_isnull_flag =", value, "dataSourceColIsnullFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagNotEqualTo(String value) {
            addCriterion("data_source_col_isnull_flag <>", value, "dataSourceColIsnullFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagGreaterThan(String value) {
            addCriterion("data_source_col_isnull_flag >", value, "dataSourceColIsnullFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_col_isnull_flag >=", value, "dataSourceColIsnullFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagLessThan(String value) {
            addCriterion("data_source_col_isnull_flag <", value, "dataSourceColIsnullFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagLessThanOrEqualTo(String value) {
            addCriterion("data_source_col_isnull_flag <=", value, "dataSourceColIsnullFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagLike(String value) {
            addCriterion("data_source_col_isnull_flag like", value, "dataSourceColIsnullFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagNotLike(String value) {
            addCriterion("data_source_col_isnull_flag not like", value, "dataSourceColIsnullFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagIn(List<String> values) {
            addCriterion("data_source_col_isnull_flag in", values, "dataSourceColIsnullFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagNotIn(List<String> values) {
            addCriterion("data_source_col_isnull_flag not in", values, "dataSourceColIsnullFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagBetween(String value1, String value2) {
            addCriterion("data_source_col_isnull_flag between", value1, value2, "dataSourceColIsnullFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColIsnullFlagNotBetween(String value1, String value2) {
            addCriterion("data_source_col_isnull_flag not between", value1, value2, "dataSourceColIsnullFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeIsNull() {
            addCriterion("data_source_col_datatype is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeIsNotNull() {
            addCriterion("data_source_col_datatype is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeEqualTo(String value) {
            addCriterion("data_source_col_datatype =", value, "dataSourceColDatatype");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeNotEqualTo(String value) {
            addCriterion("data_source_col_datatype <>", value, "dataSourceColDatatype");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeGreaterThan(String value) {
            addCriterion("data_source_col_datatype >", value, "dataSourceColDatatype");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_col_datatype >=", value, "dataSourceColDatatype");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeLessThan(String value) {
            addCriterion("data_source_col_datatype <", value, "dataSourceColDatatype");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeLessThanOrEqualTo(String value) {
            addCriterion("data_source_col_datatype <=", value, "dataSourceColDatatype");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeLike(String value) {
            addCriterion("data_source_col_datatype like", value, "dataSourceColDatatype");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeNotLike(String value) {
            addCriterion("data_source_col_datatype not like", value, "dataSourceColDatatype");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeIn(List<String> values) {
            addCriterion("data_source_col_datatype in", values, "dataSourceColDatatype");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeNotIn(List<String> values) {
            addCriterion("data_source_col_datatype not in", values, "dataSourceColDatatype");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeBetween(String value1, String value2) {
            addCriterion("data_source_col_datatype between", value1, value2, "dataSourceColDatatype");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatatypeNotBetween(String value1, String value2) {
            addCriterion("data_source_col_datatype not between", value1, value2, "dataSourceColDatatype");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenIsNull() {
            addCriterion("data_source_col_len is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenIsNotNull() {
            addCriterion("data_source_col_len is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenEqualTo(String value) {
            addCriterion("data_source_col_len =", value, "dataSourceColLen");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenNotEqualTo(String value) {
            addCriterion("data_source_col_len <>", value, "dataSourceColLen");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenGreaterThan(String value) {
            addCriterion("data_source_col_len >", value, "dataSourceColLen");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_col_len >=", value, "dataSourceColLen");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenLessThan(String value) {
            addCriterion("data_source_col_len <", value, "dataSourceColLen");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenLessThanOrEqualTo(String value) {
            addCriterion("data_source_col_len <=", value, "dataSourceColLen");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenLike(String value) {
            addCriterion("data_source_col_len like", value, "dataSourceColLen");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenNotLike(String value) {
            addCriterion("data_source_col_len not like", value, "dataSourceColLen");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenIn(List<String> values) {
            addCriterion("data_source_col_len in", values, "dataSourceColLen");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenNotIn(List<String> values) {
            addCriterion("data_source_col_len not in", values, "dataSourceColLen");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenBetween(String value1, String value2) {
            addCriterion("data_source_col_len between", value1, value2, "dataSourceColLen");
            return (Criteria) this;
        }

        public Criteria andDataSourceColLenNotBetween(String value1, String value2) {
            addCriterion("data_source_col_len not between", value1, value2, "dataSourceColLen");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionIsNull() {
            addCriterion("data_source_col_precision is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionIsNotNull() {
            addCriterion("data_source_col_precision is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionEqualTo(String value) {
            addCriterion("data_source_col_precision =", value, "dataSourceColPrecision");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionNotEqualTo(String value) {
            addCriterion("data_source_col_precision <>", value, "dataSourceColPrecision");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionGreaterThan(String value) {
            addCriterion("data_source_col_precision >", value, "dataSourceColPrecision");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_col_precision >=", value, "dataSourceColPrecision");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionLessThan(String value) {
            addCriterion("data_source_col_precision <", value, "dataSourceColPrecision");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionLessThanOrEqualTo(String value) {
            addCriterion("data_source_col_precision <=", value, "dataSourceColPrecision");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionLike(String value) {
            addCriterion("data_source_col_precision like", value, "dataSourceColPrecision");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionNotLike(String value) {
            addCriterion("data_source_col_precision not like", value, "dataSourceColPrecision");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionIn(List<String> values) {
            addCriterion("data_source_col_precision in", values, "dataSourceColPrecision");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionNotIn(List<String> values) {
            addCriterion("data_source_col_precision not in", values, "dataSourceColPrecision");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionBetween(String value1, String value2) {
            addCriterion("data_source_col_precision between", value1, value2, "dataSourceColPrecision");
            return (Criteria) this;
        }

        public Criteria andDataSourceColPrecisionNotBetween(String value1, String value2) {
            addCriterion("data_source_col_precision not between", value1, value2, "dataSourceColPrecision");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleIsNull() {
            addCriterion("data_source_col_scale is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleIsNotNull() {
            addCriterion("data_source_col_scale is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleEqualTo(String value) {
            addCriterion("data_source_col_scale =", value, "dataSourceColScale");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleNotEqualTo(String value) {
            addCriterion("data_source_col_scale <>", value, "dataSourceColScale");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleGreaterThan(String value) {
            addCriterion("data_source_col_scale >", value, "dataSourceColScale");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_col_scale >=", value, "dataSourceColScale");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleLessThan(String value) {
            addCriterion("data_source_col_scale <", value, "dataSourceColScale");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleLessThanOrEqualTo(String value) {
            addCriterion("data_source_col_scale <=", value, "dataSourceColScale");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleLike(String value) {
            addCriterion("data_source_col_scale like", value, "dataSourceColScale");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleNotLike(String value) {
            addCriterion("data_source_col_scale not like", value, "dataSourceColScale");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleIn(List<String> values) {
            addCriterion("data_source_col_scale in", values, "dataSourceColScale");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleNotIn(List<String> values) {
            addCriterion("data_source_col_scale not in", values, "dataSourceColScale");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleBetween(String value1, String value2) {
            addCriterion("data_source_col_scale between", value1, value2, "dataSourceColScale");
            return (Criteria) this;
        }

        public Criteria andDataSourceColScaleNotBetween(String value1, String value2) {
            addCriterion("data_source_col_scale not between", value1, value2, "dataSourceColScale");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentIsNull() {
            addCriterion("data_source_col_comment is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentIsNotNull() {
            addCriterion("data_source_col_comment is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentEqualTo(String value) {
            addCriterion("data_source_col_comment =", value, "dataSourceColComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentNotEqualTo(String value) {
            addCriterion("data_source_col_comment <>", value, "dataSourceColComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentGreaterThan(String value) {
            addCriterion("data_source_col_comment >", value, "dataSourceColComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_col_comment >=", value, "dataSourceColComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentLessThan(String value) {
            addCriterion("data_source_col_comment <", value, "dataSourceColComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentLessThanOrEqualTo(String value) {
            addCriterion("data_source_col_comment <=", value, "dataSourceColComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentLike(String value) {
            addCriterion("data_source_col_comment like", value, "dataSourceColComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentNotLike(String value) {
            addCriterion("data_source_col_comment not like", value, "dataSourceColComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentIn(List<String> values) {
            addCriterion("data_source_col_comment in", values, "dataSourceColComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentNotIn(List<String> values) {
            addCriterion("data_source_col_comment not in", values, "dataSourceColComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentBetween(String value1, String value2) {
            addCriterion("data_source_col_comment between", value1, value2, "dataSourceColComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColCommentNotBetween(String value1, String value2) {
            addCriterion("data_source_col_comment not between", value1, value2, "dataSourceColComment");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagIsNull() {
            addCriterion("data_source_col_datalake_flag is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagIsNotNull() {
            addCriterion("data_source_col_datalake_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagEqualTo(String value) {
            addCriterion("data_source_col_datalake_flag =", value, "dataSourceColDatalakeFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagNotEqualTo(String value) {
            addCriterion("data_source_col_datalake_flag <>", value, "dataSourceColDatalakeFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagGreaterThan(String value) {
            addCriterion("data_source_col_datalake_flag >", value, "dataSourceColDatalakeFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_col_datalake_flag >=", value, "dataSourceColDatalakeFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagLessThan(String value) {
            addCriterion("data_source_col_datalake_flag <", value, "dataSourceColDatalakeFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagLessThanOrEqualTo(String value) {
            addCriterion("data_source_col_datalake_flag <=", value, "dataSourceColDatalakeFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagLike(String value) {
            addCriterion("data_source_col_datalake_flag like", value, "dataSourceColDatalakeFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagNotLike(String value) {
            addCriterion("data_source_col_datalake_flag not like", value, "dataSourceColDatalakeFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagIn(List<String> values) {
            addCriterion("data_source_col_datalake_flag in", values, "dataSourceColDatalakeFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagNotIn(List<String> values) {
            addCriterion("data_source_col_datalake_flag not in", values, "dataSourceColDatalakeFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagBetween(String value1, String value2) {
            addCriterion("data_source_col_datalake_flag between", value1, value2, "dataSourceColDatalakeFlag");
            return (Criteria) this;
        }

        public Criteria andDataSourceColDatalakeFlagNotBetween(String value1, String value2) {
            addCriterion("data_source_col_datalake_flag not between", value1, value2, "dataSourceColDatalakeFlag");
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