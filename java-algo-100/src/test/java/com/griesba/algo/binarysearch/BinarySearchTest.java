package com.griesba.algo.binarysearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class BinarySearchTest {

    @Test void shouldSearchInSortedArray() {
        int[] ints = {3, 5, 10};
        Integer[] integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);
        assertThat(BinarySearch.search(integers, 10, 0, 2), equalTo(2));
    }

    @Test void shouldFindLargestAs10 () {
        int[] ints = {3, 5, 3, 10};
        int index = new BinarySearch().find(ints, 10);
        assertThat(index, greaterThanOrEqualTo(0));
    }
}
