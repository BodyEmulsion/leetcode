package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2542MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        var pairs = new ArrayList<Pair>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            pairs.add(new Pair(nums1[i], nums2[i]));
        }
        pairs.sort(Comparator.comparingInt(i -> i.num2));

        long sum = 0;
        long result = 0;
        var minHeap = new PriorityQueue<Integer>(k);
        for (var pair : pairs.reversed()) {
            sum += pair.num1;
            minHeap.add(pair.num1);
            if (minHeap.size() == k) {
                result = Math.max(result, sum * pair.num2);
                sum -= minHeap.poll();
            }
        }
        return result;
    }

    private record Pair(int num1, int num2) {
    }
}