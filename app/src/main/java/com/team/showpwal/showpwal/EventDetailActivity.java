package com.team.showpwal.showpwal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        Intent intent = getIntent();
        String eventName = intent.getStringExtra("eventName");
        String timeRange = intent.getStringExtra("timeRange");
        String locationName = intent.getStringExtra("locationName");
        String duration = intent.getStringExtra("duration");
        String phNo = intent.getStringExtra("phNo");

        TextView eventNameTextView = (TextView) findViewById(R.id.eventNameDetail);
        eventNameTextView.setText(eventName);

        TextView timeRangeTextView = (TextView) findViewById(R.id.timeRangeDetail);
        timeRangeTextView.setText(timeRange);

        TextView locationNameTextView = (TextView) findViewById(R.id.locationDetail);
        locationNameTextView.setText(locationName);

        TextView durationTextView = (TextView) findViewById(R.id.duration);
        durationTextView.setText(duration);

        TextView phNoTextView = (TextView) findViewById(R.id.phNo);
        phNoTextView.setText(phNo);

    }
}
