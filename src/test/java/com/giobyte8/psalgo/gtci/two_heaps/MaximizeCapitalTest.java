package com.giobyte8.psalgo.gtci.two_heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximizeCapitalTest {

    @Test
    void maxCapitalTwoHeaps() {
        int maxCapital = MaximizeCapital.maxCapitalTwoHeaps(
                1,
                2,
                new int[]{1, 2, 3},
                new int[]{2, 3, 5}
        );
        assertEquals(8, maxCapital);

        maxCapital = MaximizeCapital.maxCapitalTwoHeaps(
                3,
                1,
                new int[]{0, 2, 3, 4},
                new int[]{7, 3, 5, 2}
        );
        assertEquals(10, maxCapital);

        maxCapital = MaximizeCapital.maxCapitalTwoHeaps(
                2,
                2,
                new int[]{1, 1, 2, 4},
                new int[]{2, 3, 5, 8}
        );
        assertEquals(15, maxCapital);

        maxCapital = MaximizeCapital.maxCapitalTwoHeaps(
                1,
                4,
                new int[]{0, 3, 5, 7, 9, 10},
                new int[]{2, 3, 6, 4, 1, 5}
        );
        assertEquals(17, maxCapital);

        maxCapital = MaximizeCapital.maxCapitalTwoHeaps(
                0,
                1,
                new int[]{1, 1, 2},
                new int[]{1, 1, 3}
        );
        assertEquals(0, maxCapital);
    }

    @Test
    void maxCapitalSingleHeaps() {
        int maxCapital = MaximizeCapital.maxCapitalSingleHeap(
                1,
                2,
                new int[]{1, 2, 3},
                new int[]{2, 3, 5}
        );
        assertEquals(8, maxCapital);

        maxCapital = MaximizeCapital.maxCapitalSingleHeap(
                3,
                1,
                new int[]{0, 2, 3, 4},
                new int[]{7, 3, 5, 2}
        );
        assertEquals(10, maxCapital);

        maxCapital = MaximizeCapital.maxCapitalSingleHeap(
                2,
                2,
                new int[]{1, 1, 2, 4},
                new int[]{2, 3, 5, 8}
        );
        assertEquals(15, maxCapital);

        maxCapital = MaximizeCapital.maxCapitalSingleHeap(
                1,
                4,
                new int[]{0, 3, 5, 7, 9, 10},
                new int[]{2, 3, 6, 4, 1, 5}
        );
        assertEquals(17, maxCapital);
    }
}