package com.keennhoward.restretrofit;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UserPost {



    @SerializedName("name")
    private String name;

    @SerializedName("job")
    private String job;



    @SerializedName("id")
    private Integer id;



    @SerializedName("createdAt")
    private Date createdAt;

    public Date getUpdatedAt() {
        return updatedAt;
    }

    //for post (diff class for post?)
    @SerializedName("updatedAt")
    private Date updatedAt;

    public UserPost(String name, String job, Integer id) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public Integer getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
