package org.example.Service;

import org.example.Model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {

    private TuitionRegistration tuitionService;
    private Student testStudent;

    @BeforeEach
    void setup() {
        tuitionService = new TuitionRegistration();
        testStudent = new Student("S001", "Maria Santos", "BSIT");
    }

    @Test
    void shouldCalculateCorrectTuitionFeeWithoutDiscount() {
        // Logic check: 5 units * 1000 = 5000
        assertEquals(5000, tuitionService.calculateTuitionFee(5, 0));
    }

    @Test
    void shouldCalculateCorrectTuitionFeeWithDiscount() {
        // Logic check: 5000 - 10% = 4500
        assertEquals(4500, tuitionService.calculateTuitionFee(5, 0.10));
    }

    @Test
    void shouldMakePaymentOf600() {
        // Arrange
        double total = tuitionService.calculateTuitionFee(5, 0);
        testStudent.getTuitionDetails().setBalance(total);
        // Act
        tuitionService.makePayment(testStudent, 600);
        // Assert: 5000 - 600 = 4400
        assertEquals(4400, testStudent.getTuitionDetails().getBalance());
    }

    @Test
    void shouldBeFullyPaid() {
        // Arrange
        testStudent.getTuitionDetails().setBalance(5000);
        // Act
        tuitionService.makePayment(testStudent, 5000);
        // Assert
        assertTrue(tuitionService.isFullyPaid(testStudent));
    }

    @Test
    void shouldNotBeFullyPaid() {
        // Arrange
        testStudent.getTuitionDetails().setBalance(5000);
        // Act
        tuitionService.makePayment(testStudent, 1000);
        // Assert
        assertFalse(tuitionService.isFullyPaid(testStudent));
    }
}