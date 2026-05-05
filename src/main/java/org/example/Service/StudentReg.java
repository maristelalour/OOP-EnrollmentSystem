package org.example.Service;

import org.example.Model.Student;

public interface StudentReg {
    void saveStudent(Student student);
    void updateStudent(Student student);
    void removeStudent (Student student);
    void displayAllStudent();
}
