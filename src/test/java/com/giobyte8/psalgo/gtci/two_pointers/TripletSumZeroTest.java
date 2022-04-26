package com.giobyte8.psalgo.gtci.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class TripletSumZeroTest {

    @Test
    void searchTriplets1() {
        int[] input = new int[]{-3, 0, 1, 2, -1, 1, -2};
        int expectedTripletsCount = 4;

        List<List<Integer>> triplets = TripletSumZero.searchTriplets(input);
        assertEquals(expectedTripletsCount, triplets.size());

        triplets.forEach(triplet -> {
            Optional<Integer> optSum = triplet.stream().reduce(Integer::sum);

            assertTrue(optSum.isPresent());
            assertEquals(0, optSum.get());
        });
    }

    @Test
    void searchTriplets2() {
        int[] input = new int[]{-5, 2, -1, -2, 3};
        int expectedTripletsCount = 2;

        List<List<Integer>> triplets = TripletSumZero.searchTriplets(input);
        assertEquals(expectedTripletsCount, triplets.size());

        triplets.forEach(triplet -> {
            Optional<Integer> optSum = triplet.stream().reduce(Integer::sum);

            assertTrue(optSum.isPresent());
            assertEquals(0, optSum.get());
        });
    }
}