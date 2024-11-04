package org.example;

public class Problem283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int numberSearchIndex = 0;
        int temp;
        while (numberSearchIndex < nums.length) {
            if (nums[numberSearchIndex] != 0) {
                temp = nums[index];
                nums[index] = nums[numberSearchIndex];
                nums[numberSearchIndex] = temp;
                index++;
            }
            numberSearchIndex++;
        }
    }
}
