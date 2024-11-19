package org.example;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem933NumberOfRecentCalls {
    class RecentCounter {
        private final Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.add(t);
            while (queue.peek() != null && queue.peek() + 3000 < t) {
                queue.poll();
            }
            return queue.size();
        }
    }
}