package com.giobyte8.psalgo.hackerr;


import java.util.*;
import java.util.stream.Stream;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        List<Character> openingB = Arrays.asList('(', '[', '{');
        List<Character> closingB = Arrays.asList(')', ']', '}');

        Deque<Character> brackets = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (openingB.contains(c)) {
                brackets.push(c);
            }

            else if (closingB.contains(c)) {
                if (brackets.isEmpty()) return "NO";

                int openingIdx = closingB.indexOf(c);
                char openingSide = brackets.isEmpty() ? ' ' : brackets.poll();

                // Does pair matches?
                if (openingSide != openingB.get(openingIdx)) {
                    return "NO";
                }
            }
        }

        return brackets.isEmpty() ? "YES" : "NO";
    }
}
