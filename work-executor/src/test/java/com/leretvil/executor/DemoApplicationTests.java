package com.griesba.executor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

        ExecutorService executorService = newFixedThreadPool(1);

        Future future = executorService.submit(() -> System.out.println("I'am a thread"));

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
