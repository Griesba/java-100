package com.griesba.java100;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/*
Given an array, print the Next Greater Element (NGE) for every element.
The Next greater Element for an element x is the first greater element on the right side of x in the array.
Elements for which no greater element exist, consider the next greater element as -1.
 */
public class NextGreaterElement {

    public int getNextGreaterElement(int[] elements, int x) {

        Predicate<Integer> testEquals = i -> i == x;

        if (Arrays.stream(elements).boxed().anyMatch(testEquals)) {
            int index = List.of(elements).indexOf(x) + 1;

            for (int i = index; i < elements.length; i++) {
                if (elements[i] > x) {
                    return elements[i];
                }
            }
            return -1;
        }
        throw new NoSuchElementException(x + " not found in input array");
    }

}
