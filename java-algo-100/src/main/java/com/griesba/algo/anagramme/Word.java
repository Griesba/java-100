package com.griesba.algo.anagramme;

import java.util.ArrayList;
import java.util.List;

public class Word {

    private String word;
    private List<String> anagrams;

    public Word() {
    }

    public Word(String word) {
        this.anagrams = new ArrayList<>();
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getAnagrams() {
        return anagrams;
    }

    public void addAnagram(String anagram) {
        this.anagrams.add(anagram);
    }

    public void setAnagrams(List<String> anagrams) {
        this.anagrams = anagrams;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        if (anagrams.isEmpty()) {
            return word + ": []";
        }

        stringBuilder.append(anagrams.get(0));

        if (anagrams.size() > 1) {
            for (int i = 1; i < anagrams.size() - 1; i++) {
                stringBuilder.append(", ");
                stringBuilder.append(anagrams.get(i));
            }
            stringBuilder.append(", ");
            stringBuilder.append(anagrams.get(anagrams.size() - 1));
        }


        return word + "[" + stringBuilder + "]";
    }
}
