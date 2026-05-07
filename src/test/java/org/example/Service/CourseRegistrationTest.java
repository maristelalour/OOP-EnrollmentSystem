package org.example.Service;

import org.example.Exception.DuplicateIDException;
import org.example.Model.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseRegistrationTest {

    @Test
    void shouldSaveCourseCorrectly() {
        // Arrange
        CourseRegistration cr = new CourseRegistration();
        Course course = new Course("IT101", "Integrative Programming", "BSIT", 3);
        // Act
        cr.save(course);
        // Assert
        assertNotNull(cr.findByID("IT101"), "Course should be found after saving.");
        assertEquals("Integrative Programming", cr.findByID("IT101").getCourseName());
    }

    @Test
    void shouldCorrectlyUpdateCourseInMasterRecord() {
        // Arrange
        CourseRegistration cr = new CourseRegistration();
        Course course = new Course("IT101", "Integrative Programming", "BSIT", 3);
        cr.save(course);
        // Act
        Course found = cr.findByID("IT101");
        found.setUnits(4);
        // Assert
        assertEquals(4, cr.findByID("IT101").getUnits(), "The course units were not updated in the master record.");
    }

    @Test
    void shouldNotAddDuplicateCourseIDs() {
        // Arrange
        CourseRegistration cr = new CourseRegistration();
        Course course1 = new Course("IT101", "Integrative Programming", "BSIT", 3);
        Course course2 = new Course("IT101", "Duplicate Course", "BSIT", 3);
        // Act
        cr.save(course1);
        assertThrows(DuplicateIDException.class, () -> cr.save(course2));
        // Assert
        assertEquals(1, cr.getAllCourses().size(), "Duplicate course ID should not be added.");
    }

    @Test
    void shouldRemoveCourseCorrectly() {
        // Arrange
        CourseRegistration cr = new CourseRegistration();
        Course course = new Course("IT101", "Integrative Programming", "BSIT", 3);
        cr.save(course);
        // Act
        cr.removeCourse("IT101");
        // Assert
        assertNull(cr.findByID("IT101"), "Course should be null after removal.");
    }

    @Test
    void shouldFindCourseByIDCaseInsensitive() {
        // Arrange
        CourseRegistration cr = new CourseRegistration();
        cr.save(new Course("IT101", "Integrative Programming", "BSIT", 3));
        // Act & Assert
        assertNotNull(cr.findByID("it101"), "findByID should be case-insensitive.");
    }
}