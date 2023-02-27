package com.elleinfo.game.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GiantBombQueryOptions {
    public int limit = 100;
    public long offset = 0;
    public List<String> fieldList = new ArrayList<String>();

    public String sort = "date_added";

    public Map<String, List<String>> filter;

    public GiantBombQueryOptions() {
    }

    public GiantBombQueryOptions(int limit, long offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }


    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Map<String, List<String>> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, List<String>> filter) {
        this.filter = filter;
    }

    public String getFieldListString() {
        return String.join(",", fieldList);
    }

    public String getFilterString() {
        return filter.entrySet().stream()
                .map(entry -> entry.getKey()+":"+String.join("|",entry.getValue()))
                .collect(Collectors.joining(", "));
    }
}
