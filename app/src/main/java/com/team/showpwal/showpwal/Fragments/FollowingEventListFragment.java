package com.team.showpwal.showpwal.Fragments;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.team.showpwal.showpwal.Adapters.FollowingEventListRecyclerViewAdapter;
import com.team.showpwal.showpwal.EventDetailActivity;
import com.team.showpwal.showpwal.MainActivity;
import com.team.showpwal.showpwal.Models.Event;
import com.team.showpwal.showpwal.R;
import java.util.ArrayList;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import java.util.List;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by macbookpro on 8/18/17.
 */

public class FollowingEventListFragment extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.following_fragment, container, false);
        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        List<Object> eventList = loadEvents();

        final FollowingEventListRecyclerViewAdapter followingEventListRecyclerViewAdapter = new FollowingEventListRecyclerViewAdapter(getContext(),eventList);
        followingEventListRecyclerViewAdapter.setOnItemClickListener(new FollowingEventListRecyclerViewAdapter.OnItemClickListener() {
            @Override
            //@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN);
            public void onItemClick(View view, int position) {

                Object object = followingEventListRecyclerViewAdapter.getContent(position);
                if(object instanceof Event){
                    Event event = (Event) object;
                    Intent intent = new Intent(getContext(),EventDetailActivity.class);
                    intent.putExtra("id",event.id);
                    intent.putExtra("eventName",event.eventName);
                    intent.putExtra("timeRange",event.timeRange);
                    intent.putExtra("locationName",event.locationName);
                    intent.putExtra("phNo",event.phNo);
                    intent.putExtra("duration",event.duration);
                    intent.putExtra("description",event.description);
                    startActivity(intent);

                }

            }
        });

        GridLayoutManager manager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(followingEventListRecyclerViewAdapter);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public List<Object> loadEvents(){
        List<Object> followingEventList = new ArrayList<Object>();

        Event event = new Event();
        event.id = 3;
        event.eventName = "Influence Rock";
        event.dayLeft = 20;
        event.duration = "6PM TO 11PM";
        event.locationName = "Thuwannabumi Event Park";
        event.timeRange = "2nd September 2017";
        event.phNo = "09401548877";
        event.description = "The greatest rock show with the greatest musicians";
        followingEventList.add(event);

        return followingEventList;
    }

    /*public void letStartNoti(){
        NotificationManager notificationManager = (NotificationManager)
    }*/



}
