package com.griesba.java100;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> codes = Arrays.asList("EI", "CE");

        List<String> wrappers = Arrays.asList("EI", "CE", "Note", "LI", "EE");

        Set<String> resutl = wrappers.stream().filter( code -> !codes.contains(code)).collect(Collectors.toSet());


    }
}
