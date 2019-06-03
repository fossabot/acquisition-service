package com.acquisition.util;

public enum TypeEnume {

    MYSQL("mysql"),

    SQLSERVER("sqlserver"),

    ORACLE("oracle"),

    HIVE("hive");

    private String jdbc;

    public String getJdbc() {
        return jdbc;
    }

    TypeEnume(String jdbc) {
        this.jdbc = jdbc;
    }

    public static TypeEnume getDatabaseName(String val) {
        for (TypeEnume typeEnume : values()) {
            if (typeEnume.getJdbc().equals(val)) {
                return typeEnume;
            }
        }
        return null;
    }
}
