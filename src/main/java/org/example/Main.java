package org.example;

import org.example.Entity.Course;
import org.example.Entity.Instructor;
import org.example.Entity.Person;
import org.example.Entity.Student;
import org.example.Service.CourseRegistration;
import org.example.Service.StudentRegistration;

import java.sql.SQLOutput;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        StudentRegistration studentRegis = new StudentRegistration();
        CourseRegistration courseRegis = new CourseRegistration();

        /*Student s3 = new Student(2022317151, "John Doe", "Information Technology");
        Student s4 = new Student(2022317159, "Jane Doe", "Information Technology");
*/
      /*  studentRegis.saveStudent(s3);
        studentRegis.saveStudent(s4);*/

        studentRegis.displayAllStudent();

        Course c1 = new Course("1285416", "Integrative Programming", "Information Technology");
        courseRegis.save(c1);

        courseRegis.displayAll();

        Instructor instructor = new Instructor();

        Person person = new Person("2022317151","John Doe");
        System.out.printf("Person ID: %s \n", person.getPersonID());
        System.out.printf("Person Name: %s",person.getPersonName());







    }
}