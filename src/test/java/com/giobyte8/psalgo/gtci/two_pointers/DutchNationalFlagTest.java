package com.giobyte8.psalgo.gtci.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DutchNationalFlagTest {

    @Test
    void sort() {
        int[] input = new int[]{2, 2, 1, 1, 0, 0};
        int[] expected = new int[]{0, 0, 1, 1, 2, 2};

        DutchNationalFlag.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void sort1() {
        int[] input = new int[]{1, 0, 2, 1, 0};
        int[] expected = new int[]{0, 0, 1, 1, 2};

        DutchNationalFlag.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void sort2() {
        int[] input = new int[]{2, 2, 0, 1, 2, 0};
        int[] expected = new int[]{0, 0, 1, 2, 2, 2};

        DutchNationalFlag.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void sort3() {
        int[] input = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
        int[] expected = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2};

        DutchNationalFlag.sort(input);
        assertArrayEquals(expected, input);
    }
}