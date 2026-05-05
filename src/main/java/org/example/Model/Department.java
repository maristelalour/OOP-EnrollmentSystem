package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentID;
    private String departmentName;
    private List<Instructor> instructorList;
    private List<Section> sectionList;

    public Department(String departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.instructorList = new ArrayList<>();
        this.sectionList = new ArrayList<>();
    }

    public String getDepartmentID() { return departmentID; }
    public void setDepartmentID(String departmentID) { this.departmentID = departmentID; }
    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public List<Instructor> getInstructorList() { return instructorList; }
    public void setInstructorList(List<Instructor> instructorList) { this.instructorList = instructorList; }
    public List<Section> getSectionList() { return sectionList; }
    public void setSectionList(List<Section> sectionList) { this.sectionList = sectionList; }

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

    @Override
    public String toString() {
        return departmentName + " (ID: " + departmentID + ")";
    }
}