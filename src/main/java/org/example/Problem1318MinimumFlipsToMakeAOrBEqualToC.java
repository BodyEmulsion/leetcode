package org.example;

public class Problem1318MinimumFlipsToMakeAOrBEqualToC {
    public int minFlips(int a, int b, int c) {
        int flipToZeroA = (a ^ c) & a;
        int flipToZeroB = (b ^ c) & b;
        int flipToOne = ((a | b) ^ c) & ~(a | b);
        return Integer.bitCount(flipToZeroA) + Integer.bitCount(flipToZeroB) + Integer.bitCount(flipToOne);
    }
}
