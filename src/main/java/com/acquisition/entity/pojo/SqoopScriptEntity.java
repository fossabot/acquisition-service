package com.acquisition.entity.pojo;

/**
 * @ClassName SqoopScriptEntity
 * @Description sqoop生成脚本所需字段数据
 * @Author yu
 * @Date 2019/7/2 18:29
 * @Version 1.0
 */
public class SqoopScriptEntity {

    /**
     * flag 是否分区，true为分区，false为不分区
     */
   private Boolean flag;

    /**
     * location 脚本位置
     */
   private String location;

    /**
     * url jdbc-url
     */
   private String url;

    /**
     * userName 用户名
     */
   private String userName;

    /**
     * passWord 密码
     */
   private  String passWord;

    /**
     * database 数据库名称
     */
   private String database;

    /**
     * schema schema
     */
   private String schema;

    /**
     * table 表名称
     */
   private String table;

    /**
     * incField 增量字段
     */
   private String incField;

    /**
     * splitField 切分字段
     */
   private String splitField;

    /**
     * rule 加载规则
     */
   private String rule;

    /**
     * tableField 表字段
     */
   private String tableField;


    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getIncField() {
        return incField;
    }

    public void setIncField(String incField) {
        this.incField = incField;
    }

    public String getSplitField() {
        return splitField;
    }

    public void setSplitField(String splitField) {
        this.splitField = splitField;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getTableField() {
        return tableField;
    }

    public void setTableField(String tableField) {
        this.tableField = tableField;
    }
}
