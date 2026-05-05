package org.example.Service;

import org.example.Model.Instructor;
import org.example.Model.Student;
import org.example.Model.Department;
import org.example.Model.Section;

import java.util.ArrayList;

public class DepartmentRegistrationService implements DepartmentRegistration {
    private ArrayList<Department> departmentList = new ArrayList<>();

    // --- Department CRUD ---
    @Override
    public void saveDepartment(Department department) {
        departmentList.add(department);
        System.out.println("Department saved: " + department.getDepartmentName());
    }

    @Override
    public void updateDepartment(Department department) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentID().equals(department.getDepartmentID())) {
                departmentList.set(i, department);
                System.out.println("Department updated!");
                return;
            }
        }
        System.out.println("Department not found.");
    }

    @Override
    public void removeDepartment(String departmentID) {
        departmentList.removeIf(d -> d.getDepartmentID().equals(departmentID));
        System.out.println("Department removed!");
    }

    @Override
    public void displayAllDepartments() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments found.");
        } else {
            for (Department d : departmentList) {
                d.display();
                System.out.println();
            }
        }
    }

    // --- Section methods ---
    @Override
    public void addSectionToDepartment(String departmentID, Section section) {
        Department d = findDepartment(departmentID);
        if (d != null) {
            d.addSection(section);
            System.out.println("Section added to department!");
        } else {
            System.out.println("Department not found.");
        }
    }

    @Override
    public void removeSectionFromDepartment(String departmentID, String sectionID) {
        Department d = findDepartment(departmentID);
        if (d != null) {
            d.removeSection(sectionID);
            System.out.println("Section removed!");
        } else {
            System.out.println("Department not found.");
        }
    }

    // --- Instructor methods ---
    @Override
    public void addInstructorToDepartment(String departmentID, Instructor instructor) {
        Department d = findDepartment(departmentID);
        if (d != null) {
            d.addInstructor(instructor);
            System.out.println("Instructor added to department!");
        } else {
            System.out.println("Department not found.");
        }
    }

    @Override
    public void removeInstructorFromDepartment(String departmentID, String instructorID) {
        Department d = findDepartment(departmentID);
        if (d != null) {
            d.removeInstructor(instructorID);
            System.out.println("Instructor removed!");
        } else {
            System.out.println("Department not found.");
        }
    }

    // --- Student in Section methods ---
    @Override
    public void addStudentToSection(String departmentID, String sectionID, Student student) {
        Department d = findDepartment(departmentID);
        if (d != null) {
            Section s = findSection(d, sectionID);
            if (s != null) {
                s.addStudent(student);
                System.out.println("Student added to section!");
            } else {
                System.out.println("Section not found.");
            }
        } else {
            System.out.println("Department not found.");
        }
    }

    @Override
    public void removeStudentFromSection(String departmentID, String sectionID, String studentID) {
        Department d = findDepartment(departmentID);
        if (d != null) {
            Section s = findSection(d, sectionID);
            if (s != null) {
                s.removeStudent(studentID);
                System.out.println("Student removed from section!");
            } else {
                System.out.println("Section not found.");
            }
        } else {
            System.out.println("Department not found.");
        }
    }

    // --- Helper methods ---
    private Department findDepartment(String departmentID) {
        for (Department d : departmentList) {
            if (d.getDepartmentID().equals(departmentID)) {
                return d;
            }
        }
        return null;
    }

    private Section findSection(Department department, String sectionID) {
        for (Section s : department.getSectionList()) {
            if (s.getSectionID().equals(sectionID)) {
                return s;
            }
        }
        return null;
    }
}