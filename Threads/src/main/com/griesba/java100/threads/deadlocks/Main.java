package com.griesba.java100.threads.deadlocks;

public class Main {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        /* this program has a deadlock problem
         * thread1 and thread2 acquire the locks in circular manner
         * thread1 get lock1 and thread1 get lock2
         * A solution is to dispatch the lock in order to avoid deadlock
         */
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread {
        public void run () {
            synchronized (lock1) {
                System.out.println("Thread 1 : Has lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 1 : waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1 : Has lock1 and lock2");
                }
                System.out.println("Thread 1 : Release lock2");
            }
            System.out.println("Thread 1 : Released lock1. Exiting...");
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2 : Has lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2 : waiting for lock1");
                synchronized (lock1) {
                    System.out.println("Thread 2 : Has lock1 and lock2");
                }
                System.out.println("Thread 2 : Release lock1");
            }
            System.out.println("Thread 2 : Released lock2. Exiting...");
        }
    }
}
