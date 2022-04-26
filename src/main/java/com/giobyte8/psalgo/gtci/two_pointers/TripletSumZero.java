package com.giobyte8.psalgo.gtci.two_pointers;

import com.giobyte8.psalgo.algorithms.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it
 * that add up to zero.
 *
 * Example 1
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 *
 * Example 2
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 */
public class TripletSumZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int targetSum = arr[i] * -1;
            findAddends(arr, targetSum, i + 1, triplets);
        }

        return triplets;
    }

    public static void findAddends(
            int[] arr,
            int targetSum,
            int start,
            List<List<Integer>> triplets
    ) {
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] == arr[start - 1]) {
                start++;
                continue;
            }

            int sum = arr[start] + arr[end];
            if (sum == targetSum) {
                triplets.add(Arrays.asList(-targetSum, arr[start], arr[end]));
                start++;
                end--;
            }

            if (sum > targetSum) {
                end--;
            }

            if (sum < targetSum) {
                start++;
            }
        }
    }
}
