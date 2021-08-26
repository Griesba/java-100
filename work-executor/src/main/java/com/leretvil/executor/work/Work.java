package com.leretvil.executor.work;

public interface Work extends Runnable {
    void release();
    boolean isDaemon();
}
