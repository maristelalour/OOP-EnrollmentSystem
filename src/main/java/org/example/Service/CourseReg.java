package org.example.Service;

import org.example.Model.Course;
import java.util.List;

public interface CourseReg {
    void save(Course courseData);
    void displayAll(double unitPrice);
    void updateCourse(Course courseInfo);
    void removeCourse(String targetID);
    Course findByID(String courseID);
    List<Course> getAllCourses();
}