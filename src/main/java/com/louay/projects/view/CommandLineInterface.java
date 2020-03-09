package com.louay.projects.view;


import com.louay.projects.entry.CheckingAccount;
import com.louay.projects.entry.SavingAccount;
import com.louay.projects.controller.Transaction;
import com.louay.projects.io.IOIn;
import com.louay.projects.io.IOOut;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineInterface extends IOIn {
    Scanner input = new Scanner(System.in);
    Transaction transaction = new Transaction();


    public CommandLineInterface() {
    }


    public void showMeList(){
        System.out.print("\n///////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ \n/ Please select your operation:\t   \\ \n/ 1. Creat new account.\t\t\t   \\" +
                "\n/ 2. Deposit.\t\t\t\t\t   \\ \n/ 3. Withdraw.\t\t\t\t\t   \\ \n/ 4. Transfer.\t\t\t\t\t   \\ \n/ 5. print all account.\t\t\t   \\  \n/ 6. save all change.\t\t\t   \\  \n/ 7. Exit.\t\t\t\t\t\t   \\" +
                " \n/ PLEASE input the choice number.  \\ \n///////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ \nYou:\\> ");
    }

    public int inputChoice() throws InputMismatchException {
        int choice =0;
        try{
            choice = input.nextInt();
            if (!(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7))
                throw new IllegalArgumentException("\n######################################### \n You are enter invalid value...try again \n#########################################\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            showMeList();
            choice = inputChoice();
        }
        catch (InputMismatchException e){
            System.out.print("\n>> you can just input integer numbers only\n");
            input.nextLine();
            showMeList();
            choice = inputChoice();
        }
        return choice;
    }

    public String inputYesNoChoice() {
        String yesNo = null;
        try {
            System.out.print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n| Would you like to perform a new operation.  | \n|                                             | \n| <Y>es, I would        <N>o, thanks          |\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \nYou:\\>");
            yesNo = input.next();
            if (input.hasNextLine()) {
                yesNo += input.nextLine();
            }
            if (!(yesNo.equalsIgnoreCase("n") || yesNo.equalsIgnoreCase("y"))) {
                throw new IllegalArgumentException("\n######################################### \n You are enter invalid value...try again \n#########################################\n");
            }
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            yesNo =  inputYesNoChoice();
        }
        return yesNo;
    }

    public int inputTargetID(){
        int id = 0;
        try {
            System.out.print("\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \n>\t  please input target ID Account.\t  < \n>\t   [-1] to abort.   \t\t\t\t  <\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \nYou:\\>");
            id = input.nextInt();
            if (id == -1)
                return -1;
            if (id < -1)
                throw new IllegalArgumentException("\n>> the id can not be negative\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            id = inputTargetID();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> you can just input integer numbers only\n");
            input.nextLine();
            id = inputTargetID();
        }
        return id;
    }

    public int inputYourID(){
        int id = 0;
        try {
            System.out.print("\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \n>\t   please input Your ID Account.\t  < \n>\t   [-1] to abort.   \t\t\t\t  <\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \nYou:\\>");
            id = input.nextInt();
            if (id == -1)
                return -1;
            if (id < -1)
                throw new IllegalArgumentException("\n>> the id can not be negative\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            id = inputYourID();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> you can just input integer numbers only\n");
            input.nextLine();
            id = inputYourID();
        }
        return id;
    }

    public double inputDepositAmount(){
        double amount = 0;
        try {
            System.out.print("\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \n>\t  please input Deposit Amount in $.\t  < \n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \nYou:\\>");
            amount = input.nextDouble();
            if (amount < 0)
                throw new IllegalArgumentException("\n>> the deposit amount must be positive\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            amount = inputDepositAmount();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> you can just input numbers only\n");
            input.nextLine();
            amount = inputDepositAmount();

        }
        return amount;
    }

    public double inputWithdrawAmount(){
        double amount = 0;
        try {
            System.out.print("\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \n>\tplease input withdraw Amount in $.\t  < \n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \nYou:\\>");
            amount = input.nextDouble();
            if (amount < 0)
                throw new IllegalArgumentException("\n>> the withdraw amount must be positive\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            amount = inputWithdrawAmount();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> you can just input numbers only\n");
            input.nextLine();
            amount = inputWithdrawAmount();
        }
        return amount;
    }

    public double inputTransferAmount(){
        double amount = 0;
        try {
            System.out.print("\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \n>\tplease input transfer Amount in $.\t  < \n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \nYou:\\>");
            amount = input.nextDouble();
            if (amount < 0)
                throw new IllegalArgumentException("\n>> the transfer amount must be positive\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            amount =inputTransferAmount();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> you can just input numbers only\n");
            input.nextLine();
            amount = inputTransferAmount();
        }
        return amount;
    }

    public String inputAccountType(){
        String type = "null";
        try {
            System.out.print("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< \n> What type of Account you want to creat it.\t\t\t\t  < \n>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  < \n> [C]hecking account, please.       [S]aving account, please. <\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< \nYou:\\>");
            type = input.next();
            if (input.hasNextLine()){
                type += input.nextLine();
            }
            if (!(type.equalsIgnoreCase("c") || type.equalsIgnoreCase("s"))){
                throw new IllegalArgumentException("\n######################################### \n You are enter invalid value...try again \n#########################################\n");
            }
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            type = inputAccountType();
        }
        return type;
    }

    public double inputAnnualInterestRate(){
        double rate = 0;
        try {
            System.out.print("\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \n> please input Annual Interest Rate (%).  < \n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \nYou:\\>");
            rate = input.nextDouble();
            if (rate<0)
                throw new IllegalArgumentException("\n>> Annual Interest Rate cannot be negative\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            rate = inputAnnualInterestRate();

        }
        catch (InputMismatchException mm){
            System.out.print("\n>> you can just input numbers only\n");
            input.nextLine();
            rate = inputAnnualInterestRate();
        }
        return rate;
    }

    public double inputOverdraftRate(){
        double over = 0;
        try {
            System.out.print("\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \n>\t  please input Overdraft rate (%).    < \n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \nYou:\\>");
            over = input.nextDouble();
            if (over<0)
                throw new IllegalArgumentException("\n>> Overdraft Rate cannot be negative\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            over = inputOverdraftRate();
        }
        catch (InputMismatchException mm){
            System.out.print("\n>> you can just input numbers only\n");
            input.nextLine();
            over = inputOverdraftRate();
        }
        return over;
    }

    public String inputName(){
        System.out.print("\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \n> \t \t\tplease input name.\t\t\t  < \n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \nYou:\\>");
        String name = input.next();
        if (input.hasNextLine()){
            name += input.nextLine();
        }
        return name;
    }

    public String inputDescription(){
        System.out.print("\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \n>  please input description of account.   < \n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<< \nYou:\\>");
        String desc = input.next();
        if (input.hasNextLine()){
            desc += input.nextLine();
        }
        return desc;
    }

    public void signature(){
        System.out.println(" ______\n|      |\t\t\t\t\t\t\t          \t\t\t\t     \t\t\t  \n|      |\t\t\t\t _______________\t\t____\t     ____  \t\t\t __________ \t\t    ____\t\t ____\n|      |\t\t\t\t/\t\t\t\t\\      |    |       |\t |\t\t    /    __    \\\t\t   |    |       |    |\n|      |    \t\t   |     _______\t |     |    |       |\t |    \t   /    /  \\    \\\t\t   |    |       |    |\n|      |\t\t       |    |       |\t |     |    |       |\t |     \t  /    /    \\    \\\t\t   |    |       |    |\n|      |\t\t       |    |\t    |\t |     |    |\t    |\t |\t\t /    /______\\    \\\t\t   |    |       |    |\n|      |________       |    |\t    |\t |     |    |\t    |\t | \t\t/    __________    \\\t   |    |       |    |\n|               |      |    |_______|\t |     |    |_______|\t |     /    /          \\    \\ \t   |    |_______|    |\n|               |      |   \t\t\t\t |     |   \t\t\t\t |    /    /  \t\t    \\    \\     |                 |\n|_______________| \t\t\\_______________/\t\t\\_______________/ \t /____/\t\t\t     \\____\\    \\___________      |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|    |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |    |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |    |\n ______________________________________________________________________________________________________________/     |\n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     |\n|___________________________________________________________________________________________________________________/");
    }

    public void triggerMethod(){
        signature();
        System.out.print("\n>>please wait until we restore all data.");
        iOIn();
        setMaxOrder();
        System.out.print("done.\n");
        String yesNo = "y";
        while (yesNo.equalsIgnoreCase("y")){
            showMeList();
            int choice = inputChoice();
            if (choice == 1) {
                String type = inputAccountType();
                if (type.equalsIgnoreCase("s")) {
                    transaction.addToList(new SavingAccount(inputName(), inputDescription(), inputAnnualInterestRate(), inputDepositAmount()));
                    IOOut.write(transaction.getFromList(transaction.getListSize()-1));
                } else
                    transaction.addToList(new CheckingAccount(inputName(), inputDescription(), inputAnnualInterestRate(), inputDepositAmount(), inputOverdraftRate()));
                IOOut.write(transaction.getFromList(transaction.getListSize()-1));
            }
            if (choice == 2) {
                int id = inputYourID();
                if (id == -1)
                    continue;
                id = idSearching(id);
                depositOperation(id, inputDepositAmount());
            }
            if (choice == 3) {
                int id = inputYourID();
                if (id == -1)
                    continue;
                id = idSearching(id);
                if (transaction.getFromList(id) instanceof SavingAccount) {
                    withdrawSavingAccountOperation(inputWithdrawAmount(), id);
                } else {
                    withdrawCheckingAccountOperation(inputWithdrawAmount(), id);
                }
            }
            if (choice == 4) {
                int src = inputYourID();
                if (src == -1)
                    continue;
                src = idSearching(src);
                int trgt = inputTargetID();
                if (trgt == -1)
                    continue;
                trgt = idSearching(trgt);
                if (src == trgt){
                    System.out.print("\n>> two id numbers cannot be same.\n");
                    continue;
                }
                double amount = inputTransferAmount();
                if (transaction.getFromList(src) instanceof  SavingAccount){
                    withdrawSavingAccountOperation(amount,src);
                    depositOperation(trgt,amount);
                }else{
                    withdrawCheckingAccountOperation(amount,src);
                    depositOperation(trgt,amount);
                }
            }
            if (choice == 5) {
                showMeSortingList();
            }
            if (choice == 6){
                System.out.print("\nplease be patient until we save all change...");
                IOOut.checkToSaveAll();
                for (int i=0;i<transaction.getListSize();i++){
                    if (transaction.getFromList(i) != null)
                        IOOut.write(transaction.getFromList(i) );
                }
                System.out.print("\ndone.\n");
            }
            if (choice == 7) {
                System.out.print("\nplease be patient until we save all change...");
                IOOut.checkToSaveAll();
                for (int i=0;i<transaction.getListSize();i++){
                    if (transaction.getFromList(i)  != null)
                        IOOut.write(transaction.getFromList(i) );
                }
                System.out.println("\nGood bye...");
                System.exit(0);
            }
            yesNo=inputYesNoChoice();
            if (yesNo.equalsIgnoreCase("n")) {
                System.out.print("\nplease be patient until we save all change...");
                IOOut.checkToSaveAll();
                for (int i=0;i<transaction.getListSize();i++){
                    if (transaction.getFromList(i) != null)
                        IOOut.write(transaction.getFromList(i));
                }
                System.out.println("\nGood bye...");
                break;
            }
        }
    }
}
