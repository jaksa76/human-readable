package me.jaksa.humanreadable;

import java.math.BigInteger;

public class HumanReadableNumbers {
    private static final char[] MAGNITUDES = {' ', 'k', 'M', 'G', 'T', 'P', 'E'};

    /**
     * A human readable alias for method h. :-)
     * @see #h(long)
     */
    public static String humanReadable(long n) {
        return h(n, 1000);
    }

    /**
     * A human readable alias for method hb. :-)
     * @see #hb(long)
     */
    public static String humanReadableBytes(long n) {
        return h(n, 1024);
    }

    /**
     * Convert a number to a human readable form by appending k, M, G etc. The base is 1000 and the result is rounded down.
     * That means that hb(999) is "999" and not "1k".
     * @param n - the number to convert
     * @return - the formatted string
     */
    public static String h(long n) {
        return h(n, 1000);
    }

    /**
     * Convert a byte size to a human readable form by appending k, M, G etc. The base is 1024 and the result is rounded down.
     * That means that hb(1023) is "1023" and not "1k".
     * @param n - the number to convert
     * @return - the formatted string
     */
    public static String hb(long n) {
        return h(n, 1024);
    }

    private static String h(long n, int base) {
        if (n < 0) return "-" + h(-n, base);

        StringBuilder s = new StringBuilder();
        int magnitude = 0;
        while (n >= base) {
            n /= base;
            magnitude++;
        }
        s.append(n);
        if (magnitude > 0) s.append(MAGNITUDES[magnitude]);

        return s.toString();
    }
}
