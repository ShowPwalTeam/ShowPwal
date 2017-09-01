package com.team.showpwal.showpwal;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.team.showpwal.showpwal.Models.Event;

public class EventDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int eventId = intent.getIntExtra("id",0);
        final String eventName = intent.getStringExtra("eventName");
        String timeRange = intent.getStringExtra("timeRange");
        String locationName = intent.getStringExtra("locationName");
        String duration = intent.getStringExtra("duration");
        String phNo = intent.getStringExtra("phNo");
        String description = intent.getStringExtra("description");

        final Event event = new Event();
        event.id = eventId;
        event.eventName = eventName;
        event.timeRange = timeRange;
        event.locationName = locationName;
        event.duration = duration;
        event.phNo = phNo;
        event.description = description;

        ImageView eventDetailView = (ImageView) findViewById(R.id.eventDetailPic);
        if(event.id ==1){
            eventDetailView.setImageResource(R.drawable.yan_pone_ngwe);
        }else if(event.id==2){
            eventDetailView.setImageResource(R.drawable.zay_yaung_pwel);
        }else if(event.id==3){
            eventDetailView.setImageResource(R.drawable.influence_rock);
        }else if(event.id==4){
            eventDetailView.setImageResource(R.drawable.promotion_show);
        }else if(event.id==5){
            eventDetailView.setImageResource(R.drawable.ic_show);
        }else if(event.id==6){
            eventDetailView.setImageResource(R.drawable.hnin_si_a_nyeint);
        }

        TextView eventNameTextView = (TextView) findViewById(R.id.eventNameDetail);
        eventNameTextView.setText(event.eventName);

        TextView timeRangeTextView = (TextView) findViewById(R.id.timeRangeDetail);
        timeRangeTextView.setText(event.timeRange);

        TextView locationNameTextView = (TextView) findViewById(R.id.locationDetail);
        locationNameTextView.setText(event.locationName);

        TextView durationTextView = (TextView) findViewById(R.id.duration);
        durationTextView.setText(event.duration);

        TextView phNoTextView = (TextView) findViewById(R.id.phNo);
        phNoTextView.setText(event.phNo);

        TextView eventDescription = (TextView) findViewById(R.id.eventDescription);
        eventDescription.setText(event.description);

        phNoTextView.setPaintFlags(phNoTextView.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        phNoTextView.setText(phNo);
        phNoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call();
            }
        });

        Button button = (Button) findViewById(R.id.callBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call();
            }
        });



        Button ticketBtn = (Button) findViewById(R.id.ticketBtn);
        ticketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventDetailActivity.this,TicketActivity.class));
            }
        });

        Button followBtn = (Button) findViewById(R.id.followBtn);
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotifyUser();
                Toast.makeText(EventDetailActivity.this,"Added to the following events !",Toast.LENGTH_SHORT).show();
            }
        });

        ImageView phoneIconView = (ImageView) findViewById(R.id.phoneIcon);
        phoneIconView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                call();
            }
        });

    }
    private void call(){
        TextView phNoTextView = (TextView) findViewById(R.id.phNo);
        String number = "tel:"+phNoTextView.getText().toString();
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse(number));
        startActivity(callIntent);
    }

    private void NotifyUser()
    {
        NotificationCompat.Builder notiBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.app_logo)
                .setContentTitle("Reminder")
                .setContentText("The Event you followed is near!");

        Intent intent = new Intent(EventDetailActivity.this,MainActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(EventDetailActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notiBuilder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notiBuilder.build());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
