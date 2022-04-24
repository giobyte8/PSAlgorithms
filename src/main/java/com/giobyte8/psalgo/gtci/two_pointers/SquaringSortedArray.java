package com.giobyte8.psalgo.gtci.two_pointers;

/**
 * Given a sorted array, create a new sorted array containing squares of all
 * the numbers of the input array in the sorted order.
 *
 * Example 1:
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 *
 * Example 2:
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 */
public class SquaringSortedArray {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int squaresIdx = squares.length - 1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int lSquare = (int) Math.pow(arr[left], 2);
            int rSquare = (int) Math.pow(arr[right], 2);

            if (rSquare >= lSquare) {
                squares[squaresIdx] = rSquare;
                squaresIdx--;
                right--;
            } else {
                squares[squaresIdx] = lSquare;
                squaresIdx--;
                left++;
            }
        }

        return squares;
    }
}
