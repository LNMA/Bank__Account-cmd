package com.louay.projects.controller;

import com.louay.projects.entry.Account;
import com.louay.projects.entry.CheckingAccount;
import com.louay.projects.entry.SavingAccount;
import com.louay.projects.exception.NotEnoughMoneyException;
import com.louay.projects.util.Sortable;
import com.louay.projects.view.CommandLineInterface;

import java.io.Serializable;
import java.util.ArrayList;

public class Transaction extends Account implements Serializable {
    private ArrayList<Account> list = new ArrayList<>();


    public Transaction() {
    }


    public void addToList(Account account) {
        this.list.add(account);
    }

    public Account getFromList(int index){
        return this.list.get(index);
    }

    public int getListSize(){
        return this.list.size();
    }

    protected void setMaxOrder(){
        int maxID =0;
        int tempID = 0;
        for (int i =0;i<list.size();i++){
            if (list.get(i) != null){
                tempID = list.get(i).getId();
                if (tempID > maxID)
                    maxID = tempID;
            }
        }
        setSequence(maxID);
    }

    public int idSearching(int id ){
        int indexMatch=-3;
        try {
            for(int i =0;i< list.size();i++){
                if (list.get(i) != null){
                    if ((list.get(i).getId()) == id){
                        indexMatch=i;
                    }
                }
            }
            if (indexMatch == -3)
                throw new IllegalArgumentException("\n>> sorry we did not find match id");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            indexMatch = idSearching(new CommandLineInterface().inputYourID());

        }
        return indexMatch;
    }

    public void depositOperation(int id ,double amount){
        int matchID = id;
        double temp = (list.get(matchID)).getBalance();
        temp += amount;
        (list.get(matchID)).setBalance(temp);
        (list.get(matchID)).setDeposit(amount);
        if (list.get(matchID) instanceof CheckingAccount)
            ((CheckingAccount) list.get(matchID)).setOverDrawnDeposit();
        System.out.println(">> deposit operation done successfully");
    }



    public void withdrawCheckingAccountOperation(double amount,int id)  {
        try{
            int matchID = id;
            double balanceTemp = list.get(matchID).getBalance();
            double overTemp = ((CheckingAccount)list.get(matchID)).getOverDrawn();
            if ((balanceTemp+overTemp) < amount )
                throw new NotEnoughMoneyException(amount,balanceTemp+overTemp);
            if (balanceTemp >=amount ){
                balanceTemp -= amount;
                list.get(matchID).setBalance(balanceTemp);
                ((CheckingAccount)list.get(matchID)).setWithdraw(amount);
                System.out.println(">> withdraw operation done successfully");
            }
            if ((balanceTemp < amount) && ((balanceTemp +overTemp) >= amount)){
                double over = amount-balanceTemp;
                overTemp -= over;
                balanceTemp -= amount;
                list.get(matchID).setBalance(balanceTemp);
                ((CheckingAccount)list.get(matchID)).setWithdraw(amount);
                ((CheckingAccount)list.get(matchID)).setOverDrawn(overTemp);
                System.out.println(">> withdraw operation done successfully with "+over+" $ overdraft");
            }}
        catch (NotEnoughMoneyException e){
            System.out.println(e.getMessage());
            withdrawCheckingAccountOperation(new CommandLineInterface().inputWithdrawAmount(),id);
        }
    }

    public void withdrawSavingAccountOperation(double amount,int id){
        try{
            int matchID = id;
            double balanceTemp = list.get(matchID).getBalance();
            if ((balanceTemp) < amount )
                throw new NotEnoughMoneyException(amount,balanceTemp);
            if (balanceTemp >=amount ){
                balanceTemp -= amount;
                list.get(matchID).setBalance(balanceTemp);
                ((SavingAccount)list.get(matchID)).setWithdraw(amount);
                System.out.println(">> withdraw operation done successfully");
            }
            else {
                System.out.println(">> withdraw operation failed");
            }}
        catch (NotEnoughMoneyException e){
            System.out.println(e.getMessage());
            withdrawSavingAccountOperation(new CommandLineInterface().inputWithdrawAmount(),id);
        }
    }

    public void showMeSortingList(){
        Sortable.sort(list);
        for (int i = 0 ;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }


}
