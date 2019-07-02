package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjDataSourceConnDefineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjDataSourceConnDefineExample() {
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

        public Criteria andDataSourceTypeIsNull() {
            addCriterion("data_source_type is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeIsNotNull() {
            addCriterion("data_source_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeEqualTo(String value) {
            addCriterion("data_source_type =", value, "dataSourceType");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeNotEqualTo(String value) {
            addCriterion("data_source_type <>", value, "dataSourceType");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeGreaterThan(String value) {
            addCriterion("data_source_type >", value, "dataSourceType");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("data_source_type >=", value, "dataSourceType");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeLessThan(String value) {
            addCriterion("data_source_type <", value, "dataSourceType");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeLessThanOrEqualTo(String value) {
            addCriterion("data_source_type <=", value, "dataSourceType");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeLike(String value) {
            addCriterion("data_source_type like", value, "dataSourceType");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeNotLike(String value) {
            addCriterion("data_source_type not like", value, "dataSourceType");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeIn(List<String> values) {
            addCriterion("data_source_type in", values, "dataSourceType");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeNotIn(List<String> values) {
            addCriterion("data_source_type not in", values, "dataSourceType");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeBetween(String value1, String value2) {
            addCriterion("data_source_type between", value1, value2, "dataSourceType");
            return (Criteria) this;
        }

        public Criteria andDataSourceTypeNotBetween(String value1, String value2) {
            addCriterion("data_source_type not between", value1, value2, "dataSourceType");
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

        public Criteria andBusinessSystemNameIsNull() {
            addCriterion("business_system_name is null");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameIsNotNull() {
            addCriterion("business_system_name is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameEqualTo(String value) {
            addCriterion("business_system_name =", value, "businessSystemName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameNotEqualTo(String value) {
            addCriterion("business_system_name <>", value, "businessSystemName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameGreaterThan(String value) {
            addCriterion("business_system_name >", value, "businessSystemName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameGreaterThanOrEqualTo(String value) {
            addCriterion("business_system_name >=", value, "businessSystemName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameLessThan(String value) {
            addCriterion("business_system_name <", value, "businessSystemName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameLessThanOrEqualTo(String value) {
            addCriterion("business_system_name <=", value, "businessSystemName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameLike(String value) {
            addCriterion("business_system_name like", value, "businessSystemName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameNotLike(String value) {
            addCriterion("business_system_name not like", value, "businessSystemName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameIn(List<String> values) {
            addCriterion("business_system_name in", values, "businessSystemName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameNotIn(List<String> values) {
            addCriterion("business_system_name not in", values, "businessSystemName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameBetween(String value1, String value2) {
            addCriterion("business_system_name between", value1, value2, "businessSystemName");
            return (Criteria) this;
        }

        public Criteria andBusinessSystemNameNotBetween(String value1, String value2) {
            addCriterion("business_system_name not between", value1, value2, "businessSystemName");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeIsNull() {
            addCriterion("data_base_type is null");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeIsNotNull() {
            addCriterion("data_base_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeEqualTo(String value) {
            addCriterion("data_base_type =", value, "dataBaseType");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeNotEqualTo(String value) {
            addCriterion("data_base_type <>", value, "dataBaseType");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeGreaterThan(String value) {
            addCriterion("data_base_type >", value, "dataBaseType");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("data_base_type >=", value, "dataBaseType");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeLessThan(String value) {
            addCriterion("data_base_type <", value, "dataBaseType");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeLessThanOrEqualTo(String value) {
            addCriterion("data_base_type <=", value, "dataBaseType");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeLike(String value) {
            addCriterion("data_base_type like", value, "dataBaseType");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeNotLike(String value) {
            addCriterion("data_base_type not like", value, "dataBaseType");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeIn(List<String> values) {
            addCriterion("data_base_type in", values, "dataBaseType");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeNotIn(List<String> values) {
            addCriterion("data_base_type not in", values, "dataBaseType");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeBetween(String value1, String value2) {
            addCriterion("data_base_type between", value1, value2, "dataBaseType");
            return (Criteria) this;
        }

        public Criteria andDataBaseTypeNotBetween(String value1, String value2) {
            addCriterion("data_base_type not between", value1, value2, "dataBaseType");
            return (Criteria) this;
        }

        public Criteria andConnIpIsNull() {
            addCriterion("conn_ip is null");
            return (Criteria) this;
        }

        public Criteria andConnIpIsNotNull() {
            addCriterion("conn_ip is not null");
            return (Criteria) this;
        }

        public Criteria andConnIpEqualTo(String value) {
            addCriterion("conn_ip =", value, "connIp");
            return (Criteria) this;
        }

        public Criteria andConnIpNotEqualTo(String value) {
            addCriterion("conn_ip <>", value, "connIp");
            return (Criteria) this;
        }

        public Criteria andConnIpGreaterThan(String value) {
            addCriterion("conn_ip >", value, "connIp");
            return (Criteria) this;
        }

        public Criteria andConnIpGreaterThanOrEqualTo(String value) {
            addCriterion("conn_ip >=", value, "connIp");
            return (Criteria) this;
        }

        public Criteria andConnIpLessThan(String value) {
            addCriterion("conn_ip <", value, "connIp");
            return (Criteria) this;
        }

        public Criteria andConnIpLessThanOrEqualTo(String value) {
            addCriterion("conn_ip <=", value, "connIp");
            return (Criteria) this;
        }

        public Criteria andConnIpLike(String value) {
            addCriterion("conn_ip like", value, "connIp");
            return (Criteria) this;
        }

        public Criteria andConnIpNotLike(String value) {
            addCriterion("conn_ip not like", value, "connIp");
            return (Criteria) this;
        }

        public Criteria andConnIpIn(List<String> values) {
            addCriterion("conn_ip in", values, "connIp");
            return (Criteria) this;
        }

        public Criteria andConnIpNotIn(List<String> values) {
            addCriterion("conn_ip not in", values, "connIp");
            return (Criteria) this;
        }

        public Criteria andConnIpBetween(String value1, String value2) {
            addCriterion("conn_ip between", value1, value2, "connIp");
            return (Criteria) this;
        }

        public Criteria andConnIpNotBetween(String value1, String value2) {
            addCriterion("conn_ip not between", value1, value2, "connIp");
            return (Criteria) this;
        }

        public Criteria andConnPortIsNull() {
            addCriterion("conn_port is null");
            return (Criteria) this;
        }

        public Criteria andConnPortIsNotNull() {
            addCriterion("conn_port is not null");
            return (Criteria) this;
        }

        public Criteria andConnPortEqualTo(String value) {
            addCriterion("conn_port =", value, "connPort");
            return (Criteria) this;
        }

        public Criteria andConnPortNotEqualTo(String value) {
            addCriterion("conn_port <>", value, "connPort");
            return (Criteria) this;
        }

        public Criteria andConnPortGreaterThan(String value) {
            addCriterion("conn_port >", value, "connPort");
            return (Criteria) this;
        }

        public Criteria andConnPortGreaterThanOrEqualTo(String value) {
            addCriterion("conn_port >=", value, "connPort");
            return (Criteria) this;
        }

        public Criteria andConnPortLessThan(String value) {
            addCriterion("conn_port <", value, "connPort");
            return (Criteria) this;
        }

        public Criteria andConnPortLessThanOrEqualTo(String value) {
            addCriterion("conn_port <=", value, "connPort");
            return (Criteria) this;
        }

        public Criteria andConnPortLike(String value) {
            addCriterion("conn_port like", value, "connPort");
            return (Criteria) this;
        }

        public Criteria andConnPortNotLike(String value) {
            addCriterion("conn_port not like", value, "connPort");
            return (Criteria) this;
        }

        public Criteria andConnPortIn(List<String> values) {
            addCriterion("conn_port in", values, "connPort");
            return (Criteria) this;
        }

        public Criteria andConnPortNotIn(List<String> values) {
            addCriterion("conn_port not in", values, "connPort");
            return (Criteria) this;
        }

        public Criteria andConnPortBetween(String value1, String value2) {
            addCriterion("conn_port between", value1, value2, "connPort");
            return (Criteria) this;
        }

        public Criteria andConnPortNotBetween(String value1, String value2) {
            addCriterion("conn_port not between", value1, value2, "connPort");
            return (Criteria) this;
        }

        public Criteria andDbInstanceIsNull() {
            addCriterion("db_instance is null");
            return (Criteria) this;
        }

        public Criteria andDbInstanceIsNotNull() {
            addCriterion("db_instance is not null");
            return (Criteria) this;
        }

        public Criteria andDbInstanceEqualTo(String value) {
            addCriterion("db_instance =", value, "dbInstance");
            return (Criteria) this;
        }

        public Criteria andDbInstanceNotEqualTo(String value) {
            addCriterion("db_instance <>", value, "dbInstance");
            return (Criteria) this;
        }

        public Criteria andDbInstanceGreaterThan(String value) {
            addCriterion("db_instance >", value, "dbInstance");
            return (Criteria) this;
        }

        public Criteria andDbInstanceGreaterThanOrEqualTo(String value) {
            addCriterion("db_instance >=", value, "dbInstance");
            return (Criteria) this;
        }

        public Criteria andDbInstanceLessThan(String value) {
            addCriterion("db_instance <", value, "dbInstance");
            return (Criteria) this;
        }

        public Criteria andDbInstanceLessThanOrEqualTo(String value) {
            addCriterion("db_instance <=", value, "dbInstance");
            return (Criteria) this;
        }

        public Criteria andDbInstanceLike(String value) {
            addCriterion("db_instance like", value, "dbInstance");
            return (Criteria) this;
        }

        public Criteria andDbInstanceNotLike(String value) {
            addCriterion("db_instance not like", value, "dbInstance");
            return (Criteria) this;
        }

        public Criteria andDbInstanceIn(List<String> values) {
            addCriterion("db_instance in", values, "dbInstance");
            return (Criteria) this;
        }

        public Criteria andDbInstanceNotIn(List<String> values) {
            addCriterion("db_instance not in", values, "dbInstance");
            return (Criteria) this;
        }

        public Criteria andDbInstanceBetween(String value1, String value2) {
            addCriterion("db_instance between", value1, value2, "dbInstance");
            return (Criteria) this;
        }

        public Criteria andDbInstanceNotBetween(String value1, String value2) {
            addCriterion("db_instance not between", value1, value2, "dbInstance");
            return (Criteria) this;
        }

        public Criteria andHiveQueueIsNull() {
            addCriterion("hive_queue is null");
            return (Criteria) this;
        }

        public Criteria andHiveQueueIsNotNull() {
            addCriterion("hive_queue is not null");
            return (Criteria) this;
        }

        public Criteria andHiveQueueEqualTo(String value) {
            addCriterion("hive_queue =", value, "hiveQueue");
            return (Criteria) this;
        }

        public Criteria andHiveQueueNotEqualTo(String value) {
            addCriterion("hive_queue <>", value, "hiveQueue");
            return (Criteria) this;
        }

        public Criteria andHiveQueueGreaterThan(String value) {
            addCriterion("hive_queue >", value, "hiveQueue");
            return (Criteria) this;
        }

        public Criteria andHiveQueueGreaterThanOrEqualTo(String value) {
            addCriterion("hive_queue >=", value, "hiveQueue");
            return (Criteria) this;
        }

        public Criteria andHiveQueueLessThan(String value) {
            addCriterion("hive_queue <", value, "hiveQueue");
            return (Criteria) this;
        }

        public Criteria andHiveQueueLessThanOrEqualTo(String value) {
            addCriterion("hive_queue <=", value, "hiveQueue");
            return (Criteria) this;
        }

        public Criteria andHiveQueueLike(String value) {
            addCriterion("hive_queue like", value, "hiveQueue");
            return (Criteria) this;
        }

        public Criteria andHiveQueueNotLike(String value) {
            addCriterion("hive_queue not like", value, "hiveQueue");
            return (Criteria) this;
        }

        public Criteria andHiveQueueIn(List<String> values) {
            addCriterion("hive_queue in", values, "hiveQueue");
            return (Criteria) this;
        }

        public Criteria andHiveQueueNotIn(List<String> values) {
            addCriterion("hive_queue not in", values, "hiveQueue");
            return (Criteria) this;
        }

        public Criteria andHiveQueueBetween(String value1, String value2) {
            addCriterion("hive_queue between", value1, value2, "hiveQueue");
            return (Criteria) this;
        }

        public Criteria andHiveQueueNotBetween(String value1, String value2) {
            addCriterion("hive_queue not between", value1, value2, "hiveQueue");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNull() {
            addCriterion("login_name is null");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNotNull() {
            addCriterion("login_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoginNameEqualTo(String value) {
            addCriterion("login_name =", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotEqualTo(String value) {
            addCriterion("login_name <>", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThan(String value) {
            addCriterion("login_name >", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("login_name >=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThan(String value) {
            addCriterion("login_name <", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThanOrEqualTo(String value) {
            addCriterion("login_name <=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLike(String value) {
            addCriterion("login_name like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotLike(String value) {
            addCriterion("login_name not like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameIn(List<String> values) {
            addCriterion("login_name in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotIn(List<String> values) {
            addCriterion("login_name not in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameBetween(String value1, String value2) {
            addCriterion("login_name between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotBetween(String value1, String value2) {
            addCriterion("login_name not between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNull() {
            addCriterion("login_password is null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNotNull() {
            addCriterion("login_password is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordEqualTo(String value) {
            addCriterion("login_password =", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotEqualTo(String value) {
            addCriterion("login_password <>", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThan(String value) {
            addCriterion("login_password >", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("login_password >=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThan(String value) {
            addCriterion("login_password <", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThanOrEqualTo(String value) {
            addCriterion("login_password <=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLike(String value) {
            addCriterion("login_password like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotLike(String value) {
            addCriterion("login_password not like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIn(List<String> values) {
            addCriterion("login_password in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotIn(List<String> values) {
            addCriterion("login_password not in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordBetween(String value1, String value2) {
            addCriterion("login_password between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotBetween(String value1, String value2) {
            addCriterion("login_password not between", value1, value2, "loginPassword");
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