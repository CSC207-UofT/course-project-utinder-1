package com.example.utindergui.event;

public class Assignment extends Event{
    private String courseCode;

    public Assignment(String name, String date, String time, String code) {
        super(name, date, time);
        this.courseCode = code;
    }
}
