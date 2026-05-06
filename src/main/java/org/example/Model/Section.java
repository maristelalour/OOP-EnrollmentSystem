package org.example.Model;

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
        this.assignedInstructor = null;
        this.studentList = new ArrayList<>();
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

    public void setAssignedInstructor(Instructor assignedInstructor) {
        this.assignedInstructor = assignedInstructor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void displaySection() {
        System.out.println("Section      : " + sectionName);

        if (course != null) {
            System.out.println("Course       : " + course.getCourseName() + " (" + course.getCourseID() + ")");
        } else {
            System.out.println("Course       : Unselected");
        }

        System.out.println("Instructor   : " + (assignedInstructor != null ? assignedInstructor.getPersonName() : "Unselected"));
        System.out.println("Total Students: " + studentList.size() + "/" + maxCapacity);

        if (studentList.isEmpty()) {
            System.out.println("Student List : (No students enrolled)");
        } else {
            System.out.print("Student List : ");
            for (int i = 0; i < studentList.size(); i++) {
                System.out.print(studentList.get(i).getPersonName() + (i < studentList.size() - 1 ? ", " : ""));
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
    }
}