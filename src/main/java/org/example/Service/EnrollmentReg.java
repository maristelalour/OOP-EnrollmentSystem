package org.example.Service;

import org.example.Exception.SectionFullException;
import org.example.Model.Department;
import org.example.Model.Section;
import org.example.Model.Student;
import java.util.List;

public interface EnrollmentReg {
    void enrollStudentInSection(Section sectionData, Student studentData) throws SectionFullException;
    void viewDepartmentHierarchy(List<Department> deptList);
}