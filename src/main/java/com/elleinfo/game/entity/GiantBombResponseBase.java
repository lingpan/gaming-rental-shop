package com.elleinfo.game.entity;

import java.io.Serializable;

public abstract class GiantBombResponseBase implements Serializable {
    public int status_code;
    public String error;
    public long number_of_total_results;
    public int number_of_page_results;

    public int limit = 100;

    public int offset = 0;

    public String version;

    @Override
    public String toString() {
        return "GiantBombResponse [status_code=" + status_code + ", error="
                + error + ", number_of_total_results="
                + number_of_total_results + ", number_of_page_results="
                + number_of_page_results + ", limit=" + limit + ", offset="
                + offset + ", version=" + version + "]";
    }

}
