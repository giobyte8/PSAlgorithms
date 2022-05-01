package com.giobyte8.psalgo.gtci.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SubarraysProductLessThanKTest {

    @Test
    void findSubarrays1() {
        int[] input = new int[]{2, 5, 3, 10, 30};
        int target = 30;

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(2));
        expected.add(List.of(5));
        expected.add(List.of(2, 5));
        expected.add(List.of(3));
        expected.add(List.of(5, 3));
        expected.add(List.of(10));

        List<List<Integer>> subarrays = SubarraysProductLessThanK
                .findSubarrays(input, target);

        assertEquals(expected.size(), subarrays.size());
        expected.forEach(expectedArray -> assertTrue(subarrays
                .stream()
                .anyMatch(subarray -> subarray.equals(expectedArray))
        ));
    }

    @Test
    void findSubarrays2() {
        int[] input = new int[]{8, 2, 6, 5};
        int target = 50;

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(8));
        expected.add(List.of(2));
        expected.add(List.of(8, 2));
        expected.add(List.of(6));
        expected.add(List.of(2, 6));
        expected.add(List.of(5));
        expected.add(List.of(6, 5));

        List<List<Integer>> subarrays = SubarraysProductLessThanK
                .findSubarrays(input, target);

        assertEquals(expected.size(), subarrays.size());
        expected.forEach(expectedArray -> assertTrue(subarrays
                .stream()
                .anyMatch(subarray -> subarray.equals(expectedArray))
        ));
    }
}