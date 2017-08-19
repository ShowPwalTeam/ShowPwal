package com.team.showpwal.showpwal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.team.showpwal.showpwal.Fragments.FollowingEventListFragment;
import com.team.showpwal.showpwal.Models.Event;


public class EventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        Intent intent = getIntent();
        int eventId = intent.getIntExtra("id",0);
        String eventName = intent.getStringExtra("eventName");
        String timeRange = intent.getStringExtra("timeRange");
        String locationName = intent.getStringExtra("locationName");
        String duration = intent.getStringExtra("duration");
        String phNo = intent.getStringExtra("phNo");

        final Event event = new Event();
        event.id = eventId;
        event.eventName = eventName;
        event.timeRange = timeRange;
        event.locationName = locationName;
        event.duration = duration;
        event.phNo = phNo;

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
        phNoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call();
            }
        });

        Button followBtn = (Button) findViewById(R.id.followBtn);
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putInt("id",event.id);
                bundle.putString("eventName",event.eventName);
                bundle.putString("timeRange",event.timeRange);
                bundle.putString("locationName",event.locationName);
                bundle.putString("phNo",event.phNo);
                bundle.putString("duration",event.duration);

                FollowingEventListFragment followingEventListFragment = new FollowingEventListFragment();
                followingEventListFragment.setArguments(bundle);

                Toast.makeText(EventDetailActivity.this,"Added to the following events !",Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void call(){
        TextView phNoTextView = (TextView) findViewById(R.id.phNo);
        String number = "tel:"+phNoTextView.getText().toString();
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse(number));
        startActivity(callIntent);
    }
}
