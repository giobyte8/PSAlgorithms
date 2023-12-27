package com.giobyte8.psalgo.gtci.two_heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianSlidingWindowTest {

    @Test
    void medianSlidingWindow1() {
        double[] medians = MedianSlidingWindow.medianSlidingWindow(
                new int[]{1, 1, 1, 1, 1, 1},
                3
        );

        assertArrayEquals(new double[]{1, 1, 1, 1}, medians);
    }
}