package com.leretvil.sort.qsort;

import com.leretvil.sort.Swapper;
import com.leretvil.support.ArraySwapper;
import com.leretvil.support.ArrayWrapper;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionerTest {

    private void assertSmallElements(Integer [] array, int cutIndex, Integer pivot) {
        for (int i=0; i < cutIndex; i++) {
            Assert.assertTrue(array[i] < pivot);
        }
    }

    private void assertLargeElements(Integer [] array, int cutIndex, Integer pivot) {
        for (int i = cutIndex; i < array.length; i++) {
            Assert.assertTrue(array[i] >= pivot);
        }
    }

    @Test
    public void partitionsIntArray() {
        Integer[] partitionThis = new Integer[] {0, 7, 6};
        Swapper swapper = new ArraySwapper<>(partitionThis);
        Partitioner<Integer> partitioner = new Partitioner<>((a, b) -> a < b ? -1 : a > b ? +1 : 0,swapper);
        final Integer pivot = 6;
        final int cutIndex = partitioner.partition(new ArrayWrapper<>(partitionThis), 0, 2, pivot);
        Assert.assertEquals(1, cutIndex);
        assertSmallElements(partitionThis, cutIndex, pivot);
        assertLargeElements(partitionThis, cutIndex, pivot);
    }
}