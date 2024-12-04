package org.example;

public class Problem1372LongestZigZagPathInABinaryTree {
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(longestZigZag(root, "right", 0), longestZigZag(root, "left", 0));
    }

    public int longestZigZag(TreeNode root, String direction, int count) {
        if (root == null) {
            return count - 1;
        }
        if ("left".equals(direction)) {
            return Math.max(longestZigZag(root.left, "right", count + 1), longestZigZag(root.right, "left", 1));
        } else {
            return Math.max(longestZigZag(root.right, "left", count + 1), longestZigZag(root.left, "right", 1));
        }
    }
}
