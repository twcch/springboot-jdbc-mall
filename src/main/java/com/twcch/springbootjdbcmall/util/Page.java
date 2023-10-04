package com.twcch.springbootjdbcmall.util;

import java.util.List;

public class Page<T> {

    private Integer limit;
    private Integer offset;
    private Integer total;
    private List<T> results;

    public Page() {

    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Page{" +
                "limit=" + limit +
                ", offset=" + offset +
                ", total=" + total +
                ", results=" + results +
                '}';
    }

}
