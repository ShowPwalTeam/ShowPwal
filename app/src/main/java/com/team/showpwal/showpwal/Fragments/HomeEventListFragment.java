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
import com.team.showpwal.showpwal.EventDetailActivity;
import com.team.showpwal.showpwal.GetterTasks.HomeEventGetterTask;
import com.team.showpwal.showpwal.Models.Event;
import com.team.showpwal.showpwal.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbookpro on 8/18/17.
 */

public class HomeEventListFragment extends Fragment {

    private HomeEventListRecyclerViewAdapter homeEventListRecyclerViewAdapter;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.home_fragment, container, false);
        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        List<Object> homeEventList = loadEvents();

        /*HomeEventGetterTask homeEventGetterTask = new HomeEventGetterTask(){
            @Override
            protected void onPostExecute(List<Object> events){
                super.onPostExecute(events);
                if(events!=null){
                    Toast.makeText(getContext(),"Not Null",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(),"Null",Toast.LENGTH_SHORT).show();
                }
            }
        };
        homeEventGetterTask.execute();*/

        homeEventListRecyclerViewAdapter = new HomeEventListRecyclerViewAdapter(getContext(),homeEventList);
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
                    intent.putExtra("description",event.description);

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
        List<Object> homeEventList = new ArrayList<Object>();

        Event event = new Event();
        event.id = 1;
        event.eventName = "Yan Pone Ngwe";
        event.dayLeft = 7;
        event.duration = "7PM TO 12PM";
        event.locationName = "National Theatre";
        event.timeRange = "28th to 30th June 2017";
        event.phNo = "09977370400";
        event.description = "focus to help War Refugees with the funding from here";
        homeEventList.add(event);

        Event event1 = new Event();
        event1.id = 2;
        event1.eventName = "Zay Yaung Pwal Taw";
        event1.dayLeft = 3;
        event1.duration = "5PM TO 9PM";
        event1.locationName = "Myaw Sin Kyun";
        event1.timeRange = "25th to 30th March 2017";
        event1.phNo = "09679855431";
        event1.description = "foucs on the products";
        homeEventList.add(event1);

        Event event2 = new Event();
        event2.id = 3;
        event2.eventName = "Influence Rock";
        event2.dayLeft = 20;
        event2.duration = "6PM TO 11PM";
        event2.locationName = "Thuwannabumi Event Park";
        event2.timeRange = "2nd September 2017";
        event2.phNo = "09401548877";
        event2.description = "The greatest rock show with the greatest musicians";
        homeEventList.add(event2);

        Event event3 = new Event();
        event3.id = 4;
        event3.eventName = "Mel Thi Dar promotion show";
        event3.dayLeft = 1;
        event3.duration = "4PM TO 6PM";
        event3.locationName = "Hleden Center";
        event3.timeRange = "1st August 2017";
        event3.phNo = "09988654321";
        event3.description = "to promote the albumn called mel thi dar ";
        homeEventList.add(event3);

        Event event4 = new Event();
        event4.id = 5;
        event4.eventName = "IC show in Yangon";
        event4.dayLeft = 25;
        event4.duration = "4PM TO 10PM";
        event4.locationName = "Myaw Sin Kyun";
        event4.timeRange = "1st July 2017";
        event4.phNo = "09876432114";
        event4.description = "One of the greatest rock band of Myanmar will perform in Myaw Sin Kyun";
        homeEventList.add(event4);

        Event event5 = new Event();
        event5.id = 6;
        event5.eventName = "Hnin Si A Nyeint";
        event5.dayLeft = 4;
        event5.duration = "8PM TO 1AM";
        event5.locationName = "National Theatre";
        event5.timeRange = "13th June 2018";
        event5.phNo = "09876432114";
        event5.description = "A comedy show featuring celebrities ";
        homeEventList.add(event5);


        return homeEventList;
    }

}
