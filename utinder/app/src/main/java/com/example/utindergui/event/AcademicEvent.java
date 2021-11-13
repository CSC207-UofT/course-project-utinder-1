package com.example.utindergui.event;

public class AcademicEvent extends GeneralEvent{
    public AcademicEvent(String eventName, String eventDate, String eventTime) {
        super(eventName, eventDate, eventTime, "academic");
    }
}
