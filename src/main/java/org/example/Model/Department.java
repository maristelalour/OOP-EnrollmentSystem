package org.example.Model;

import java.util.List;

public class Department {
    private String departmentID;
    private String departmentName;
    private List<Instructor> instructorList;
    private List<Section> sectionList;

    public Department(String departmentID, String departmentName, List<Instructor> instructorList, List<Section> sectionList) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.instructorList = instructorList;
        this.sectionList = sectionList;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public void displayDept() {
        System.out.println("Department ID   : " + getDepartmentID());
        System.out.println("Department Name : " + getDepartmentName());

        if (instructorList == null || instructorList.isEmpty()) {
            System.out.println("Instructors     : (None)");
        } else {
            System.out.print("Instructors     : ");
            for (int i = 0; i < instructorList.size(); i++) {
                System.out.print(instructorList.get(i).getPersonName());
                if (i < instructorList.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }

        if (sectionList == null || sectionList.isEmpty()) {
            System.out.println("Sections        : (None)");
        } else {
            System.out.print("Sections        : ");
            for (int i = 0; i < sectionList.size(); i++) {
                System.out.print(sectionList.get(i).getSectionName());
                if (i < sectionList.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return departmentName + " (ID: " + departmentID + ")";
    }
}