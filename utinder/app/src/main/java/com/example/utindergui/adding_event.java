package com.example.utindergui;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class adding_event extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_event);

        Button BackToEvent = findViewById(R.id.backtoeventbutton);
        BackToEvent.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtoevent = new Intent(adding_event.this, activity_event.class);
                startActivity(backtoevent);
                finish();
            }
        }));
    }
}