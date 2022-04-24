package com.giobyte8.psalgo.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    void quickSort() {
        int[] input = new int[]{ 1, 9, 8, 7, 6 };

        Sorting.quickSort(input);
        assertEquals(1, input[0]);
        assertEquals(6, input[1]);
        assertEquals(7, input[2]);
        assertEquals(8, input[3]);
        assertEquals(9, input[4]);
    }

    @Test
    void quickSort2() {
        int[] input = new int[]{ 10, 9, 8, 7, 6 };

        Sorting.quickSort(input);
        assertEquals(6, input[0]);
        assertEquals(7, input[1]);
        assertEquals(8, input[2]);
        assertEquals(9, input[3]);
        assertEquals(10, input[4]);
    }
}