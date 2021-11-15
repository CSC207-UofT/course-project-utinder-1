package com.example.utindergui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.utindergui.event.EventManager;

public class CreatingEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_event);

        final EditText eventName = findViewById(R.id.puttingevent);
        final EditText eventDate = findViewById(R.id.puttingdate);
        final EditText eventTime = findViewById(R.id.puttingtime);
        final EditText eventType = findViewById(R.id.categorizing);
        final EditText eventLocation = findViewById(R.id.puttinglocation);
        final EditText courseCode = findViewById(R.id.puttingcoursecode);
        final Button BackToEventView = findViewById(R.id.createingeventbutton);
        final TextView failed = findViewById(R.id.fail_message);
        final TextView success = findViewById(R.id.success_message);
        BackToEventView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // Add the new Event to the EventManager
                String name = eventName.getText().toString();
                String date = eventDate.getText().toString();
                String time = eventTime.getText().toString();
                String type = eventType.getText().toString();
                String location = eventLocation.getText().toString();
                String code = courseCode.getText().toString();

                // Maybe this violates the Clean Architecture
                EventManager manager = new EventManager();
                if (code.equals("")) {
                    boolean result = manager.createEvent(name, date, time, location, type);
                    // indicate that a new event is created!
                    // We can show the red dot on the right date!
                    if (result) {
                        success.setVisibility(View.VISIBLE);
                    } else {
                        failed.setVisibility(View.VISIBLE);
                    }
                } else {
                    boolean result = manager.createEvent(name, date, time, code, type);
                    // indicate that a new event is created!
                    if (result) {
                        success.setVisibility(View.VISIBLE);
                    } else {
                        failed.setVisibility(View.VISIBLE);
                    }
                }

                Intent back_to_event = new Intent(CreatingEvent.this, ActivityEvent.class);
                startActivity(back_to_event);
                finish();
            }
        });
    }
}