package com.elleinfo.game.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GiantBombResource {
    /**
     * Unique ID of the resource (without a prefix).
     */
    public int id;
    /**
     * Name of the resource.
     */
    public String name;
    /**
     * URL pointing to the resource detail api endpoint.
     */
    public String api_detail_url;
    /**
     * URL pointing to the descriptive site of the resource on Giant Bomb.
     */
    public String site_detail_url;

    /**
     * Date the game was added to Giant Bomb.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date date_added;
    /**
     * Date the game was last updated on Giant Bomb.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date date_last_updated;
    /**
     * Brief summary of the game.
     */
    public String deck;
    /**
     * Description of the game.
     */
    public String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi_detail_url() {
        return api_detail_url;
    }

    public void setApi_detail_url(String api_detail_url) {
        this.api_detail_url = api_detail_url;
    }

    public String getSite_detail_url() {
        return site_detail_url;
    }

    public void setSite_detail_url(String site_detail_url) {
        this.site_detail_url = site_detail_url;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public Date getDate_last_updated() {
        return date_last_updated;
    }

    public void setDate_last_updated(Date date_last_updated) {
        this.date_last_updated = date_last_updated;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
