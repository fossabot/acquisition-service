package com.acquisition.entity;

public class OdsJobInfo {
    private String jobPk;

    private String workflowName;

    private String sourceSystem;

    private String sourceTable;

    private String extractType;

    private String targetDatabase;

    private String targetTable;

    private String startTime;

    private String endTime;

    private Long importRows;

    private Long elapsedTime;

    private String dt;

    private String jobStatus;

    private String importLog;

    private String sqoopEndTime;

    public String getJobPk() {
        return jobPk;
    }

    public void setJobPk(String jobPk) {
        this.jobPk = jobPk == null ? null : jobPk.trim();
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName == null ? null : workflowName.trim();
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem == null ? null : sourceSystem.trim();
    }

    public String getSourceTable() {
        return sourceTable;
    }

    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable == null ? null : sourceTable.trim();
    }

    public String getExtractType() {
        return extractType;
    }

    public void setExtractType(String extractType) {
        this.extractType = extractType == null ? null : extractType.trim();
    }

    public String getTargetDatabase() {
        return targetDatabase;
    }

    public void setTargetDatabase(String targetDatabase) {
        this.targetDatabase = targetDatabase == null ? null : targetDatabase.trim();
    }

    public String getTargetTable() {
        return targetTable;
    }

    public void setTargetTable(String targetTable) {
        this.targetTable = targetTable == null ? null : targetTable.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Long getImportRows() {
        return importRows;
    }

    public void setImportRows(Long importRows) {
        this.importRows = importRows;
    }

    public Long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt == null ? null : dt.trim();
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus == null ? null : jobStatus.trim();
    }

    public String getImportLog() {
        return importLog;
    }

    public void setImportLog(String importLog) {
        this.importLog = importLog == null ? null : importLog.trim();
    }

    public String getSqoopEndTime() {
        return sqoopEndTime;
    }

    public void setSqoopEndTime(String sqoopEndTime) {
        this.sqoopEndTime = sqoopEndTime == null ? null : sqoopEndTime.trim();
    }
}