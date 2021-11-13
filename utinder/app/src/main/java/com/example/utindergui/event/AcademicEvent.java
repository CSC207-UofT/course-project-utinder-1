package com.example.utindergui.event;

public class AcademicEvent extends GeneralEvent{
    public AcademicEvent(String eventName, String eventDate, String eventTime, String eventLocation) {
        super(eventName, eventDate, eventTime, eventLocation, "academic");
    }
}
