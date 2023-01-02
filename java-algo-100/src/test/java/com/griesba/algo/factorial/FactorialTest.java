package com.griesba.algo.factorial;


import com.griesba.algo.factoriel.Factorial;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FactorialTest {

    @Test
    void shouldBe1IfFactorialOf0() {
        int result = Factorial.of(0);
        assertThat(result, equalTo(1));
    }

    @Test
    void shouldBe1IfFactorialOf1() {
       int result = Factorial.of(1);
       assertThat(result, equalTo(1));
    }

    @Test
    void shouldBe120IfFactorialOf5() {
        int result = Factorial.of(5);
        assertThat(result, equalTo(120));
    }
}