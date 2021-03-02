package com.example.demo.work;

public interface Work extends Runnable {
    void release();
    boolean isDaemon();
}
