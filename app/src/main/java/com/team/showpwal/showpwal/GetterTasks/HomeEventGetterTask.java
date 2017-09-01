package com.team.showpwal.showpwal.GetterTasks;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.team.showpwal.showpwal.APIs.ShowPwalClient;
import com.team.showpwal.showpwal.Models.Event;
import com.team.showpwal.showpwal.Models.EventList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by macbookpro on 8/25/17.
 */

public class HomeEventGetterTask extends AsyncTask<String,String,List<Object>> {

    @Override
    protected List<Object> doInBackground(String... strings) {

        String API_BASE_URL = "http://192.168.43.197/showpwal/api/Show_api/";
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );
        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();
        ShowPwalClient service =  retrofit.create(ShowPwalClient.class);

        Call<List<EventList>> call = service.info_get();
        call.enqueue(new Callback<List<EventList>>() {
            @Override
            public void onResponse(Call<List<EventList>> call, Response<List<EventList>> response) {

                Log.d("Response",response.body()+"");

                //return response.body();
            }

            @Override
            public void onFailure(Call<List<EventList>> call, Throwable t) {

            }
        });


        return null;
    }
}
