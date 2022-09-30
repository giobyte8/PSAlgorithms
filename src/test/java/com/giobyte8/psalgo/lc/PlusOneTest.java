package com.giobyte8.psalgo.lc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

    @Test
    void plusOne() {
        int[] digits = new int[]{1, 2, 3};
        int[] plusOne = new PlusOne().plusOne(digits);

        assertEquals(1, plusOne[0]);
        assertEquals(2, plusOne[1]);
        assertEquals(4, plusOne[2]);
    }

    @Test
    void plusOne1() {
        int[] digits = new int[]{4, 3, 2, 1};
        int[] plusOne = new PlusOne().plusOne(digits);

        assertEquals(4, plusOne[0]);
        assertEquals(3, plusOne[1]);
        assertEquals(2, plusOne[2]);
        assertEquals(2, plusOne[3]);
    }

    @Test
    void plusOne3() {
        int[] digits = new int[]{9};
        int[] plusOne = new PlusOne().plusOne(digits);

        assertEquals(1, plusOne[0]);
        assertEquals(0, plusOne[1]);
    }

    @Test
    void plusOne4() {
        int[] digits = new int[]{9, 9, 9, 8};
        int[] plusOne = new PlusOne().plusOne(digits);

        assertEquals(9, plusOne[0]);
        assertEquals(9, plusOne[1]);
        assertEquals(9, plusOne[2]);
        assertEquals(9, plusOne[3]);
    }

    @Test
    void plusOne5() {
        int[] digits = new int[]{9, 9, 9, 9};
        int[] plusOne = new PlusOne().plusOne(digits);

        assertEquals(1, plusOne[0]);
        assertEquals(0, plusOne[1]);
        assertEquals(0, plusOne[2]);
        assertEquals(0, plusOne[3]);
        assertEquals(0, plusOne[4]);
    }
}