package com.keennhoward.restretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PostProcessor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ReqresApi reqresApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        reqresApi = retrofit.create(ReqresApi.class);
        //getUsers();
        //getUserWithId(1);
        //createPost();
        //updatePost();
        deletePost();
    }

    //onResponse means there is a response in the server Whether an error or correct message
    //use if(response.isSuccessful()){} to differentiate between the correct and error response
    //onFailure means there is a problem with the connection

    public void getUserWithId(int id){
        Call<UserData> call = reqresApi.getUserData(id);
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                UserData userData = response.body();
                Data data = userData.getData();
                textView.setText(data.toString());
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    public void getUsers(){
        Call<Users> call = reqresApi.getUsers();
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                Users users = response.body();
                List<Data> datas = users.getData();

                for(Data data:datas) {
                    String c = "";
                    c += data.toString()+ "\n";
                    textView.append(c);
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                textView.setText(t.toString());
            }
        });
    }

    private void createPost(){
        UserPost userPost = new UserPost("name","job",22);

        Call<UserPost> call = reqresApi.createPost(userPost);
        call.enqueue(new Callback<UserPost>() {
            @Override
            public void onResponse(Call<UserPost> call, Response<UserPost> response) {
                UserPost postRes = response.body();
                String content = "";
                content += postRes.getName()+"\n";
                content += postRes.getJob()+"\n";
                content += postRes.getId()+"\n";
                content += postRes.getCreatedAt()+"\n";
                textView.setText(content);
            }

            @Override
            public void onFailure(Call<UserPost> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    private void updatePost(){
        UserPost userPost = new UserPost("keenn", "caveman", 22);

        Call<UserPost> call = reqresApi.putPost(1, userPost);

        call.enqueue(new Callback<UserPost>() {
            @Override
            public void onResponse(Call<UserPost> call, Response<UserPost> response) {
                UserPost result  = response.body();
                String content = "";
                content += result.getName()+"\n";
                content += result.getJob()+"\n";
                content += result.getUpdatedAt()+"\n";
                textView.setText(content);
            }

            @Override
            public void onFailure(Call<UserPost> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }

    public void deletePost(){
        Call<Void> call = reqresApi.deleteUser(1);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                textView.setText("Code: "+ response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}

