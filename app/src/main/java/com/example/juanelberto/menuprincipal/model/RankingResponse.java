package com.example.juanelberto.menuprincipal.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chen on 14/02/2018.
 */

public class RankingResponse {
    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
