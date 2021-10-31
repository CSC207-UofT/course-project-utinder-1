package com.example.utindergui.event;

import java.util.ArrayList;

public class EventManager {

    private ArrayList<Event> events;

    public EventManager() {
        this.events = new ArrayList<>();
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

    public boolean createEvent(String name, String date, String time) {
        if (findEvent(name, date, time) == -1) {
            this.events.add(new Event(name, date, time));
            return true;
        } else {
            return false;
        }

    }

    public boolean removeEvent(Event old_event) {
        this.events.remove(old_event);
        return false;
    }


}
