package com.team.showpwal.showpwal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.team.showpwal.showpwal.Adapters.TicketListRecyclerViewAdapter;
import com.team.showpwal.showpwal.Models.Ticket;
import java.util.ArrayList;
import java.util.List;

public class TicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        List<Object> ticketList = loadTickets();

        TicketListRecyclerViewAdapter ticketListRecyclerViewAdapter = new TicketListRecyclerViewAdapter(TicketActivity.this,ticketList);
        ticketListRecyclerViewAdapter.setOnItemClickListener(new TicketListRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


            }
        });

        GridLayoutManager manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(ticketListRecyclerViewAdapter);


    }

    private List<Object> loadTickets(){
        List<Object> ticketList = new ArrayList<Object>();

        Ticket ticket = new Ticket();
        ticket.type = "VIP";
        ticket.price = "300000";
        ticketList.add(ticket);

        Ticket ticket1 = new Ticket();
        ticket1.type = "Regular";
        ticket1.price = "10000";
        ticketList.add(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.type = "VVIP";
        ticket2.price = "100000";
        ticketList.add(ticket2);

        return ticketList;
    }

}
