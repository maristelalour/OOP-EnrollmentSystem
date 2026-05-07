package org.example.Service;

import org.example.Model.Student;
import java.util.List;

public interface StudentReg {
    void saveStudent(Student studentData);
    void displayAllStudent();
    boolean updateStudent(Student studentInfo);
    boolean removeStudent(Student studentRecord);
    List<Student> getAllStudents();
    Student findByID(String id);
}