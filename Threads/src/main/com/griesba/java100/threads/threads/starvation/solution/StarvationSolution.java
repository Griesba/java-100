package com.griesba.java100.threads.threads.starvation.solution;

import com.griesba.java100.threads.threads.ThreadColors;
import com.griesba.java100.threads.threads.starvation.problem.Starvation;

import java.util.concurrent.locks.ReentrantLock;

public class StarvationSolution {
/*
     using ReentrantLock with fairness to ensure all thread can interleave and run in a fair way to avoid starvation

     When we have many thread using one resource and we want them to interleave, we don't want starvation, using ReentrantLock is the solution.
But starvation use many resource, so in the case where a waiting thread is not a problem, starvation is a acceptable situation.
For example, of many thread a reading from a queue, if one thread is starved but they other thread are reading the queue normaly, then it is not a big issue.
  */
    private static ReentrantLock lock = new ReentrantLock(true);

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
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), i);
                } finally {
                    lock.unlock(); // whatever happen the lock will be released in finally block
                }
            }
        }
    }
}
