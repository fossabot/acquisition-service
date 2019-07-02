package com.acquisition.entity;

import java.util.ArrayList;
import java.util.List;

public class OdsJobInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OdsJobInfoExample() {
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

        public Criteria andJobPkIsNull() {
            addCriterion("job_pk is null");
            return (Criteria) this;
        }

        public Criteria andJobPkIsNotNull() {
            addCriterion("job_pk is not null");
            return (Criteria) this;
        }

        public Criteria andJobPkEqualTo(String value) {
            addCriterion("job_pk =", value, "jobPk");
            return (Criteria) this;
        }

        public Criteria andJobPkNotEqualTo(String value) {
            addCriterion("job_pk <>", value, "jobPk");
            return (Criteria) this;
        }

        public Criteria andJobPkGreaterThan(String value) {
            addCriterion("job_pk >", value, "jobPk");
            return (Criteria) this;
        }

        public Criteria andJobPkGreaterThanOrEqualTo(String value) {
            addCriterion("job_pk >=", value, "jobPk");
            return (Criteria) this;
        }

        public Criteria andJobPkLessThan(String value) {
            addCriterion("job_pk <", value, "jobPk");
            return (Criteria) this;
        }

        public Criteria andJobPkLessThanOrEqualTo(String value) {
            addCriterion("job_pk <=", value, "jobPk");
            return (Criteria) this;
        }

        public Criteria andJobPkLike(String value) {
            addCriterion("job_pk like", value, "jobPk");
            return (Criteria) this;
        }

        public Criteria andJobPkNotLike(String value) {
            addCriterion("job_pk not like", value, "jobPk");
            return (Criteria) this;
        }

        public Criteria andJobPkIn(List<String> values) {
            addCriterion("job_pk in", values, "jobPk");
            return (Criteria) this;
        }

        public Criteria andJobPkNotIn(List<String> values) {
            addCriterion("job_pk not in", values, "jobPk");
            return (Criteria) this;
        }

        public Criteria andJobPkBetween(String value1, String value2) {
            addCriterion("job_pk between", value1, value2, "jobPk");
            return (Criteria) this;
        }

