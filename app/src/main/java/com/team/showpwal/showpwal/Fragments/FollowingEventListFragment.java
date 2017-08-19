package com.team.showpwal.showpwal.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.team.showpwal.showpwal.Adapters.FollowingEventListRecyclerViewAdapter;
import com.team.showpwal.showpwal.Models.Event;
import com.team.showpwal.showpwal.R;
import java.util.ArrayList;
import java.util.List;

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


        FollowingEventListRecyclerViewAdapter followingEventListRecyclerViewAdapter = new FollowingEventListRecyclerViewAdapter(getContext(),eventList);
        followingEventListRecyclerViewAdapter.setOnItemClickListener(new FollowingEventListRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

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
        List<Object> eventList = new ArrayList<Object>();

        //int eventId = getArguments().getInt("id",0);
        /*String eventName = getArguments().getString("eventName");
        String timeRange = getArguments().getString("timeRange");
        String locationName = getArguments().getString("locationName");
        String duration = getArguments().getString("duration");
        String phNo = getArguments().getString("phNo");*/

        /*Event event = new Event();
        event.id = eventId;
        event.eventName = eventName;
        event.timeRange = timeRange;
        event.locationName = locationName;
        event.duration = duration;
        event.phNo = phNo;

        eventList.add(event);*/

        return eventList;
    }
}
