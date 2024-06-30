package com.griesba.algo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Java100CollectionTest {

    @Test
    void shouldAddNewElementOnlyIfNotExist() {
        //given list1 and list2
        List<String> list1 = new ArrayList<>(List.of("one", "two", "three"));
        List<String> list2 = new ArrayList<>(List.of("one", "two", "five", "six"));

        //add list2 to list1 only if not present
        list2.removeAll(list1);
        list1.addAll(list2);

        assertThat(list1).isEqualTo(List.of("one", "two", "three", "five", "six"));
    }
}
