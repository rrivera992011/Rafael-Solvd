package com.solvd.delivery.deadlock.src;

public class Thread2 implements Runnable{

    private String username;
    private String password;

    public Thread2(String name, String password){
        this.username = name;
        this.password = password;
    }

    @Override
    public void run() {

        synchronized (password) {
            System.out.println("Thread 2: locked resource 2");

            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }

            synchronized (username) {
                System.out.println("Thread 2: locked resource 1");
            }
        }

    }
}
