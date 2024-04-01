package com.griesba.algo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Java100MapTest {

    @Test
    void shouldTestThatMultiSameKeyOverrideOldValueInMap() {
        Map<String, Integer> integerMap = new HashMap<>();
        integerMap.put("one", 1);
        integerMap.put("two", 2);
        integerMap.put("three", 3);

        assertThat(integerMap).hasSize(3);
        assertThat(integerMap.get("one")).isEqualTo(1);

        integerMap.put("one", 10001);

        assertThat(integerMap).hasSize(3);
        assertThat(integerMap.get("one")).isEqualTo(10001);
    }
}
