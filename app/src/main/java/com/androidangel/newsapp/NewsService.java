package com.androidangel.newsapp;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NewsService {

    String BASE_URL = "https://content.guardianapis.com";

    @Headers("Content-Type: application/json")
    @GET(".json")
    Call<News> getData();





    @GET("/search")
    Call<JsonObject> getNewsDetail(@Query("q")String q);

    @GET(" https://content.guardianapis.com/search?api-key=9271ca86-4372-430a-9c6f-b9bb1b837446 ")
    Call<JsonObject>listOfAllNews();







}
