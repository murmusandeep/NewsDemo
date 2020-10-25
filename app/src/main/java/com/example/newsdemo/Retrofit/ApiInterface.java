package com.example.newsdemo.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines?country=in&pageSize=30&apiKey=4ada2e0c19864489967a3d8c5a51c31e")
    Call<NewsData> getNewsData();


}
