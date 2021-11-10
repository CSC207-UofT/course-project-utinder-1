package com.example.utindergui.event;

public class Exam extends Event{
    private String courseCode;

    public Exam (String name, String date, String time, String code) {
        super(name, date, time);
        this.courseCode = code;
    }

    public String getCourseCode() {
        return this.courseCode;
    }
}
