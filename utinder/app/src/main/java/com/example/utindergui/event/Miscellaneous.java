package com.example.utindergui.event;

/*
   A subclass of Event that represents extra
   homeworks for the particular course
 */
public class Miscellaneous extends Event{
    public Miscellaneous(String name, String date, String time, String code) {
        super(name, date, time, code, "miscellaneous");
    }
}
