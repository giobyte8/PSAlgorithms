package com.giobyte8.psalgo.gtci.topk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestTest {

    @Test
    void add1() {
        KthLargest kthLargest = new KthLargest(
                5,
                new int[]{1, 2, 3, 4, 5, -1, -5, 50, 80}
        );

        int kth = kthLargest.add(1);
        assertEquals(3, kth);

        kth = kthLargest.add(85);
        assertEquals(4, kth);
    }
}