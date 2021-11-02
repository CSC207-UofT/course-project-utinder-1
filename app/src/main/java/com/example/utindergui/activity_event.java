package com.example.utindergui;

import android.widget.CalendarView;

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
    }
}