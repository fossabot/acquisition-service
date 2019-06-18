package com.acquisition.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author : Francis Du
 * @Date : Create in 10:28 2019/6/11
 * Modified By :
 */
@ApiModel(value = "PageGeorge<T>", description = "page筛选对象")
public class PageGeorge<T> {

    @ApiModelProperty(value = "当前页数", name = "pagenum", required = true)
    public Integer pagenum;
    @ApiModelProperty(value = "数据", name = "query", required = true)
    public T query;
    @ApiModelProperty(value = "页面大小", name = "pagesize", required = true)
    public Integer pagesize;

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public T getQuery() {
        return query;
    }

    public void setQuery(T query) {
        this.query = query;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }
}
