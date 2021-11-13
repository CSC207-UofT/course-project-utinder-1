package com.example.utindergui.event;

public class ExtracurricularEvent extends GeneralEvent{
    public ExtracurricularEvent(String eventName, String eventDate, String eventTime, String eventLocation) {
        super(eventName, eventDate, eventTime, eventLocation, "extracurricular");
    }
}
