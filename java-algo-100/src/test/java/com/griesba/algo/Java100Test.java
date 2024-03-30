package com.griesba.algo;

import com.griesba.algo.entity.Bunny;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static org.assertj.core.api.Assertions.assertThat;

public class Java100Test {
    @Test
    void shouldOrderListOfString() {
        ArrayList<String> actual = new ArrayList<>(List.of("cc", "dd", "aa", "bb"));
        actual.sort(comparing(String::toString));

        ArrayList<String> expected = new ArrayList<>(List.of("aa", "bb", "cc", "dd"));
        assertThat(actual.size()).isEqualTo(4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldOrderListOfStringWithCollections() {
        ArrayList<String> actual = new ArrayList<>(List.of("cc", "dd", "aa", "bb"));
        Collections.sort(actual);

        ArrayList<String> expected = new ArrayList<>(List.of("aa", "bb", "cc", "dd"));
        assertThat(actual.size()).isEqualTo(4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldOrderListOfStringWithStreamSorted() {
        List<String> actual = List.of("cc", "dd", "aa", "bb");
        actual = actual.stream().sorted(naturalOrder()).collect(Collectors.toList());

        List<String> expected = List.of("aa", "bb", "cc", "dd");
        assertThat(actual.size()).isEqualTo(4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldOrderListOfBunnyWithWeight() {
        List<Bunny> actualBunnies = new ArrayList<>(List.of(
                new Bunny("male", 500),
                new Bunny("male", 100),
                new Bunny("male", 150)));

        List<Bunny> expectedBunnies = new ArrayList<>(List.of(
                new Bunny("male", 100),
                new Bunny("male", 150),
                new Bunny("male", 500)));
        Collections.sort(actualBunnies);
        assertThat(actualBunnies).isEqualTo(expectedBunnies);
    }

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

    @Test
    void testConstructorCanHaveReturnType() {
        class Unicorn {
            private boolean alive;

            public boolean Unicorn() {
                this.alive = true;
                return true;
            }

            public Unicorn() {
            }

            public Unicorn(boolean alive) {
                this.alive = alive;
            }
        }

        Unicorn unicorn = new Unicorn();
        assertThat(unicorn.Unicorn()).isEqualTo(true);
    }

    @Test
    void shouldTestMultiKeyInMap() {
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
