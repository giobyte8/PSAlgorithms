package com.giobyte8.psalgo.gtci.sliding_window;

import com.giobyte8.psalgo.gtci.sliding_window.FruitBaskets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitBasketsTest {

    @Test
    void findLength1() {
        char[] treeLine = new char[]{'A', 'B', 'C', 'A', 'C'};

        int maxFruitsCount = FruitBaskets.findLength(treeLine);
        assertEquals(3, maxFruitsCount);
    }

    @Test
    void findLength2() {
        char[] treeLine = new char[]{'A', 'B', 'C', 'B', 'B', 'C'};

        int maxFruitsCount = FruitBaskets.findLength(treeLine);
        assertEquals(5, maxFruitsCount);
    }
}