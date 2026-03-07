package org.example.Entity;


public class Course extends Person {
    private String program;

    public Course(String personID, String personName, String program){
        super(personID,personName);
        this.program=program;
    }

    public void setprogram(String program){
        this.program=program;
    }

    public String getprogram(){
        return program;
    }

    public void display(){
        System.out.printf("Course ID: %d \n", getPersonID());
        System.out.printf("Course Name: %s \n", getPersonName());
        System.out.printf("Program: %s \n", program);
    }

}
