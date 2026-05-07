package org.example.Model;

public class TuitionFeePayment {
    private double totalTuitionFee;
    private double balance;

    public TuitionFeePayment(double totalTuitionFee) {
        this.totalTuitionFee = totalTuitionFee;
        this.balance = totalTuitionFee;
    }

    public double getTotalTuitionFee() {
        return totalTuitionFee;
    }

    public void setTotalTuitionFee(double totalTuitionFee) {
        this.totalTuitionFee = totalTuitionFee;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}