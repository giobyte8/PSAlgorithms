package com.giobyte8.psalgo.gtci.fast_slow_pointers;

/**
 * Any number will be called a happy number if, after repeatedly replacing
 * it with a number equal to the sum of the square of all of its digits, leads
 * us to number ‘1’. All other (not-happy) numbers will never reach ‘1’.
 * Instead, they will be stuck in a cycle of numbers which does not include
 * ‘1’.
 *
 * Example 1:
 * Input: 23
 * Output: true (23 is a happy number)
 * Explanations: Here are the steps to find out that 23 is a happy number:
 *   - 2^2 + 3^2 = 4 + 9 = 13
 *   - 1^2 + 3^2 = 10
 *   - 1^2 + 0^2 = 1
 *
 * Example 2:
 * Input: 12
 * Output: false (12 is not a happy number)
 * Explanations: Here are the steps to find out that 12 is not a happy number:
 *   - It cycles on 89 number
 */
public class HappyNumber {

    public static boolean find(int num) {
        int slowPointerValue = num;
        int fastPointerValue = num;

        // Happy number or not, eventually there will be a cycle
        do {

            // Advance slow pointer one position
            slowPointerValue = squaredDigitsSum(slowPointerValue);

            // Advance fast pointer two positions
            fastPointerValue = squaredDigitsSum(squaredDigitsSum(fastPointerValue));
        } while (slowPointerValue != fastPointerValue);

        return slowPointerValue == 1;
    }

    private static int squaredDigitsSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += Math.pow(num % 10, 2);
            num = Math.floorDiv(num, 10);
        }

        return sum;
    }
}
