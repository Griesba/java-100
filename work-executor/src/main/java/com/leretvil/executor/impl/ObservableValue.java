package com.leretvil.executor.impl;

import com.leretvil.executor.Callback;
import com.leretvil.executor.ObservableException;
import com.leretvil.executor.work.WorkExecutor;
import com.leretvil.executor.work.WorkExecutorException;
import com.leretvil.executor.Observable;
import com.leretvil.executor.ValueChangeEvent;

import java.io.Serializable;

public class ObservableValue<V extends Serializable> implements Observable<V, ValueChangeEvent<V>> {

    private final WorkExecutor executor = new DefaultWorkExecutor(5, null);
    private V value;

    public ObservableValue(V initialValue) {
        this.value = initialValue;
    }

    @Override
    public void observe(Callback<ValueChangeEvent<V>> callback, String observerName, V previousValue, long timeout) throws ObservableException {
        try{
            executor.executeWork(new ObserverWork<>(observerName, this, callback, previousValue, timeout), "ObserverWorkManager");
        } catch (WorkExecutorException e) {
            throw new ObservableException("could not start observing change", e);
        }
    }

    @Override
    public void define(V newValue) {
        synchronized (this) {
            value = newValue;
            this.notifyAll();
        }
    }

    @Override
    public V get() {
        return value;
    }
}
