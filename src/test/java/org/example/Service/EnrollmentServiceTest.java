package org.example.Service;

import org.example.Exception.SectionFullException;
import org.example.Model.Section;
import org.example.Model.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EnrollmentServiceTest {

    @Test
    void shouldEnrollStudentSuccessfully() throws SectionFullException {
        // Arrange
        Section section = new Section("SEC01", "IT2D", 30);
        Student student = new Student("S001", "Alice Santos", "BSIT");
        EnrollmentService service = new EnrollmentService();
        // Act
        service.enrollStudentInSection(section, student);
        // Assert
        assertEquals(1, section.getStudentList().size(), "Student should be enrolled in the section.");
    }

    @Test
    void shouldRejectEnrollmentWhenSectionIsFull() throws SectionFullException {
        // Arrange
        Section section = new Section("SEC01", "IT2D", 1);
        Student student1 = new Student("S001", "Alice Santos", "BSIT");
        Student student2 = new Student("S002", "Bob Reyes", "BSCS");
        EnrollmentService service = new EnrollmentService();
        // Act
        service.enrollStudentInSection(section, student1);
        // Assert
        assertThrows(SectionFullException.class,
                () -> service.enrollStudentInSection(section, student2),
                "Section should have blocked the 2nd student.");
    }

    @Test
    void shouldNotExceedMaxCapacity() throws SectionFullException {
        // Arrange
        Section section = new Section("SEC01", "IT2D", 2);
        Student student1 = new Student("S001", "Alice Santos", "BSIT");
        Student student2 = new Student("S002", "Bob Reyes", "BSCS");
        Student student3 = new Student("S003", "Charlie Gomez", "BSIT");
        EnrollmentService service = new EnrollmentService();
        // Act
        service.enrollStudentInSection(section, student1);
        service.enrollStudentInSection(section, student2);
        try {
            service.enrollStudentInSection(section, student3);
        } catch (SectionFullException ignored) {}
        // Assert
        assertEquals(2, section.getStudentList().size(), "Section size must not exceed max capacity.");
    }

    @Test
    void shouldAllowEnrollmentUpToCapacity() {
        // Arrange
        Section section = new Section("SEC01", "IT2D", 2);
        Student student1 = new Student("S001", "Alice Santos", "BSIT");
        Student student2 = new Student("S002", "Bob Reyes", "BSCS");
        EnrollmentService service = new EnrollmentService();
        // Act & Assert
        assertDoesNotThrow(() -> {
            service.enrollStudentInSection(section, student1);
            service.enrollStudentInSection(section, student2);
        });
        assertEquals(2, section.getStudentList().size());
    }

    @Test
    void shouldIncludeSectionNameInExceptionMessage() throws SectionFullException {
        // Arrange
        Section section = new Section("SEC01", "IT2D", 1);
        Student student1 = new Student("S001", "Alice Santos", "BSIT");
        Student student2 = new Student("S002", "Bob Reyes", "BSCS");
        EnrollmentService service = new EnrollmentService();
        // Act
        service.enrollStudentInSection(section, student1);
        SectionFullException ex = assertThrows(SectionFullException.class,
                () -> service.enrollStudentInSection(section, student2));
        // Assert
        assertTrue(ex.getMessage().contains("IT2D"), "Exception message should mention the section name.");
    }
}