package com.giobyte8.psalgo.gtci.sliding_window;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FindRepeatedSequencesTest {

    @Test
    void findRepeatedSequences1() {
        String s = "AGCTGAAAGCTTAGCTG";
        int k = 5;

        Set<String> seqs = FindRepeatedSequences.findRepeatedSequences(s, k);
        assertEquals(1, seqs.size());
        assertTrue(seqs.contains("AGCTG"));
    }

    @Test
    void findRepeatedSequences2() {
        String s = "AGAGCTCCAGAGCTTG";
        int k = 6;

        Set<String> seqs = FindRepeatedSequences.findRepeatedSequences(s, k);
        assertEquals(1, seqs.size());
        assertTrue(seqs.contains("AGAGCT"));
    }

    @Test
    void findRepeatedSequences3() {
        String s = "ATATATATATATATAT";
        int k = 6;

        Set<String> seqs = FindRepeatedSequences.findRepeatedSequences(s, k);
        assertEquals(2, seqs.size());
        assertTrue(seqs.contains("TATATA"));
        assertTrue(seqs.contains("ATATAT"));
    }



}