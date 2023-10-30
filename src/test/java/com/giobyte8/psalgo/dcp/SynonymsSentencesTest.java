package com.giobyte8.psalgo.dcp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SynonymsSentencesTest {

    @Test
    void areEquivalent1() {
        String s1 = "He wants to eat food.";
        String s2 = "He wants to consume food.";

        String[] synonyms = new String[]{"eat", "consume"};

        assertTrue(SynonymsSentences.areEquivalent(s1, s2, synonyms));
    }

    @Test
    void areEquivalent2() {
        String s1 = "He wants to eat food with his big mouth.";
        String s2 = "He wants to consume food with his large mouth.";

        String[] synonyms = new String[]{"eat", "consume", "big", "large"};

        assertTrue(SynonymsSentences.areEquivalent(s1, s2, synonyms));
    }
}