package com.androidangel.newsapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SectionData {
    @SerializedName("response")
    @Expose
    private SectionsResponse sectionsResponse;


    public SectionsResponse getSectionsResponse() {
        return sectionsResponse;
    }

    public void setSectionsResponse(SectionsResponse sectionsResponse) {
        this.sectionsResponse = sectionsResponse;
    }

    @Override
    public String toString() {
        return "SectionData{" +
                "sectionsResponse = " + sectionsResponse + '\'' + '}';
    }
}

