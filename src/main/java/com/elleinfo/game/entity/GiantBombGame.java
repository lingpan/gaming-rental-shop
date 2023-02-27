package com.elleinfo.game.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GiantBombGame extends GiantBombResource {


    private String aliases;
    private String expectedReleaseQuarter;
    private String expectedReleaseMonth;
    private String characters;
    private Integer expectedReleaseYear;
    private String guid;
    private String expectedReleaseDay;
    private String originalReleaseDate;
    private Integer numberOfUserReviews;
    private String firstAppearanceCharacters;

    private String image_thumb_url;

    @JsonProperty("image")
    public void setImage_thumb_url(Map<String, String> images) {
        //images.forEach((k,v)->System.out.println(k+":"+v));
        this.image_thumb_url = images.get("thumb_url");
        //System.out.println("image_thumb_url="+this.image_thumb_url);
    }

    @Override
    public String toString() {
        return "GiantBombGame{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}