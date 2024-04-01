package com.griesba.algo;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class Java100RegExTest {

    @Test
    void shouldTestUsageOfScannerWithRegEx () {

        String input = "Hi java user 2 java 4 java you";
        Scanner scanner = new Scanner(input).useDelimiter("\\s*java\\s*");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(scanner.next());
        stringBuilder.append(scanner.next());
        stringBuilder.append(scanner.next());
        stringBuilder.append(scanner.next());

        assertThat(stringBuilder.toString()).isEqualTo("Hiuser24you");
    }
}
