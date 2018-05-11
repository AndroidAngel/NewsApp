package com.androidangel.newsapp;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import java.util.ArrayList;

public class SectionsResponse {
    @SerializedName("results")
    @Expose
    private ArrayList<SectionResults> sectionResultsArrayList;

    public ArrayList<SectionResults> getSectionResultsArrayList() {
        return sectionResultsArrayList;
    }

    public void setSectionResultsArrayList(ArrayList<SectionResults> sectionResultsArrayList) {
        this.sectionResultsArrayList = sectionResultsArrayList;
    }

    @Override
    public String toString() {
        return "SectionResponse{" +
                "sectionresults = " + sectionResultsArrayList + '}';

    }
}


