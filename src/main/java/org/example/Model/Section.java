package org.example.Model;

import org.example.Entity.Student;
import java.util.ArrayList;

public class Section {
    private String sectionID;
    private String sectionName;
    private ArrayList<Student> studentList = new ArrayList<>();

    public Section() {}

    public Section(String sectionID, String sectionName) {
        this.sectionID = sectionID;
        this.sectionName = sectionName;
    }

    public String getSectionID() { return sectionID; }
    public void setSectionID(String sectionID) { this.sectionID = sectionID; }

    public String getSectionName() { return sectionName; }
    public void setSectionName(String sectionName) { this.sectionName = sectionName; }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(String studentID) {
        studentList.removeIf(s -> s.getPersonID().equals(studentID));
    }

    public ArrayList<Student> getStudentList() { return studentList; }

    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("  No students in this section.");
        } else {
            for (Student s : studentList) {
                System.out.println("  - [" + s.getPersonID() + "] " + s.getPersonName());
            }
        }
    }

    public void display() {
        System.out.println("Section ID   : " + sectionID);
        System.out.println("Section Name : " + sectionName);
        System.out.println("Students     :");
        displayStudents();
    }
}