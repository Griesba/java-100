package com.griesba.java100.threads;

public class RunnableTread implements Runnable {
    @Override
    public void run() {
        System.out.println(ThreadColors.ANSI_PURPLE + "Hello from runnable thread");
    }
}
