package com.giobyte8.psalgo.gtci.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMaxInEachWindowTest {

    @Test
    void findMaxSlidingWindow1() {
        int[] maxValues = FindMaxInEachWindow.findMaxSlidingWindow(
                new int[]{-4, 5, 4, -4, 4, 6, 7, 20},
                2
        );

        assertArrayEquals(
                new int[]{5, 5, 4, 4, 6, 7, 20},
                maxValues
        );
    }

    @Test
    void findMaxSlidingWindow2() {
        int[] maxValues = FindMaxInEachWindow.findMaxSlidingWindow(
                new int[]{-4, 5, 4, -4, 4 , 6, 7},
                10
        );

        assertArrayEquals(
                new int[]{7},
                maxValues
        );
    }

    @Test
    void findMaxSlidingWindow3() {
        int[] maxValues = FindMaxInEachWindow.findMaxSlidingWindow(
                new int[]{3, 3, 3, 3, 3, 3},
                3
        );

        assertArrayEquals(
                new int[]{3, 3, 3, 3},
                maxValues
        );
    }

    @Test
    void findMaxSlidingWindow4() {
        int[] maxValues = FindMaxInEachWindow.findMaxSlidingWindow(
                new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6},
                3
        );

        assertArrayEquals(
                new int[]{3, 3, 4, 5, 5, 5, 6},
                maxValues
        );
    }
}