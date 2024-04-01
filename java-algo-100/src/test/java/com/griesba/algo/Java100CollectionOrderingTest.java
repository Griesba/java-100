package com.griesba.algo;

import com.griesba.algo.entity.Bunny;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static org.assertj.core.api.Assertions.assertThat;

public class Java100CollectionOrderingTest {

    @Test
    void shouldOrderListOfString() {
        ArrayList<String> actual = new ArrayList<>(List.of("cc", "dd", "aa", "bb"));
        actual.sort(comparing(String::toString));

        ArrayList<String> expected = new ArrayList<>(List.of("aa", "bb", "cc", "dd"));
        assertThat(actual.size()).isEqualTo(4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldSortListOfStringWithTheirSize() {
        List<String> tags = new ArrayList<>(List.of("#morning", "#coffee", "#tea"));

        tags.sort(Comparator.comparing(String::length));

        assertThat(tags).isEqualTo(List.of( "#tea", "#coffee", "#morning"));
    }

    @Test
    void shouldOrderListOfStringWithCollections() {
        List<String> actual = new ArrayList<>(List.of("cc", "dd", "aa", "bb"));
        Collections.sort(actual);

        ArrayList<String> expected = new ArrayList<>(List.of("aa", "bb", "cc", "dd"));
        assertThat(actual.size()).isEqualTo(4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldOrderListOfStringWithStreamSorted() {
        List<String> actual = List.of("cc", "dd", "aa", "bb");
        actual = actual.stream().sorted(naturalOrder()).collect(Collectors.toList());
        //actual = actual.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList()); // this will also work
        //actual = actual.stream().sorted(Comparator.comparing(String::toString)).toList(); // this will also work
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
}
