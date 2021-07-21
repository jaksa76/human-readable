package me.jaksa.humanreadable;

import java.math.BigInteger;

public class HumanReadableNumbers {
    private static final char[] MAGNITUDES = {' ', 'k', 'M', 'G', 'T', 'P', 'E'};

    /**
     * A human readable alias for method h. :-)
     * @see #h(long)
     */
    public static String humanReadable(long n) {
        return h(n);
    }

    /**
     * Convert a number to a human readable form by appending k, M, G etc.
     * @param n - the number to convert
     * @return - the formatted string
     */
    public static String h(long n) {
        StringBuilder s = new StringBuilder();
        if (n < 0) {
            n = -n;
            s.append("-");
        }

        int magnitude = 0;
        while (n >= 1000) {
            n /= 1000;
            magnitude++;
        }
        s.append(n);
        if (magnitude > 0) s.append(MAGNITUDES[magnitude]);

        return s.toString();
    }
}
