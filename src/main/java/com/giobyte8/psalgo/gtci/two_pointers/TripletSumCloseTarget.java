package com.giobyte8.psalgo.gtci.two_pointers;

import com.giobyte8.psalgo.algorithms.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in
 * the array whose sum is as close to the target number as possible, return the
 * sum of the triplet. If there are more than one such triplet, return the sum
 * of the triplet with the smallest sum.
 *
 * Example 1:
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 *
 * Example 2:
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 *
 * Example 3:
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 */
public class TripletSumCloseTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        Sorting.quickSort(arr);

        int closestDistance = Integer.MAX_VALUE;
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            // Look two addends that sum up closest to target
            int end = arr.length - 1;
            int start = i + 1;
            while (start < end) {
                if (start > i + 1 && arr[start] == arr[start - 1]) {
                    start++;
                    continue;
                }

                int sum = arr[i] + arr[start] + arr[end];
                int distance = Math.abs(targetSum - sum);

                if (distance > 0) {

                    // Found more than one triplet with same distance to target
                    if (distance == closestDistance) {
                        triplets.add(Arrays.asList(arr[i], arr[start], arr[end]));
                    }

                    // Found new closest triplet
                    else if (distance < closestDistance) {
                        closestDistance = distance;
                        triplets.clear();
                        triplets.add(Arrays.asList(arr[i], arr[start], arr[end]));
                    }
                }

                // We need a smaller sum
                if (sum > targetSum) {
                    end--;
                }

                // We need a greater sum
                else {
                    start++;
                }
            }
        }

        return triplets
                .stream()
                .mapToInt(triplet -> triplet.stream()
                        .reduce(Integer::sum)
                        .orElse(0)
                )
                .min()
                .orElse(0);
    }

}
