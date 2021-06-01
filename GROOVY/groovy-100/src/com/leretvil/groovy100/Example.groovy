package com.leretvil.groovy100

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class Example {
    static void sum(int a, int b) {
        int c = a + b;
        println(c);
    }

    static void main(String[] args) {
        sum(10, 12);
        String input = "{\"name\": \"Eternal Flame\",\"age\": 1000000,\"secretIdentity\": \"Unknown\"}"
        def json = new JsonSlurper().parseText(input);

    }

}
