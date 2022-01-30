package com.griesba.java100.bst;

import java.util.NoSuchElementException;
import java.util.Stack;


/*
Given an expression string exp,
write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
 */
public class CharSequenceBalanceValidator {

    public boolean isValidSequence(String seq) {
        Stack<Character> stack = new Stack<>();

        if (seq.length() % 2 != 0 ) return false;
        for (Character ch : seq.toCharArray()) {
            switch (ch) {
                case '{' :
                case '[' :
                case '(' : stack.push(ch); break;
                default:
                    if (stack.peek() != getPartner(ch) ) {
                        return false;
                    }
                    stack.pop();
            }
        }
        return stack.empty();
    }

    private static char getPartner(Character ch) {
        switch (ch) {
            case '}' : return '{';
            case ']' : return '[';
            case ')' : return '(';
            default: throw new NoSuchElementException(ch + "is not managed");
        }
    }
}
