package com.javaalgo100.anagramme;

import java.util.ArrayList;
import java.util.List;

public class Word {

    private String word;
    private List<String> anagrams ;

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

        for (int i = 0; i < anagrams.size(); i++) {
            stringBuilder.append(anagrams.get(i));
            stringBuilder.append(" ");
        }

        return word + " " +  stringBuilder.toString();
    }
}
