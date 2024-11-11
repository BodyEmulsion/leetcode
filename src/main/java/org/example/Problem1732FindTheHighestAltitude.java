package org.example;

public class Problem1732FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int current = 0;
        int max = current;
        for (var change : gain) {
            current += change;
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
}
