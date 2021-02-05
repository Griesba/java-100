package com.javaalgo100.anagramme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static boolean areAnagrams(String s1, String s2) {
        char[] s1ACharArr = s1.toLowerCase().toCharArray();
        char[] s2ACharArr = s2.toLowerCase().toCharArray();

        //Arrays.sort(s1ACharArr);
        //Arrays.sort(s2ACharArr);

        QuickSort myQuickSort = new QuickSort();

        myQuickSort.sort(s1ACharArr, 0, s1ACharArr.length - 1);
        myQuickSort.sort(s2ACharArr, 0, s2ACharArr.length - 1);

        String s1Result = String.valueOf(s1ACharArr);
        String s2Result = String.valueOf(s2ACharArr);

        return s1Result.equals(s2Result);
    }

    public static void main(String[] args) {
	    String[] dico = {"orca", "notte", "treno","arco", "albero", "roca", "tonte", "albore"};
        List<Word> words = new ArrayList<>();
        for (String str: dico) {
            Word word = new Word(str);
            for (String str2: dico) {
                if (areAnagrams(str, str2) && !str.equals(str2)) {
                    word.addAnagram(str2);
                }
            }
            words.add(word);
        }

        for (Word word: words) {
            System.out.println(word.toString());
        }
    }
}
