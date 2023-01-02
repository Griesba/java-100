package com.griesba.algo.binarysearch;

import com.griesba.algo.anagramme.QuickSort;

import java.util.Arrays;
import java.util.stream.Stream;


public class BinarySearch {
    public int find(int[] inputs, int key) {
        Integer[] integers = Arrays.stream(inputs).boxed().toArray(Integer[]::new);
        new QuickSort<Integer>().sort(integers, 0, inputs.length-1);
        return search(integers, key, 0, integers.length);
    }

    public static int search(Integer[] inputs, int key, int start, int end) {
        if(start > end) {
            return -1;
        }
        if (start == end && inputs[start] == key) return start;
        int middle = (end - start)/2;
        if (inputs[middle] == key) return middle;
        if (key > inputs[middle]) return search(inputs, key, middle + 1, end);
        return search(inputs, key, start, middle - 1);

    }
}