        public Criteria andJobPkNotBetween(String value1, String value2) {
            addCriterion("job_pk not between", value1, value2, "jobPk");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameIsNull() {
            addCriterion("workflow_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameIsNotNull() {
            addCriterion("workflow_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameEqualTo(String value) {
            addCriterion("workflow_name =", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameNotEqualTo(String value) {
            addCriterion("workflow_name <>", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameGreaterThan(String value) {
            addCriterion("workflow_name >", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameGreaterThanOrEqualTo(String value) {
            addCriterion("workflow_name >=", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameLessThan(String value) {
            addCriterion("workflow_name <", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameLessThanOrEqualTo(String value) {
            addCriterion("workflow_name <=", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameLike(String value) {
            addCriterion("workflow_name like", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameNotLike(String value) {
            addCriterion("workflow_name not like", value, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameIn(List<String> values) {
            addCriterion("workflow_name in", values, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameNotIn(List<String> values) {
            addCriterion("workflow_name not in", values, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameBetween(String value1, String value2) {
            addCriterion("workflow_name between", value1, value2, "workflowName");
            return (Criteria) this;
        }

        public Criteria andWorkflowNameNotBetween(String value1, String value2) {
            addCriterion("workflow_name not between", value1, value2, "workflowName");
            return (Criteria) this;
        }

        public Criteria andSourceSystemIsNull() {
            addCriterion("source_system is null");
            return (Criteria) this;
        }

        public Criteria andSourceSystemIsNotNull() {
            addCriterion("source_system is not null");
            return (Criteria) this;
        }

        public Criteria andSourceSystemEqualTo(String value) {
            addCriterion("source_system =", value, "sourceSystem");
            return (Criteria) this;
        }

        public Criteria andSourceSystemNotEqualTo(String value) {
            addCriterion("source_system <>", value, "sourceSystem");
            return (Criteria) this;
        }

        public Criteria andSourceSystemGreaterThan(String value) {
            addCriterion("source_system >", value, "sourceSystem");
            return (Criteria) this;
        }

        public Criteria andSourceSystemGreaterThanOrEqualTo(String value) {
            addCriterion("source_system >=", value, "sourceSystem");
            return (Criteria) this;
        }

        public Criteria andSourceSystemLessThan(String value) {
            addCriterion("source_system <", value, "sourceSystem");
            return (Criteria) this;
        }

        public Criteria andSourceSystemLessThanOrEqualTo(String value) {
            addCriterion("source_system <=", value, "sourceSystem");
            return (Criteria) this;
        }

        public Criteria andSourceSystemLike(String value) {
            addCriterion("source_system like", value, "sourceSystem");
            return (Criteria) this;
        }

        public Criteria andSourceSystemNotLike(String value) {
            addCriterion("source_system not like", value, "sourceSystem");
            return (Criteria) this;
        }

        public Criteria andSourceSystemIn(List<String> values) {
            addCriterion("source_system in", values, "sourceSystem");
            return (Criteria) this;
        }

        public Criteria andSourceSystemNotIn(List<String> values) {
            addCriterion("source_system not in", values, "sourceSystem");
            return (Criteria) this;
        }

        public Criteria andSourceSystemBetween(String value1, String value2) {
            addCriterion("source_system between", value1, value2, "sourceSystem");
            return (Criteria) this;
        }

        public Criteria andSourceSystemNotBetween(String value1, String value2) {
            addCriterion("source_system not between", value1, value2, "sourceSystem");
            return (Criteria) this;
        }

        public Criteria andSourceTableIsNull() {
            addCriterion("source_table is null");
            return (Criteria) this;
        }

        public Criteria andSourceTableIsNotNull() {
            addCriterion("source_table is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTableEqualTo(String value) {
            addCriterion("source_table =", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotEqualTo(String value) {
            addCriterion("source_table <>", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableGreaterThan(String value) {
            addCriterion("source_table >", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableGreaterThanOrEqualTo(String value) {
            addCriterion("source_table >=", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableLessThan(String value) {
            addCriterion("source_table <", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableLessThanOrEqualTo(String value) {
            addCriterion("source_table <=", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableLike(String value) {
            addCriterion("source_table like", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotLike(String value) {
            addCriterion("source_table not like", value, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableIn(List<String> values) {
            addCriterion("source_table in", values, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotIn(List<String> values) {
            addCriterion("source_table not in", values, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableBetween(String value1, String value2) {
            addCriterion("source_table between", value1, value2, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andSourceTableNotBetween(String value1, String value2) {
            addCriterion("source_table not between", value1, value2, "sourceTable");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIsNull() {
            addCriterion("extract_type is null");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIsNotNull() {
            addCriterion("extract_type is not null");
            return (Criteria) this;
        }

        public Criteria andExtractTypeEqualTo(String value) {
            addCriterion("extract_type =", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotEqualTo(String value) {
            addCriterion("extract_type <>", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeGreaterThan(String value) {
            addCriterion("extract_type >", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeGreaterThanOrEqualTo(String value) {
            addCriterion("extract_type >=", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLessThan(String value) {
            addCriterion("extract_type <", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLessThanOrEqualTo(String value) {
            addCriterion("extract_type <=", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeLike(String value) {
            addCriterion("extract_type like", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotLike(String value) {
            addCriterion("extract_type not like", value, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeIn(List<String> values) {
            addCriterion("extract_type in", values, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotIn(List<String> values) {
            addCriterion("extract_type not in", values, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeBetween(String value1, String value2) {
            addCriterion("extract_type between", value1, value2, "extractType");
            return (Criteria) this;
        }

        public Criteria andExtractTypeNotBetween(String value1, String value2) {
            addCriterion("extract_type not between", value1, value2, "extractType");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseIsNull() {
            addCriterion("target_database is null");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseIsNotNull() {
            addCriterion("target_database is not null");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseEqualTo(String value) {
            addCriterion("target_database =", value, "targetDatabase");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseNotEqualTo(String value) {
            addCriterion("target_database <>", value, "targetDatabase");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseGreaterThan(String value) {
            addCriterion("target_database >", value, "targetDatabase");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseGreaterThanOrEqualTo(String value) {
            addCriterion("target_database >=", value, "targetDatabase");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseLessThan(String value) {
            addCriterion("target_database <", value, "targetDatabase");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseLessThanOrEqualTo(String value) {
            addCriterion("target_database <=", value, "targetDatabase");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseLike(String value) {
            addCriterion("target_database like", value, "targetDatabase");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseNotLike(String value) {
            addCriterion("target_database not like", value, "targetDatabase");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseIn(List<String> values) {
            addCriterion("target_database in", values, "targetDatabase");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseNotIn(List<String> values) {
            addCriterion("target_database not in", values, "targetDatabase");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseBetween(String value1, String value2) {
            addCriterion("target_database between", value1, value2, "targetDatabase");
            return (Criteria) this;
        }

        public Criteria andTargetDatabaseNotBetween(String value1, String value2) {
            addCriterion("target_database not between", value1, value2, "targetDatabase");
            return (Criteria) this;
        }

        public Criteria andTargetTableIsNull() {
            addCriterion("target_table is null");
            return (Criteria) this;
        }

        public Criteria andTargetTableIsNotNull() {
            addCriterion("target_table is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTableEqualTo(String value) {
            addCriterion("target_table =", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableNotEqualTo(String value) {
            addCriterion("target_table <>", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableGreaterThan(String value) {
            addCriterion("target_table >", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableGreaterThanOrEqualTo(String value) {
            addCriterion("target_table >=", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableLessThan(String value) {
            addCriterion("target_table <", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableLessThanOrEqualTo(String value) {
            addCriterion("target_table <=", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableLike(String value) {
            addCriterion("target_table like", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableNotLike(String value) {
            addCriterion("target_table not like", value, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableIn(List<String> values) {
            addCriterion("target_table in", values, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableNotIn(List<String> values) {
            addCriterion("target_table not in", values, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableBetween(String value1, String value2) {
            addCriterion("target_table between", value1, value2, "targetTable");
            return (Criteria) this;
        }

        public Criteria andTargetTableNotBetween(String value1, String value2) {
            addCriterion("target_table not between", value1, value2, "targetTable");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("start_time like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("start_time not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("end_time like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("end_time not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andImportRowsIsNull() {
            addCriterion("import_rows is null");
            return (Criteria) this;
        }

        public Criteria andImportRowsIsNotNull() {
            addCriterion("import_rows is not null");
            return (Criteria) this;
        }

        public Criteria andImportRowsEqualTo(Long value) {
            addCriterion("import_rows =", value, "importRows");
            return (Criteria) this;
        }

        public Criteria andImportRowsNotEqualTo(Long value) {
            addCriterion("import_rows <>", value, "importRows");
            return (Criteria) this;
        }

        public Criteria andImportRowsGreaterThan(Long value) {
            addCriterion("import_rows >", value, "importRows");
            return (Criteria) this;
        }

        public Criteria andImportRowsGreaterThanOrEqualTo(Long value) {
            addCriterion("import_rows >=", value, "importRows");
            return (Criteria) this;
        }

        public Criteria andImportRowsLessThan(Long value) {
            addCriterion("import_rows <", value, "importRows");
            return (Criteria) this;
        }

        public Criteria andImportRowsLessThanOrEqualTo(Long value) {
            addCriterion("import_rows <=", value, "importRows");
            return (Criteria) this;
        }

        public Criteria andImportRowsIn(List<Long> values) {
            addCriterion("import_rows in", values, "importRows");
            return (Criteria) this;
        }

        public Criteria andImportRowsNotIn(List<Long> values) {
            addCriterion("import_rows not in", values, "importRows");
            return (Criteria) this;
        }

        public Criteria andImportRowsBetween(Long value1, Long value2) {
            addCriterion("import_rows between", value1, value2, "importRows");
            return (Criteria) this;
        }

        public Criteria andImportRowsNotBetween(Long value1, Long value2) {
            addCriterion("import_rows not between", value1, value2, "importRows");
            return (Criteria) this;
        }

        public Criteria andElapsedTimeIsNull() {
            addCriterion("elapsed_time is null");
            return (Criteria) this;
        }

        public Criteria andElapsedTimeIsNotNull() {
            addCriterion("elapsed_time is not null");
            return (Criteria) this;
        }

        public Criteria andElapsedTimeEqualTo(Long value) {
            addCriterion("elapsed_time =", value, "elapsedTime");
            return (Criteria) this;
        }

        public Criteria andElapsedTimeNotEqualTo(Long value) {
            addCriterion("elapsed_time <>", value, "elapsedTime");
            return (Criteria) this;
        }

        public Criteria andElapsedTimeGreaterThan(Long value) {
            addCriterion("elapsed_time >", value, "elapsedTime");
            return (Criteria) this;
        }

        public Criteria andElapsedTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("elapsed_time >=", value, "elapsedTime");
            return (Criteria) this;
        }

        public Criteria andElapsedTimeLessThan(Long value) {
            addCriterion("elapsed_time <", value, "elapsedTime");
            return (Criteria) this;
        }

        public Criteria andElapsedTimeLessThanOrEqualTo(Long value) {
            addCriterion("elapsed_time <=", value, "elapsedTime");
            return (Criteria) this;
        }

        public Criteria andElapsedTimeIn(List<Long> values) {
            addCriterion("elapsed_time in", values, "elapsedTime");
            return (Criteria) this;
        }

        public Criteria andElapsedTimeNotIn(List<Long> values) {
            addCriterion("elapsed_time not in", values, "elapsedTime");
            return (Criteria) this;
        }

        public Criteria andElapsedTimeBetween(Long value1, Long value2) {
            addCriterion("elapsed_time between", value1, value2, "elapsedTime");
            return (Criteria) this;
        }

        public Criteria andElapsedTimeNotBetween(Long value1, Long value2) {
            addCriterion("elapsed_time not between", value1, value2, "elapsedTime");
            return (Criteria) this;
        }

        public Criteria andDtIsNull() {
            addCriterion("dt is null");
            return (Criteria) this;
        }

        public Criteria andDtIsNotNull() {
            addCriterion("dt is not null");
            return (Criteria) this;
        }

        public Criteria andDtEqualTo(String value) {
            addCriterion("dt =", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotEqualTo(String value) {
            addCriterion("dt <>", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtGreaterThan(String value) {
            addCriterion("dt >", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtGreaterThanOrEqualTo(String value) {
            addCriterion("dt >=", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLessThan(String value) {
            addCriterion("dt <", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLessThanOrEqualTo(String value) {
            addCriterion("dt <=", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLike(String value) {
            addCriterion("dt like", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotLike(String value) {
            addCriterion("dt not like", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtIn(List<String> values) {
            addCriterion("dt in", values, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotIn(List<String> values) {
            addCriterion("dt not in", values, "dt");
            return (Criteria) this;
        }

        public Criteria andDtBetween(String value1, String value2) {
            addCriterion("dt between", value1, value2, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotBetween(String value1, String value2) {
            addCriterion("dt not between", value1, value2, "dt");
            return (Criteria) this;
        }

        public Criteria andJobStatusIsNull() {
            addCriterion("job_status is null");
            return (Criteria) this;
        }

        public Criteria andJobStatusIsNotNull() {
            addCriterion("job_status is not null");
            return (Criteria) this;
        }

        public Criteria andJobStatusEqualTo(String value) {
            addCriterion("job_status =", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotEqualTo(String value) {
            addCriterion("job_status <>", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusGreaterThan(String value) {
            addCriterion("job_status >", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusGreaterThanOrEqualTo(String value) {
            addCriterion("job_status >=", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusLessThan(String value) {
            addCriterion("job_status <", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusLessThanOrEqualTo(String value) {
            addCriterion("job_status <=", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusLike(String value) {
            addCriterion("job_status like", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotLike(String value) {
            addCriterion("job_status not like", value, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusIn(List<String> values) {
            addCriterion("job_status in", values, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotIn(List<String> values) {
            addCriterion("job_status not in", values, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusBetween(String value1, String value2) {
            addCriterion("job_status between", value1, value2, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andJobStatusNotBetween(String value1, String value2) {
            addCriterion("job_status not between", value1, value2, "jobStatus");
            return (Criteria) this;
        }

        public Criteria andImportLogIsNull() {
            addCriterion("import_log is null");
            return (Criteria) this;
        }

        public Criteria andImportLogIsNotNull() {
            addCriterion("import_log is not null");
            return (Criteria) this;
        }

        public Criteria andImportLogEqualTo(String value) {
            addCriterion("import_log =", value, "importLog");
            return (Criteria) this;
        }

        public Criteria andImportLogNotEqualTo(String value) {
            addCriterion("import_log <>", value, "importLog");
            return (Criteria) this;
        }

        public Criteria andImportLogGreaterThan(String value) {
            addCriterion("import_log >", value, "importLog");
            return (Criteria) this;
        }

        public Criteria andImportLogGreaterThanOrEqualTo(String value) {
            addCriterion("import_log >=", value, "importLog");
            return (Criteria) this;
        }

        public Criteria andImportLogLessThan(String value) {
            addCriterion("import_log <", value, "importLog");
            return (Criteria) this;
        }

        public Criteria andImportLogLessThanOrEqualTo(String value) {
            addCriterion("import_log <=", value, "importLog");
            return (Criteria) this;
        }

        public Criteria andImportLogLike(String value) {
            addCriterion("import_log like", value, "importLog");
            return (Criteria) this;
        }

        public Criteria andImportLogNotLike(String value) {
            addCriterion("import_log not like", value, "importLog");
            return (Criteria) this;
        }

        public Criteria andImportLogIn(List<String> values) {
            addCriterion("import_log in", values, "importLog");
            return (Criteria) this;
        }

        public Criteria andImportLogNotIn(List<String> values) {
            addCriterion("import_log not in", values, "importLog");
            return (Criteria) this;
        }

        public Criteria andImportLogBetween(String value1, String value2) {
            addCriterion("import_log between", value1, value2, "importLog");
            return (Criteria) this;
        }

        public Criteria andImportLogNotBetween(String value1, String value2) {
            addCriterion("import_log not between", value1, value2, "importLog");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeIsNull() {
            addCriterion("sqoop_end_time is null");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeIsNotNull() {
            addCriterion("sqoop_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeEqualTo(String value) {
            addCriterion("sqoop_end_time =", value, "sqoopEndTime");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeNotEqualTo(String value) {
            addCriterion("sqoop_end_time <>", value, "sqoopEndTime");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeGreaterThan(String value) {
            addCriterion("sqoop_end_time >", value, "sqoopEndTime");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("sqoop_end_time >=", value, "sqoopEndTime");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeLessThan(String value) {
            addCriterion("sqoop_end_time <", value, "sqoopEndTime");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeLessThanOrEqualTo(String value) {
            addCriterion("sqoop_end_time <=", value, "sqoopEndTime");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeLike(String value) {
            addCriterion("sqoop_end_time like", value, "sqoopEndTime");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeNotLike(String value) {
            addCriterion("sqoop_end_time not like", value, "sqoopEndTime");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeIn(List<String> values) {
            addCriterion("sqoop_end_time in", values, "sqoopEndTime");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeNotIn(List<String> values) {
            addCriterion("sqoop_end_time not in", values, "sqoopEndTime");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeBetween(String value1, String value2) {
            addCriterion("sqoop_end_time between", value1, value2, "sqoopEndTime");
            return (Criteria) this;
        }

        public Criteria andSqoopEndTimeNotBetween(String value1, String value2) {
            addCriterion("sqoop_end_time not between", value1, value2, "sqoopEndTime");
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