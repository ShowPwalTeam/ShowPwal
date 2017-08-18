package com.team.showpwal.showpwal.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import and
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

    private long selectedFeedId = -1;

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
            View view = layoutInflater.inflate(R.layout.item_feed, parent, false);
            return new FeedListRecyclerViewAdapter.FeedViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Object item = feedList.get(position);

        if(item instanceof Feed && holder instanceof FeedViewHolder) {
            Feed feed = (Feed) item;
            FeedViewHolder feedViewHolder = (FeedViewHolder) holder;
            feedViewHolder.showFeedInfo(feed);
        }

    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameTextView;
        private TextView topicNameTextView;
        private ImageView typeImageView;

        public FeedViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.feed_description);
            //topicNameTextView = (TextView) itemView.findViewById(R.id.feedList_topic_name);
            itemView.setOnClickListener(this);
        }

        public void showFeedInfo(Feed feed){
            //TextView feedName = (TextView) itemView.findViewById(R.id.feed_description;
            //TextView feedListTopicName = (TextView) itemView.findViewById(R.id.feedList_topic_name);

            nameTextView.setText(feed.name + " challenged you on this subject.");
            //feedListTopicName.setText(feed.topic.name);
        }

        private SpannableStringBuilder makeBoldText(String string) {
            final StyleSpan boldStyle = new StyleSpan(android.graphics.Typeface.BOLD); // Span to make text bold
            final StyleSpan italicStyle = new StyleSpan(android.graphics.Typeface.ITALIC); //Span to make text italic

            final SpannableStringBuilder sb = new SpannableStringBuilder("HELLOO");
            sb.setSpan(boldStyle, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first 4 characters Bold
            sb.setSpan(italicStyle, 4, 6, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 2 characters Italic
            return sb;
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
