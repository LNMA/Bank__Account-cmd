package com.louay.projects.entry;

import java.io.Serializable;

public class SavingAccount extends Account implements Serializable {
    private double withdraw;

    public SavingAccount(String name, String description, double annualInterestRate, double balance) {
        super(name, description, annualInterestRate, balance);
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
            return super.toString() + " SavingAccount{" +
                    "withdraw=" + getWithdraw() +" $"+
                    '}';
        }else {
            return super.toString() ;
        }
    }
}
