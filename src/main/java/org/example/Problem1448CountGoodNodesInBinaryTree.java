package org.example;

public class Problem1448CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return goodNodes(root.left, root.val) + goodNodes(root.right, root.val) + 1;
    }

    public int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int newMax = Math.max(root.val, max);
        int goodNodes = goodNodes(root.left, newMax) + goodNodes(root.right, newMax);
        if (root.val >= max) {
            goodNodes += 1;
        }
        return goodNodes;
    }
}
