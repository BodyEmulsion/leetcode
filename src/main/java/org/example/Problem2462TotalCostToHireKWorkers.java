package org.example;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2462TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        var minHeap = new PriorityQueue<Pair>(candidates * 2, Comparator.comparingInt(i -> ((Pair) i).cost).thenComparingInt(i -> ((Pair) i).i));
        long costSum = 0;

        for (int i = 0; i < candidates; i++) {
            if (costs[i] > 0) {
                minHeap.add(new Pair(i, costs[i]));
                costs[i] = 0;
            }
            if (costs[costs.length - 1 - i] > 0) {
                minHeap.add(new Pair(costs.length - 1 - i, costs[costs.length - 1 - i]));
                costs[costs.length - 1 - i] = 0;
            }
        }

        int leftPointer, rightPointer;
        leftPointer = candidates - 1;
        rightPointer = costs.length - candidates;

        for (;k > 0; k--) {
            Pair polled = minHeap.poll();
            costSum += polled.cost;

            if (polled.i >= rightPointer && rightPointer - 1 > leftPointer) {
                rightPointer--;
                minHeap.add(new Pair(rightPointer, costs[rightPointer]));
            } else if (polled.i <= leftPointer && leftPointer + 1 < rightPointer){
                leftPointer++;
                minHeap.add(new Pair(leftPointer, costs[leftPointer]));
            }
        }
        return costSum;
    }

    private record Pair(int i, int cost) {}
}