package org.example.Entity;

public class Instructor {
    String instructorID;
    String instructorName;
    String courses;

    public Instructor(){

    }

    public Instructor(String instructorID, String instructorName, String courses){
        this.instructorID = instructorID;
        this.instructorName = instructorName;
        this.courses = courses;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getCourses(){
        return getCourses();
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }
}
