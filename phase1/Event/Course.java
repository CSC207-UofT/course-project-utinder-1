package com.example.utindergui.event;

import java.util.ArrayList;

// Are we going to put the course in the same calendar as the event?
// Should we add its lecture room/tutorial room number?
// are we going to distinguish them by the lecture/tutorial
public class Course {
    private String courseCode;
    private String section;
    private ArrayList<String> time; // lecture and tutorial time
    private ArrayList<Assignment> assignment;
    private ArrayList<Exam> exam;
    private ArrayList<Extra> extra; // list of homeworks that are not assignments/exam

    public Course(String code, String s) {
        this.courseCode = code;
        this.section = s;
        this.assignment = new ArrayList<>();
        this.exam = new ArrayList<>();
        this.extra = new ArrayList<>();
    }

    public ArrayList<Assignment> getAllAssignments() {
        return this.assignment;
    }

    public ArrayList<Exam> getAllExams() {
        return this.exam;
    }

    public ArrayList<Extra> getExtra() {
        return this.extra;
    }

}
