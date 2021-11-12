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

public class activity_event extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Button AddEventB = findViewById(R.id.addingbutton);
        AddEventB.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent adding_event_intent = new Intent(activity_event.this, adding_event.class);
                startActivity(adding_event_intent);
                finish();
            }
        });
        };
    }