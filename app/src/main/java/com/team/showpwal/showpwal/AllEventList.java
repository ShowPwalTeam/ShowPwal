package com.team.showpwal.showpwal;

import com.team.showpwal.showpwal.Models.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbookpro on 8/19/17.
 */

public class AllEventList {

    public static List<Object> getALlEvents(){

        List<Object> events = new ArrayList<Object>();

        for(int i=0;i<15;i++){
            Event event = new Event();
            event.eventName = "Event"+i;
            event.timeRange = "25th to 29th,March 2017";
            event.dayLeft = 3;
            event.locationName = "People's park";
            event.phNo = "09401548877";
            event.duration = "7 PM To 10 PM";
            if(i%2==0){
                event.type = 0;
            }else{
                event.type = 1;
            }

            events.add(event);
        }

        return events;
    }
}
