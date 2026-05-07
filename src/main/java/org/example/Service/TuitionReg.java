package org.example.Service;

import org.example.Model.Student;

public interface TuitionReg {
    double calculateTuitionFee(int numUnits, double discount);
    void makePayment(Student studentData, double amount);
    double getRemainingBalance(Student studentData);
    boolean isFullyPaid(Student studentData);
}