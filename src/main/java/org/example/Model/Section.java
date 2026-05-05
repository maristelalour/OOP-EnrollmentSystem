package org.example.Model;

import org.example.Model.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionID;
    private String sectionName;
    private int maxCapacity;
    private Instructor assignedInstructor;
    private Course course;
    private List<Student> studentList;

    public Section(String sectionID, String sectionName, int maxCapacity) {
        this.sectionID = sectionID;
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.studentList = new ArrayList<>();
    }

    public String getSectionID() { return sectionID; }
    public void setSectionID(String sectionID) { this.sectionID = sectionID; }
    public String getSectionName() { return sectionName; }
    public void setSectionName(String sectionName) { this.sectionName = sectionName; }
    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }
    public Instructor getAssignedInstructor() { return assignedInstructor; }
    public void setAssignedInstructor(Instructor instructor) { this.assignedInstructor = instructor; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    public List<Student> getStudentList() { return studentList; }

    public void removeStudent(String studentID) {
        studentList.removeIf(s -> s.getPersonID().equals(studentID));
    }

    public void display() {
        System.out.println("  Section ID   : " + sectionID);
        System.out.println("  Section Name : " + sectionName);
        System.out.println("  Capacity     : " + studentList.size() + "/" + maxCapacity);
        System.out.println("  Course       : " + (course != null ? course.getCourseName() : "Not assigned"));
        System.out.println("  Instructor   : " + (assignedInstructor != null ? assignedInstructor.getPersonName() : "Not assigned"));
        System.out.println("  Students     :");
        if (studentList.isEmpty()) {
            System.out.println("    No students enrolled.");
        } else {
            for (Student s : studentList) {
                System.out.println("    - [" + s.getPersonID() + "] " + s.getPersonName());
            }
        }
    }
}