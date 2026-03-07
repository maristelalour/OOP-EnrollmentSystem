package org.example.Service;
import org.example.Entity.Course;
import org.example.Entity.Person;
import java.util.*;

public class CourseRegistration extends Person {
    private ArrayList <Course> courseList = new ArrayList<>();

    public CourseRegistration(){

    }

    public void save(Course course){
        courseList.add(course);
    }

    public void displayAll(){
        for (Course c : courseList){
            System.out.println("Course ID: " + c.getPersonID());
            System.out.println("Course Name: " + c.getPersonName());
            System.out.println("Program: " + c.getprogram());
        }
    }

    public void updateCourse(Course course){
        for (int i=0; i<courseList.size(); i++){
            if (courseList.get(i).getPersonID()==course.getPersonID()){
                courseList.set(i,course);
                break;
            }

        }
    }

    public void removeCourse(Course course){
        for (int i=0; i<courseList.size(); i++){
            if (courseList.get(i).getPersonID()==course.getPersonID()){
                courseList.remove(i);
                break;
            }
        }
    }



}
