package com.example.myapplication.event;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreatingEvent extends AppCompatActivity {

    private HashMap<String, Object> events = new HashMap<>();
    private ArrayList<Map<String, String>> courseEvents = new ArrayList<>();
    private ArrayList<Map<String, String>> generalEvents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.myapplication.R.layout.activity_creating_event);

        final EditText eventName = findViewById(com.example.myapplication.R.id.puttingevent);
        final EditText eventDate = findViewById(com.example.myapplication.R.id.puttingdate);
        final EditText eventTime = findViewById(com.example.myapplication.R.id.puttingtime);
        final EditText eventType = findViewById(com.example.myapplication.R.id.categorizing);
        final EditText eventLocation = findViewById(com.example.myapplication.R.id.puttinglocation);
        final EditText courseCode = findViewById(com.example.myapplication.R.id.puttingcoursecode);
        final Button BackToEventView = findViewById(com.example.myapplication.R.id.createingeventbutton);
        final TextView failed = findViewById(R.id.fail_message);

        BackToEventView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String name = eventName.getText().toString();
                String date = eventDate.getText().toString();
                String time = eventTime.getText().toString();
                String type = eventType.getText().toString();
                String location = eventLocation.getText().toString();
                String code = courseCode.getText().toString();

                Map<String, String> newEvent = new HashMap<>();
                newEvent.put("name", name);
                newEvent.put("date", date);
                newEvent.put("time", time);
                newEvent.put("type", type);

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                DocumentReference userEvents = db.collection("users")
                        .document("UserEvent");

                userEvents.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            events = (HashMap) document.get("admin");
                            courseEvents = (ArrayList) events.get("CourseEvents");
                            generalEvents = (ArrayList) events.get("GeneralEvents");

                            // When the event is general event
                            if (code.equals("")) {
                                newEvent.put("location", location);
                                generalEvents.add(newEvent);
                                HashMap<String, HashMap> newData = new HashMap<>();
                                HashMap<String, ArrayList> newAdminData = new HashMap<>();
                                newAdminData.put("GeneralEvents", generalEvents);
                                newAdminData.put("CourseEvents", courseEvents);
                                newData.put("admin", newAdminData);
                                userEvents.set(newData).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d("Creating Event", "Successfully added new data");
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w("Creating Event", "Failed to add new data", e);
                                    }
                                });
                            } else { // when the event is assignment/exam/other homeworks
                                newEvent.put("code", code);

                                // add the data to the database
                                courseEvents.add(newEvent);
                                HashMap<String, HashMap> newData = new HashMap<>();
                                HashMap<String, ArrayList> newAdminData = new HashMap<>();
                                newAdminData.put("GeneralEvents", generalEvents);
                                newAdminData.put("CourseEvents", courseEvents);
                                newData.put("admin", newAdminData);
                                userEvents.set(newData).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d("Creating Event", "Successfully added new data");
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w("Creating Event", "Failed to add new data", e);
                                    }
                                });
                            }
                        } else {
                            Log.d("Creating Event", "get failed with", task.getException());
                        }
                    }
                });

                // Call EventDataConverter and its addEvent() method
                EventDataConverter dataConverter= new EventDataConverter();
                boolean result;
                if (code.equals("")) {
                    result = dataConverter.addNewEvent(name, date, time, location, type);
                } else {
                    result = dataConverter.addNewEvent(name, date, time, code, type);
                }
                if (result) {
                    Intent back_to_event = new Intent(CreatingEvent.this, ActivityEvent.class);
                    startActivity(back_to_event);
                    finish();
                } else {
                    failed.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}