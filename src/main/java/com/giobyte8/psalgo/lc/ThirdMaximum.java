package com.giobyte8.psalgo.lc;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * Source: <a href="https://leetcode.com/problems/third-maximum-number/">LeetCode</a><br/>
 *
 * Given an integer array nums, return the third distinct maximum number
 * in this array. If the third maximum does not exist, return the maximum
 * number.
 * <br/>
 *
 * Example 1
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * <br/>
 *
 * Example 2:
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 * <br/>
 *
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 * <br/>
 *
 * Constraints
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 */
public class ThirdMaximum {

    public int thirdMaxRBT(int[] nums) {
        TreeMap<Integer, Object> tMap = new TreeMap<>();
        for (int num : nums) {
            tMap.put(num, null);
        }

        // Return first maximum
        if (tMap.size() < 3) return tMap.lastKey();

        // Skip greatest two maximums and return third
        tMap.pollLastEntry();
        tMap.pollLastEntry();
        return tMap.pollLastEntry().getKey();
    }

    public int thirdMaxLineal(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        Set<Integer> hSet = new HashSet<>(nums.length);
        for (int num : nums) {
            if (hSet.add(num)) {
                if (num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                } else if (num > max3) {
                    max3 = num;
                }
            }
        }

        return hSet.size() >= 3 ? max3 : max1;
    }
}
