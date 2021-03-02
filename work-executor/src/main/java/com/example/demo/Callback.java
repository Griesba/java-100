package com.example.demo;

public interface Callback <E extends Event> {
    void onEvent(Event event);
    void onTimeout();
}
