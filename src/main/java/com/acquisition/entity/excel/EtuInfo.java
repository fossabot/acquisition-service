package com.acquisition.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yxk
 * @Description: excel对应实体
 * @create 2019/6/18
 * @since 1.0.0
 */

@ApiModel(value = "EtuInfo", description = "excel实体")
@Data
public class EtuInfo extends BaseRowModel {

    private String index;

    @ApiModelProperty(value = "源系统缩写", name = "businessSystemNameShortName", required = true)
    @ExcelProperty(value = {"源系统缩写"}, index = 0)
    private String businessSystemNameShortName;

    @ApiModelProperty(value = "dataSourceSchema", name = "dataSourceSchema", required = true)
    @ExcelProperty(value = {"schema"}, index = 1)
    private String dataSourceSchema;

    @ApiModelProperty(value = "源表名", name = "dataSourceTable", required = true)
    @ExcelProperty(value = {"源表名"}, index = 2)
    private String dataSourceTable;

    private String metaStatus;

}
