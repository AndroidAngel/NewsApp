package com.androidangel.newsapp;


import android.content.Intent;
import android.net.Uri;
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

public class NewsActivity extends AppCompatActivity {

    private static final String LOG_TAG = NewsActivity.class.getSimpleName();

    private static final String BASE_URL = "https://content.guardianapis.com";

    private NewsAdapter mNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ListView listViewNews = findViewById(R.id.mainList);
        mNewsAdapter = new NewsAdapter(this, new ArrayList<Results>());
        listViewNews.setAdapter(mNewsAdapter);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsService newsService = retrofit.create(NewsService.class);
        Call<NewsData> call = newsService.listOfAllNews();
        call.enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {

                Log.d(LOG_TAG, "onResponse: Server Response: " + response.toString());
                Log.d(LOG_TAG, "onResponse: received information: " + response.body().toString());

                ArrayList<Results> resultsNewslist = response.body().getNewsResponse().getResultsArrayList();
                for (int i = 0; i < resultsNewslist.size(); i++) {
                    Log.d(LOG_TAG, "onResponse:  \n" +
                            "sectionId" + resultsNewslist.get(i).getSectionId() + "\n" +
                            "webTitle" + resultsNewslist.get(i).getWebTitle() + "\n" +
                            "apiUrl" + resultsNewslist.get(i).getApiUrl() + "\n" +
                            "-----------------------------------------------\n\n");

                }
                mNewsAdapter.clear();
                mNewsAdapter.addAll(resultsNewslist);


            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {
                Log.e(LOG_TAG, "onFailure: Something went wrong: " + t.getMessage());
                Toast.makeText(NewsActivity.this, "Something went wrong,\n  CHECK YOUR INTERNET CONNECTION", Toast.LENGTH_LONG).show();

            }
        });


        listViewNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Results currentUri = mNewsAdapter.getItem(position);
                Uri newsUri = Uri.parse(currentUri.getWebUrl());
                final Intent intent = new Intent(Intent.ACTION_VIEW, newsUri);

                NewsService newsService = retrofit.create(NewsService.class);
                Call<NewsData> call = newsService.listOfAllNews();
                call.enqueue(new Callback<NewsData>() {
                    @Override
                    public void onResponse(Call<NewsData> call, Response<NewsData> response) {

                        Log.d(LOG_TAG, "onResponse: Server Response: " + response.toString());
                        Log.d(LOG_TAG, "onResponse: received information: " + response.body().toString());

                        ArrayList<Results> resultsList = response.body().getNewsResponse().getResultsArrayList();
                        for (int i = 0; i < resultsList.size(); i++) {
                            Log.d(LOG_TAG, "onResponse: \n" +
                                    "sectionId: " + resultsList.get(i).getSectionId() + "\n" +
                                    "sectionName: " + resultsList.get(i).getSectionName() + "\n" +
                                    "webTitle: " + resultsList.get(i).getWebTitle() + "\n" +
                                    "-----------------------------------------------\n\n");


                            startActivity(intent);

                        }


                    }

                    @Override
                    public void onFailure(Call<NewsData> call, Throwable t) {
                        Log.e(LOG_TAG, "onFailure: Something went wrong: " + t.getMessage());
                        Toast.makeText(NewsActivity.this, "Something went wrong, \n CHECK YOUR INTERNET CONNECTION", Toast.LENGTH_LONG).show();

                    }
                });

            }
        });


    }


}
