package com.griesba.java100.threads.producerConsumer.executorService;

import com.griesba.java100.threads.ThreadColors;
import com.griesba.java100.threads.producerConsumer.MyConsumerTryLock;
import com.griesba.java100.threads.producerConsumer.NewMyProducerReentrantLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class MainReentrantLockWithExecutorService {
    public MainReentrantLockWithExecutorService() {
    }

    public static void main(String[] args) {

        List<String> buffer = new ArrayList<>();
        ReentrantLock reentrantLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        NewMyProducerReentrantLock producerWithTryFinally2 = new NewMyProducerReentrantLock(buffer, reentrantLock, ThreadColors.ANSI_BLUE);
        MyConsumerTryLock consumer1WithTryLock = new MyConsumerTryLock(buffer, ThreadColors.ANSI_GREEN, reentrantLock);
        MyConsumerTryLock consumer2WithTryLock = new MyConsumerTryLock(buffer, ThreadColors.ANSI_CYAN, reentrantLock);

        executorService.execute(producerWithTryFinally2);
        executorService.execute(consumer1WithTryLock);
        executorService.execute(consumer2WithTryLock);

        executorService.shutdown(); // Executor service does not shut down automatically

    }

}
