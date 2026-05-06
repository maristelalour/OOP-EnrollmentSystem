package org.example.Model;

public class Course {
    private String courseID;
    private String courseName;
    private String program;
    private int units;

    public Course() {}

    public Course(String courseID, String courseName, String program, int units) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
        this.units = units;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void display() {
        System.out.println("Course ID   : " + courseID);
        System.out.println("Course Name : " + courseName);
        System.out.println("Program     : " + program);
        System.out.println("Units       : " + units + "\n");
    }
}