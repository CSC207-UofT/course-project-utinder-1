package com.example.utindergui.event;

public class Meeting extends GeneralEvent{
    public Meeting(String eventName, String eventDate, String eventTime, String eventLocation) {
        super(eventName, eventDate, eventTime, eventLocation, "academic");
    }
}
