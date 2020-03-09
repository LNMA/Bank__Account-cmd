package com.louay.projects.exception;

public class NotEnoughMoneyException extends  Exception{
    private double missingAmount;
    public NotEnoughMoneyException(double amount , double balance) {
        super("you can not withdraw "+amount+" $ ,from your account with balance "+balance+" $");
        setMissingAmount(amount,balance);
        System.out.println("your balance missing amount of "+getMissingAmount()+" $");
    }

    public double getMissingAmount() {
        return missingAmount;
    }

    public void setMissingAmount(double amount , double balance)  {
        this.missingAmount = balance - amount;
    }
}
