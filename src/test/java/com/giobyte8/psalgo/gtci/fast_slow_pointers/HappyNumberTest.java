package com.giobyte8.psalgo.gtci.fast_slow_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {

    @Test
    void findHappyNumber() {
        int number = 23;

        // It is a happy number
        assertTrue(HappyNumber.find(number));
    }

    @Test
    void findHappyNumber2() {
        int number = 12;

        // It is not a happy number
        assertFalse(HappyNumber.find(number));
    }
}