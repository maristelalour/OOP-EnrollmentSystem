package org.example.Service;

import org.example.Model.Department;
import org.example.Model.Section;
import org.example.Entity.Instructor;
import org.example.Entity.Student;

public interface DepartmentRegistration {
    void saveDepartment(Department department);
    void updateDepartment(Department department);
    void removeDepartment(String departmentID);
    void displayAllDepartments();

    void addSectionToDepartment(String departmentID, Section section);
    void removeSectionFromDepartment(String departmentID, String sectionID);

    void addInstructorToDepartment(String departmentID, Instructor instructor);
    void removeInstructorFromDepartment(String departmentID, String instructorID);

    void addStudentToSection(String departmentID, String sectionID, Student student);
    void removeStudentFromSection(String departmentID, String sectionID, String studentID);
}