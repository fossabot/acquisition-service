package com.acquisition.entity;

public class TaskMonitor {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_monitor.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_monitor.check_time
     *
     * @mbggenerated
     */
    private String checkTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_monitor.job_status
     *
     * @mbggenerated
     */
    private String jobStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_monitor.count
     *
     * @mbggenerated
     */
    private String count;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_monitor.id
     *
     * @return the value of task_monitor.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_monitor.id
     *
     * @param id the value for task_monitor.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_monitor.check_time
     *
     * @return the value of task_monitor.check_time
     *
     * @mbggenerated
     */
    public String getCheckTime() {
        return checkTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_monitor.check_time
     *
     * @param checkTime the value for task_monitor.check_time
     *
     * @mbggenerated
     */
    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime == null ? null : checkTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_monitor.job_status
     *
     * @return the value of task_monitor.job_status
     *
     * @mbggenerated
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_monitor.job_status
     *
     * @param jobStatus the value for task_monitor.job_status
     *
     * @mbggenerated
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus == null ? null : jobStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_monitor.count
     *
     * @return the value of task_monitor.count
     *
     * @mbggenerated
     */
    public String getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_monitor.count
     *
     * @param count the value for task_monitor.count
     *
     * @mbggenerated
     */
    public void setCount(String count) {
        this.count = count == null ? null : count.trim();
    }
}