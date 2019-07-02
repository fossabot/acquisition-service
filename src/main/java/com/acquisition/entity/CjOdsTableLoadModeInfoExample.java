package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjOdsTableLoadModeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjOdsTableLoadModeInfoExample() {
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

        public Criteria andOdsDataLoadModeIsNull() {
            addCriterion("ods_data_load_mode is null");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeIsNotNull() {
            addCriterion("ods_data_load_mode is not null");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeEqualTo(String value) {
            addCriterion("ods_data_load_mode =", value, "odsDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeNotEqualTo(String value) {
            addCriterion("ods_data_load_mode <>", value, "odsDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeGreaterThan(String value) {
            addCriterion("ods_data_load_mode >", value, "odsDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeGreaterThanOrEqualTo(String value) {
            addCriterion("ods_data_load_mode >=", value, "odsDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeLessThan(String value) {
            addCriterion("ods_data_load_mode <", value, "odsDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeLessThanOrEqualTo(String value) {
            addCriterion("ods_data_load_mode <=", value, "odsDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeLike(String value) {
            addCriterion("ods_data_load_mode like", value, "odsDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeNotLike(String value) {
            addCriterion("ods_data_load_mode not like", value, "odsDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeIn(List<String> values) {
            addCriterion("ods_data_load_mode in", values, "odsDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeNotIn(List<String> values) {
            addCriterion("ods_data_load_mode not in", values, "odsDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeBetween(String value1, String value2) {
            addCriterion("ods_data_load_mode between", value1, value2, "odsDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andOdsDataLoadModeNotBetween(String value1, String value2) {
            addCriterion("ods_data_load_mode not between", value1, value2, "odsDataLoadMode");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameIsNull() {
            addCriterion("ods_table_partition_col_name is null");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameIsNotNull() {
            addCriterion("ods_table_partition_col_name is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameEqualTo(String value) {
            addCriterion("ods_table_partition_col_name =", value, "odsTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameNotEqualTo(String value) {
            addCriterion("ods_table_partition_col_name <>", value, "odsTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameGreaterThan(String value) {
            addCriterion("ods_table_partition_col_name >", value, "odsTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameGreaterThanOrEqualTo(String value) {
            addCriterion("ods_table_partition_col_name >=", value, "odsTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameLessThan(String value) {
            addCriterion("ods_table_partition_col_name <", value, "odsTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameLessThanOrEqualTo(String value) {
            addCriterion("ods_table_partition_col_name <=", value, "odsTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameLike(String value) {
            addCriterion("ods_table_partition_col_name like", value, "odsTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameNotLike(String value) {
            addCriterion("ods_table_partition_col_name not like", value, "odsTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameIn(List<String> values) {
            addCriterion("ods_table_partition_col_name in", values, "odsTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameNotIn(List<String> values) {
            addCriterion("ods_table_partition_col_name not in", values, "odsTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameBetween(String value1, String value2) {
            addCriterion("ods_table_partition_col_name between", value1, value2, "odsTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameNotBetween(String value1, String value2) {
            addCriterion("ods_table_partition_col_name not between", value1, value2, "odsTablePartitionColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitIsNull() {
            addCriterion("ods_table_partition_unit is null");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitIsNotNull() {
            addCriterion("ods_table_partition_unit is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitEqualTo(String value) {
            addCriterion("ods_table_partition_unit =", value, "odsTablePartitionUnit");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitNotEqualTo(String value) {
            addCriterion("ods_table_partition_unit <>", value, "odsTablePartitionUnit");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitGreaterThan(String value) {
            addCriterion("ods_table_partition_unit >", value, "odsTablePartitionUnit");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitGreaterThanOrEqualTo(String value) {
            addCriterion("ods_table_partition_unit >=", value, "odsTablePartitionUnit");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitLessThan(String value) {
            addCriterion("ods_table_partition_unit <", value, "odsTablePartitionUnit");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitLessThanOrEqualTo(String value) {
            addCriterion("ods_table_partition_unit <=", value, "odsTablePartitionUnit");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitLike(String value) {
            addCriterion("ods_table_partition_unit like", value, "odsTablePartitionUnit");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitNotLike(String value) {
            addCriterion("ods_table_partition_unit not like", value, "odsTablePartitionUnit");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitIn(List<String> values) {
            addCriterion("ods_table_partition_unit in", values, "odsTablePartitionUnit");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitNotIn(List<String> values) {
            addCriterion("ods_table_partition_unit not in", values, "odsTablePartitionUnit");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitBetween(String value1, String value2) {
            addCriterion("ods_table_partition_unit between", value1, value2, "odsTablePartitionUnit");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionUnitNotBetween(String value1, String value2) {
            addCriterion("ods_table_partition_unit not between", value1, value2, "odsTablePartitionUnit");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameIsNull() {
            addCriterion("ods_table_primary_col_name is null");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameIsNotNull() {
            addCriterion("ods_table_primary_col_name is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameEqualTo(String value) {
            addCriterion("ods_table_primary_col_name =", value, "odsTablePrimaryColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameNotEqualTo(String value) {
            addCriterion("ods_table_primary_col_name <>", value, "odsTablePrimaryColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameGreaterThan(String value) {
            addCriterion("ods_table_primary_col_name >", value, "odsTablePrimaryColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameGreaterThanOrEqualTo(String value) {
            addCriterion("ods_table_primary_col_name >=", value, "odsTablePrimaryColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameLessThan(String value) {
            addCriterion("ods_table_primary_col_name <", value, "odsTablePrimaryColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameLessThanOrEqualTo(String value) {
            addCriterion("ods_table_primary_col_name <=", value, "odsTablePrimaryColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameLike(String value) {
            addCriterion("ods_table_primary_col_name like", value, "odsTablePrimaryColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameNotLike(String value) {
            addCriterion("ods_table_primary_col_name not like", value, "odsTablePrimaryColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameIn(List<String> values) {
            addCriterion("ods_table_primary_col_name in", values, "odsTablePrimaryColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameNotIn(List<String> values) {
            addCriterion("ods_table_primary_col_name not in", values, "odsTablePrimaryColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameBetween(String value1, String value2) {
            addCriterion("ods_table_primary_col_name between", value1, value2, "odsTablePrimaryColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePrimaryColNameNotBetween(String value1, String value2) {
            addCriterion("ods_table_primary_col_name not between", value1, value2, "odsTablePrimaryColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameIsNull() {
            addCriterion("ods_table_increment_col_name is null");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameIsNotNull() {
            addCriterion("ods_table_increment_col_name is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameEqualTo(String value) {
            addCriterion("ods_table_increment_col_name =", value, "odsTableIncrementColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameNotEqualTo(String value) {
            addCriterion("ods_table_increment_col_name <>", value, "odsTableIncrementColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameGreaterThan(String value) {
            addCriterion("ods_table_increment_col_name >", value, "odsTableIncrementColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameGreaterThanOrEqualTo(String value) {
            addCriterion("ods_table_increment_col_name >=", value, "odsTableIncrementColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameLessThan(String value) {
            addCriterion("ods_table_increment_col_name <", value, "odsTableIncrementColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameLessThanOrEqualTo(String value) {
            addCriterion("ods_table_increment_col_name <=", value, "odsTableIncrementColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameLike(String value) {
            addCriterion("ods_table_increment_col_name like", value, "odsTableIncrementColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameNotLike(String value) {
            addCriterion("ods_table_increment_col_name not like", value, "odsTableIncrementColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameIn(List<String> values) {
            addCriterion("ods_table_increment_col_name in", values, "odsTableIncrementColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameNotIn(List<String> values) {
            addCriterion("ods_table_increment_col_name not in", values, "odsTableIncrementColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameBetween(String value1, String value2) {
            addCriterion("ods_table_increment_col_name between", value1, value2, "odsTableIncrementColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableIncrementColNameNotBetween(String value1, String value2) {
            addCriterion("ods_table_increment_col_name not between", value1, value2, "odsTableIncrementColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameIsNull() {
            addCriterion("ods_table_split_col_name is null");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameIsNotNull() {
            addCriterion("ods_table_split_col_name is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameEqualTo(String value) {
            addCriterion("ods_table_split_col_name =", value, "odsTableSplitColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameNotEqualTo(String value) {
            addCriterion("ods_table_split_col_name <>", value, "odsTableSplitColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameGreaterThan(String value) {
            addCriterion("ods_table_split_col_name >", value, "odsTableSplitColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameGreaterThanOrEqualTo(String value) {
            addCriterion("ods_table_split_col_name >=", value, "odsTableSplitColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameLessThan(String value) {
            addCriterion("ods_table_split_col_name <", value, "odsTableSplitColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameLessThanOrEqualTo(String value) {
            addCriterion("ods_table_split_col_name <=", value, "odsTableSplitColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameLike(String value) {
            addCriterion("ods_table_split_col_name like", value, "odsTableSplitColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameNotLike(String value) {
            addCriterion("ods_table_split_col_name not like", value, "odsTableSplitColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameIn(List<String> values) {
            addCriterion("ods_table_split_col_name in", values, "odsTableSplitColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameNotIn(List<String> values) {
            addCriterion("ods_table_split_col_name not in", values, "odsTableSplitColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameBetween(String value1, String value2) {
            addCriterion("ods_table_split_col_name between", value1, value2, "odsTableSplitColName");
            return (Criteria) this;
        }

        public Criteria andOdsTableSplitColNameNotBetween(String value1, String value2) {
            addCriterion("ods_table_split_col_name not between", value1, value2, "odsTableSplitColName");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceIsNull() {
            addCriterion("ods_table_partition_col_name_source is null");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceIsNotNull() {
            addCriterion("ods_table_partition_col_name_source is not null");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceEqualTo(String value) {
            addCriterion("ods_table_partition_col_name_source =", value, "odsTablePartitionColNameSource");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceNotEqualTo(String value) {
            addCriterion("ods_table_partition_col_name_source <>", value, "odsTablePartitionColNameSource");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceGreaterThan(String value) {
            addCriterion("ods_table_partition_col_name_source >", value, "odsTablePartitionColNameSource");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceGreaterThanOrEqualTo(String value) {
            addCriterion("ods_table_partition_col_name_source >=", value, "odsTablePartitionColNameSource");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceLessThan(String value) {
            addCriterion("ods_table_partition_col_name_source <", value, "odsTablePartitionColNameSource");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceLessThanOrEqualTo(String value) {
            addCriterion("ods_table_partition_col_name_source <=", value, "odsTablePartitionColNameSource");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceLike(String value) {
            addCriterion("ods_table_partition_col_name_source like", value, "odsTablePartitionColNameSource");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceNotLike(String value) {
            addCriterion("ods_table_partition_col_name_source not like", value, "odsTablePartitionColNameSource");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceIn(List<String> values) {
            addCriterion("ods_table_partition_col_name_source in", values, "odsTablePartitionColNameSource");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceNotIn(List<String> values) {
            addCriterion("ods_table_partition_col_name_source not in", values, "odsTablePartitionColNameSource");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceBetween(String value1, String value2) {
            addCriterion("ods_table_partition_col_name_source between", value1, value2, "odsTablePartitionColNameSource");
            return (Criteria) this;
        }

        public Criteria andOdsTablePartitionColNameSourceNotBetween(String value1, String value2) {
            addCriterion("ods_table_partition_col_name_source not between", value1, value2, "odsTablePartitionColNameSource");
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