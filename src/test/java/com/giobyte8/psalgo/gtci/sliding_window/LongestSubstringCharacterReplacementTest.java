package com.giobyte8.psalgo.gtci.sliding_window;

import com.giobyte8.psalgo.gtci.sliding_window.LongestSubstringCharacterReplacement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringCharacterReplacementTest {

    @Test
    void findLength1() {
        String input = "AABCCBB";
        int k = 2;

        int length = LongestSubstringCharacterReplacement.findLength(input, k);
        assertEquals(5, length);
    }

    @Test
    void findLength2() {
        String input = "ABBCB";
        int k = 1;

        int length = LongestSubstringCharacterReplacement.findLength(input, k);
        assertEquals(4, length);
    }

    @Test
    void findLength3() {
        String input = "ABCCDE";
        int k = 1;

        int length = LongestSubstringCharacterReplacement.findLength(input, k);
        assertEquals(3, length);
    }

    @Test
    void findLength4() {
        String input = "CCCCBDEFAAB";
        int k = 1;

        int length = LongestSubstringCharacterReplacement.findLength(input, k);
        assertEquals(5, length);
    }
}