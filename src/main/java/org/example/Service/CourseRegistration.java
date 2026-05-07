package org.example.Service;

import org.example.Exception.DuplicateIDException;
import org.example.Model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRegistration implements CourseReg {
    private ArrayList<Course> courseList = new ArrayList<>();

    @Override
    public void save(Course courseData) {
        if (findByID(courseData.getCourseID()) != null) {
            throw new DuplicateIDException("Error: Course ID " + courseData.getCourseID() + " already exists!");
        }
        courseList.add(courseData);
        System.out.println("Course " + courseData.getCourseName() + " registered successfully.");
    }

    @Override
    public void displayAll(double unitPrice) {
        if (courseList.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }
        System.out.println("\n--- Available Courses ---");
        for (Course c : courseList) {
            double totalCost = c.getUnits() * unitPrice;
            System.out.println("ID: " + c.getCourseID() +
                    " || Name: " + c.getCourseName() +
                    " || Units: " + c.getUnits() +
                    " || Tuition: PHP " + totalCost);
        }
    }

    @Override
    public void updateCourse(Course courseInfo) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseID().equalsIgnoreCase(courseInfo.getCourseID())) {
                courseList.set(i, courseInfo);
                System.out.println("Course " + courseInfo.getCourseID() + " updated successfully.");
                return;
            }
        }
        System.out.println("Error: Course ID not found.");
    }

    @Override
    public void removeCourse(String targetID) {
        boolean removed = courseList.removeIf(c -> c.getCourseID().equalsIgnoreCase(targetID));
        if (removed) {
            System.out.println("Course " + targetID + " removed successfully.");
        } else {
            System.out.println("Error: Course ID not found.");
        }
    }

    @Override
    public Course findByID(String courseID) {
        for (Course c : courseList) {
            if (c.getCourseID().equalsIgnoreCase(courseID)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseList;
    }
}