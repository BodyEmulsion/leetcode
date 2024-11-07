package org.example;

public class Problem643MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;
        for (int i = 0; i < nums.length - k; i++) {
            sum += nums[i + k] - nums[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max / k;
    }
}
