package com.griesba.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Java100FunctionalInterfaceTest {

    @FunctionalInterface
    interface Square {
        int calculate(int number);
    }

    @Test
    void shouldUsageOfFunctionalInterface() {
        Square square = x -> x*x;
        assertThat(square.calculate(2)).isEqualTo(4);
    }
}
