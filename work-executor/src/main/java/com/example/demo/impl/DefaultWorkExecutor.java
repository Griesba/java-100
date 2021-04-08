package com.example.demo.impl;

import com.example.demo.utils.ThreadContextManager;
import com.example.demo.work.GenericWork;
import com.example.demo.work.WorkExecutor;
import com.example.demo.work.WorkExecutorException;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class DefaultWorkExecutor implements WorkExecutor {
    private final ConcurrentMap<String, ExecutorService> executors = new ConcurrentHashMap<>();
    private final int threadPoolSize;

    private final ThreadContextManager threadContextManager;

    public DefaultWorkExecutor(int threadPoolSize, ThreadContextManager threadContextManager) {
        this.threadPoolSize = threadPoolSize;
        this.threadContextManager = threadContextManager;
    }

    @Override
    public void executeWork(GenericWork genericWork, String jndiName) throws WorkExecutorException {
        LOGGER.debug("Send work using thread {} (thread pool '{}')", genericWork.toString(), jndiName);

        ExecutorService executorService = executors.get(jndiName);
        if (executorService == null){
            executorService = newFixedThreadPool(threadPoolSize);
            ExecutorService previousExecutor = executors.putIfAbsent(jndiName, executorService);
            if (previousExecutor != null) {
                executorService = previousExecutor;
            }
        }

        enrichGenericWork(genericWork);
        Future<?> future = executorService.submit(genericWork);
        genericWork.setFuture(future);


    }

    @Override
    public boolean waitFor(Collection<? extends GenericWork> works, long waitTimeInMillis, String jndiName) throws Exception {
        LOGGER.debug("Wait for work using thread");

        try {
            boolean success = true;
            for (GenericWork work: works) {
                enrichGenericWork(work);
                work.getFuture().get(waitTimeInMillis, TimeUnit.MILLISECONDS);
                success = success && !work.getFuture().isCancelled();
            }
            return success;
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException | InterruptedException e) {
            throw new Exception(e.getMessage(), e);// create a custom one
        }
    }

    private void enrichGenericWork(GenericWork work){
        work.setThreadContextManager(threadContextManager);
    }
}
