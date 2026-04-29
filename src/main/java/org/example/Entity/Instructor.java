package org.example.Entity;

import java.util.ArrayList;

public class Instructor extends Person {
    private ArrayList<String> courses;

    public Instructor() {
        this.courses = new ArrayList<>();
    }

    public Instructor(String personID, String personName) {
        super(personID, personName);
        this.courses = new ArrayList<>();
    }

    public ArrayList<String> getCourses() { return courses; }
    public void addCourse(String course) { courses.add(course); }
    public void setCourses(ArrayList<String> courses) { this.courses = courses; }

    public void display() {
        System.out.println("Instructor ID   : " + getPersonID());
        System.out.println("Instructor Name : " + getPersonName());
        System.out.println("Courses         : " + courses);
    }

    @Override
    public void mainTask() {
        System.out.println("Instructor teaches");
    }
}