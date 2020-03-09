package com.louay.projects.entry;

/* Author: Louay Amr , and my email is :louay_amr@outlook.com */

import com.louay.projects.io.IOOut;
import com.louay.projects.util.Sortable;

import java.io.Serializable;
import java.util.*;

public class Account implements Sortable, IOOut,Serializable {
    private int id ;
    private  String name;
    private  String description;
    private double annualInterestRate;
    private double monthlyInterestRate;
    private double monthlyInterest;
    private double balance;
    private double deposit;
    private String dateCreated;
    private static int sequence;

    public Account(String name, String description, double annualInterestRate,double balance) {
        setId(++sequence);
        this.name = name;
        this.description = description;
        this.balance = balance;
        setAnnualInterestRate(annualInterestRate);
        setDateCreated();
    }


    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
        setMonthlyInterestRate();
        setMonthlyInterest();
    }

    public void setMonthlyInterestRate(){
        this.monthlyInterestRate = getAnnualInterestRate()/12;
    }

    public double getMonthlyInterestRate(){
        return monthlyInterestRate ;
    }

    public double setMonthlyInterest(){
        return this.monthlyInterest =  getBalance()*(getMonthlyInterestRate()/100);
    }

    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setDateCreated() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        this.dateCreated = date.toString();
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        Account.sequence = sequence;
    }

    @Override
    public int compareTo(Object o) {
        Account t = ((Account)o);
        if (getBalance() > t.getBalance())
            return 1;
        if (getBalance() < t.getBalance())
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        if (getDeposit() != 0) {
            return "Account{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", annualInterestRate=" + annualInterestRate + " %"+
                    ", monthlyInterest=" + monthlyInterest +" $"+
                    ", balance=" + balance +" $"+
                    ", deposit=" + deposit +" $"+
                    ", dateCreated='" + dateCreated + '\'' +
                    '}';
        }else{
            return "Account{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", annualInterestRate=" + annualInterestRate +" %"+
                    ", monthlyInterest=" + monthlyInterest +" $"+
                    ", balance=" + balance +" $"+
                    ", dateCreated='" + dateCreated + '\'' +
                    '}';
        }
    }
}
