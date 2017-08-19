package com.team.showpwal.showpwal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BuyTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        Intent intent = getIntent();
        String ticketType = intent.getStringExtra("type");
        String ticketPrice = intent.getStringExtra("price");

        TextView ticketTypeBuy = (TextView) findViewById(R.id.ticketTypeBuy);
        ticketTypeBuy.setText(ticketType);
        TextView ticketPriceBuy = (TextView) findViewById(R.id.ticketPriceBuy);
        ticketPriceBuy.setText(ticketPrice);
        TextView numberOfTickets = (TextView) findViewById(R.id.number_of_tickets);

        /*int cost = Integer.parseInt(ticketPriceBuy.getText().toString();
        int num = Integer.parseInt(numberOfTickets.getText().toString());
*/
        //TextView totalCost = (TextView) findViewById(R.id.totalCosts);
        //totalCost.setText(cost*num+"");

    }
}
