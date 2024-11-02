package org.example;

public class Problem334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int firstMinimum = Integer.MAX_VALUE;
        int secondMinimum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= firstMinimum) {
                firstMinimum = num;
            } else if (num <= secondMinimum) {
                secondMinimum = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
