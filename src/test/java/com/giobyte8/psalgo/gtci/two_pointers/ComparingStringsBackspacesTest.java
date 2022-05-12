package com.giobyte8.psalgo.gtci.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparingStringsBackspacesTest {

    @Test
    void compare() {
        String str1 = "xy#z";
        String str2 = "xzz#";

        assertTrue(ComparingStringsBackspaces.compare(str1, str2));
    }

    @Test
    void compare2() {
        String str1 = "xy#z";
        String str2 = "xyz#";

        assertFalse(ComparingStringsBackspaces.compare(str1, str2));
    }

    @Test
    void compare3() {
        String str1 = "xp#";
        String str2 = "xyz##";

        assertTrue(ComparingStringsBackspaces.compare(str1, str2));
    }

    @Test
    void compare4() {
        String str1 = "xywrrmp";
        String str2 = "xywrrmu#p";

        assertTrue(ComparingStringsBackspaces.compare(str1, str2));
    }
}
