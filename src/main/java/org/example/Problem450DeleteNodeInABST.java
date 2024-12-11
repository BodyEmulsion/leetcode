package org.example;

public class Problem450DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.right == null) {
                return root.left;
            }
            return rearrange(root.left, root.right);
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode rearrange(TreeNode left, TreeNode right) {
        if (left == null) {
            return right;
        }
        left.right = rearrange(left.right, right);
        return left;
    }
}
