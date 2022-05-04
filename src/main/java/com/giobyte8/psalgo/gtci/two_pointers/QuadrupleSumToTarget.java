package com.giobyte8.psalgo.gtci.two_pointers;

import com.giobyte8.psalgo.algorithms.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers and a target number, find all unique
 * quadruplets in it, whose sum is equal to the target number.
 *
 * Example 1
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 *
 * Example 2
 * Input: [2, 0, -1, 1, -2, 2], target=2
 * Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 */
public class QuadrupleSumToTarget {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);

        for (int start = 0; start < arr.length - 3; start++) {

            // Avoid duplicated quadruplets
            if (start > 0 && arr[start] == arr[start - 1])
                continue;

            for (int end = arr.length - 1; end >= start + 3; end--) {

                // Avoid duplicated quadruplets
                if (end < arr.length - 1 && arr[end] == arr[end + 1])
                    continue;

                int endsSum = arr[start] + arr[end];
                int targetPairSum = target - endsSum;

                int left = start + 1;
                int right = end - 1;
                while (left < right) {

                    // Avoid duplicated quadruplets
                    if (left > start + 1 && arr[left] == arr[left - 1]) {
                        left++;
                        continue;
                    }

                    // Avoid duplicated quadruplets
                    if (right < end - 1 && arr[right] == arr[right + 1]) {
                        right--;
                        continue;
                    }


                    int sum = arr[left] + arr[right];

                    // Found a quadruplet
                    if (sum == targetPairSum) {
                        quadruplets.add(Arrays.asList(
                                arr[start],
                                arr[left],
                                arr[right],
                                arr[end]
                        ));

                        left++;
                        right--;
                    }

                    else if (sum > targetPairSum) {
                        right--;
                    }

                    else left++;
                }
            }
        }

        return quadruplets;
    }
}
