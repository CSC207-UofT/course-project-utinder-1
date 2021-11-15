package com.example.myapplication.event;

import com.example.myapplication.login.user.User;
import java.util.HashMap;

public class EventDataConverter {
    /*
        A method that passes the previous data to EventManager

        Will modify later
     */
    public HashMap passData (User name, HashMap data) {
        EventManager manager = new EventManager();
        return data;
    }

    public boolean addNewEvent(String name, String date, String time, String location, String type) {
        EventManager e = new EventManager();

        // call EventManager.setData to get the previous data

        return e.createEvent(name, date, time, location, type);
    }
}
