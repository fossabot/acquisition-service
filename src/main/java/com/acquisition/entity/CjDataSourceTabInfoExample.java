package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjDataSourceTabInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjDataSourceTabInfoExample() {
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

        public Criteria andDataFlagForGetColsIsNull() {
            addCriterion("data_flag_for_get_cols is null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsIsNotNull() {
            addCriterion("data_flag_for_get_cols is not null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsEqualTo(String value) {
            addCriterion("data_flag_for_get_cols =", value, "dataFlagForGetCols");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsNotEqualTo(String value) {
            addCriterion("data_flag_for_get_cols <>", value, "dataFlagForGetCols");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsGreaterThan(String value) {
            addCriterion("data_flag_for_get_cols >", value, "dataFlagForGetCols");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsGreaterThanOrEqualTo(String value) {
            addCriterion("data_flag_for_get_cols >=", value, "dataFlagForGetCols");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsLessThan(String value) {
            addCriterion("data_flag_for_get_cols <", value, "dataFlagForGetCols");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsLessThanOrEqualTo(String value) {
            addCriterion("data_flag_for_get_cols <=", value, "dataFlagForGetCols");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsLike(String value) {
            addCriterion("data_flag_for_get_cols like", value, "dataFlagForGetCols");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsNotLike(String value) {
            addCriterion("data_flag_for_get_cols not like", value, "dataFlagForGetCols");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsIn(List<String> values) {
            addCriterion("data_flag_for_get_cols in", values, "dataFlagForGetCols");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsNotIn(List<String> values) {
            addCriterion("data_flag_for_get_cols not in", values, "dataFlagForGetCols");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsBetween(String value1, String value2) {
            addCriterion("data_flag_for_get_cols between", value1, value2, "dataFlagForGetCols");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetColsNotBetween(String value1, String value2) {
            addCriterion("data_flag_for_get_cols not between", value1, value2, "dataFlagForGetCols");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsIsNull() {
            addCriterion("data_flag_for_get_rows is null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsIsNotNull() {
            addCriterion("data_flag_for_get_rows is not null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsEqualTo(String value) {
            addCriterion("data_flag_for_get_rows =", value, "dataFlagForGetRows");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsNotEqualTo(String value) {
            addCriterion("data_flag_for_get_rows <>", value, "dataFlagForGetRows");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsGreaterThan(String value) {
            addCriterion("data_flag_for_get_rows >", value, "dataFlagForGetRows");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsGreaterThanOrEqualTo(String value) {
            addCriterion("data_flag_for_get_rows >=", value, "dataFlagForGetRows");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsLessThan(String value) {
            addCriterion("data_flag_for_get_rows <", value, "dataFlagForGetRows");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsLessThanOrEqualTo(String value) {
            addCriterion("data_flag_for_get_rows <=", value, "dataFlagForGetRows");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsLike(String value) {
            addCriterion("data_flag_for_get_rows like", value, "dataFlagForGetRows");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsNotLike(String value) {
            addCriterion("data_flag_for_get_rows not like", value, "dataFlagForGetRows");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsIn(List<String> values) {
            addCriterion("data_flag_for_get_rows in", values, "dataFlagForGetRows");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsNotIn(List<String> values) {
            addCriterion("data_flag_for_get_rows not in", values, "dataFlagForGetRows");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsBetween(String value1, String value2) {
            addCriterion("data_flag_for_get_rows between", value1, value2, "dataFlagForGetRows");
            return (Criteria) this;
        }

        public Criteria andDataFlagForGetRowsNotBetween(String value1, String value2) {
            addCriterion("data_flag_for_get_rows not between", value1, value2, "dataFlagForGetRows");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllIsNull() {
            addCriterion("data_flag_for_crt_ods_dll is null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllIsNotNull() {
            addCriterion("data_flag_for_crt_ods_dll is not null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllEqualTo(String value) {
            addCriterion("data_flag_for_crt_ods_dll =", value, "dataFlagForCrtOdsDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllNotEqualTo(String value) {
            addCriterion("data_flag_for_crt_ods_dll <>", value, "dataFlagForCrtOdsDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllGreaterThan(String value) {
            addCriterion("data_flag_for_crt_ods_dll >", value, "dataFlagForCrtOdsDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllGreaterThanOrEqualTo(String value) {
            addCriterion("data_flag_for_crt_ods_dll >=", value, "dataFlagForCrtOdsDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllLessThan(String value) {
            addCriterion("data_flag_for_crt_ods_dll <", value, "dataFlagForCrtOdsDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllLessThanOrEqualTo(String value) {
            addCriterion("data_flag_for_crt_ods_dll <=", value, "dataFlagForCrtOdsDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllLike(String value) {
            addCriterion("data_flag_for_crt_ods_dll like", value, "dataFlagForCrtOdsDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllNotLike(String value) {
            addCriterion("data_flag_for_crt_ods_dll not like", value, "dataFlagForCrtOdsDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllIn(List<String> values) {
            addCriterion("data_flag_for_crt_ods_dll in", values, "dataFlagForCrtOdsDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllNotIn(List<String> values) {
            addCriterion("data_flag_for_crt_ods_dll not in", values, "dataFlagForCrtOdsDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllBetween(String value1, String value2) {
            addCriterion("data_flag_for_crt_ods_dll between", value1, value2, "dataFlagForCrtOdsDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsDllNotBetween(String value1, String value2) {
            addCriterion("data_flag_for_crt_ods_dll not between", value1, value2, "dataFlagForCrtOdsDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveIsNull() {
            addCriterion("data_flag_for_crt_ods_hive is null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveIsNotNull() {
            addCriterion("data_flag_for_crt_ods_hive is not null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveEqualTo(String value) {
            addCriterion("data_flag_for_crt_ods_hive =", value, "dataFlagForCrtOdsHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveNotEqualTo(String value) {
            addCriterion("data_flag_for_crt_ods_hive <>", value, "dataFlagForCrtOdsHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveGreaterThan(String value) {
            addCriterion("data_flag_for_crt_ods_hive >", value, "dataFlagForCrtOdsHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveGreaterThanOrEqualTo(String value) {
            addCriterion("data_flag_for_crt_ods_hive >=", value, "dataFlagForCrtOdsHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveLessThan(String value) {
            addCriterion("data_flag_for_crt_ods_hive <", value, "dataFlagForCrtOdsHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveLessThanOrEqualTo(String value) {
            addCriterion("data_flag_for_crt_ods_hive <=", value, "dataFlagForCrtOdsHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveLike(String value) {
            addCriterion("data_flag_for_crt_ods_hive like", value, "dataFlagForCrtOdsHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveNotLike(String value) {
            addCriterion("data_flag_for_crt_ods_hive not like", value, "dataFlagForCrtOdsHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveIn(List<String> values) {
            addCriterion("data_flag_for_crt_ods_hive in", values, "dataFlagForCrtOdsHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveNotIn(List<String> values) {
            addCriterion("data_flag_for_crt_ods_hive not in", values, "dataFlagForCrtOdsHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveBetween(String value1, String value2) {
            addCriterion("data_flag_for_crt_ods_hive between", value1, value2, "dataFlagForCrtOdsHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsHiveNotBetween(String value1, String value2) {
            addCriterion("data_flag_for_crt_ods_hive not between", value1, value2, "dataFlagForCrtOdsHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllIsNull() {
            addCriterion("data_flag_for_crt_dw_dll is null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllIsNotNull() {
            addCriterion("data_flag_for_crt_dw_dll is not null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllEqualTo(String value) {
            addCriterion("data_flag_for_crt_dw_dll =", value, "dataFlagForCrtDwDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllNotEqualTo(String value) {
            addCriterion("data_flag_for_crt_dw_dll <>", value, "dataFlagForCrtDwDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllGreaterThan(String value) {
            addCriterion("data_flag_for_crt_dw_dll >", value, "dataFlagForCrtDwDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllGreaterThanOrEqualTo(String value) {
            addCriterion("data_flag_for_crt_dw_dll >=", value, "dataFlagForCrtDwDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllLessThan(String value) {
            addCriterion("data_flag_for_crt_dw_dll <", value, "dataFlagForCrtDwDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllLessThanOrEqualTo(String value) {
            addCriterion("data_flag_for_crt_dw_dll <=", value, "dataFlagForCrtDwDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllLike(String value) {
            addCriterion("data_flag_for_crt_dw_dll like", value, "dataFlagForCrtDwDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllNotLike(String value) {
            addCriterion("data_flag_for_crt_dw_dll not like", value, "dataFlagForCrtDwDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllIn(List<String> values) {
            addCriterion("data_flag_for_crt_dw_dll in", values, "dataFlagForCrtDwDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllNotIn(List<String> values) {
            addCriterion("data_flag_for_crt_dw_dll not in", values, "dataFlagForCrtDwDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllBetween(String value1, String value2) {
            addCriterion("data_flag_for_crt_dw_dll between", value1, value2, "dataFlagForCrtDwDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwDllNotBetween(String value1, String value2) {
            addCriterion("data_flag_for_crt_dw_dll not between", value1, value2, "dataFlagForCrtDwDll");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveIsNull() {
            addCriterion("data_flag_for_crt_dw_hive is null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveIsNotNull() {
            addCriterion("data_flag_for_crt_dw_hive is not null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveEqualTo(String value) {
            addCriterion("data_flag_for_crt_dw_hive =", value, "dataFlagForCrtDwHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveNotEqualTo(String value) {
            addCriterion("data_flag_for_crt_dw_hive <>", value, "dataFlagForCrtDwHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveGreaterThan(String value) {
            addCriterion("data_flag_for_crt_dw_hive >", value, "dataFlagForCrtDwHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveGreaterThanOrEqualTo(String value) {
            addCriterion("data_flag_for_crt_dw_hive >=", value, "dataFlagForCrtDwHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveLessThan(String value) {
            addCriterion("data_flag_for_crt_dw_hive <", value, "dataFlagForCrtDwHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveLessThanOrEqualTo(String value) {
            addCriterion("data_flag_for_crt_dw_hive <=", value, "dataFlagForCrtDwHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveLike(String value) {
            addCriterion("data_flag_for_crt_dw_hive like", value, "dataFlagForCrtDwHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveNotLike(String value) {
            addCriterion("data_flag_for_crt_dw_hive not like", value, "dataFlagForCrtDwHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveIn(List<String> values) {
            addCriterion("data_flag_for_crt_dw_hive in", values, "dataFlagForCrtDwHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveNotIn(List<String> values) {
            addCriterion("data_flag_for_crt_dw_hive not in", values, "dataFlagForCrtDwHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveBetween(String value1, String value2) {
            addCriterion("data_flag_for_crt_dw_hive between", value1, value2, "dataFlagForCrtDwHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwHiveNotBetween(String value1, String value2) {
            addCriterion("data_flag_for_crt_dw_hive not between", value1, value2, "dataFlagForCrtDwHive");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptIsNull() {
            addCriterion("data_flag_for_crt_ods_script is null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptIsNotNull() {
            addCriterion("data_flag_for_crt_ods_script is not null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptEqualTo(String value) {
            addCriterion("data_flag_for_crt_ods_script =", value, "dataFlagForCrtOdsScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptNotEqualTo(String value) {
            addCriterion("data_flag_for_crt_ods_script <>", value, "dataFlagForCrtOdsScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptGreaterThan(String value) {
            addCriterion("data_flag_for_crt_ods_script >", value, "dataFlagForCrtOdsScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptGreaterThanOrEqualTo(String value) {
            addCriterion("data_flag_for_crt_ods_script >=", value, "dataFlagForCrtOdsScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptLessThan(String value) {
            addCriterion("data_flag_for_crt_ods_script <", value, "dataFlagForCrtOdsScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptLessThanOrEqualTo(String value) {
            addCriterion("data_flag_for_crt_ods_script <=", value, "dataFlagForCrtOdsScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptLike(String value) {
            addCriterion("data_flag_for_crt_ods_script like", value, "dataFlagForCrtOdsScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptNotLike(String value) {
            addCriterion("data_flag_for_crt_ods_script not like", value, "dataFlagForCrtOdsScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptIn(List<String> values) {
            addCriterion("data_flag_for_crt_ods_script in", values, "dataFlagForCrtOdsScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptNotIn(List<String> values) {
            addCriterion("data_flag_for_crt_ods_script not in", values, "dataFlagForCrtOdsScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptBetween(String value1, String value2) {
            addCriterion("data_flag_for_crt_ods_script between", value1, value2, "dataFlagForCrtOdsScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtOdsScriptNotBetween(String value1, String value2) {
            addCriterion("data_flag_for_crt_ods_script not between", value1, value2, "dataFlagForCrtOdsScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptIsNull() {
            addCriterion("data_flag_for_crt_dw_script is null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptIsNotNull() {
            addCriterion("data_flag_for_crt_dw_script is not null");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptEqualTo(String value) {
            addCriterion("data_flag_for_crt_dw_script =", value, "dataFlagForCrtDwScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptNotEqualTo(String value) {
            addCriterion("data_flag_for_crt_dw_script <>", value, "dataFlagForCrtDwScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptGreaterThan(String value) {
            addCriterion("data_flag_for_crt_dw_script >", value, "dataFlagForCrtDwScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptGreaterThanOrEqualTo(String value) {
            addCriterion("data_flag_for_crt_dw_script >=", value, "dataFlagForCrtDwScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptLessThan(String value) {
            addCriterion("data_flag_for_crt_dw_script <", value, "dataFlagForCrtDwScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptLessThanOrEqualTo(String value) {
            addCriterion("data_flag_for_crt_dw_script <=", value, "dataFlagForCrtDwScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptLike(String value) {
            addCriterion("data_flag_for_crt_dw_script like", value, "dataFlagForCrtDwScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptNotLike(String value) {
            addCriterion("data_flag_for_crt_dw_script not like", value, "dataFlagForCrtDwScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptIn(List<String> values) {
            addCriterion("data_flag_for_crt_dw_script in", values, "dataFlagForCrtDwScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptNotIn(List<String> values) {
            addCriterion("data_flag_for_crt_dw_script not in", values, "dataFlagForCrtDwScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptBetween(String value1, String value2) {
            addCriterion("data_flag_for_crt_dw_script between", value1, value2, "dataFlagForCrtDwScript");
            return (Criteria) this;
        }

        public Criteria andDataFlagForCrtDwScriptNotBetween(String value1, String value2) {
            addCriterion("data_flag_for_crt_dw_script not between", value1, value2, "dataFlagForCrtDwScript");
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