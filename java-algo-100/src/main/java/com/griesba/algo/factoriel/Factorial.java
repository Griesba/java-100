package com.griesba.algo.factoriel;

public class Factorial {

    public static int of(int input) {
        if (input <= 1) return 1;
        return of(input-1) * input;
    }
}
