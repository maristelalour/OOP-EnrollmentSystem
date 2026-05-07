package org.example.Service;

import org.example.Exception.DuplicateIDException;
import org.example.Model.Instructor;
import org.example.Model.Section;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorRegistrationTest {

    @Test
    void shouldSuccessfullyLinkInstructorToSection() {
        // Arrange
        Instructor prof = new Instructor("I001", "Prof. Reyes", "Integrative Programming");
        Section section = new Section("SEC01", "IT2D", 30);
        InstructorRegistration ir = new InstructorRegistration();
        // Act
        ir.assignInstructorToSection(prof, section);
        // Assert
        assertNotNull(section.getAssignedInstructor(), "Section should have an assigned instructor.");
        assertEquals("Prof. Reyes", section.getAssignedInstructor().getPersonName());
    }

    @Test
    void shouldSaveInstructorCorrectly() {
        // Arrange
        InstructorRegistration ir = new InstructorRegistration();
        Instructor prof = new Instructor("I001", "Prof. Reyes", "Integrative Programming");
        // Act
        ir.save(prof);
        // Assert
        assertNotNull(ir.findByID("I001"), "Instructor should be found after saving.");
        assertEquals("Prof. Reyes", ir.findByID("I001").getPersonName());
    }

    @Test
    void shouldNotAddDuplicateInstructorIDs() {
        // Arrange
        InstructorRegistration ir = new InstructorRegistration();
        Instructor prof1 = new Instructor("I001", "Prof. Reyes", "Integrative Programming");
        Instructor prof2 = new Instructor("I001", "Fake Prof", "Math"); // Same ID!
        // Act
        ir.save(prof1);
        assertThrows(DuplicateIDException.class, () -> ir.save(prof2));
        // Assert
        assertEquals(1, ir.displayAll().size(), "Duplicate instructor ID should not be added.");
    }

    @Test
    void shouldDeleteInstructorCorrectly() {
        // Arrange
        InstructorRegistration ir = new InstructorRegistration();
        Instructor prof = new Instructor("I001", "Prof. Reyes", "Integrative Programming");
        ir.save(prof);
        // Act
        ir.deleteInstructor("I001");
        // Assert
        assertNull(ir.findByID("I001"), "Instructor should be null after deletion.");
    }

    @Test
    void shouldUpdateInstructorCorrectly() {
        // Arrange
        InstructorRegistration ir = new InstructorRegistration();
        Instructor prof = new Instructor("I001", "Prof. Reyes", "Integrative Programming");
        ir.save(prof);
        // Act
        ir.updateInstructor("I001", new Instructor("I001", "Prof. Santos", "Integrative Programming"));
        // Assert
        assertEquals("Prof. Santos", ir.findByID("I001").getPersonName());
    }
}