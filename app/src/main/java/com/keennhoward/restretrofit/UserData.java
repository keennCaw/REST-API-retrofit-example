package com.keennhoward.restretrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserData {
    @SerializedName("data")
    private Data data;
    public Data getData() {
        return data;
    }
}
