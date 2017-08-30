package com.team.showpwal.showpwal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BuyTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

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
                showDialog();
            }
        });
    }

    public void showDialog(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(BuyTicketActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(BuyTicketActivity.this);
        }
        builder.setTitle("Purchase")
                .setMessage("Are you sure you want to purchase this ticket?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BuyTicketActivity.this,"Purchased!",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(R.drawable.purchase_alert)
                .show();
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
