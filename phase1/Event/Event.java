package com.example.utindergui.event;

// Still okay to put as a class since the subclass will only extend this class

// Should we use Observable? So when there is new event created, then these changes can be updated
//
public class Event {
    private String eventName;
    private String eventDate; // need to check for the data type for date
    private String eventTime; // need to check for the time format
    // private String type; // type of the event
    // add done feature?
    // add features about whether event happens weekly???

    public Event(String name, String date, String time) {
        this.eventName = name;
        this.eventDate = date;
        this.eventTime = time;
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getEventDate() {
        return this.eventDate;
    }

    public String getEventTime() {
        return this.eventTime;
    }

    // We can use the observer design pattern here
    public void setEventDate(String newDate) {
        this.eventDate = newDate;
        // change in the data
    }

    public void setEventTime(String newTime) {
        this.eventTime = newTime;
        // change in the data
    }

    // Interact with the EventManager
}
