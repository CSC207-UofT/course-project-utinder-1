package com.example.utindergui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class creating_event extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_event);

        final Button BackToEventView = findViewById(R.id.createingeventbutton);
        BackToEventView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Intent back_to_event = new Intent(creating_event.this, activity_event.class);
                startActivity(back_to_event);
                finish();
            }
        });
    }
}