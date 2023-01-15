package com.griesba.algo.anagramme.kata;

import com.griesba.algo.anagramme.Anagram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kata {

    
    public List<String> loadDictionary() {
        List<String> dictionary = new ArrayList<>();
        String location = "src/main/resources/anagram-dico.txt";
        try {
            File file = new File(location);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
               dictionary.add(scanner.next());
            }
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dictionary;
    }
    public void checkDictionaryAnagram(List<String> dictionary) {
        
        String refPattern = Anagram.sortString("documenting");

        System.out.print("Anagram : ");
        for (int i = 0; i < dictionary.size(); i++) {
            for (int j = i+1; j < dictionary.size(); j++) {
                if (refPattern.equals(Anagram.sortString(dictionary.get(i).trim() + dictionary.get(j).trim()))) {
                    System.out.println("Two-Word : " + dictionary.get(i) + "- " + dictionary.get(j));
                }
            }
        }
    }
}
