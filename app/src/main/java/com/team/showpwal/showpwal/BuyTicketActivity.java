package com.team.showpwal.showpwal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        Button cancelBtn = (Button) findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Button purchaseBtn = (Button) findViewById(R.id.purchaseBtn);
        purchaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BuyTicketActivity.this,"You have purchased your ticket",Toast.LENGTH_SHORT).show();
            }
        });



        /*int cost = Integer.parseInt(ticketPriceBuy.getText().toString();
        int num = Integer.parseInt(numberOfTickets.getText().toString());
*/
        //TextView totalCost = (TextView) findViewById(R.id.totalCosts);
        //totalCost.setText(cost*num+"");

    }
}
