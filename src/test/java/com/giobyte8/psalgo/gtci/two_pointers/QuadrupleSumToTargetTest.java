package com.giobyte8.psalgo.gtci.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuadrupleSumToTargetTest {

    @Test
    void searchQuadruplets1() {
        int[] input = new int[]{4, 1, 2, -1, 1, -3};
        int target = 1;

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(-3, -1, 1, 4));
        expected.add(List.of(-3, 1, 1, 2));

        List<List<Integer>> quadruplets = QuadrupleSumToTarget
                .searchQuadruplets(input, target);

        assertEquals(expected.size(), quadruplets.size());
        expected.forEach(expectedQuadruplet -> assertTrue(quadruplets
                .stream()
                .anyMatch(quadruplet -> quadruplet.equals(expectedQuadruplet))
        ));
    }

    @Test
    void searchQuadruplets2() {
        int[] input = new int[]{2, 0, -1, 1, -2, 2};
        int target = 2;

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(-2, 0, 2, 2));
        expected.add(List.of(-1, 0, 1, 2));

        List<List<Integer>> quadruplets = QuadrupleSumToTarget
                .searchQuadruplets(input, target);

        assertEquals(expected.size(), quadruplets.size());
        expected.forEach(expectedQuadruplet -> assertTrue(quadruplets
                .stream()
                .anyMatch(quadruplet -> quadruplet.equals(expectedQuadruplet))
        ));
    }
}