package com.androidangel.newsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainCategory extends AppCompatActivity {


    private static final String LOG_TAG = MainCategory.class.getName();

    private static final String BASE_URL_SECTIONS = "https://content.guardianapis.com/sections";

    private NewsAdapter mNewsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_category);

        ListView listViewMainCategory = findViewById(R.id.category_list);
        mNewsAdapter = new NewsAdapter(this,new ArrayList<News>());
        listViewMainCategory.setAdapter(mNewsAdapter);
        listViewMainCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL_SECTIONS)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

            }
        });



    }
}