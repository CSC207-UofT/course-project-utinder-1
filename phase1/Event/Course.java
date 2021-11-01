package com.example.utindergui.event;

import java.util.ArrayList;
import java.util.HashMap;

// Are we going to put the course in the same calendar as the event?
// Should we add its lecture room/tutorial room number?
// are we going to distinguish them by the lecture/tutorial => lecture and tutorial in a seperate section!
// need to work on the dataset for the courses! (Need to export json file from the website using API)

/*
    This class is for creating either one lecture or tutorial section for one course!
 */
public class Course {
    private String courseCode;
    private String section;
    // How to store the lecture and tutorial time in an efficient way?
    private HashMap<String, String[]> time; // key: day, value: [startTime, endTime];
    private ArrayList<Assignment> assignment;
    private ArrayList<Exam> exam;
    private ArrayList<Extra> extra; // list of homeworks that are not assignments/exam

    public Course(String code, String s, HashMap<String, String[]> t) {
        this.courseCode = code;
        this.section = s;
        this.time = t;
        this.assignment = new ArrayList<>();
        this.exam = new ArrayList<>();
        this.extra = new ArrayList<>();
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public String getSection() {
        return this.section;
    }

    public ArrayList<Assignment> getAllAssignments() {
        return this.assignment;
    }

    // Since there is a specific course code written in the Assignment object
    public void addAssignment(Assignment a) {
        // Add the duplicated assignments created message
        this.assignment.add(a);
    }

    public ArrayList<Exam> getAllExams() {
        return this.exam;
    }

    public ArrayList<Extra> getExtra() {
        return this.extra;
    }

}
