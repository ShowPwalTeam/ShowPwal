package com.team.showpwal.showpwal.GetterTasks;

import android.os.AsyncTask;
import com.team.showpwal.showpwal.APIs.ShowPwalClient;
import com.team.showpwal.showpwal.Models.Event;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by macbookpro on 8/25/17.
 */

public class HomeEventGetterTask extends AsyncTask<String,String,List<Object>> {

    @Override
    protected List<Object> doInBackground(String... strings) {

        String API_BASE_URL = "http://www.mocky.io/v2/";
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

        Call<List<Object>> call = service.info_get();
        try {
            Response<List<Object>> response = call.execute();
            List<Object> homeEvents = response.body();
            return homeEvents;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
