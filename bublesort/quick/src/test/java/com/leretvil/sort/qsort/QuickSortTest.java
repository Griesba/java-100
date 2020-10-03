package com.leretvil.sort.qsort;

import com.leretvil.sort.Sort;
import com.leretvil.support.ArraySwapper;
import com.leretvil.support.ArrayWrapper;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void canSortStrings() {
        final String[] actualNames = new String[]{
                "Johnson", "Wilson",
                "Wilkinson", "Abraham", "Dagobert"
        };
        final String[] expected = new String[]{"Abraham", "Dagobert",
                "Johnson", "Wilkinson", "Wilson"};
        Sort<String> sort = new QuickSort<>();
        sort.setComparator(String::compareTo);
        sort.setSwapper(new ArraySwapper<>(actualNames));
        sort.sort(new ArrayWrapper<>(actualNames));
        Assert.assertArrayEquals(expected, actualNames);
    }
}