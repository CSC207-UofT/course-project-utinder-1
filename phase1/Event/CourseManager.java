package com.example.utindergui.event;

import java.util.ArrayList;
import java.util.HashMap;

/*
    This Java class takes care of all courses that the user is currently taking
 */
public class CourseManager {
    private ArrayList<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
        // Just for now
        HashMap<String, String[]> time = new HashMap<>();
        time.put("Tuesday", new String[]{"1:00PM", "2:00PM"});
        time.put("Thursday", new String[]{"1:00PM", "2:00PM"});
        this.courses.add(new Course("CSC207", "LEC0101", time));
    }

    /*
       If the event is already created, return the index of the event. Otherwise, return -1
     */
    public int findCourse(String code, String section) {
        for (int i = 0; i < this.courses.size(); i++) {
            Course c = this.courses.get(i);
            if (c.getCourseCode().equals(code) && c.getSection().equals(section)) {
                return i;
            }
        }
        return -1;
    }

    public int findCourse(String code) {
        for (int j = 0; j < this.courses.size(); j++) {
            Course c = this.courses.get(j);
            if (c.getCourseCode().equals(code)) {
                return j;
            }
        }
        return -1;
    }


    public boolean createCourse(String code, String section, HashMap<String, String[]> time) {
        if (findCourse(code, section) == -1) {
            this.courses.add(new Course(code, section, time));
            return true;
        } else {
            return false;
            // In the UI, we can display a popup message about the duplicated course!
        }

    }

    public boolean removeCourse(Course c) {
        this.courses.remove(c);
        return true;
    }

    public boolean addAssignment(Assignment a) {
        int index = findCourse(a.getCourseCode());

        if (index != -1) {
            Course c = this.courses.get(index);
            c.addAssignment(a);
            return true;
        } else {
            return false;
        }
    }

}
