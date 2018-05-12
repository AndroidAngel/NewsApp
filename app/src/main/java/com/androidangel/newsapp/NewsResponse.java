package com.androidangel.newsapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsResponse {
    @SerializedName("results")
    @Expose
    private ArrayList<Results> resultsArrayList;

    public ArrayList<Results> getResultsArrayList() {
        return resultsArrayList;
    }

    public void setResultsArrayList(ArrayList<Results> resultsArrayList) {
        this.resultsArrayList = resultsArrayList;
    }
    @Override
    public String toString() {
        return "NewsResponse{" +
                "results = " + resultsArrayList + '}';

    }
}


