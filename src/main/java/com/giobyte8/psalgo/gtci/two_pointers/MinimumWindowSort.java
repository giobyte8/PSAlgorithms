package com.giobyte8.psalgo.gtci.two_pointers;

/**
 * Given an array, find the length of the smallest subarray in it which when
 * sorted will sort the whole array.
 *
 * Example 1
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 *
 * Example 2
 * Input: [1, 3, 2, 0, -1, 7, 10]
 * Output: 5
 * Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 *
 * Example 3
 * Input: [1, 2, 3]
 * Output: 0
 * Explanation: The array is already sorted
 *
 * Example 4
 * Input: [3, 2, 1]
 * Output: 3
 * Explanation: The whole array needs to be sorted.
 *
 * [1, 3, 2]
 * [1, 3, 2, 5]
 * [1, 3, 2, 5, 6]
 */
public class MinimumWindowSort {

    public static int sort(int[] arr) {
        if (arr.length <= 1) return 0;
        if (arr.length == 2) return (arr[0] > arr[1]) ? 2 : 0;

        int unsortStart = -1;
        int unsortEnd = -1;
        int unsortSmallest = Integer.MAX_VALUE;
        int unsortGreatest = Integer.MIN_VALUE;


        // Look first index where order breaks
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                unsortStart = i;
                break;
            }
        }

        // If order never broke
        if (unsortStart == -1) return 0;

        // Look for last point where order breaks
        for (int i = arr.length - 2; i >= unsortStart; i--) {
            if (arr[i] > arr[i + 1]) {
                unsortEnd = i;
                break;
            }
        }

        // Order breaks just one time
        if (unsortEnd == -1) unsortEnd = unsortStart;

        // Find min and max values from unsorted window
        for (int i = unsortStart; i <= unsortEnd; i++) {
            unsortSmallest = Math.min(unsortSmallest, arr[i]);
            unsortGreatest = Math.max(unsortGreatest, arr[i]);
        }

        // Find min and max affected indexes after sorting

        int left = unsortStart;
        while (left > 0 && arr[left - 1] > unsortSmallest) {
            left--;
        }

        int right = unsortEnd;
        while (right < arr.length - 1 && arr[right + 1] < unsortGreatest)
            right++;

        return right - left + 1;
    }
}
