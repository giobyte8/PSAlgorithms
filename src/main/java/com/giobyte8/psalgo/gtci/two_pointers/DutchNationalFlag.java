package com.giobyte8.psalgo.gtci.two_pointers;

/**
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should
 * treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s
 * to recreate the array.
 *
 * The flag of the Netherlands consists of three colors: red, white and blue;
 * and since our input array also consists of three different numbers that is
 * why it is called Dutch National Flag problem.
 *
 * Example 1
 * Input: [1, 0, 2, 1, 0]
 * Output: [0, 0, 1, 1, 2]
 *
 * Example 2
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0, 0, 1, 2, 2, 2]
 */
public class DutchNationalFlag {

    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int i = 0;
        while (i <= right) {
            if (arr[i] == 0 && i > left) {
                swap(arr, left, i);
                left++;
            }

            else if (arr[i] == 2 && i < right) {
                swap(arr, right, i);
                right--;
            }

            else i++;
        }
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int aux = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = aux;
    }
}
