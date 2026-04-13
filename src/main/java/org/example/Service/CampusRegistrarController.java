package org.example.Service;

import org.example.Entity.Instructor;
import org.example.Entity.Student;
import org.example.Model.Course;
import org.example.Model.Department;
import org.example.Model.Section;

public class CampusRegistrarController {
    private DepartmentRegistrationService deptService;
    private StudentRegistration studentRegis;
    private CourseRegistration courseRegis;

    public CampusRegistrarController(DepartmentRegistrationService deptService,
                                     StudentRegistration studentRegis,
                                     CourseRegistration courseRegis) {
        this.deptService = deptService;
        this.studentRegis = studentRegis;
        this.courseRegis = courseRegis;
    }

    // --- Department ---
    public void saveDepartment(Department department) {
        deptService.saveDepartment(department);
    }

    public void updateDepartment(Department department) {
        deptService.updateDepartment(department);
    }

    public void removeDepartment(String departmentID) {
        deptService.removeDepartment(departmentID);
    }

    public void displayAllDepartments() {
        deptService.displayAllDepartments();
    }

    // --- Section ---
    public void addSectionToDepartment(String departmentID, Section section) {
        deptService.addSectionToDepartment(departmentID, section);
    }

    public void removeSectionFromDepartment(String departmentID, String sectionID) {
        deptService.removeSectionFromDepartment(departmentID, sectionID);
    }

    // --- Instructor ---
    public void addInstructorToDepartment(String departmentID, Instructor instructor) {
        deptService.addInstructorToDepartment(departmentID, instructor);
    }

    public void removeInstructorFromDepartment(String departmentID, String instructorID) {
        deptService.removeInstructorFromDepartment(departmentID, instructorID);
    }

    // --- Student in Section ---
    public void addStudentToSection(String departmentID, String sectionID, Student student) {
        deptService.addStudentToSection(departmentID, sectionID, student);
    }

    public void removeStudentFromSection(String departmentID, String sectionID, String studentID) {
        deptService.removeStudentFromSection(departmentID, sectionID, studentID);
    }

    // --- Student ---
    public void saveStudent(Student student) {
        studentRegis.saveStudent(student);
    }

    public void displayAllStudents() {
        studentRegis.displayAllStudent();
    }

    // --- Course ---
    public void saveCourse(org.example.Entity.Course course) {
        courseRegis.save(course);
    }

    public void displayAllCourses() {
        courseRegis.displayAll();
    }
}