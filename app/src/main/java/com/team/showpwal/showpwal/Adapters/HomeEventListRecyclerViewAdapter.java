package com.team.showpwal.showpwal.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.team.showpwal.showpwal.R;
import com.team.showpwal.showpwal.Models.Event;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by macbookpro on 7/21/17.
 */

public class HomeEventListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private static final int VIEW_TYPE_HOME = 1;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    private Context context;

    private final LayoutInflater layoutInflater;
    private List<Object> eventList = Collections.emptyList();
    private HomeEventListRecyclerViewAdapter.OnItemClickListener onItemClickListener;

    public HomeEventListRecyclerViewAdapter(Context context, List<Object> eventList) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.eventList = new ArrayList<>();
        this.eventList.addAll(eventList);

        setHasStableIds(true);
    }

    public Object getContent(int position) {
        return this.eventList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        Object content = eventList.get(position);
        if(content instanceof Event) {
            return VIEW_TYPE_HOME;
        }
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        Object obj = eventList.get(position);
        if(obj instanceof Event) {
            Event event = (Event) obj;
            return event.id;
        }
        return super.getItemId(position);
    }

    public void setOnItemClickListener(HomeEventListRecyclerViewAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == VIEW_TYPE_HOME) {
            View view = layoutInflater.inflate(R.layout.item_event, parent, false);
            return new HomeEventListRecyclerViewAdapter.EventHomeViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Object item = eventList.get(position);

        if(item instanceof Event && holder instanceof EventHomeViewHolder) {
            Event event = (Event) item;
            EventHomeViewHolder eventHomeViewHolder = (EventHomeViewHolder) holder;
            eventHomeViewHolder.showFeedInfo(event);
        }

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class EventHomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView eventNameTextView;
        private TextView timeRange;
        private TextView dayLeft;
        private TextView locationName;
        private ImageView eventPicture;

        public EventHomeViewHolder(View itemView) {
            super(itemView);

            eventNameTextView = (TextView) itemView.findViewById(R.id.eventName);
            timeRange = (TextView) itemView.findViewById(R.id.timeRange);
            dayLeft = (TextView) itemView.findViewById(R.id.daysLeft);
            locationName = (TextView) itemView.findViewById(R.id.location);
            eventPicture = (ImageView) itemView.findViewById(R.id.eventPicture);

            itemView.setOnClickListener(this);
        }

        public void showFeedInfo(Event event){

            eventNameTextView.setText(event.eventName);
            timeRange.setText(event.timeRange);
            dayLeft.setText(event.dayLeft+" days left");
            locationName.setText(event.locationName);
            eventPicture.setImageResource(R.drawable.event_pic);
        }

        @Override
        public void onClick(View v) {
            if(onItemClickListener !=  null) {
                //this.itemView.setBackground(context.getDrawable(R.drawable.shape_button_answer_selected));
                onItemClickListener.onItemClick(v, getPosition());
            }
        }
    }
}
