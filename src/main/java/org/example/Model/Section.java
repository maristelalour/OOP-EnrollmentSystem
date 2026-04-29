package org.example.Model;

import org.example.Entity.Instructor;
import org.example.Entity.Student;
import java.util.ArrayList;

public class Section {
    private String sectionID;
    private String sectionName;
    private int maxCapacity;
    private Instructor assignedInstructor;
    private ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Section() {}

    public Section(String sectionID, String sectionName, int maxCapacity) {
        this.sectionID = sectionID;
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
    }

    public String getSectionID() {
        return sectionID;
    }
    public void setSectionID(String sectionID) {
        this.sectionID = sectionID;
    }
    public String getSectionName() {
        return sectionName;
    }
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    public Instructor getAssignedInstructor() {
        return assignedInstructor;
    }
    public void setAssignedInstructor(Instructor instructor) {
        this.assignedInstructor = instructor;
    }
    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void removeStudent(String studentID) {
        enrolledStudents.removeIf(s -> s.getPersonID().equals(studentID));
    }

    public void display() {
        System.out.println("  Section ID   : " + sectionID);
        System.out.println("  Section Name : " + sectionName);
        System.out.println("  Capacity     : " + enrolledStudents.size() + "/" + maxCapacity);
        System.out.println("  Instructor   : " +
                //change
                (assignedInstructor != null ? assignedInstructor.getPersonName() : "Not assigned"));
        System.out.println("  Students     :");
        if (enrolledStudents.isEmpty()) {
            System.out.println("    No students enrolled.");
        } else {
            for (Student s : enrolledStudents) {
                System.out.println("    - [" + s.getPersonID() + "] " + s.getPersonName());
            }
        }
    }
}