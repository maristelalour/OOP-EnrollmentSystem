package org.example.Model;

public class TuitionFeePayment {
    private double totalTuitionFee;
    private double balance;

    public TuitionFeePayment(double balance) {
        this.balance = balance;
        this.totalTuitionFee = balance;
    }

    public double getTotalTuitionFee() { return totalTuitionFee; }
    public void setTotalTuitionFee(double totalTuitionFee) { this.totalTuitionFee = totalTuitionFee; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}