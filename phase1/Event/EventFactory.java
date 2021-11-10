package com.example.utindergui.event;

public class EventFactory {
    // Problem: how to distinguish the difference between the assignment/exam/extra in more efficient ways???
    // how to add the course code????
    // maybe,,,, need to create subclasses for GeneralEvent class?

    // even though we create Assignment/Exam/Extra in CourseManager, as these are still parts of Events,
    // it would be good to make EventManager also keep track of them....
    public Event createEvent(String name, String date, String time, String type1, String type2) {
        switch (type1) {
            case "academic":
                return new AcademicEvent(name, date, time);
            case "extracurricular":
                return new ExtracurricularEvent(name, date, time);
            default: // when the event is specific for the Course
                switch (type2) {
                    case "assignment":
                        return new Assignment(name, date, time, type1);
                    case "exam":
                        return new Exam(name, date, time, type1);
                    case "extra":
                        return new Extra(name, date, time, type1);
                }
        }
        return new Event(name, date, time);
    }
}
