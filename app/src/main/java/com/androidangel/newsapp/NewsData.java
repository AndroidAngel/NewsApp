package com.androidangel.newsapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsData {
    @SerializedName("response")
    @Expose
    private NewsResponse response;


    public NewsResponse getResponse() {
        return response;
    }

    public void setResponse(NewsResponse response) {
        this.response = response;
    }

    @Override
    public String toString(){
        return "NewsData{" +
                "response = " + response + '\'' +'}';
    }
}


