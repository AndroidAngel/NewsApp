package com.androidangel.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;


public interface NewsService {

    String BASE_URL = "https://content.guardianapis.com";

    @GET("/search?api-key=apikey")
    Call<NewsData> listOfAllNews();

    @GET("/sections?api-key=apikey")
    Call<SectionData> listSections();
}
