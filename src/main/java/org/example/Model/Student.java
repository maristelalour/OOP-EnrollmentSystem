package org.example.Model;

public class Student extends Person {
    private String program;
    private TuitionFeePayment tuitionDetails;

    public Student(String personID, String personName, String program) {
        super(personID, personName);
        this.program = program;
        this.tuitionDetails = new TuitionFeePayment(0);
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public TuitionFeePayment getTuitionDetails() {
        return tuitionDetails;
    }

    public void display() {
        System.out.println("Student ID   : " + getPersonID());
        System.out.println("Student Name : " + getPersonName());
        System.out.println("Program      : " + getProgram());
    }

    @Override
    public void mainTask() {
        System.out.println("Student learns from the instructor");
    }
}