package com.example.demo;

public interface Callback <E extends Event> {
    void onEvent(E event);
    void onTimeout();
}
