package com.giobyte8.psalgo.gtci.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSortTest {

    @Test
    void sort1() {
        int[] input = new int[]{1, 2, 5, 3, 7, 10, 9, 12};
        int expectedWindowSize = 5;

        assertEquals(expectedWindowSize, MinimumWindowSort.sort(input));
    }

    @Test
    void sort2() {
        int[] input = new int[]{1, 3, 2, 0, -1, 7, 10};
        int expectedWindowSize = 5;

        assertEquals(expectedWindowSize, MinimumWindowSort.sort(input));
    }

    @Test
    void sort3() {
        int[] input = new int[]{1, 2, 3};
        int expectedWindowSize = 0;

        assertEquals(expectedWindowSize, MinimumWindowSort.sort(input));
    }

    @Test
    void sort4() {
        int[] input = new int[]{3, 2, 1};
        int expectedWindowSize = 3;

        assertEquals(expectedWindowSize, MinimumWindowSort.sort(input));
    }

    @Test
    void sort5() {
        int[] input = new int[]{1, 3, 2};
        int expectedWindowSize = 2;

        assertEquals(expectedWindowSize, MinimumWindowSort.sort(input));
    }

    @Test
    void sort6() {
        int[] input = new int[]{1, 3, 2, 5};
        int expectedWindowSize = 2;

        assertEquals(expectedWindowSize, MinimumWindowSort.sort(input));
    }

    @Test
    void sort7() {
        int[] input = new int[]{1, 3, 2, 5, 6};
        int expectedWindowSize = 2;

        assertEquals(expectedWindowSize, MinimumWindowSort.sort(input));
    }
}