package org.example.Service;

import org.example.Exception.DuplicateIDException;
import org.example.Model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistrationTest {

    @Test
    void shouldSaveStudentCorrectly() {
        // Arrange
        StudentRegistration sr = new StudentRegistration();
        Student s1 = new Student("S001", "Maria Santos", "BSIT");
        // Act
        sr.saveStudent(s1);
        // Assert
        assertEquals(1, sr.getStudentList().size());
        assertEquals("Maria Santos", sr.findByID("S001").getPersonName());
    }

    @Test
    void shouldRemoveStudentCorrectly() {
        // Arrange
        StudentRegistration sr = new StudentRegistration();
        Student s1 = new Student("S001", "Maria Santos", "BSIT");
        sr.saveStudent(s1);
        // Act
        sr.removeStudent(s1);
        // Assert
        assertEquals(0, sr.getStudentList().size(), "List should be empty after removal.");
        assertNull(sr.findByID("S001"));
    }

    @Test
    void shouldNotAddDuplicateStudentIDs() {
        // Arrange
        StudentRegistration sr = new StudentRegistration();
        Student s1 = new Student("S001", "Maria Santos", "BSIT");
        Student s2 = new Student("S001", "Fake Maria", "BSCS"); // Same ID!
        // Act
        sr.saveStudent(s1);
        assertThrows(DuplicateIDException.class, () -> sr.saveStudent(s2));
        // Assert
        assertEquals(1, sr.getStudentList().size(), "The system allowed a duplicate ID to be saved.");
    }

    @Test
    void shouldUpdateStudentCorrectly() {
        // Arrange
        StudentRegistration sr = new StudentRegistration();
        Student s1 = new Student("S001", "Maria Santos", "BSIT");
        sr.saveStudent(s1);
        // Act
        boolean result = sr.updateStudent(new Student("S001", "Maria Reyes", "BSIT"));
        // Assert
        assertTrue(result);
        assertEquals("Maria Reyes", sr.findByID("S001").getPersonName());
    }

    @Test
    void shouldReturnFalseWhenUpdatingNonExistentStudent() {
        // Arrange
        StudentRegistration sr = new StudentRegistration();
        // Act
        boolean result = sr.updateStudent(new Student("S999", "Ghost Student", "BSIT"));
        // Assert
        assertFalse(result, "Updating a non-existent student should return false.");
    }
}