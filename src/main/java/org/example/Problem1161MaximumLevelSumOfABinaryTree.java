package org.example;

import java.util.ArrayList;
import java.util.List;

public class Problem1161MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        List<TreeNode> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        int max = Integer.MIN_VALUE;
        int maxLevel = 0;
        int counter = 1;
        int currentSum = 0;
        while (!currentLevel.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : currentLevel) {
                currentSum += node.val;
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            if (currentSum > max) {
                max = currentSum;
                maxLevel = counter;
            }
            currentSum = 0;
            counter++;
            currentLevel = nextLevel;
        }
        return maxLevel;
    }
}
