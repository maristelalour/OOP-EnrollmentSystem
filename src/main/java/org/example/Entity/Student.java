package org.example.Entity;

public class Student extends Person {
    private String program;

    public Student() {}

    public Student(String personID, String personName, String program) {
        super(personID, personName);
        this.program = program;
    }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    public void display() {
        System.out.println("Student ID   : " + getPersonID());
        System.out.println("Student Name : " + getPersonName());
        System.out.println("Program      : " + program);
    }

    @Override
    public void mainTask() {
        System.out.println("Learns from Instructor");
    }
}