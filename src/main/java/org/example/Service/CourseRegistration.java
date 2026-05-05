package org.example.Service;
import org.example.Model.Course;
import org.example.Model.Person;
import java.util.*;

public class CourseRegistration extends Person implements CourseReg{
    private ArrayList <Course> courseList = new ArrayList<>();

    public CourseRegistration(){

    }

    @Override
    public void mainTask() {
        System.out.println("Student registers for the course");

    }

    @Override
    public void save(Course course){
        courseList.add(course);
    }

    @Override
    public void displayAll(){
        for (Course c : courseList){
            System.out.println("Course ID: " + c.getPersonID());
            System.out.println("Course Name: " + c.getPersonName());
            System.out.println("Program: " + c.getprogram());
        }
    }

    @Override
    public void updateCourse(Course course){
        for (int i=0; i<courseList.size(); i++){
            if (courseList.get(i).getPersonID()==course.getPersonID()){
                courseList.set(i,course);
                break;
            }

        }
    }

    @Override
    public void removeCourse(Course course){
        for (int i=0; i<courseList.size(); i++){
            if (courseList.get(i).getPersonID()==course.getPersonID()){
                courseList.remove(i);
                break;
            }
        }
    }



}
