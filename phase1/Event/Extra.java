package com.example.utindergui.event;

/*
   A subclass of Event that represents extra
   homeworks for the particular course
 */
public class Extra extends Event{
    private String courseCode;
    public Extra (String name, String date, String time, String code) {
        super(name, date, time);
        this.courseCode = code;
    }
    public String getCourseCode() {
        return this.courseCode;
    }
}
