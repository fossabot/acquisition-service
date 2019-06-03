package com.acquisition.job;


/**
 * @author yxk
 * @Description: 适配Database
 * @create 2019/5/30
 * @since 1.0.0
 */
public class DatabaseType {

    /**
     * 匹配各种数据库
     */
    public static String AdapterDatabaseType(String par) {
        String str = "";
        switch (TypeEnume.getDatabaseName(par)) {

            case MYSQL:
                str = "com.mysql.jdbc.Driver";
                break;
            case SQLSERVER:
                str = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                break;
            case ORACLE:
                str = "oracle.jdbc.OracleDriver";
                break;
            case HIVE:
                str = "org.apache.hive.jdbc.HiveDriver";
                break;
        }
        return str;
    }
}
