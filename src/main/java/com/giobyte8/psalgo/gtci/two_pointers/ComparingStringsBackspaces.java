package com.giobyte8.psalgo.gtci.two_pointers;

/**
 * Given two strings containing backspaces (identified by the character ‘#’),
 * check if the two strings are equal.
 *
 * Example 1
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 *
 * Example 2:
 * Input: str1="xy#z", str2="xyz#"
 * Output: false
 * Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
 *
 * Example 3:
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 *
 * Example 4:
 * Input: str1="xywrrmp", str2="xywrrmu#p"
 * Output: true
 * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 */
public class ComparingStringsBackspaces {

    public static boolean compare(String str1, String str2) {
        int str1Idx = str1.length();
        int str2Idx = str2.length();

        while (true) {
            str1Idx = previousValidCharIdx(str1, str1Idx);
            str2Idx = previousValidCharIdx(str2, str2Idx);

            if (str1Idx == -1 && str2Idx == -1) return true;
            if (str1Idx == -1 || str2Idx == -1) return false;
            if (str1.charAt(str1Idx) != str2.charAt(str2Idx)) return false;
        }
    }

    public static int previousValidCharIdx(String str, int idx) {
        int hashesCount = 0;
        while (--idx >= 0) {
            char c = str.charAt(idx);

            if (c == '#') {
                hashesCount++;
            } else if (hashesCount > 0) {
                hashesCount--;
            } else {
                return idx;
            }
        }

        return -1;
    }
}
