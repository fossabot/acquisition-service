package com.acquisition.entity;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/6/6.
 */
public class Page {
    public  Integer pagenum;
    public List<String> query=new ArrayList<>();
    public  Integer pagesize;

    @Override
    public String toString() {
        return "page{" +
                "pagenum=" + pagenum +
                ", query='" + query + '\'' +
                ", pagesize=" + pagesize +
                '}';
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }


    public List<String> getQuery() {
        return query;
    }

    public void setQuery(List<String> query) {
        this.query = query;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }
}
