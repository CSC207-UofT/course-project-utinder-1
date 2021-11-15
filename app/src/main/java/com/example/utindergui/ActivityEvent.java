package com.example.utindergui;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ActivityEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Button AddEventB = findViewById(R.id.addingbutton);
        final Button homebutton = findViewById(R.id.homebutton);
        final Button eventbutton = findViewById(R.id.eventbutton);
        final Button communitybutton = findViewById(R.id.communitybutton);
        final Button mebutton = findViewById(R.id.mebutton);
        AddEventB.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent adding_event_intent = new Intent(ActivityEvent.this, CreatingEvent.class);
                startActivity(adding_event_intent);
                finish();
            }
        });
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homebutton_intent = new Intent(ActivityEvent.this, Homepage.class);
                startActivity(homebutton_intent);
                finish();
            }
        });
        eventbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eventbutton_intent = new Intent(ActivityEvent.this, ActivityEvent.class);
                startActivity(eventbutton_intent);
                finish();
            }
        });
        communitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent communitybutton_intent = new Intent(ActivityEvent.this, Community.class);
                startActivity(communitybutton_intent);
                finish();
            }
        });
        mebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mebutton_intent = new Intent(ActivityEvent.this, MePage.class);
                startActivity(mebutton_intent);
                finish();
            }
        });
        };
    }

