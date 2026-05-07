package org.example.Service;

import org.example.Exception.SectionFullException;
import org.example.Model.Department;
import org.example.Model.Section;
import org.example.Model.Student;
import java.util.List;

public class EnrollmentService implements EnrollmentReg {

    @Override
    public void enrollStudentInSection(Section sectionData, Student studentData) throws SectionFullException {
        if (sectionData.getStudentList().size() >= sectionData.getMaxCapacity()) {
            throw new SectionFullException("Enrollment failed: " + sectionData.getSectionName() + " is currently full.");
        }
        sectionData.getStudentList().add(studentData);
        System.out.println("Success: " + studentData.getPersonName() + " enrolled in " + sectionData.getSectionName());
    }

    @Override
    public void viewDepartmentHierarchy(List<Department> deptList) {
        System.out.println("\n========== INSTITUTIONAL HIERARCHY ==========");
        for (Department dept : deptList) {
            System.out.println("\nDepartment: " + dept.getDepartmentName());
            if (dept.getSectionList().isEmpty()) {
                System.out.println("   └── (No sections assigned)");
                continue;
            }
            for (Section sec : dept.getSectionList()) {
                String instructorName = (sec.getAssignedInstructor() != null) ?
                        sec.getAssignedInstructor().getPersonName() : "TBA";
                System.out.println("   └── Section: " + sec.getSectionName() + " | Instructor: " + instructorName);
                if (sec.getCourse() != null) {
                    System.out.println("       Course: " + sec.getCourse().getCourseName() +
                            " (" + sec.getCourse().getCourseID() + ")");
                } else {
                    System.out.println("       Course: No Course Assigned");
                }
                if (sec.getStudentList().isEmpty()) {
                    System.out.println("       └── (No students enrolled)");
                } else {
                    for (Student s : sec.getStudentList()) {
                        System.out.println("       └── Student: [" + s.getPersonID() + "] " + s.getPersonName());
                    }
                }
            }
        }
        System.out.println("\n=============================================");
    }
}