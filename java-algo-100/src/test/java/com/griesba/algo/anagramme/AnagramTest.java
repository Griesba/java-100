package com.griesba.algo.anagramme;

import com.griesba.algo.anagramme.kata.Kata;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AnagramTest {

    @Test
    void shouldTestTwoWordAnagram() {
        Kata kata = new Kata();
        String[] arrayStr = {"iotcn", "mengdu"};
        kata.checkDictionaryAnagram(Arrays.asList(arrayStr));
    }
}