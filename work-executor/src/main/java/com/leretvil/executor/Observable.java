package com.griesba.executor;

import java.io.Serializable;

public interface Observable <V extends Serializable, E extends Event> {

    void observe(Callback<E> callback, String observerName, V previousValue, long timeout) throws ObservableException;
    void define(V value);
    V get();
}
