package com.example.utindergui.event;

public class Exam extends Event{
    public Exam (String name, String date, String time, String code) {
        super(name, date, time, code, "exam");
    }
}
