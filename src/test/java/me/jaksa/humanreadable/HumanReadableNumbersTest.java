package me.jaksa.humanreadable;

import org.junit.jupiter.api.Test;

import static me.jaksa.humanreadable.HumanReadableNumbers.h;
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

    @Test void benchmark() {
        long start = System.currentTimeMillis();
        for (long i = 0; i < 100_000_000; i++) {
            h(i);
            h (i*1000000);
        }
        System.out.println("time: " + (System.currentTimeMillis() - start));
    }
}