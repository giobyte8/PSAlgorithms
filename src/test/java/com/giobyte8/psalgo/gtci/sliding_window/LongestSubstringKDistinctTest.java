package com.giobyte8.psalgo.gtci.sliding_window;

import org.junit.jupiter.api.Test;

import static com.giobyte8.psalgo.gtci.sliding_window.LongestSubstringKDistinct.findLongestSubstring;
import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringKDistinctTest {

    @Test
    void findLongestSubstring1() {
        String input = "araaci";
        int k = 2;

        assertEquals(4, findLongestSubstring(input, k));
    }

    @Test
    void findLongestSubstring2() {
        String input = "araaci";
        int k = 1;

        assertEquals(2, findLongestSubstring(input, k));
    }

    @Test
    void findLongestSubstring3() {
        String input = "cbbebi";
        int k = 3;

        assertEquals(5, findLongestSubstring(input, k));
    }

    @Test
    void findLongestSubstring4() {
        String input = "cbbebi";
        int k = 10;

        assertEquals(6, findLongestSubstring(input, k));
    }
}