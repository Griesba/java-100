package com.griesba.executor;

public interface Callback <E extends Event> {
    void onEvent(E event);
    void onTimeout();
}
