package com.giobyte8.psalgo.lc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {

    @Test
    void test1() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);

        // arr = [1, 2]
        assertEquals(1.5, medianFinder.findMedian());

        medianFinder.addNum(3);

        // arr = [1, 2, 2]
        assertEquals(2, medianFinder.findMedian());
    }

}