package com.giobyte8.psalgo.gtci.two_pointers;

import com.giobyte8.psalgo.algorithms.Sorting;

import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum, count all triplets
 * in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are
 * three different indices. Write a function to return the count of such
 * triplets.
 *
 * Example 1
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 *
 * Example 2
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target: [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
public class TripletsSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;

        // [-1, 1, 2, 3, 4], 5
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            // If all subsequent sums are going to be greater
            if (arr[i] >= target - 2) break;

            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];

                if (sum >= target) {
                    end--;
                } else {

                    // Count all pairs for current start that will add up less
                    // than target
                    count += end - start;
                    start++;
                }
            }
        }

        return count;
    }
}
