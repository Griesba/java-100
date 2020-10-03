package com.leretvil.bublesort.stringsort;

import com.leretvil.sort.bubble.BubbleSort;
import com.leretvil.sort.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void should_sort_string_array() {
        final List actual = new ArrayList<>(Arrays.asList("un", "deux", "trois"));

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.setComparator(new StringComparator());
        bubbleSort.setSwapper(new ArrayListSwapper(actual));
        bubbleSort.sort(new ArrayListSortableCollection(actual));
        assertArrayEquals(actual.toArray(), new String[]{"deux", "trois", "un"});

    }

    @Test
    public void canSortString() {
        ArrayList<String> actualNames = new ArrayList< >(Arrays.asList(
                "Johnson", "Wilson",
                "Wilkinson", "Abraham", "Dagobert"
        ));
        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList(
                "Abraham", "Dagobert",
                "Johnson", "Wilkinson", "Wilson"
        ));
        SortableCollection<String> sortableCollection = new ArrayListSortableCollection(actualNames);
        Sort<String> sort = new BubbleSort<>();
        sort.setSwapper(new ArrayListSwapper(actualNames));
        sort.setComparator(String::compareTo);
        sort.sort(sortableCollection);
        Assert.assertEquals(actualNames, expectedResult);
    }
}