package com.giobyte8.psalgo.gtci.sliding_window;

import com.giobyte8.psalgo.gtci.sliding_window.LongestSubarray1sReplacement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubarray1sReplacementTest {

    @Test
    void findLength1() {
        int[] input = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int allowed0sReplacements = 2;

        assertEquals(
                6,
                LongestSubarray1sReplacement
                        .findLength(input, allowed0sReplacements)
        );
    }

    @Test
    void findLength2() {
        int[] input = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int allowed0sReplacements = 3;

        assertEquals(
                9,
                LongestSubarray1sReplacement
                        .findLength(input, allowed0sReplacements)
        );
    }
}