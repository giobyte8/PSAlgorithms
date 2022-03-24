package com.giobyte8.psalgo.lc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Taken from: https://leetcode.com/problems/permutation-in-string/
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of
 * s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring
 * of s2.
 *
 * Example 1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 */
public class PermutationInString {

    public boolean containsPermutation(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        Map<Character, Integer> s1CharOccurrences = charOccurrences(s1);

        int windowStart = 0;
        for (int windowEnd = s1.length(); windowEnd <= s2.length(); windowEnd++) {
            String s2Fragment = s2.substring(windowStart, windowEnd);

            // Check if substring is a permutation of s1
            if (sameOccurrences(s1CharOccurrences, charOccurrences(s2Fragment))) {
                return true;
            }

            windowStart++;
        }

        return false;
    }

    private Map<Character, Integer> charOccurrences(String str) {
        Map<Character, Integer> occurrences = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            occurrences.put(c, occurrences.getOrDefault(c, 0) + 1);
        }
        
        return occurrences;
    }

    /**
     * A permutation should contain the same characters the same number
     * of times as the original string.
     *
     * This method compares occurrences of two strings to determine if those
     * have the same characters the same number of times
     */
    private boolean sameOccurrences(Map<Character, Integer> m1,
                                    Map<Character, Integer> m2) {
        if (m1.size() != m2.size()) {
            return false;
        }
        
        AtomicBoolean sameOccurrences = new AtomicBoolean(true);
        m1.forEach((c, count) -> {
            if (!m2.containsKey(c) || !Objects.equals(m2.get(c), count)) {
                sameOccurrences.set(false);
            }
        });
        
        return sameOccurrences.get();
    }
}
