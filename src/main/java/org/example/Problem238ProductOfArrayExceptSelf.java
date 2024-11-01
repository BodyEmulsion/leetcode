package org.example;

public class Problem238ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        var tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
}
