package com.example.utindergui.event;

public class EventFactory {
    public Event createEvent(String name, String date, String time, String location, String type) {
        switch (type) {
            case "academic":
                return new AcademicEvent(name, date, time, location);
            case "extracurricular":
                return new ExtracurricularEvent(name, date, time, location);
            case "assignment":
                return new Assignment(name, date, time, location);
            case "exam":
                return new Exam(name, date, time, location);
            case "miscellaneous":
                return new Miscellaneous(name, date, time, location);
        }
        return new Event(name, date, time, location, type);
    }
}
