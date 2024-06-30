package com.griesba.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Java100ExceptionTest {

    @Test
    void testUsageOfErrorInterface() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("A");
            throw new Error();
        } catch (Error e) {
            e.printStackTrace();
        } finally {
            stringBuilder.append("D");
        }
        assertThat(stringBuilder.toString()).isEqualTo("AD");
    }
}
