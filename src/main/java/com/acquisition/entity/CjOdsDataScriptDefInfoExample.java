package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjOdsDataScriptDefInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjOdsDataScriptDefInfoExample() {
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

        public Criteria andOdsDataScriptTypeIsNull() {
            addCriterion("ods_data_script_type is null");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeIsNotNull() {
            addCriterion("ods_data_script_type is not null");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeEqualTo(String value) {
            addCriterion("ods_data_script_type =", value, "odsDataScriptType");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeNotEqualTo(String value) {
            addCriterion("ods_data_script_type <>", value, "odsDataScriptType");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeGreaterThan(String value) {
            addCriterion("ods_data_script_type >", value, "odsDataScriptType");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ods_data_script_type >=", value, "odsDataScriptType");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeLessThan(String value) {
            addCriterion("ods_data_script_type <", value, "odsDataScriptType");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeLessThanOrEqualTo(String value) {
            addCriterion("ods_data_script_type <=", value, "odsDataScriptType");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeLike(String value) {
            addCriterion("ods_data_script_type like", value, "odsDataScriptType");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeNotLike(String value) {
            addCriterion("ods_data_script_type not like", value, "odsDataScriptType");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeIn(List<String> values) {
            addCriterion("ods_data_script_type in", values, "odsDataScriptType");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeNotIn(List<String> values) {
            addCriterion("ods_data_script_type not in", values, "odsDataScriptType");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeBetween(String value1, String value2) {
            addCriterion("ods_data_script_type between", value1, value2, "odsDataScriptType");
            return (Criteria) this;
        }

        public Criteria andOdsDataScriptTypeNotBetween(String value1, String value2) {
            addCriterion("ods_data_script_type not between", value1, value2, "odsDataScriptType");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineIsNull() {
            addCriterion("ods_data_sqoop_define is null");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineIsNotNull() {
            addCriterion("ods_data_sqoop_define is not null");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineEqualTo(String value) {
            addCriterion("ods_data_sqoop_define =", value, "odsDataSqoopDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineNotEqualTo(String value) {
            addCriterion("ods_data_sqoop_define <>", value, "odsDataSqoopDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineGreaterThan(String value) {
            addCriterion("ods_data_sqoop_define >", value, "odsDataSqoopDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineGreaterThanOrEqualTo(String value) {
            addCriterion("ods_data_sqoop_define >=", value, "odsDataSqoopDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineLessThan(String value) {
            addCriterion("ods_data_sqoop_define <", value, "odsDataSqoopDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineLessThanOrEqualTo(String value) {
            addCriterion("ods_data_sqoop_define <=", value, "odsDataSqoopDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineLike(String value) {
            addCriterion("ods_data_sqoop_define like", value, "odsDataSqoopDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineNotLike(String value) {
            addCriterion("ods_data_sqoop_define not like", value, "odsDataSqoopDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineIn(List<String> values) {
            addCriterion("ods_data_sqoop_define in", values, "odsDataSqoopDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineNotIn(List<String> values) {
            addCriterion("ods_data_sqoop_define not in", values, "odsDataSqoopDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineBetween(String value1, String value2) {
            addCriterion("ods_data_sqoop_define between", value1, value2, "odsDataSqoopDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataSqoopDefineNotBetween(String value1, String value2) {
            addCriterion("ods_data_sqoop_define not between", value1, value2, "odsDataSqoopDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineIsNull() {
            addCriterion("ods_data_hivesql_define is null");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineIsNotNull() {
            addCriterion("ods_data_hivesql_define is not null");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineEqualTo(String value) {
            addCriterion("ods_data_hivesql_define =", value, "odsDataHivesqlDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineNotEqualTo(String value) {
            addCriterion("ods_data_hivesql_define <>", value, "odsDataHivesqlDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineGreaterThan(String value) {
            addCriterion("ods_data_hivesql_define >", value, "odsDataHivesqlDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineGreaterThanOrEqualTo(String value) {
            addCriterion("ods_data_hivesql_define >=", value, "odsDataHivesqlDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineLessThan(String value) {
            addCriterion("ods_data_hivesql_define <", value, "odsDataHivesqlDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineLessThanOrEqualTo(String value) {
            addCriterion("ods_data_hivesql_define <=", value, "odsDataHivesqlDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineLike(String value) {
            addCriterion("ods_data_hivesql_define like", value, "odsDataHivesqlDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineNotLike(String value) {
            addCriterion("ods_data_hivesql_define not like", value, "odsDataHivesqlDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineIn(List<String> values) {
            addCriterion("ods_data_hivesql_define in", values, "odsDataHivesqlDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineNotIn(List<String> values) {
            addCriterion("ods_data_hivesql_define not in", values, "odsDataHivesqlDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineBetween(String value1, String value2) {
            addCriterion("ods_data_hivesql_define between", value1, value2, "odsDataHivesqlDefine");
            return (Criteria) this;
        }

        public Criteria andOdsDataHivesqlDefineNotBetween(String value1, String value2) {
            addCriterion("ods_data_hivesql_define not between", value1, value2, "odsDataHivesqlDefine");
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