package org.example;

public class Problem724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] delta = new int[nums.length];
        int accumulator = 0;
        for (int i = 1; i < nums.length; i++) {
            accumulator += nums[i - 1];
            delta[i] = accumulator;
        }
        accumulator = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            accumulator -= nums[i];
            delta[i - 1] += accumulator;
        }
        for (int i = 0; i < nums.length; i++) {
            if (delta[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
