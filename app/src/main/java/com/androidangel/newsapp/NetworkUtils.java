package com.androidangel.newsapp;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {


    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    public NetworkUtils(){

    }
    public static void getNewsDetail(final String END_POINT_URL,final String API_KEY, final CallBackHandler handler){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(END_POINT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsService service = retrofit.create(NewsService.class);

        String call = service.getNewsDetail(String.valueOf("q")).toString();
        call.enqueue(new Callback<JsonObject>(){

            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                JsonObject resp = response.body().getAsJsonObject("results");
                handler.onComplete(convertJsonToNewsDetail(resp,END_POINT_URL,API_KEY));

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                handler.onFail(t);

            }
        });

    }
    private static News convertJsonToNewsDetail(JsonObject resp, String END_POINT_URL, String API_KEY){
        News newsData = new News();

        newsData.setSectionName(resp.get("sectionName").getAsString());
        newsData.setWebTitle(resp.get("webTitle").getAsString());

        return newsData;
    }
    public static void getListOfAllNews(final String END_POINT_URL,final String API_KEY, final CallBackHandler handler){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(END_POINT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

}

