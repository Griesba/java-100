package com.example.demo.work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

public interface WorkExecutor {

    Logger LOGGER = LoggerFactory.getLogger(WorkExecutor.class);

    String DEFAULT_WORK = "default";

    default void executorWork(GenericWork genericWork) throws Exception {
        executeWork(genericWork, DEFAULT_WORK);
    }

    void executeWork(GenericWork genericWork, String jndiName) throws Exception;

    default boolean waitFor(long waitTimeInMillis, GenericWork ... works) throws Exception {
        return waitFor(waitTimeInMillis, DEFAULT_WORK, works);
    }

    default boolean waitFor(long waitTimeInMillis, String defaultWork, GenericWork... works) throws Exception{
        return waitFor(Arrays.asList(works), waitTimeInMillis, DEFAULT_WORK);
    }

    default boolean waitFor(Collection<? extends GenericWork> works, long waitTimeInMillis) throws Exception {
        return waitFor(works, waitTimeInMillis, DEFAULT_WORK);
    }

    boolean waitFor(Collection<? extends GenericWork> works, long waitTimeInMillis, String jndiName) throws Exception;
}
