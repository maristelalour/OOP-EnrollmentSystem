package org.example.Service;

import org.example.Model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionRegistrationTest {

    @Test
    void shouldHandleOverpaymentCorrectly() {
        // Arrange
        TuitionRegistration tr = new TuitionRegistration();
        Student student = new Student("S001", "Maria Santos", "BSIT");
        student.getTuitionDetails().setBalance(1000.0);
        // Act
        tr.makePayment(student, 1500.0);
        // Assert
        assertEquals(-500.0, student.getTuitionDetails().getBalance(),
                "The system should reflect a credit balance on overpayment.");
    }

    @Test
    void shouldReturnCorrectRemainingBalance() {
        // Arrange
        TuitionRegistration tr = new TuitionRegistration();
        Student student = new Student("S001", "Maria Santos", "BSIT");
        student.getTuitionDetails().setBalance(3000.0);
        // Act
        tr.makePayment(student, 1000.0);
        // Assert
        assertEquals(2000.0, tr.getRemainingBalance(student),
                "Remaining balance should be 2000 after paying 1000 from 3000.");
    }

    @Test
    void shouldReturnZeroBalanceAfterFullPayment() {
        // Arrange
        TuitionRegistration tr = new TuitionRegistration();
        Student student = new Student("S001", "Maria Santos", "BSIT");
        student.getTuitionDetails().setBalance(2000.0);
        // Act
        tr.makePayment(student, 2000.0);
        // Assert
        assertEquals(0.0, student.getTuitionDetails().getBalance(),
                "Balance should be zero after full payment.");
    }
}