package me.jaksa.humanreadable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static me.jaksa.humanreadable.HumanReadableNumbers.*;
import static org.junit.jupiter.api.Assertions.*;

class HumanReadableNumbersTest {
    @Test void testConvertingSomeStraightforwardNumbers() {
        assertEquals("1", h(1));
        assertEquals("1k", h(1000));
        assertEquals("1M", h(1_000_000));
        assertEquals("1G", h(1_000_000_000));
        assertEquals("1T", h(1_000_000_000_000L));
        assertEquals("1P", h(1_000_000_000_000_000L));
        assertEquals("1E", h(1_000_000_000_000_000_000L));
    }

    @Test void testConvertingNegativeNumbers() {
        assertEquals("-1", h(-1));
        assertEquals("-1k", h(-1000));
        assertEquals("-1E", h(-1_000_000_000_000_000_000L));
    }

    @Test void testConvertingSomeAlmostBigNumbers() {
        assertEquals("999", h(999));
        assertEquals("-999", h(-999));
        assertEquals("999k", h(999_999));
        assertEquals("-999k", h(-999_999));
        assertEquals("999P", h(999_999_999_999_999_999L));
        assertEquals("-999P", h(-999_999_999_999_999_999L));
    }

    @Test void testConvertingByteSizes() {
        assertEquals("1023", hb(1024-1));
        assertEquals("1k", hb(1024));
        assertEquals("1023k", hb(1024L*1024L-1));
        assertEquals("1M", hb(1024L*1024L));
        assertEquals("1023M", hb(1024L*1024L*1024L-1));
        assertEquals("1G", hb(1024L*1024L*1024L));
        assertEquals("1023G", hb(1024L*1024L*1024L*1024L-1));
        assertEquals("1T", hb(1024L*1024L*1024L*1024L));
        assertEquals("1023T", hb(1024L*1024L*1024L*1024L*1024L-1));
        assertEquals("1P", hb(1024L*1024L*1024L*1024L*1024L));
        assertEquals("1023P", hb(1024L*1024L*1024L*1024L*1024L*1024L-1));
        assertEquals("1E", hb(1024L*1024L*1024L*1024L*1024L*1024L));
    }

    @Test void testAliases() {
        assertEquals("123k", humanReadable(123456));
        assertEquals("1023", humanReadableBytes(1023));
        assertEquals("1k", humanReadableBytes(1024));
    }

    @Disabled @Test void benchmark() {
        long start = System.currentTimeMillis();
        for (long i = 0; i < 100_000_000; i++) {
            h(i);
            h (i*1000000);
        }
        System.out.println("time: " + (System.currentTimeMillis() - start));
    }
}