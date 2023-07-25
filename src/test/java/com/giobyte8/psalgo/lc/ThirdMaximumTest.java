package com.giobyte8.psalgo.lc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThirdMaximumTest {

    @Test
    void thirdMaxTreeMap() {
        ThirdMaximum thirdMaximum = new ThirdMaximum();

        int max = thirdMaximum.thirdMaxRBT(new int[]{1, 2, 3});
        assertEquals(1, max);

        max = thirdMaximum.thirdMaxRBT(new int[]{1, 2});
        assertEquals(2, max);

        max = thirdMaximum.thirdMaxRBT(new int[]{2, 2, 3, 1});
        assertEquals(1, max);
    }

    @Test
    void thirdMaxLineal() {
        ThirdMaximum thirdMaximum = new ThirdMaximum();

        int max = thirdMaximum.thirdMaxLineal(new int[]{1, 2, 3});
        assertEquals(1, max);

        max = thirdMaximum.thirdMaxLineal(new int[]{1, 2});
        assertEquals(2, max);

        max = thirdMaximum.thirdMaxLineal(new int[]{2, 2, 3, 1});
        assertEquals(1, max);
    }
}