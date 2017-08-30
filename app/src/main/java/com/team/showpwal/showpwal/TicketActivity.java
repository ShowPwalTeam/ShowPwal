package com.team.showpwal.showpwal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
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

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        List<Object> ticketList = loadTickets();

        final TicketListRecyclerViewAdapter ticketListRecyclerViewAdapter = new TicketListRecyclerViewAdapter(TicketActivity.this,ticketList);
        ticketListRecyclerViewAdapter.setOnItemClickListener(new TicketListRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Ticket ticket = (Ticket) ticketListRecyclerViewAdapter.getContent(position);

                Intent intent = new Intent(TicketActivity.this,BuyTicketActivity.class);
                intent.putExtra("type",ticket.type);
                intent.putExtra("price",ticket.price);
                startActivity(intent);

            }
        });

        GridLayoutManager manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(ticketListRecyclerViewAdapter);


    }

    private List<Object> loadTickets(){
        List<Object> ticketList = new ArrayList<Object>();

        Ticket ticket = new Ticket();
        ticket.type = "VVIP";
        ticket.price = "300000";
        ticketList.add(ticket);

        Ticket ticket1 = new Ticket();
        ticket1.type = "VIP";
        ticket1.price = "100000";
        ticketList.add(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.type = "Regular";
        ticket2.price = "30000";
        ticketList.add(ticket2);

        return ticketList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
