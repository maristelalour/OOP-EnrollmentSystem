package org.example.Service;

import org.example.Model.Student;

public class TuitionRegistration implements TuitionReg {
    private final double PRICE_PER_UNIT = 1000.0;

    public double getPricePerUnit() {
        return PRICE_PER_UNIT;
    }

    @Override
    public double calculateTuitionFee(int numUnits, double discount) {
        double total = numUnits * PRICE_PER_UNIT;
        if (discount > 0) {
            total = total - (total * discount);
        }
        return total;
    }

    @Override
    public void makePayment(Student studentData, double amount) {
        double currentBalance = studentData.getTuitionDetails().getBalance();
        studentData.getTuitionDetails().setBalance(currentBalance - amount);
        System.out.println("Payment processed for  : " + studentData.getPersonName());
        System.out.println("Remaining Balance      : PHP " + studentData.getTuitionDetails().getBalance());
    }

    @Override
    public double getRemainingBalance(Student studentData) {
        return studentData.getTuitionDetails().getBalance();
    }

    @Override
    public boolean isFullyPaid(Student studentData) {
        return studentData.getTuitionDetails().getBalance() <= 0;
    }
}