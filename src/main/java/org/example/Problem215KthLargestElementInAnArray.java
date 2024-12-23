package org.example;

import java.util.PriorityQueue;

public class Problem215KthLargestElementInAnArray {
    /**
     * O(klogn)
     * Just imagine that nums added through constructor (there is no Collection AND Comparator constructor)
     */
    public int findKthLargest(int[] nums, int k) {
        var heap = new PriorityQueue<Integer>(nums.length, (a, b) -> Integer.compare(b, a));
        for (var num : nums) {
            heap.add(num);
        }

        int kthLargest = 0;
        while (k > 0) {
            k--;
            kthLargest = heap.poll();
        }
        return kthLargest;
    }
    //TODO QuickSelect solution
}
