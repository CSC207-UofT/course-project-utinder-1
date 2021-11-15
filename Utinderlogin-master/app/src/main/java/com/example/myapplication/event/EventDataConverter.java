package com.example.myapplication.event;

import com.example.myapplication.event.EventManager;

public class EventDataConverter {

    public boolean addNewEvent(String name, String date, String time, String location, String type) {
        EventManager e = new EventManager();
        boolean result = e.createEvent(name, date, time, location, type);
        return result;
    }
}
