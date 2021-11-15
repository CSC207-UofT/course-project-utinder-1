package com.example.myapplication.event;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

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
        AddEventB.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent adding_event_intent = new Intent(ActivityEvent.this, CreatingEvent.class);
                startActivity(adding_event_intent);
                finish();
            }
        });
    };
}
