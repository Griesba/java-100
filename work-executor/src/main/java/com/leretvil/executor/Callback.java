package com.leretvil.executor;

public interface Callback <E extends Event> {
    void onEvent(E event);
    void onTimeout();
}
