package com.griesba.java100;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testModulo () {
        CharSequenceBalanceValidator validator = new CharSequenceBalanceValidator();
        assertTrue(validator.isValidSequence("{}[]{([])}"));
        assertFalse(validator.isValidSequence("{[}[]"));
    }

    @Test
    public void testNextGreaterElement () {
        NextGreaterElement nge = new NextGreaterElement();
        assertEquals(nge.getNextGreaterElement(new int[]{3,1,3,4,5}, 3), 4);
        assertEquals(nge.getNextGreaterElement(new int[]{3,6,3,4,5}, 3), 6);
        assertEquals(nge.getNextGreaterElement(new int[]{3,6,3,4,5}, 6), -1);
    }

    @Test
    public void testFibonacci() {
        Fibonacci fibonacci = new Fibonacci();

        Assert.assertEquals(fibonacci.get(2), 1);
        Assert.assertEquals(fibonacci.get(10), 55);
    }
}