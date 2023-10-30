package com.giobyte8.psalgo.hackerr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeFormatConversionTest {

    @Test
    void timeConversion00Hours() {
        String time24 = TimeFormatConversion.timeConversion("12:00:00AM");
        assertEquals("00:00:00", time24);
    }

    @Test
    void timeConversion09Hours() {
        String time24 = TimeFormatConversion.timeConversion("09:00:00AM");
        assertEquals("09:00:00", time24);
    }

    @Test
    void timeConversion12Hours() {
        String time24 = TimeFormatConversion.timeConversion("12:00:00PM");
        assertEquals("12:00:00", time24);
    }

    @Test
    void timeConversion17Hours() {
        String time24 = TimeFormatConversion.timeConversion("05:36:00PM");
        assertEquals("17:36:00", time24);
    }
}