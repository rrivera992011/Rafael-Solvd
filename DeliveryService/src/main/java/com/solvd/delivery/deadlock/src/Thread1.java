package com.solvd.delivery.deadlock.src;

public class Thread1 extends Thread{

    private String username;
    private String password;

    public Thread1(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {

        synchronized (username) {
            System.out.println("Thread 1: locked resource 1");

            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }

            synchronized (password) {
                System.out.println("Thread 1: locked resource 2");
            }
        }

    }
}
