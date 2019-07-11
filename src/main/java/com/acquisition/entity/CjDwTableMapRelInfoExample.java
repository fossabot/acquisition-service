package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjDwTableMapRelInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjDwTableMapRelInfoExample() {
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

        public Criteria andTableJoinTypeIsNull() {
            addCriterion("table_join_type is null");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeIsNotNull() {
            addCriterion("table_join_type is not null");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeEqualTo(String value) {
            addCriterion("table_join_type =", value, "tableJoinType");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeNotEqualTo(String value) {
            addCriterion("table_join_type <>", value, "tableJoinType");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeGreaterThan(String value) {
            addCriterion("table_join_type >", value, "tableJoinType");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeGreaterThanOrEqualTo(String value) {
            addCriterion("table_join_type >=", value, "tableJoinType");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeLessThan(String value) {
            addCriterion("table_join_type <", value, "tableJoinType");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeLessThanOrEqualTo(String value) {
            addCriterion("table_join_type <=", value, "tableJoinType");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeLike(String value) {
            addCriterion("table_join_type like", value, "tableJoinType");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeNotLike(String value) {
            addCriterion("table_join_type not like", value, "tableJoinType");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeIn(List<String> values) {
            addCriterion("table_join_type in", values, "tableJoinType");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeNotIn(List<String> values) {
            addCriterion("table_join_type not in", values, "tableJoinType");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeBetween(String value1, String value2) {
            addCriterion("table_join_type between", value1, value2, "tableJoinType");
            return (Criteria) this;
        }

        public Criteria andTableJoinTypeNotBetween(String value1, String value2) {
            addCriterion("table_join_type not between", value1, value2, "tableJoinType");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameIsNull() {
            addCriterion("join_table_name is null");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameIsNotNull() {
            addCriterion("join_table_name is not null");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameEqualTo(String value) {
            addCriterion("join_table_name =", value, "joinTableName");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameNotEqualTo(String value) {
            addCriterion("join_table_name <>", value, "joinTableName");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameGreaterThan(String value) {
            addCriterion("join_table_name >", value, "joinTableName");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("join_table_name >=", value, "joinTableName");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameLessThan(String value) {
            addCriterion("join_table_name <", value, "joinTableName");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameLessThanOrEqualTo(String value) {
            addCriterion("join_table_name <=", value, "joinTableName");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameLike(String value) {
            addCriterion("join_table_name like", value, "joinTableName");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameNotLike(String value) {
            addCriterion("join_table_name not like", value, "joinTableName");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameIn(List<String> values) {
            addCriterion("join_table_name in", values, "joinTableName");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameNotIn(List<String> values) {
            addCriterion("join_table_name not in", values, "joinTableName");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameBetween(String value1, String value2) {
            addCriterion("join_table_name between", value1, value2, "joinTableName");
            return (Criteria) this;
        }

        public Criteria andJoinTableNameNotBetween(String value1, String value2) {
            addCriterion("join_table_name not between", value1, value2, "joinTableName");
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

        public Criteria andSourceTableAliasNameIsNull() {
            addCriterion("source_table_alias_name is null");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameIsNotNull() {
            addCriterion("source_table_alias_name is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameEqualTo(String value) {
            addCriterion("source_table_alias_name =", value, "sourceTableAliasName");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameNotEqualTo(String value) {
            addCriterion("source_table_alias_name <>", value, "sourceTableAliasName");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameGreaterThan(String value) {
            addCriterion("source_table_alias_name >", value, "sourceTableAliasName");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameGreaterThanOrEqualTo(String value) {
            addCriterion("source_table_alias_name >=", value, "sourceTableAliasName");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameLessThan(String value) {
            addCriterion("source_table_alias_name <", value, "sourceTableAliasName");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameLessThanOrEqualTo(String value) {
            addCriterion("source_table_alias_name <=", value, "sourceTableAliasName");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameLike(String value) {
            addCriterion("source_table_alias_name like", value, "sourceTableAliasName");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameNotLike(String value) {
            addCriterion("source_table_alias_name not like", value, "sourceTableAliasName");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameIn(List<String> values) {
            addCriterion("source_table_alias_name in", values, "sourceTableAliasName");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameNotIn(List<String> values) {
            addCriterion("source_table_alias_name not in", values, "sourceTableAliasName");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameBetween(String value1, String value2) {
            addCriterion("source_table_alias_name between", value1, value2, "sourceTableAliasName");
            return (Criteria) this;
        }

        public Criteria andSourceTableAliasNameNotBetween(String value1, String value2) {
            addCriterion("source_table_alias_name not between", value1, value2, "sourceTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaIsNull() {
            addCriterion("join_table_schema is null");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaIsNotNull() {
            addCriterion("join_table_schema is not null");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaEqualTo(String value) {
            addCriterion("join_table_schema =", value, "joinTableSchema");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaNotEqualTo(String value) {
            addCriterion("join_table_schema <>", value, "joinTableSchema");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaGreaterThan(String value) {
            addCriterion("join_table_schema >", value, "joinTableSchema");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("join_table_schema >=", value, "joinTableSchema");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaLessThan(String value) {
            addCriterion("join_table_schema <", value, "joinTableSchema");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaLessThanOrEqualTo(String value) {
            addCriterion("join_table_schema <=", value, "joinTableSchema");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaLike(String value) {
            addCriterion("join_table_schema like", value, "joinTableSchema");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaNotLike(String value) {
            addCriterion("join_table_schema not like", value, "joinTableSchema");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaIn(List<String> values) {
            addCriterion("join_table_schema in", values, "joinTableSchema");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaNotIn(List<String> values) {
            addCriterion("join_table_schema not in", values, "joinTableSchema");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaBetween(String value1, String value2) {
            addCriterion("join_table_schema between", value1, value2, "joinTableSchema");
            return (Criteria) this;
        }

        public Criteria andJoinTableSchemaNotBetween(String value1, String value2) {
            addCriterion("join_table_schema not between", value1, value2, "joinTableSchema");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameIsNull() {
            addCriterion("join_table_alias_name is null");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameIsNotNull() {
            addCriterion("join_table_alias_name is not null");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameEqualTo(String value) {
            addCriterion("join_table_alias_name =", value, "joinTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameNotEqualTo(String value) {
            addCriterion("join_table_alias_name <>", value, "joinTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameGreaterThan(String value) {
            addCriterion("join_table_alias_name >", value, "joinTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameGreaterThanOrEqualTo(String value) {
            addCriterion("join_table_alias_name >=", value, "joinTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameLessThan(String value) {
            addCriterion("join_table_alias_name <", value, "joinTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameLessThanOrEqualTo(String value) {
            addCriterion("join_table_alias_name <=", value, "joinTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameLike(String value) {
            addCriterion("join_table_alias_name like", value, "joinTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameNotLike(String value) {
            addCriterion("join_table_alias_name not like", value, "joinTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameIn(List<String> values) {
            addCriterion("join_table_alias_name in", values, "joinTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameNotIn(List<String> values) {
            addCriterion("join_table_alias_name not in", values, "joinTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameBetween(String value1, String value2) {
            addCriterion("join_table_alias_name between", value1, value2, "joinTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableAliasNameNotBetween(String value1, String value2) {
            addCriterion("join_table_alias_name not between", value1, value2, "joinTableAliasName");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionIsNull() {
            addCriterion("join_table_condition is null");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionIsNotNull() {
            addCriterion("join_table_condition is not null");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionEqualTo(String value) {
            addCriterion("join_table_condition =", value, "joinTableCondition");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionNotEqualTo(String value) {
            addCriterion("join_table_condition <>", value, "joinTableCondition");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionGreaterThan(String value) {
            addCriterion("join_table_condition >", value, "joinTableCondition");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionGreaterThanOrEqualTo(String value) {
            addCriterion("join_table_condition >=", value, "joinTableCondition");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionLessThan(String value) {
            addCriterion("join_table_condition <", value, "joinTableCondition");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionLessThanOrEqualTo(String value) {
            addCriterion("join_table_condition <=", value, "joinTableCondition");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionLike(String value) {
            addCriterion("join_table_condition like", value, "joinTableCondition");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionNotLike(String value) {
            addCriterion("join_table_condition not like", value, "joinTableCondition");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionIn(List<String> values) {
            addCriterion("join_table_condition in", values, "joinTableCondition");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionNotIn(List<String> values) {
            addCriterion("join_table_condition not in", values, "joinTableCondition");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionBetween(String value1, String value2) {
            addCriterion("join_table_condition between", value1, value2, "joinTableCondition");
            return (Criteria) this;
        }

        public Criteria andJoinTableConditionNotBetween(String value1, String value2) {
            addCriterion("join_table_condition not between", value1, value2, "joinTableCondition");
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