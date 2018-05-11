package com.androidangel.newsapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsData {
    @SerializedName("response")
    @Expose
    private NewsResponse newsResponse;


    public NewsResponse getNewsResponse() {
        return newsResponse;
    }

    public void setNewsResponse(NewsResponse newsResponse) {
        this.newsResponse = newsResponse;
    }

    @Override
    public String toString() {
        return "NewsData{" +
                "NewsResponse = " + newsResponse + '\'' + '}';
    }
}


