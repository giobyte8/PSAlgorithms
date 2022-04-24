package com.giobyte8.psalgo.gtci.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace
 * no more than k letters with any letter, find the length of the longest
 * substring having the same letters after replacement.
 *
 *
 * Example 1:
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have the longest repeating
 * substring "bbbbb
 *
 * Example 2:
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have the longest repeating
 * substring "bbbb".
 *
 * Example 3:
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating
 * substring "ccc".
 */
public class LongestSubstringCharacterReplacement {

    public static int findLength(String str, int k) {
        Map<Character, Integer> charsFrequency = new HashMap<>();
        int longestSubstring = 0;

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            addOccurrence(charsFrequency, str.charAt(windowEnd));

            while(!canReplaceDistinctChars(charsFrequency, k)) {
                removeOccurrence(charsFrequency, str.charAt(windowStart));
                windowStart++;
            }

            longestSubstring = Math.max(
                    longestSubstring,
                    windowEnd - windowStart + 1
            );
        }

        return longestSubstring;
    }

    /**
     * 1. Look for the entry with greater frequency
     * 2. Sum the frequencies of all other characters
     * 3. Check if sum of frequencies minus greatest freq is less than or
     *    equal to 'allowedReplacements'
     *
     * @param charFreq Character frequencies
     * @param allowedReplacements Number of max allowed replacements
     * @return Whether frequency of characters different from most frequent
     *  char is less than or equal to allowedReplacements
     */
    private static boolean canReplaceDistinctChars(Map<Character, Integer> charFreq,
                                                   int allowedReplacements) {
        int greatestFreq = charFreq.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseGet(() -> Map.entry('x', 0))
                .getValue();

        int frequenciesSum = charFreq.values()
                .stream()
                .mapToInt(freq -> freq)
                .sum();

        return frequenciesSum - greatestFreq <= allowedReplacements;
    }

    private static void addOccurrence(Map<Character, Integer> charFreq,
                                      char c) {
        charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
    }

    private static void removeOccurrence(Map<Character, Integer> charFreq,
                                         char c) {
        if (charFreq.get(c) > 1) {
            charFreq.put(c, charFreq.get(c) - 1);
        } else {
            charFreq.remove(c);
        }
    }
}
