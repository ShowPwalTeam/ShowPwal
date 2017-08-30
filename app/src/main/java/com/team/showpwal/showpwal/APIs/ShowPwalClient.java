package com.team.showpwal.showpwal.APIs;

import com.team.showpwal.showpwal.Models.Event;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by macbookpro on 8/25/17.
 */

public interface ShowPwalClient{
    @GET("59a1979f25000071018d66c6")
    Call<List<Object>> info_get();
}
