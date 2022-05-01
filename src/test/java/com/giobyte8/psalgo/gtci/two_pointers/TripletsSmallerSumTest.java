package com.giobyte8.psalgo.gtci.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripletsSmallerSumTest {

    @Test
    void searchTriplets() {
        int[] input = new int[]{-1, 0, 2, 3};
        int targetSum = 3;

        assertEquals(2, TripletsSmallerSum.searchTriplets(input, targetSum));
    }

    @Test
    void searchTriplets2() {
        int[] input = new int[]{-1, 4, 2, 1, 3};
        int targetSum = 5;

        assertEquals(4, TripletsSmallerSum.searchTriplets(input, targetSum));
    }
}