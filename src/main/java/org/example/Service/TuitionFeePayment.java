package org.example.Service;

public class TuitionFeePayment {
    private final double PRICE_PER_UNIT = 1000.0;
    private double totalTuitionFee;
    private double amountPaid;

    public double calculateTuitionFee(int units, double discountRate) {
        totalTuitionFee = units * PRICE_PER_UNIT;
        if (discountRate > 0) {
            totalTuitionFee -= totalTuitionFee * discountRate;
        }
        amountPaid = 0;
        return totalTuitionFee;
    }

    public void makePayment(double amount) {
        amountPaid += amount;
    }

    public double getRemainingBalance() {
        return totalTuitionFee - amountPaid;
    }

    public boolean isFullyPaid() {
        return getRemainingBalance() <= 0;
    }
}