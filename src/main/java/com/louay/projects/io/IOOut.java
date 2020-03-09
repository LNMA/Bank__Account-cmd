package com.louay.projects.io;


import java.io.*;

public interface IOOut {

    public static void write(Object o) {
        File file = new File("accounts.dat");
        if (file.exists()) {
            iOOutExist(o);
        } else
            iOOutNew(o);
    }

    static void iOOutExist(Object o) {
        try (AppendingObjectOutputStream out = new AppendingObjectOutputStream(new BufferedOutputStream(new FileOutputStream("accounts.dat", true)))) {
            out.writeObject(o);
            out.writeStreamHeader();
        } catch (IOException e) {
            System.out.print("\n>> " + e.getMessage() + "\n");
        }
    }

    static void iOOutNew(Object o) {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("accounts.dat", false)))) {
            out.writeObject(o);
        } catch (IOException e) {
            System.out.print("\n>> " + e.getMessage() + " \n");
        }
    }

    static void checkToSaveAll() {
        File file = new File("accounts.dat");
        if (file.exists())
            file.delete();
    }
}
