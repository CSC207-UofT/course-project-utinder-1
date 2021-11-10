package com.example.utindergui.event;

/*
    A subclass of Event that represents the events, such as meeting, extracurricular events, etc.
 */
public class GeneralEvent extends Event{
    // maybe we do not need this,,,,
    private String typeEvent; // type of the event; academic or extracurricular
    public GeneralEvent(String eventName, String eventDate, String eventTime, String type) {
        super(eventName, eventDate, eventTime);
        this.typeEvent = type;
    }
}
