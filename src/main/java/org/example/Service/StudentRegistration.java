package org.example.Service;
import org.example.Entity.Student;
import org.example.Entity.Person;
import java.util.*;

public class StudentRegistration extends Person implements StudentReg {
    private final ArrayList<Student> studentLists = new ArrayList();

    public StudentRegistration(){

    }

    @Override
    public void mainTask() {
        System.out.println("Student registers in for the semester");

    }

    @Override
    public void saveStudent(Student student){
        studentLists.add(student);
    }

    @Override
    public void updateStudent(Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if (studentLists.get(i).getPersonID() == student.getPersonID()){
                studentLists.set(i,student);
                break;
            }
        }
    }

    @Override
    public void removeStudent (Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(i).getPersonID() == student.getPersonID()){
                studentLists.remove(i);
                break;
            }
        }
    }

    @Override
    public void displayAllStudent(){
        for (Student s: studentLists){
            System.out.println("Student ID: " + s.getPersonID());
            System.out.println("Student Name: " + s.getPersonName());
            System.out.println("Program: " + s.getprogram());
            System.out.println();
        }
    }






}
