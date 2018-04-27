package com.example.juanelberto.menuprincipal.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chen on 14/02/2018.
 */

public class Data {
    @SerializedName("ranking")
    private List<RankingUser> ranking;

    String name;
    String description;
    String image_path;

    public List<RankingUser> getRanking() {
        return ranking;
    }
    public void setRanking(List<RankingUser> ranking) {
        this.ranking = ranking;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}
