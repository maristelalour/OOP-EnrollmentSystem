package org.example.Service;

import org.example.Model.Department;
import org.example.Model.Section;
import org.example.Model.Student;
import java.util.List;

public interface EnrollmentReg {
    void enrollStudentInSection(Section section, Student student);
    void viewDepartmentHierarchy(List<Department> departments);
}