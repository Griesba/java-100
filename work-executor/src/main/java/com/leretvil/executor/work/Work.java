package com.griesba.executor.work;

public interface Work extends Runnable {
    void release();
    boolean isDaemon();
}
