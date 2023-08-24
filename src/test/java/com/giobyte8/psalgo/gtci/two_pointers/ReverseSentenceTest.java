package com.giobyte8.psalgo.gtci.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseSentenceTest {

    @Test
    void reverseWords() {
        String sentence = "Hello Friend";
        String reversed = "Friend Hello";
        assertEquals(reversed, ReverseSentence.reverseWords(sentence));

        sentence = "The quick brown fox jumped over a lazy dog";
        reversed = "dog lazy a over jumped fox brown quick The";
        assertEquals(reversed, ReverseSentence.reverseWords(sentence));
    }

    @Test
    void reverseWordsExtraSpaces() {
        String sentence = " Hello Friend  ";
        String reversed = "Friend Hello";
        assertEquals(reversed, ReverseSentence.reverseWords(sentence));

        sentence = "Hello   Friend ";
        reversed = "Friend Hello";
        assertEquals(reversed, ReverseSentence.reverseWords(sentence));
    }

    @Test
    void reverseWordsEmptyNull() {
        String sentence = " ";
        String reversed = "";
        assertEquals(reversed, ReverseSentence.reverseWords(sentence));

        sentence = "";
        reversed = "";
        assertEquals(reversed, ReverseSentence.reverseWords(sentence));

        sentence = null;
        reversed = null;
        assertEquals(reversed, ReverseSentence.reverseWords(sentence));
    }


    @Test
    void reverseWordsGio() {
        String sentence = "Hello Friend";
        String reversed = "Friend Hello";
        assertEquals(reversed, ReverseSentence.reverseWordsGio(sentence));

        sentence = "The quick brown fox jumped over a lazy dog";
        reversed = "dog lazy a over jumped fox brown quick The";
        assertEquals(reversed, ReverseSentence.reverseWordsGio(sentence));
    }

    @Test
    void reverseWordsGioExtraSpaces() {
        String sentence = " Hello Friend  ";
        String reversed = "Friend Hello";
        assertEquals(reversed, ReverseSentence.reverseWordsGio(sentence));

        sentence = "Hello   Friend ";
        reversed = "Friend Hello";
        assertEquals(reversed, ReverseSentence.reverseWordsGio(sentence));
    }

    @Test
    void reverseWordsGioEmptyNull() {
        String sentence = " ";
        String reversed = "";
        assertEquals(reversed, ReverseSentence.reverseWordsGio(sentence));

        sentence = "";
        reversed = "";
        assertEquals(reversed, ReverseSentence.reverseWordsGio(sentence));

        sentence = null;
        reversed = null;
        assertEquals(reversed, ReverseSentence.reverseWordsGio(sentence));
    }
}