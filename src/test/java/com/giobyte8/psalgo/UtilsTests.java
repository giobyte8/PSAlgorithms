package com.giobyte8.psalgo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTests {

    @Test
    void toDigits() {
        int[] digits = Utils.toDigits(56);
        Assertions.assertArrayEquals(new int[]{5, 6}, digits);
    }
}
