package com.acquisition.entity;

public class CjDataSourceConnDefine extends CjDataSourceConnDefineKey {
    private String businessSystemId;

    private String businessSystemName;

    private String dataBaseType;

    private String connIp;

    private String connPort;

    private String dbInstance;

    private String hiveQueue;

    private String loginName;

    private String loginPassword;

    private String lastModifyDt;

    private String lastModifyBy;

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId == null ? null : businessSystemId.trim();
    }

    public String getBusinessSystemName() {
        return businessSystemName;
    }

    public void setBusinessSystemName(String businessSystemName) {
        this.businessSystemName = businessSystemName == null ? null : businessSystemName.trim();
    }

    public String getDataBaseType() {
        return dataBaseType;
    }

    public void setDataBaseType(String dataBaseType) {
        this.dataBaseType = dataBaseType == null ? null : dataBaseType.trim();
    }

    public String getConnIp() {
        return connIp;
    }

    public void setConnIp(String connIp) {
        this.connIp = connIp == null ? null : connIp.trim();
    }

    public String getConnPort() {
        return connPort;
    }

    public void setConnPort(String connPort) {
        this.connPort = connPort == null ? null : connPort.trim();
    }

    public String getDbInstance() {
        return dbInstance;
    }

    public void setDbInstance(String dbInstance) {
        this.dbInstance = dbInstance == null ? null : dbInstance.trim();
    }

    public String getHiveQueue() {
        return hiveQueue;
    }

    public void setHiveQueue(String hiveQueue) {
        this.hiveQueue = hiveQueue == null ? null : hiveQueue.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getLastModifyDt() {
        return lastModifyDt;
    }

    public void setLastModifyDt(String lastModifyDt) {
        this.lastModifyDt = lastModifyDt == null ? null : lastModifyDt.trim();
    }

    public String getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(String lastModifyBy) {
        this.lastModifyBy = lastModifyBy == null ? null : lastModifyBy.trim();
    }
}