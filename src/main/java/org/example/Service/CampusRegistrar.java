package org.example.Service;

import org.example.Exception.DuplicateIDException;
import org.example.Exception.SectionFullException;
import org.example.Model.*;
import java.util.List;

public class CampusRegistrar {
    private StudentReg studentReg;
    private CourseReg courseReg;
    private DepartmentRegis departmentReg;
    private SectionReg sectionReg;
    private TuitionReg tuitionReg;
    private EnrollmentReg enrollmentReg;
    private InstructorReg instructorReg;

    public CampusRegistrar(StudentReg studentReg, CourseReg courseReg,
                           DepartmentRegis departmentReg, SectionReg sectionReg,
                           TuitionReg tuitionReg, EnrollmentReg enrollmentReg,
                           InstructorReg instructorReg) {
        this.studentReg = studentReg;
        this.courseReg = courseReg;
        this.departmentReg = departmentReg;
        this.sectionReg = sectionReg;
        this.tuitionReg = tuitionReg;
        this.enrollmentReg = enrollmentReg;
        this.instructorReg = instructorReg;
    }

    // --- Student ---
    public void addStudent(Student studentData) {
        try {
            studentReg.saveStudent(studentData);
        } catch (DuplicateIDException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayAllStudents() {
        studentReg.displayAllStudent();
    }

    public boolean updateStudent(Student studentInfo) {
        boolean success = studentReg.updateStudent(studentInfo);
        if (success) {
            System.out.println("Student " + studentInfo.getPersonID() + " updated successfully.");
        } else {
            System.out.println("Student ID " + studentInfo.getPersonID() + " does not exist.");
        }
        return success;
    }

    public void removeStudent(String id) {
        Student found = findStudentByID(id);
        if (found != null) {
            studentReg.removeStudent(found);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student ID " + id + " does not exist.");
        }
    }

    // --- Course ---
    public void addCourse(Course courseData) {
        try {
            courseReg.save(courseData);
        } catch (DuplicateIDException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayAllCourses() {
        courseReg.displayAll(1000.0);
    }

    public void updateCourse(Course courseInfo) {
        courseReg.updateCourse(courseInfo);
    }

    public void removeCourse(String targetID) {
        courseReg.removeCourse(targetID);
    }

    // --- Instructor ---
    public void addInstructor(Instructor instructorData) {
        try {
            instructorReg.save(instructorData);
        } catch (DuplicateIDException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayAllInstructors() {
        instructorReg.displayAll();
    }

    public void updateInstructor(String instructorID, Instructor instructorInfo) {
        Instructor found = instructorReg.findByID(instructorID);
        if (found != null) {
            instructorReg.updateInstructor(instructorID, instructorInfo);
        } else {
            System.out.println("Instructor ID " + instructorID + " does not exist.");
        }
    }

    public void removeInstructor(String instructorID) {
        Instructor found = instructorReg.findByID(instructorID);
        if (found != null) {
            instructorReg.deleteInstructor(instructorID);
        } else {
            System.out.println("Instructor ID " + instructorID + " does not exist.");
        }
    }

    public void assignInstructorToSection(String instructorID, String sectionName) {
        Instructor instructor = instructorReg.findByID(instructorID);
        Section section = findSectionByName(sectionName);
        if (instructor != null && section != null) {
            instructorReg.assignInstructorToSection(instructor, section);
        } else if (instructor == null) {
            System.out.println("Instructor ID " + instructorID + " not found.");
        } else {
            System.out.println("Section " + sectionName + " not found.");
        }
    }

    // --- Section ---
    public void addSection(Section sectionData) {
        sectionReg.save(sectionData);
    }

    public void displayAllSections() {
        List<Section> sections = sectionReg.displayAll();
        if (sections.isEmpty()) {
            System.out.println("No sections found.");
        } else {
            for (Section s : sections) {
                s.displaySection();
            }
        }
    }

    public void updateSection(String sectionName, Section sectionInfo) {
        sectionReg.updateSection(sectionName, sectionInfo);
    }

    public void deleteSection(String sectionName) {
        sectionReg.deleteSection(sectionName);
    }

    public void displaySectionDetails(String sectionName) {
        Section sec = findSectionByName(sectionName);
        if (sec != null) {
            sec.displaySection();
        } else {
            System.out.println("Section not found.");
        }
    }

    public void assignCourseToSection(String sectionName, String courseID) {
        Section sec = findSectionByName(sectionName);
        Course course = findCourseByID(courseID);
        if (sec != null && course != null) {
            sec.setCourse(course);
            System.out.println("Course assigned to section successfully.");
        } else {
            System.out.println("Section or Course not found.");
        }
    }

    // --- Department ---
    public void addDepartment(Department deptData) {
        departmentReg.save(deptData);
    }

    public void displayAllDepartments() {
        List<Department> depts = departmentReg.displayAll();
        if (depts.isEmpty()) {
            System.out.println("No departments found.");
        } else {
            for (Department d : depts) {
                d.displayDept();
            }
        }
    }

    public void addSectionToDepartment(String deptName, String sectionName) {
        Department dept = findDeptByName(deptName);
        Section section = findSectionByName(sectionName);
        if (dept != null && section != null) {
            dept.getSectionList().add(section);
            System.out.println("Section added to department successfully.");
        } else {
            System.out.println("Department or Section not found.");
        }
    }

    public void addInstructorToDepartment(String deptName, String instructorID) {
        Department dept = findDeptByName(deptName);
        Instructor instructor = instructorReg.findByID(instructorID);
        if (dept != null && instructor != null) {
            dept.getInstructorList().add(instructor);
            System.out.println("Instructor added to department successfully.");
        } else {
            System.out.println("Department or Instructor not found.");
        }
    }

    public Department findDeptByName(String name) {
        List<Department> allDepts = departmentReg.displayAll();
        for (Department d : allDepts) {
            if (d.getDepartmentName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }

    // --- Tuition ---
    public void calculateAndSetTuition(String studentID, int numUnits) {
        Student studentData = findStudentByID(studentID);
        if (studentData != null) {
            double fee = tuitionReg.calculateTuitionFee(numUnits, 0);
            double currentBalance = studentData.getTuitionDetails().getBalance();
            studentData.getTuitionDetails().setTotalTuitionFee(currentBalance + fee);
            studentData.getTuitionDetails().setBalance(currentBalance + fee);
            System.out.println("New charges added     : PHP " + fee);
            System.out.println("Total updated balance : PHP " + (currentBalance + fee));
        } else {
            System.out.println("Student not found.");
        }
    }

    public void processPayment(String studentID, double amount) {
        Student studentData = findStudentByID(studentID);
        if (studentData != null) {
            tuitionReg.makePayment(studentData, amount);
        } else {
            System.out.println("Payment failed: Student not found.");
        }
    }

    public void checkBalance(String studentID) {
        Student studentData = findStudentByID(studentID);
        if (studentData != null) {
            double bal = studentData.getTuitionDetails().getBalance();
            System.out.println("Student         : " + studentData.getPersonName());
            System.out.println("Current Balance : PHP " + bal);
            String status = tuitionReg.isFullyPaid(studentData) ? "FULLY PAID" : "PENDING";
            System.out.println("Status          : " + status);
        } else {
            System.out.println("Student not found.");
        }
    }

    // --- Enrollment ---
    public void enrollStudent(String sectionName, String studentID) {
        Section sectionData = findSectionByName(sectionName);
        Student studentData = findStudentByID(studentID);
        if (sectionData == null) {
            System.out.println("Section " + sectionName + " not found.");
            return;
        }
        if (studentData == null) {
            System.out.println("Student ID " + studentID + " not found.");
            return;
        }
        try {
            enrollmentReg.enrollStudentInSection(sectionData, studentData);
        } catch (SectionFullException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void displayHierarchy() {
        List<Department> allDepts = departmentReg.displayAll();
        if (allDepts.isEmpty()) {
            System.out.println("No departments found. Please add a department first.");
            return;
        }
        enrollmentReg.viewDepartmentHierarchy(allDepts);
    }

    // --- Lookup Helpers (no casts needed) ---
    public Student findStudentByID(String id) {
        return studentReg.findByID(id);
    }

    public Section findSectionByName(String name) {
        return sectionReg.findBySectionName(name);
    }

    public Course findCourseByID(String id) {
        return courseReg.findByID(id);
    }

    public Instructor findInstructorByID(String id) {
        return instructorReg.findByID(id);
    }
}