package com.acquisition.entity;

/**
 * @Author : Francis Du
 * @Date : Create in 10:28 2019/6/11
 * Modified By :
 */
public class PageGeorge<T> {
    public Integer pagenum;
    public T query;
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
