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
        HashMap<String, String[]> sectionTime = new HashMap<>();
        sectionTime.put("Tuesday", new String[]{"1:00PM", "2:00PM"});
        sectionTime.put("Thursday", new String[]{"1:00PM", "2:00PM"});
        this.courses.add(new Course("CSC207F1", "LEC0101", sectionTime));
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

    // When we remove the course, the corresponding assignments, exams,
    // and extra homework events should be deleted
    public boolean removeCourse(String code, String section) {
        int index = findCourse(code, section);
        Course c = this.courses.get(index);
        ArrayList<Event> allTasks = new ArrayList<>();
        allTasks.addAll(c.getAllAssignments());
        allTasks.addAll(c.getAllExams());
        allTasks.addAll(c.getAllExtra());
        this.courses.remove(this.courses.get(index));

        // Remove all Assignments, Exams, Extras in Event
        // There should be one specific manager that we're working with
        EventManager manager = new EventManager();
        for (int i = 0; i < allTasks.size(); i++) {
            manager.removeEvent(allTasks.get(i));
        }

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

    public boolean addExam(Exam e) {
        int index = findCourse(e.getCourseCode());

        if (index != -1) {
            Course c = this.courses.get(index);
            c.addExam(e);
            return true;
        } else {
            return false;
        }
    }

    public boolean addExtra(Extra e) {
        int index = findCourse(e.getCourseCode());

        if (index != -1) {
            Course c = this.courses.get(index);
            c.addExtra(e);
            return true;
        } else {
            return false;
        }
    }

}
