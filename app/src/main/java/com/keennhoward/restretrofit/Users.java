package com.keennhoward.restretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {
    @SerializedName("id")
    private int id;
    @SerializedName("per_page")
    private int per_page;
    @SerializedName("total")
    private int total;
    @SerializedName("total_pages")
    private int total_pages;

    public List<Data> getData() {
        return data;
    }

    @SerializedName("data")
    private List<Data> data;

}

