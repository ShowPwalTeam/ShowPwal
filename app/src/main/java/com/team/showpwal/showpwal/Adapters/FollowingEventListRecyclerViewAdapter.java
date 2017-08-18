package com.team.showpwal.showpwal.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.team.showpwal.showpwal.Models.Event;
import com.team.showpwal.showpwal.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by macbookpro on 8/18/17.
 */

public class FollowingEventListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int VIEW_TYPE_FOLLOWING = 2;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    private Context context;

    private final LayoutInflater layoutInflater;
    private List<Object> eventList = Collections.emptyList();
    private FollowingEventListRecyclerViewAdapter.OnItemClickListener onItemClickListener;

    public FollowingEventListRecyclerViewAdapter(Context context, List<Object> eventList) {
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
            return VIEW_TYPE_FOLLOWING;
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

    public void setOnItemClickListener(FollowingEventListRecyclerViewAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == VIEW_TYPE_FOLLOWING) {
            View view = layoutInflater.inflate(R.layout.item_event, parent, false);
            return new FollowingEventListRecyclerViewAdapter.EventFollowingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Object item = eventList.get(position);

        if(item instanceof Event && holder instanceof FollowingEventListRecyclerViewAdapter.EventFollowingViewHolder) {
            Event event = (Event) item;
            FollowingEventListRecyclerViewAdapter.EventFollowingViewHolder eventFollowingViewHolder = (FollowingEventListRecyclerViewAdapter.EventFollowingViewHolder) holder;
            eventFollowingViewHolder.showFeedInfo(event);
        }

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class EventFollowingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView eventNameTextView;
        private TextView dayRange;
        private TextView monthYear;
        private TextView dayLeft;
        private TextView locationName;
        private ImageView eventPicture;

        public EventFollowingViewHolder(View itemView) {
            super(itemView);

            eventNameTextView = (TextView) itemView.findViewById(R.id.eventName);
            dayRange = (TextView) itemView.findViewById(R.id.dayRange);
            monthYear = (TextView) itemView.findViewById(R.id.monthYear);
            dayLeft = (TextView) itemView.findViewById(R.id.daysLeft);
            locationName = (TextView) itemView.findViewById(R.id.location);
            eventPicture = (ImageView) itemView.findViewById(R.id.eventPicture);

            //topicNameTextView = (TextView) itemView.findViewById(R.id.feedList_topic_name);
            itemView.setOnClickListener(this);
        }

        public void showFeedInfo(Event event){

            eventNameTextView.setText(event.eventName);
            dayRange.setText(event.dayRange);
            monthYear.setText(event.monthYear);
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
