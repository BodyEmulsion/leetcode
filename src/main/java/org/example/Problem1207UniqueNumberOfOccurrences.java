package org.example;

import java.util.HashMap;
import java.util.HashSet;

public class Problem1207UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        System.out.println(new Problem1207UniqueNumberOfOccurrences().uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        var numberCount = new HashMap<Integer, Integer>();
        for (int num : arr) {
            numberCount.merge(num, 1, Integer::sum);
        }
        var counts = new HashSet<Integer>();
        for (int count : numberCount.values()) {
            if (!counts.add(count)) {
                return false;
            }
        }
        return true;
    }
}
