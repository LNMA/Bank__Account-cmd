package com.louay.projects.entry;

import java.io.Serializable;

public class CheckingAccount extends Account implements Serializable {

    private double overDrawn;
    private double overDrawnRate;
    private double withdraw;

    public CheckingAccount(String name, String description, double annualInterestRate, double balance, double overDrawnRate) {
        super(name, description, annualInterestRate, balance);
        setOverDrawnRate(overDrawnRate);
        setOverDrawnDeposit();
    }

    public double getOverDrawn() {
        return overDrawn;
    }

    public void setOverDrawnDeposit() {
        this.overDrawn = getBalance()*getOverDrawnRate();
    }

    public void setOverDrawn(double overDrawn) {
        this.overDrawn = overDrawn;
    }

    public double getOverDrawnRate() {
        return overDrawnRate;
    }

    public void setOverDrawnRate(double overDrawnRate) {
        this.overDrawnRate = overDrawnRate/100;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public double getWithdraw() {
        return withdraw;
    }

    @Override
    public String toString() {
        if (getWithdraw() != 0) {
            return super.toString() + " CheckingAccount{" +
                    "overDrawn=" + overDrawn +" $"+
                    ", overDrawnRate=" + overDrawnRate +
                    ", withdraw=" + withdraw +" $"+
                    '}';
        }else {
            return super.toString() + " CheckingAccount{" +
                    "overDrawn=" + overDrawn +" $"+
                    ", overDrawnRate=" + overDrawnRate +
                    '}';
        }
    }
}
