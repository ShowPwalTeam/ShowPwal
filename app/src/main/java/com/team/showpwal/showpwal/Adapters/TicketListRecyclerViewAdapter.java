package com.team.showpwal.showpwal.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.showpwal.showpwal.Models.Event;
import com.team.showpwal.showpwal.Models.Ticket;
import com.team.showpwal.showpwal.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by macbookpro on 8/18/17.
 */

public class TicketListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int VIEW_TYPE_TICKET = 3;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    private Context context;

    private final LayoutInflater layoutInflater;
    private List<Object> ticketList = Collections.emptyList();
    private TicketListRecyclerViewAdapter.OnItemClickListener onItemClickListener;

    public TicketListRecyclerViewAdapter(Context context, List<Object> ticketList) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.ticketList = new ArrayList<>();
        this.ticketList.addAll(ticketList);

        setHasStableIds(true);
    }

    public Object getContent(int position) {
        return this.ticketList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        Object content = ticketList.get(position);
        if(content instanceof Ticket) {
            return VIEW_TYPE_TICKET;
        }
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        Object obj = ticketList.get(position);
        if(obj instanceof Ticket) {
            Ticket ticket = (Ticket) obj;
            return 1;
        }
        return super.getItemId(position);
    }

    public void setOnItemClickListener(TicketListRecyclerViewAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == VIEW_TYPE_TICKET) {
            View view = layoutInflater.inflate(R.layout.item_ticket, parent, false);
            return new TicketListRecyclerViewAdapter.TicketViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Object item = ticketList.get(position);

        if(item instanceof Ticket && holder instanceof TicketListRecyclerViewAdapter.TicketViewHolder) {
            Ticket ticket = (Ticket) item;
            TicketListRecyclerViewAdapter.TicketViewHolder ticketViewHolder = (TicketListRecyclerViewAdapter.TicketViewHolder) holder;
            ticketViewHolder.showTicketInfo(ticket);
        }

    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView sampleTextView;
        private TextView sampleTextView2;

        public TicketViewHolder(View itemView) {
            super(itemView);

            sampleTextView = (TextView) itemView.findViewById(R.id.sampleTextView);
            sampleTextView2 = (TextView) itemView.findViewById(R.id.sampleTextView2);

            itemView.setOnClickListener(this);
        }

        public void showTicketInfo(Ticket ticket){

            sampleTextView.setText(ticket.type);
            sampleTextView2.setText(ticket.price);
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
