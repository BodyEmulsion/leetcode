package org.example;

import java.util.Arrays;

public class Problem1679MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        int counter = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                counter++;
                left++;
                right--;
            } else if (nums[right] + nums[left] < k) {
                left++;
            } else {
                right--;
            }
        }
        return counter;
    }
}
