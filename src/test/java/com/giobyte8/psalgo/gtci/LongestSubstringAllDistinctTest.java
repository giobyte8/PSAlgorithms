package com.giobyte8.psalgo.gtci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringAllDistinctTest {

    @Test
    void findLength1() {
        String input = "aabccbb";

        int length = LongestSubstringAllDistinct.findLength(input);
        assertEquals(3, length);
    }

    @Test
    void findLength2() {
        String input = "abbbb";

        int length = LongestSubstringAllDistinct.findLength(input);
        assertEquals(2, length);
    }

    @Test
    void findLength3() {
        String input = "abccde";

        int length = LongestSubstringAllDistinct.findLength(input);
        assertEquals(3, length);
    }
}