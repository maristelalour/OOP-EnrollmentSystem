package org.example.Model;

import org.example.Entity.Instructor;
import java.util.ArrayList;

public class Department {
    private String departmentID;
    private String departmentName;
    private ArrayList<Section> sectionList = new ArrayList<>();
    private ArrayList<Instructor> instructorList = new ArrayList<>();

    public Department() {}

    public Department(String departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public String getDepartmentID() { return departmentID; }
    public void setDepartmentID(String departmentID) { this.departmentID = departmentID; }
    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public ArrayList<Section> getSectionList() { return sectionList; }
    public ArrayList<Instructor> getInstructorList() { return instructorList; }

    public void addSection(Section section) { sectionList.add(section); }
    public void removeSection(String sectionID) {
        sectionList.removeIf(s -> s.getSectionID().equals(sectionID));
    }
    public void addInstructor(Instructor instructor) { instructorList.add(instructor); }
    public void removeInstructor(String instructorID) {
        instructorList.removeIf(i -> i.getPersonID().equals(instructorID));
    }

    public void display() {
        System.out.println("Department ID   : " + departmentID);
        System.out.println("Department Name : " + departmentName);
        System.out.println("Sections        :");
        if (sectionList.isEmpty()) {
            System.out.println("  No sections available.");
        } else {
            for (Section s : sectionList) {
                s.display();
                System.out.println();
            }
        }
    }
}