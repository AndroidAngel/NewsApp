package com.androidangel.newsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainCategory extends AppCompatActivity {


    private static final String LOG_TAG = MainCategory.class.getName();

    private static final String BASE_URL_SECTIONS = "https://content.guardianapis.com/";

    private NewsAdapter mNewsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_category);

        ListView listViewMainCategory = findViewById(R.id.category_list);
        mNewsAdapter = new NewsAdapter(this,new ArrayList<Results>());
        listViewMainCategory.setAdapter(mNewsAdapter);
        listViewMainCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL_SECTIONS)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                NewsService newsService = retrofit.create(NewsService.class);
                Call<NewsData> call = newsService.getResults();
                call.enqueue(new Callback<NewsData>() {
                    @Override
                    public void onResponse(Call<NewsData> call, Response<NewsData> response) {

                        Log.d(LOG_TAG, "onResponse: Server Response: " + response.toString());
                        Log.d(LOG_TAG, "onResponse: received information: " + response.body().toString());

                        ArrayList<Results> resultsList = response.body().getResponse().getResultsArrayList();
                        for (int i = 0; i<resultsList.size(); i++){
                            Log.d(LOG_TAG, "onResponse: \n" +
                                    "sectionId: " + resultsList.get(i).getSectionId() +"\n" +
                                    "sectionName: " + resultsList.get(i).getSectionName() +"\n" +
                                    "webTitle: " + resultsList.get(i).getWebTitle() + "\n" +
                                    "-----------------------------------------------\n\n");



                        }



                    }

                    @Override
                    public void onFailure(Call<NewsData> call, Throwable t) {
                        Log.e(LOG_TAG, "onFailure: Something went wrong: " + t.getMessage() );
                        Toast.makeText(MainCategory.this, "Something went wrong", Toast.LENGTH_LONG).show();

                    }
                });

            }
        });



    }
}