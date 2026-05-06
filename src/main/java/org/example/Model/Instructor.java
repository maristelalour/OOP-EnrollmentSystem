package org.example.Model;

public class Instructor extends Person {
    private String courses;

    public Instructor() {

    }

    public Instructor(String personID, String personName, String courses) {
        super(personID, personName);
        this.courses = courses;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public void displayInst() {
        System.out.println("Instructor ID   : " + getPersonID());
        System.out.println("Instructor Name : " + getPersonName());
        System.out.println("Courses         : " + courses);
    }

    @Override
    public void mainTask() {
        System.out.println("Instructor teaches: " + courses);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "Name='" + getPersonName() + '\'' +
                ", ID='" + getPersonID() + '\'' +
                ", Courses='" + courses + '\'' +
                '}';
    }
}