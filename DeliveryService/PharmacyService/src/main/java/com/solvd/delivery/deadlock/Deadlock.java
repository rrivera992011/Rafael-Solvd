package com.solvd.delivery.deadlock;

public class Deadlock {
    public static void main(String[] args) {

        String username = "AwesomeBear100";
        String password = "i<3B3ars";
        Thread1 thread1 = new Thread1(username, password);

        Thread2 thread2 = new Thread2(username, password);
        Thread myThread = new Thread(thread2);

        thread1.start();
        myThread.start();
    }
}