package org.example;

public class Course {
    private int courseID;
    private String courseName;
    private String program;

    public Course(){

    }

    public Course(int CourseID, String courseName, String program){
        this.courseID=courseID;
        this.courseName=courseName;
        this.program=program;

    }

    public void setcourseID(int courseID){
        this.courseID= courseID;
    }

    public int getcourseID(){
        return courseID;
    }

    public void setcourseName(String courseName){
        this.courseName=courseName;
    }

    public String getcourseName(){
        return courseName;
    }

    public void setprogram(String program){
        this.program=program;
    }

    public String getprogram(){
        return program;
    }

    public void display(){
        System.out.printf("Course ID: %d \n", courseID);
        System.out.printf("Course Name: %s \n", courseName);
        System.out.printf("Program: %s \n", program);
    }


}
