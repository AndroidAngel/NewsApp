package com.androidangel.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;


public interface NewsService {


    String BASE_URL = "https://content.guardianapis.com";

    @GET("/search?api-key=9271ca86-4372-430a-9c6f-b9bb1b837446")
    Call<NewsData> listOfAllNews();

    @GET("/sections?api-key=9271ca86-4372-430a-9c6f-b9bb1b837446")
    Call<SectionData> listSections();


}
