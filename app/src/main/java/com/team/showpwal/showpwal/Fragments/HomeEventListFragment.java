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
import com.team.showpwal.showpwal.Adapters.HomeEventListRecyclerViewAdapter;
import com.team.showpwal.showpwal.AllEventList;
import com.team.showpwal.showpwal.EventDetailActivity;
import com.team.showpwal.showpwal.Models.Event;
import com.team.showpwal.showpwal.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbookpro on 8/18/17.
 */

public class HomeEventListFragment extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.home_fragment, container, false);
        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        List<Object> feedList = loadEvents();

        final HomeEventListRecyclerViewAdapter homeEventListRecyclerViewAdapter = new HomeEventListRecyclerViewAdapter(getContext(),feedList);
        homeEventListRecyclerViewAdapter.setOnItemClickListener(new HomeEventListRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Object object = homeEventListRecyclerViewAdapter.getContent(position);
                if(object instanceof Event){
                    Event event = (Event) object;
                    Intent intent = new Intent(getContext(),EventDetailActivity.class);

                    intent.putExtra("id",event.id);
                    intent.putExtra("eventName",event.eventName);
                    intent.putExtra("timeRange",event.timeRange);
                    intent.putExtra("locationName",event.locationName);
                    intent.putExtra("phNo",event.phNo);
                    intent.putExtra("duration",event.duration);

                    startActivity(intent);

                }
            }
        });

        GridLayoutManager manager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(homeEventListRecyclerViewAdapter);

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
        List<Object> eventList = AllEventList.getALlEvents();
        List<Object> homeEventList = new ArrayList<Object>();

        for(int i=0;i<eventList.size();i++){
            if(eventList.get(i) instanceof Event){
                Event event = (Event) eventList.get(i);
                if(event.type==0){
                    homeEventList.add(event);
                }
            }
        }

        return homeEventList;
    }

}
