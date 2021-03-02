package com.example.demo.impl;

import com.example.demo.Callback;
import com.example.demo.Observable;
import com.example.demo.ObservableException;
import com.example.demo.ValueChangeEvent;

import java.io.Serializable;

public class ObservableValue<V extends Serializable> implements Observable<V, ValueChangeEvent<V>> {

    private final Work

    @Override
    public void observe(Callback callback, String observerName, Serializable previousValue, long timeout) throws ObservableException {

    }

    @Override
    public void define(V value) {

    }

    @Override
    public V get() {
        return null;
    }
}
