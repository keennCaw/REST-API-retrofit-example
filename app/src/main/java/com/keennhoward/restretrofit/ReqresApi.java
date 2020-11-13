package com.keennhoward.restretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ReqresApi {

    @GET("/api/users?page=2")
    Call<Users> getUsers();

    @GET("/api/users/{id}")
    Call<UserData> getUserData(@Path("id") int userId);

    @POST("/api/users")
    Call<UserPost> createPost(@Body UserPost userPost);

    //delete and replace
    @PUT("/api/users/{id}")
    Call<UserPost> putPost(@Path("id") int id, @Body UserPost userPost);

    //only changes data does not delete
    @PATCH("/api/users/{id}")
    Call<UserPost> patchPost(@Path("id") int id, @Body UserPost userPost);

    @DELETE("/api/users/{id}")
    Call<Void> deleteUser(@Path("id") int id);
}
