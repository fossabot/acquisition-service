package com.acquisition.util;

/**
 * Created by Administrator on 2018/11/1.
 */
public class Constant {
    public static final int TABLE_LEVEL=1;
    public static final int OWNER_LEVEL=2;
    public static final int COLUMN_LEVEL=3;
    public static final int CONSTRAINT_LEVEL=4;
    public static final String TO_BE_DEVELOPED="待开发";
    public static final String UN_DEVELOPED="不开发";
    public static final String DEVELOPED="已开发";
    public static final String ODS_CRT_HIVE="1";
    public static final String DW_CRT_HIVE="1";
    public static final String DW_CRT_DDL="1";
    public static final String DW_CRT_SCRIPT="1";
    public static final String DW_HIVE_SCHEMA="acquisition_dw";
    public static final String ODS_HIVE_FULL_SCHEMA="acquisition_ods";
    public static final String ODS_HIVE_INCREMENT_SCHEMA="acquisition_ods_inc";
    public static final int ODS_INCREMENT_TABLE_SIZE=0;
    public static final String ODS_PARTITION_KEY="data_dt";
    public static final String ODS_PARTITION_UNIT="month";
    public static final String ODS_INCREMENT_EXTRACT="increment";
    public static final String ODS_FULL_EXTRACT="full";
    public static final String ODS_COL_TYPE="string";
    public static final String TABLE_OPTION_SUCCESS="success";
    public static final String TABLE_OPTION_FAILED="failed";
    public static final String TABLE_OPTION_AVAIL="avail";
    public static final String DW_BAK_DEFAULT_TOPIC_DOMAIN="nct";
    public static final String DW_BAK_DOMAIN="0";
    public static final String DW_USEING_DOMAIN="1";
    public static final String META_NOT_EXISTS="not_exists";
    public static final String META_EXISTS="exists";
    public static final String CONNECTION_NOT_EXISTS="con_not_exists";
}
