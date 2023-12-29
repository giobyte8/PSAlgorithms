package com.giobyte8.psalgo.gtci.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkDelayTest {

    @Test
    void networkDelayTime1() {
        int delay = NetworkDelay.networkDelayTime(
                new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 4, 15}},
                4,
                1
        );

        assertEquals(15, delay);
    }

    @Test
    void networkDelayTime2() {
        int delay = NetworkDelay.networkDelayTime(
                new int[][]{{2, 1, 1}, {3, 2, 1}, {3, 4, 2}},
                4,
                3
        );

        assertEquals(2, delay);
    }

    @Test
    void networkDelayTime3() {
        int delay = NetworkDelay.networkDelayTime(
                new int[][]{{1, 2, 1}, {2, 3, 1}, {3, 5, 2}},
                5,
                1
        );

        assertEquals(-1, delay);
    }
}