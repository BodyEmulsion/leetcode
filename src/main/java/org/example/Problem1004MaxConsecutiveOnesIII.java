package org.example;

public class Problem1004MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int[] islands = new int[k + 1];
        int islandIndex = k;
        int max = 0;
        int current = 0;
        int zeros = 0;
        for (int num : nums) {
            if (num == 1) {
                current++;
                islands[islandIndex]++;
            } else {
                zeros++;
                islandIndex++;
                islandIndex %= islands.length;
                current -= islands[islandIndex];
                islands[islandIndex] = 0;
            }
            if (current > max) {
                max = current;
            }
        }
        max += Math.min(zeros, k);
        return max;
    }
}
