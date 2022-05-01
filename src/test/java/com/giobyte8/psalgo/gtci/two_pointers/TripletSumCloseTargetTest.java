package com.giobyte8.psalgo.gtci.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripletSumCloseTargetTest {

    @Test
    void searchTriplet1() {
        int[] input = new int[]{-2, 0, 1, 2};
        int targetSum = 2;

        int output = TripletSumCloseTarget.searchTriplet(input, targetSum);
        assertEquals(1, output);
    }

    @Test
    void searchTriplet2() {
        int[] input = new int[]{-3, -1, 1, 2};
        int targetSum = 1;

        int output = TripletSumCloseTarget.searchTriplet(input, targetSum);
        assertEquals(0, output);
    }

    @Test
    void searchTriplet3() {
        int[] input = new int[]{1, 0, 1, 1};
        int targetSum = 100;

        int output = TripletSumCloseTarget.searchTriplet(input, targetSum);
        assertEquals(3, output);
    }
}