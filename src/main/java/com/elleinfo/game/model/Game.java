package com.elleinfo.game.model;

import java.util.Date;

public class Game {

    private int id;
    private String name;
    private String deck;
    private String image_icon_url;

    public Date date_added;

    public Game() {
    }

    public Game(int id, String name, String deck, String image_icon_url, Date date_added) {
        this.id = id;
        this.name = name;
        this.deck = deck;
        this.image_icon_url = image_icon_url;
        this.date_added = date_added;
    }

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

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public String getImage_icon_url() {
        return image_icon_url;
    }

    public void setImage_icon_url(String image_icon_url) {
        this.image_icon_url = image_icon_url;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deck='" + deck + '\'' +
                ", image_icon_url='" + image_icon_url + '\'' +
                ", date_added=" + date_added +
                '}';
    }
}
