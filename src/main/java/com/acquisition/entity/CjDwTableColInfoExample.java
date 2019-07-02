package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class CjDwTableColInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjDwTableColInfoExample() {
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

        public Criteria andDwBusinessTopicDomainIsNull() {
            addCriterion("dw_business_topic_domain is null");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainIsNotNull() {
            addCriterion("dw_business_topic_domain is not null");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainEqualTo(String value) {
            addCriterion("dw_business_topic_domain =", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainNotEqualTo(String value) {
            addCriterion("dw_business_topic_domain <>", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainGreaterThan(String value) {
            addCriterion("dw_business_topic_domain >", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainGreaterThanOrEqualTo(String value) {
            addCriterion("dw_business_topic_domain >=", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainLessThan(String value) {
            addCriterion("dw_business_topic_domain <", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainLessThanOrEqualTo(String value) {
            addCriterion("dw_business_topic_domain <=", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainLike(String value) {
            addCriterion("dw_business_topic_domain like", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainNotLike(String value) {
            addCriterion("dw_business_topic_domain not like", value, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainIn(List<String> values) {
            addCriterion("dw_business_topic_domain in", values, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainNotIn(List<String> values) {
            addCriterion("dw_business_topic_domain not in", values, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainBetween(String value1, String value2) {
            addCriterion("dw_business_topic_domain between", value1, value2, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwBusinessTopicDomainNotBetween(String value1, String value2) {
            addCriterion("dw_business_topic_domain not between", value1, value2, "dwBusinessTopicDomain");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaIsNull() {
            addCriterion("dw_data_schema is null");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaIsNotNull() {
            addCriterion("dw_data_schema is not null");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaEqualTo(String value) {
            addCriterion("dw_data_schema =", value, "dwDataSchema");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaNotEqualTo(String value) {
            addCriterion("dw_data_schema <>", value, "dwDataSchema");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaGreaterThan(String value) {
            addCriterion("dw_data_schema >", value, "dwDataSchema");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("dw_data_schema >=", value, "dwDataSchema");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaLessThan(String value) {
            addCriterion("dw_data_schema <", value, "dwDataSchema");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaLessThanOrEqualTo(String value) {
            addCriterion("dw_data_schema <=", value, "dwDataSchema");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaLike(String value) {
            addCriterion("dw_data_schema like", value, "dwDataSchema");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaNotLike(String value) {
            addCriterion("dw_data_schema not like", value, "dwDataSchema");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaIn(List<String> values) {
            addCriterion("dw_data_schema in", values, "dwDataSchema");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaNotIn(List<String> values) {
            addCriterion("dw_data_schema not in", values, "dwDataSchema");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaBetween(String value1, String value2) {
            addCriterion("dw_data_schema between", value1, value2, "dwDataSchema");
            return (Criteria) this;
        }

        public Criteria andDwDataSchemaNotBetween(String value1, String value2) {
            addCriterion("dw_data_schema not between", value1, value2, "dwDataSchema");
            return (Criteria) this;
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

        public Criteria andDwTableColNameIsNull() {
            addCriterion("dw_table_col_name is null");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameIsNotNull() {
            addCriterion("dw_table_col_name is not null");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameEqualTo(String value) {
            addCriterion("dw_table_col_name =", value, "dwTableColName");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameNotEqualTo(String value) {
            addCriterion("dw_table_col_name <>", value, "dwTableColName");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameGreaterThan(String value) {
            addCriterion("dw_table_col_name >", value, "dwTableColName");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameGreaterThanOrEqualTo(String value) {
            addCriterion("dw_table_col_name >=", value, "dwTableColName");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameLessThan(String value) {
            addCriterion("dw_table_col_name <", value, "dwTableColName");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameLessThanOrEqualTo(String value) {
            addCriterion("dw_table_col_name <=", value, "dwTableColName");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameLike(String value) {
            addCriterion("dw_table_col_name like", value, "dwTableColName");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameNotLike(String value) {
            addCriterion("dw_table_col_name not like", value, "dwTableColName");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameIn(List<String> values) {
            addCriterion("dw_table_col_name in", values, "dwTableColName");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameNotIn(List<String> values) {
            addCriterion("dw_table_col_name not in", values, "dwTableColName");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameBetween(String value1, String value2) {
            addCriterion("dw_table_col_name between", value1, value2, "dwTableColName");
            return (Criteria) this;
        }

        public Criteria andDwTableColNameNotBetween(String value1, String value2) {
            addCriterion("dw_table_col_name not between", value1, value2, "dwTableColName");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainIsNull() {
            addCriterion("dw_table_belong_domain is null");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainIsNotNull() {
            addCriterion("dw_table_belong_domain is not null");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainEqualTo(String value) {
            addCriterion("dw_table_belong_domain =", value, "dwTableBelongDomain");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainNotEqualTo(String value) {
            addCriterion("dw_table_belong_domain <>", value, "dwTableBelongDomain");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainGreaterThan(String value) {
            addCriterion("dw_table_belong_domain >", value, "dwTableBelongDomain");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainGreaterThanOrEqualTo(String value) {
            addCriterion("dw_table_belong_domain >=", value, "dwTableBelongDomain");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainLessThan(String value) {
            addCriterion("dw_table_belong_domain <", value, "dwTableBelongDomain");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainLessThanOrEqualTo(String value) {
            addCriterion("dw_table_belong_domain <=", value, "dwTableBelongDomain");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainLike(String value) {
            addCriterion("dw_table_belong_domain like", value, "dwTableBelongDomain");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainNotLike(String value) {
            addCriterion("dw_table_belong_domain not like", value, "dwTableBelongDomain");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainIn(List<String> values) {
            addCriterion("dw_table_belong_domain in", values, "dwTableBelongDomain");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainNotIn(List<String> values) {
            addCriterion("dw_table_belong_domain not in", values, "dwTableBelongDomain");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainBetween(String value1, String value2) {
            addCriterion("dw_table_belong_domain between", value1, value2, "dwTableBelongDomain");
            return (Criteria) this;
        }

        public Criteria andDwTableBelongDomainNotBetween(String value1, String value2) {
            addCriterion("dw_table_belong_domain not between", value1, value2, "dwTableBelongDomain");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentIsNull() {
            addCriterion("dw_table_comment is null");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentIsNotNull() {
            addCriterion("dw_table_comment is not null");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentEqualTo(String value) {
            addCriterion("dw_table_comment =", value, "dwTableComment");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentNotEqualTo(String value) {
            addCriterion("dw_table_comment <>", value, "dwTableComment");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentGreaterThan(String value) {
            addCriterion("dw_table_comment >", value, "dwTableComment");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentGreaterThanOrEqualTo(String value) {
            addCriterion("dw_table_comment >=", value, "dwTableComment");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentLessThan(String value) {
            addCriterion("dw_table_comment <", value, "dwTableComment");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentLessThanOrEqualTo(String value) {
            addCriterion("dw_table_comment <=", value, "dwTableComment");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentLike(String value) {
            addCriterion("dw_table_comment like", value, "dwTableComment");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentNotLike(String value) {
            addCriterion("dw_table_comment not like", value, "dwTableComment");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentIn(List<String> values) {
            addCriterion("dw_table_comment in", values, "dwTableComment");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentNotIn(List<String> values) {
            addCriterion("dw_table_comment not in", values, "dwTableComment");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentBetween(String value1, String value2) {
            addCriterion("dw_table_comment between", value1, value2, "dwTableComment");
            return (Criteria) this;
        }

        public Criteria andDwTableCommentNotBetween(String value1, String value2) {
            addCriterion("dw_table_comment not between", value1, value2, "dwTableComment");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderIsNull() {
            addCriterion("dw_table_col_order is null");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderIsNotNull() {
            addCriterion("dw_table_col_order is not null");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderEqualTo(String value) {
            addCriterion("dw_table_col_order =", value, "dwTableColOrder");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderNotEqualTo(String value) {
            addCriterion("dw_table_col_order <>", value, "dwTableColOrder");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderGreaterThan(String value) {
            addCriterion("dw_table_col_order >", value, "dwTableColOrder");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderGreaterThanOrEqualTo(String value) {
            addCriterion("dw_table_col_order >=", value, "dwTableColOrder");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderLessThan(String value) {
            addCriterion("dw_table_col_order <", value, "dwTableColOrder");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderLessThanOrEqualTo(String value) {
            addCriterion("dw_table_col_order <=", value, "dwTableColOrder");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderLike(String value) {
            addCriterion("dw_table_col_order like", value, "dwTableColOrder");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderNotLike(String value) {
            addCriterion("dw_table_col_order not like", value, "dwTableColOrder");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderIn(List<String> values) {
            addCriterion("dw_table_col_order in", values, "dwTableColOrder");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderNotIn(List<String> values) {
            addCriterion("dw_table_col_order not in", values, "dwTableColOrder");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderBetween(String value1, String value2) {
            addCriterion("dw_table_col_order between", value1, value2, "dwTableColOrder");
            return (Criteria) this;
        }

        public Criteria andDwTableColOrderNotBetween(String value1, String value2) {
            addCriterion("dw_table_col_order not between", value1, value2, "dwTableColOrder");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeIsNull() {
            addCriterion("dw_table_col_type is null");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeIsNotNull() {
            addCriterion("dw_table_col_type is not null");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeEqualTo(String value) {
            addCriterion("dw_table_col_type =", value, "dwTableColType");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeNotEqualTo(String value) {
            addCriterion("dw_table_col_type <>", value, "dwTableColType");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeGreaterThan(String value) {
            addCriterion("dw_table_col_type >", value, "dwTableColType");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dw_table_col_type >=", value, "dwTableColType");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeLessThan(String value) {
            addCriterion("dw_table_col_type <", value, "dwTableColType");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeLessThanOrEqualTo(String value) {
            addCriterion("dw_table_col_type <=", value, "dwTableColType");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeLike(String value) {
            addCriterion("dw_table_col_type like", value, "dwTableColType");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeNotLike(String value) {
            addCriterion("dw_table_col_type not like", value, "dwTableColType");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeIn(List<String> values) {
            addCriterion("dw_table_col_type in", values, "dwTableColType");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeNotIn(List<String> values) {
            addCriterion("dw_table_col_type not in", values, "dwTableColType");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeBetween(String value1, String value2) {
            addCriterion("dw_table_col_type between", value1, value2, "dwTableColType");
            return (Criteria) this;
        }

        public Criteria andDwTableColTypeNotBetween(String value1, String value2) {
            addCriterion("dw_table_col_type not between", value1, value2, "dwTableColType");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentIsNull() {
            addCriterion("dw_table_col_comment is null");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentIsNotNull() {
            addCriterion("dw_table_col_comment is not null");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentEqualTo(String value) {
            addCriterion("dw_table_col_comment =", value, "dwTableColComment");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentNotEqualTo(String value) {
            addCriterion("dw_table_col_comment <>", value, "dwTableColComment");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentGreaterThan(String value) {
            addCriterion("dw_table_col_comment >", value, "dwTableColComment");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentGreaterThanOrEqualTo(String value) {
            addCriterion("dw_table_col_comment >=", value, "dwTableColComment");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentLessThan(String value) {
            addCriterion("dw_table_col_comment <", value, "dwTableColComment");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentLessThanOrEqualTo(String value) {
            addCriterion("dw_table_col_comment <=", value, "dwTableColComment");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentLike(String value) {
            addCriterion("dw_table_col_comment like", value, "dwTableColComment");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentNotLike(String value) {
            addCriterion("dw_table_col_comment not like", value, "dwTableColComment");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentIn(List<String> values) {
            addCriterion("dw_table_col_comment in", values, "dwTableColComment");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentNotIn(List<String> values) {
            addCriterion("dw_table_col_comment not in", values, "dwTableColComment");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentBetween(String value1, String value2) {
            addCriterion("dw_table_col_comment between", value1, value2, "dwTableColComment");
            return (Criteria) this;
        }

        public Criteria andDwTableColCommentNotBetween(String value1, String value2) {
            addCriterion("dw_table_col_comment not between", value1, value2, "dwTableColComment");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagIsNull() {
            addCriterion("dw_table_partition_flag is null");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagIsNotNull() {
            addCriterion("dw_table_partition_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagEqualTo(String value) {
            addCriterion("dw_table_partition_flag =", value, "dwTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagNotEqualTo(String value) {
            addCriterion("dw_table_partition_flag <>", value, "dwTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagGreaterThan(String value) {
            addCriterion("dw_table_partition_flag >", value, "dwTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagGreaterThanOrEqualTo(String value) {
            addCriterion("dw_table_partition_flag >=", value, "dwTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagLessThan(String value) {
            addCriterion("dw_table_partition_flag <", value, "dwTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagLessThanOrEqualTo(String value) {
            addCriterion("dw_table_partition_flag <=", value, "dwTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagLike(String value) {
            addCriterion("dw_table_partition_flag like", value, "dwTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagNotLike(String value) {
            addCriterion("dw_table_partition_flag not like", value, "dwTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagIn(List<String> values) {
            addCriterion("dw_table_partition_flag in", values, "dwTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagNotIn(List<String> values) {
            addCriterion("dw_table_partition_flag not in", values, "dwTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagBetween(String value1, String value2) {
            addCriterion("dw_table_partition_flag between", value1, value2, "dwTablePartitionFlag");
            return (Criteria) this;
        }

        public Criteria andDwTablePartitionFlagNotBetween(String value1, String value2) {
            addCriterion("dw_table_partition_flag not between", value1, value2, "dwTablePartitionFlag");
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