package com.team.showpwal.showpwal.APIs;

import com.team.showpwal.showpwal.Models.Event;
import com.team.showpwal.showpwal.Models.EventList;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by macbookpro on 8/25/17.
 */

public interface ShowPwalClient{
    /*@GET("info")
    Call<List<Event>> info_get();*/

    @GET("info")
    Call<List<EventList>> info_get();
}
