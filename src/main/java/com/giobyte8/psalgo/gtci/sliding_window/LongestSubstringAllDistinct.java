package com.giobyte8.psalgo.gtci.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring,
 * which has all distinct characters.
 *
 * Example 1:
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring with distinct characters is "abc".
 *
 * Example 2:
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring with distinct characters is "ab".
 *
 * Example 3:
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings with distinct characters are "abc" & "cde".
 */
public class LongestSubstringAllDistinct {

    public static int findLength(String str) {
        Set<Character> substrChars = new HashSet<>();
        int maxLength = 0;

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char currChar = str.charAt(windowEnd);

            if (substrChars.contains(currChar)) {
                maxLength = Math.max(maxLength, substrChars.size());

                while (currChar != str.charAt(windowStart)) {
                    substrChars.remove(str.charAt(windowStart));
                    windowStart++;
                }

                windowStart++;
            } else {
                substrChars.add(currChar);
                maxLength = Math.max(maxLength, substrChars.size());
            }
        }

        return maxLength;
    }
}
