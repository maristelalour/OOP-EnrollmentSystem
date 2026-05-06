package org.example.Service;

import org.example.Model.Course;

public interface CourseReg {
    void save(Course course);
    void displayAll(double pricePerUnit);
    void updateCourse(Course course);
    void removeCourse(String courseID);
    Course findByID(String id);
}
