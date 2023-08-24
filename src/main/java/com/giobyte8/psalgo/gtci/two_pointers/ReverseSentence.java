package com.giobyte8.psalgo.gtci.two_pointers;

public class ReverseSentence {

    private ReverseSentence() {}

    /**
     * Given a sentence, reverse the order of its words without affecting the
     * order of letters within a given word.
     * <br/><br/>
     *
     * Constraints:
     * - Sentence contains English uppercase and lowercase letters, digits,
     *   and spaces.
     * - 1 ≤ sentence.length ≤ 10^4
     * - The order of the letters within a word is not to be reversed.
     * <br/><br/>
     *
     * Examples:
     * - "Hello Friend" -> "Friend Hello"
     * - "Reverse the words in a sentence" -> "sentence a in words the Reverse"
     * - "The quick brown fox jumped over a lazy dog" -> "dog lazy a over jumped fox brown quick The"
     *
     * @param sentence Sentence to be reversed
     * @return Reversed sentence
     */
    public static String reverseWords(String sentence) {
        if (sentence == null) return null;
        if (sentence.length() == 1) return sentence.trim();

        // Reverse whole sentence. O(n)
        char[] sentenceArr = sentence.trim().toCharArray();
        reverse(sentenceArr, 0, sentenceArr.length);

        // Revert each reversed word
        int start = 0;
        int end   = 0;
        while (end < sentenceArr.length) {

            // Look for current word ending
            while (end < sentenceArr.length && sentenceArr[end] != ' ') end++;

            // Revert previously reversed word
            reverse(sentenceArr, start, end);

            // Advance until start of next word
            start = end;
            while (start < sentenceArr.length && sentenceArr[start] == ' ') {
                start++;
                end++;
            }
        }

        // Get rid of possible multiple spaces between words
        char[] reversedSentence = new char[sentenceArr.length];
        int reversedIdx = 0;
        int sentenceIdx = 0;
        while (sentenceIdx < sentenceArr.length) {
            reversedSentence[reversedIdx] = sentenceArr[sentenceIdx];
            sentenceIdx++;
            reversedIdx++;

            while (sentenceIdx < sentenceArr.length &&
                    sentenceArr[sentenceIdx] == ' ' &&
                    sentenceArr[sentenceIdx - 1] == ' ') {
                sentenceIdx++;
            }
        }

        return new String(reversedSentence).trim();
    }

    public static String reverseWordsGio(String sentence) {
        if (sentence == null) return null;

        // Verify for empty or pure spaces strings
        String trimmedSentence = sentence.trim();
        if (trimmedSentence.isEmpty()) return "";

        // Get rid of extra spaces between words
        String[] words = trimmedSentence.split("\\s+");

        // Reverse sentence words O(n)
        int start = 0;
        int end   = words.length - 1;
        while (start < end) {
            String tmp = words[start];
            words[start] = words[end];
            words[end]   = tmp;

            start++;
            end--;
        }

        return String.join(" ", words);
    }

    /**
     * Reverse characters in a given sentence from 'start' position
     * until 'end' position.
     *
     * @param sentence Array containing chars to reverse
     * @param start Initial position for reverse chars
     * @param end Last char to be reversed (Not inclusive)
     */
    private static void reverse(char[] sentence, int start, int end) {
        end--;

        while (start <= end) {
            char tmp = sentence[end];
            sentence[end] = sentence[start];
            sentence[start] = tmp;

            start++;
            end--;
        }
    }
}
