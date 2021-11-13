package com.example.utindergui.event;

import java.util.ArrayList;

// Use Observer design pattern?

public class EventManager {

    private ArrayList<Event> events;

    public EventManager() {
        // We need to make sure event manager connects to the database
        this.events = new ArrayList<>();
        this.events.add(new Event("KOVA Meeting", "2021-11-01", "9:00PM"));
    }

    /*
       If the event is already created, return the index of the event. Otherwise, return -1
     */
    public int findEvent(String name, String date, String time) {
        for (int i = 0; i < this.events.size(); i++) {
            Event e = this.events.get(i);
            if (e.getEventName().equals(name) && e.getEventDate().equals(date) && e.getEventTime().equals(time)) {
                return i;
            }
        }
        return -1;
    }

    // When new Assignment, Exam, and Extra objects are created, then we also
    // need to automatically update the specific Course => Observer pattern
    // empty string for type2 if type1 is academic or extracurricular
    // assignment/exam/extra for type2 if type1 is for the specific Course code
    public boolean createEvent(String name, String date, String time, String type1, String type2) {
        if (findEvent(name, date, time) == -1) {
            EventFactory factory = new EventFactory();
            Event newEvent = factory.createEvent(name, date, time, type1, type2);
            this.events.add(newEvent);

            return true;
        } else {
            return false;
        }

    }

    public boolean removeEvent(Event old_event) {
        this.events.remove(old_event);
        return true; // indicate that it is successfully removed
    }


}
