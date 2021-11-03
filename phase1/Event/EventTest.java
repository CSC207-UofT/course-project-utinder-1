package com.example.utindergui.event;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class EventTest {
    // Test for the general events
    EventManager testManager = new EventManager();
    CourseManager testManager2 = new CourseManager();

    @Test
    public void EventCreationFail() {
        // When there is a duplicated event, then it returns false!
        String eventName = "KOVA Meeting";
        String eventDate = "2021-11-01";
        String eventTime = "9:00PM";
        boolean actual_result = testManager.createEvent(eventName, eventDate, eventTime);
        assertFalse(actual_result);
    }

    @Test
    public void EventCreationSuccess() {
        String eventName = "Meeting with CSC207 Prof";
        String eventDate = "2021-11-04";
        String eventTime = "3:00PM";
        boolean actual_result = testManager.createEvent(eventName, eventDate, eventTime);
        assertTrue(actual_result);
    }

    @Test
    public void CourseCreationFail() {
        String code = "CSC207F1";
        String section = "LEC0101";
        HashMap<String, String[]> sectionTime = new HashMap<>();
        sectionTime.put("Tuesday", new String[]{"1:00PM", "2:00PM"});
        sectionTime.put("Thursday", new String[]{"1:00PM", "2:00PM"});
        boolean actualResult = testManager2.createCourse(code, section, sectionTime);
        assertFalse(actualResult);
    }

    @Test
    public void CourseCreationSuccess() {
        String code = "CSC209S1";
        String section = "LEC0101";
        HashMap<String, String[]> time = new HashMap<>();
        time.put("Tuesday", new String[]{"2:00PM", "3:00PM"});
        time.put("Thursday", new String[]{"2:00PM", "3:00PM"});
        boolean actualResult = testManager2.createCourse(code, section, time);
        assertTrue(actualResult);
    }

    // Tests for the course events
    @Test
    public void AssignmentCreationSuccess() {
        String name = "Code Smells Quiz";
        String date = "2021-11-02";
        String time = "12:00PM";
        String course = "CSC207F1";
        boolean actual_result = testManager2.addAssignment(new Assignment(name, date, time, course));
        assertTrue(actual_result);
    }

    @Test
    public void AssignmentCreationFail() {
        String name = "Code Smells Quiz";
        String date = "2021-11-02";
        String time = "12:00PM";
        String course = "CSC209S1";
        boolean actual_result = testManager2.addAssignment(new Assignment(name, date, time, course));
        assertFalse(actual_result);
    }

    @Test
    public void ExamCreationSuccess() {
        String name = "Final Exam";
        String date = "2021-12-15";
        String time = "6:00PM";
        String course = "CSC207F1";
        boolean actual_result = testManager2.addExam(new Exam(name, date, time, course));
        assertTrue(actual_result);
    }

    @Test
    public void ExamCreationFail() {
        String name = "Final Exam";
        String date = "2021-12-15";
        String time = "8:00PM";
        String course = "CSC236F1";
        boolean actual_result = testManager2.addExam(new Exam(name, date, time, course));
        assertFalse(actual_result);
    }

    @Test
    public void ExtraHomeworkCreationSuccess() {
        String name = "Weekly Quiz 10";
        String date = "2021-12-01";
        String time = "12:00PM";
        String course = "CSC207F1";
        boolean actual_result = testManager2.addExtra(new Extra(name, date, time, course));
        assertTrue(actual_result);
    }

    @Test
    public void ExtraHomeworkCreationFail() {
        String name = "Exercise 10";
        String date = "2021-12-03";
        String time = "10:00AM";
        String course = "CSC236F1";
        boolean actual_result = testManager2.addExtra(new Extra(name, date, time, course));
        assertFalse(actual_result);
    }


}
