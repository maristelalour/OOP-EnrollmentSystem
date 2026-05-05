package org.example.Service;

import org.example.Model.Course;

public interface CourseReg {
    void save(Course course);
    void displayAll();
    void updateCourse(Course course);
    void removeCourse(Course course);
}
