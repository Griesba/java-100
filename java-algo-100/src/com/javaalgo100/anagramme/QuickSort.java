package com.javaalgo100.anagramme;

public class QuickSort {

    public void sort(char [] A, int lo, int hi) {
        if (lo < hi) {
            int p = partition(A, lo, hi);
            sort(A, lo, p - 1);
            sort(A, p + 1, hi);
        }
    }

    private int partition(char [] A, int lo, int hi) {
        char pivot = A[hi];
        int i = lo;
        for (int j = i; j < hi; j++) {
            if (A[j] < pivot) {
                swapArray(A, i, j);
                i++;
            }
        }
        swapArray(A, i, hi);
        return i;
    }

    private void swapArray(char [] A, int lo, int hi) {
        char temp = A[lo];
        A[lo] = A[hi];
        A[hi] = temp;
    }
}
