package com.elleinfo.game.entity;

import java.util.List;

public class GiantBombResponse<T extends GiantBombResource> extends GiantBombResponseBase {
    public List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return super.toString() + ", results=(" + results.size() + ")";
    }
}
