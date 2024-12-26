package org.example;

public class Problem338CountingBits {
    public int[] countBits(int n) {
        var result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
