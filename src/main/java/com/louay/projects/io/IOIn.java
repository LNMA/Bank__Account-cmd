package com.louay.projects.io;

import com.louay.projects.entry.Account;
import com.louay.projects.controller.Transaction;

import java.io.*;


public class IOIn extends Transaction {
    public IOIn() {
    }

    public void iOIn() {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("accounts.dat")))) {
            while (true) {
                addToList((Account) in.readObject());
            }
        }
        catch (EOFException e) {
            System.out.print("\n>>all data was read successfully.\n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.print("\n>>" + e.getMessage() + ".\n");
        }
    }
}
