package com.acquisition.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 源系统数据表唯一索引信息
 */
@Data
public class CjDataSourceUniqueIndexInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 业务源系统ID
     */
    private String businessSystemId;
    /**
     * 业务源系统缩写
     */
    private String businessSystemNameShortName;
    /**
     * 数据模式
     */
    private String dataSourceSchema;
    /**
     * 数据源表名
     */
    private String dataSourceTable;
    /**
     * 唯一索引名称
     */
    private String uniqueIndexName;
    /**
     * 索引字段名
     */
    private String dataSourceColName;
    /**
     * 表中字段序号
     */
    private String dataSourceColOrder;
    /**
     * 修改时间
     */
    private String lastModifyDt;
    /**
     * 修改人
     */
    private String lastModifyBy;

}
