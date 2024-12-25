package org.example;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem2336SmallestNumberInInfiniteSet {
    /**
     * Simple O(logn) without cleaning memory
     */
    static class SmallestInfiniteSet {
        private int smallestContinuous = 1;
        private final PriorityQueue<Integer> heap = new PriorityQueue<>();
        private final Set<Integer> set = new HashSet<>();

        public SmallestInfiniteSet() {
        }

        public int popSmallest() {
            if (!heap.isEmpty()) {
                Integer smallest = heap.poll();
                set.remove(smallest);
                return smallest;
            } else {
                return smallestContinuous++;
            }
        }

        public void addBack(int num) {
            if (num >= smallestContinuous) {
                return;
            }
            if (set.add(num)) {
                heap.add(num);
            }
        }
    }
    //TODO version with memory cleaning?
}
