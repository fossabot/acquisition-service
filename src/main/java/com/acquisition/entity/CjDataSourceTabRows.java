package com.acquisition.entity;

import lombok.Data;

/**
 * 数据源表行数统计信息表
 * 
 * @author yuxk
 * @date 2019-06-25 09:53:08
 */
@Data
public class CjDataSourceTabRows {

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
	 * 数据源表名称
	 */
	private String dataSourceTable;
	/**
	 * 数据源表记录行数
	 */
	private String dataSourceTabRows;
	/**
	 * 数据源表使用空间
	 */
	private String dataSourceTabSizes;
	/**
	 * 修改时间
	 */
	private String lastModifyDt;
	/**
	 * 修改人
	 */
	private String lastModifyBy;

}
