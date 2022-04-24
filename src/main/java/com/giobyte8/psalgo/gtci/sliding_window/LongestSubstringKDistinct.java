package com.giobyte8.psalgo.gtci.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no
 * more than K distinct characters.
 *
 * Example 1:
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters
 * is "araa".
 *
 * Example 2:
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters
 * is "aa".
 *
 * Example 3:
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters
 * are "cbbeb" & "bbebi".
 *
 * Example 4:
 * Input: String="cbbebi", K=10
 * Output: 6
 * Explanation: The longest substring with no more than '10' distinct characters
 * is "cbbebi".
 */
public class LongestSubstringKDistinct {
    private static Map<Character, Integer> charOccurrences;

    public static int findLongestSubstring(String str, int k) {
        charOccurrences = new HashMap<>();
        int longestLength = 0;

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char windowEndChar = str.charAt(windowEnd);
            addOccurrence(windowEndChar);

            while (charOccurrences.size() > k) {
                removeOccurrence(str.charAt(windowStart));
                windowStart++;
            }

            longestLength = Math.max(
                    longestLength,
                    windowEnd - windowStart + 1
            );
        }

        return longestLength;
    }

    private static void addOccurrence(char c) {
        charOccurrences.put(
                c,
                charOccurrences.getOrDefault(c, 0) + 1
        );
    }

    private static void removeOccurrence(char c) {
        if (!charOccurrences.containsKey(c)) {
            return;
        }

        if (charOccurrences.get(c) > 1) {
            charOccurrences.put(
                    c,
                    charOccurrences.get(c) - 1
            );
        } else {
            charOccurrences.remove(c);
        }
    }
}
