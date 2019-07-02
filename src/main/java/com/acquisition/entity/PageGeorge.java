package com.acquisition.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author : Francis Du
 * @Date : Create in 10:28 2019/6/11
 * Modified By :
 */
@ApiModel(value = "PageGeorge", description = "page筛选对象")
@Data
public class PageGeorge<T> {

    @ApiModelProperty(value = "当前页数", name = "pagenum", required = true)
    public Integer pagenum;

    @ApiModelProperty(value = "数据", name = "query", required = true)
    public T query;

    @ApiModelProperty(value = "页面大小", name = "pagesize", required = true)
    public Integer pagesize;

}
