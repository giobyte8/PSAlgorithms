package com.giobyte8.psalgo.gtci.two_heaps;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfStreamTest {

    @Test
    void findMedian1() {
        MedianOfStream medianOfStream = new MedianOfStream();
        assertEquals(0, medianOfStream.findMedian());

        Arrays
                .stream(new int[]{12, 14, 36, 54})
                .forEach(medianOfStream::insertNum);
        assertEquals(25, medianOfStream.findMedian());
    }

    @Test
    void findMedian2() {
        MedianOfStream medianOfStream = new MedianOfStream();
        Arrays.stream(new int[]{3, 2, 3}).forEach(medianOfStream::insertNum);

        assertEquals(2, medianOfStream.firstHalf.size());
        assertEquals(1, medianOfStream.secondHalf.size());

        assertEquals(3, medianOfStream.firstHalf.peek());
        assertEquals(3, medianOfStream.secondHalf.peek());

        assertEquals(3, medianOfStream.findMedian());

        Arrays.stream(new int[]{4, 5, 6, 1}).forEach(medianOfStream::insertNum);
        assertEquals(3, medianOfStream.findMedian());
    }

    @Test
    void findMedian3() {
        MedianOfStream medianOfStream = new MedianOfStream();
        Arrays
                .stream(new int[]{1, 1, 1, 1, 2, 3, 4, 2, 1, 2, 3})
                .forEach(medianOfStream::insertNum);
        assertEquals(2, medianOfStream.findMedian());
    }
}