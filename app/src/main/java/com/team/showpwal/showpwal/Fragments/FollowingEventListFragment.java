package com.team.showpwal.showpwal.Fragments;

import android.content.Context;
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
                Toast.makeText(getContext(),"Clicked event",Toast.LENGTH_LONG);
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

    public static List<Object> loadEvents(){
        List<Object> eventList = new ArrayList<Object>();

        for(int i=1;i<10;i++){
            Event event = new Event();
            event.id = i;
            event.eventName = "Event "+i;
            event.dayRange = "25th to 28th";
            event.dayLeft = 3;
            event.monthYear = "March 2017";
            event.locationName = "People's park";

            eventList.add(event);
        }

        return eventList;
    }
}
