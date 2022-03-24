package com.giobyte8.psalgo.lc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInStringTest {

    PermutationInString permutationChecker = new PermutationInString();

    @Test
    void containsPermutation1() {
        String s1 = "ab";
        String s2 = "eidbaooo";

        assertTrue(permutationChecker.containsPermutation(s1, s2));
    }

    @Test
    void containsPermutation2() {
        String s1 = "ab";
        String s2 = "eidboa0oo";

        assertFalse(permutationChecker.containsPermutation(s1, s2));
    }
}