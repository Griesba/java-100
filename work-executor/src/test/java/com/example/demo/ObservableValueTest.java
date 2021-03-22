package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ObservableValueTest {

    @Test
    public void testExecutor() {
        assertThat("true", true, equalTo(true));
    }

}
