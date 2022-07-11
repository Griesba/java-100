package com.griesba.java100.threads.threads.starvation.problem;

import com.griesba.java100.threads.threads.ThreadColors;

public class Starvation {

    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColors.ANSI_BLUE), "Priority 1");
        Thread t2 = new Thread(new Worker(ThreadColors.ANSI_GREEN), "Priority 2");
        Thread t3 = new Thread(new Worker(ThreadColors.ANSI_PURPLE), "Priority 3");
        Thread t4 = new Thread(new Worker(ThreadColors.ANSI_RED), "Priority 4");

        t1.setPriority(1);
        t2.setPriority(2);
        t3.setPriority(3);
        t4.setPriority(4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

    private static class Worker implements Runnable {

        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), i);
                }
            }
        }
    }
}
