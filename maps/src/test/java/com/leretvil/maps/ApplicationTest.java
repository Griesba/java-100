package com.leretvil.maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class ApplicationTest {

    private Map<String, String> employees;


    @BeforeEach
    void setUp() {
        employees = new HashMap<>();
    }

    @Test
    void shouldAddItemToMap() {
        //given
        employees.put("Ashley", "director");

        assertThat(employees).hasSize(1);
    }

    @Test
    void shouldReplaceExistingValue() {
        //given
        employees.put("Ashley", "director");
        employees.put("Ashley", "CEO");

        assertThat(employees).hasSize(1);
        assertThat(employees).containsExactly(entry("Ashley", "CEO"));
        assertThat(employees.values()).hasSize(1);
    }
}