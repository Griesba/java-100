package com.griesba.algo.anagramme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static boolean areAnagrams(String s1, String s2) {
        Character[] s1ACharArr = s1.toLowerCase().chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Character[] s2ACharArr = s2.toLowerCase().chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        //char[] s2ACharArr = s2.toLowerCase().toCharArray();

        //Arrays.sort(s1ACharArr);
        //Arrays.sort(s2ACharArr);

        QuickSort<Character> myQuickSort = new QuickSort<>();

        myQuickSort.sort(s1ACharArr, 0, s1ACharArr.length - 1);
        myQuickSort.sort(s2ACharArr, 0, s2ACharArr.length - 1);

        String s1Result = Arrays.stream(s1ACharArr).map(String::valueOf).collect(Collectors.joining());
        String s2Result = Arrays.stream(s2ACharArr).map(String::valueOf).collect(Collectors.joining());

        return s1Result.equals(s2Result);
    }

    public static void main(String[] args) {
        String[] dico = {"orca", "notte", "treno", "arco", "albero", "roca", "tonte", "albore"};
        List<Word> words = new ArrayList<>();
        for (String str : dico) {
            Word word = new Word(str);
            for (String str2 : dico) {
                if (!str.equals(str2) && areAnagrams(str, str2)) {
                    word.addAnagram(str2);
                }
            }
            words.add(word);
        }

        for (Word word : words) {
            System.out.println(word.toString());
        }
    }
}
