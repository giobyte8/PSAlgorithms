package com.giobyte8.psalgo.gtci.topk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReorganizeStringTest {

    @Test
    void reorganizeString() {
        String res = ReorganizeString.reorganizeString("abb");
        assertEquals("bab", res);
    }
}