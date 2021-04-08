package com.example.demo;

import com.example.demo.impl.ObservableValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ObservableValueTest {

    @Test
    public void testExecutor() {
        assertThat("true", true, equalTo(true));
    }

    @Test
    public void testEventExecution() {
        ObservableValue<String> observable = new ObservableValue<>("initial");
        Assertions.assertEquals("initial", observable.get());

        TestCallback callback = new TestCallback();
        Assertions.assertNull(callback.newVal);

        try {
            observable.observe(callback, "TEST", "initial", 50001);
        } catch (ObservableException e) {
            Assertions.fail();
        }
        Assertions.assertNull(callback.newVal);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Assertions.fail();
        }

        observable.define("changed");

        Assertions.assertEquals("changed", observable.get());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Assertions.fail();
        }
        Assertions.assertEquals("changed", callback.newVal);
        Assertions.assertFalse(callback.terminated);

    }


    private class TestCallback implements Callback<ValueChangeEvent<String>> {

        private volatile String newVal = null;
        private volatile boolean terminated = false;

        @Override
        public void onEvent(ValueChangeEvent<String> event) {
            Assertions.assertEquals("initial", event.getOldValue());
            Assertions.assertEquals("changed", event.getNewValue());
            newVal = event.getNewValue();
        }

        @Override
        public void onTimeout() {
            this.terminated = true;
        }
    }
}
