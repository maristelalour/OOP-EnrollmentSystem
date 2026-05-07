package org.example.Service;

import org.example.Exception.DuplicateIDException;
import org.example.Model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRegistration implements StudentReg {
    private ArrayList<Student> studentList = new ArrayList<>();

    @Override
    public void saveStudent(Student studentData) {
        if (findByID(studentData.getPersonID()) != null) {
            throw new DuplicateIDException("Error: Student ID " + studentData.getPersonID() + " already exists!");
        }
        studentList.add(studentData);
        System.out.println("Student " + studentData.getPersonName() + " registered successfully.");
    }

    @Override
    public void displayAllStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        for (Student s : studentList) {
            System.out.println("\nStudent ID   : " + s.getPersonID());
            System.out.println("Student Name : " + s.getPersonName());
            System.out.println("Program      : " + s.getProgram());
        }
    }

    @Override
    public boolean updateStudent(Student studentInfo) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPersonID().equalsIgnoreCase(studentInfo.getPersonID())) {
                studentList.set(i, studentInfo);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeStudent(Student studentRecord) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPersonID().equalsIgnoreCase(studentRecord.getPersonID())) {
                studentList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Student findByID(String id) {
        for (Student s : studentList) {
            if (s.getPersonID().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
}