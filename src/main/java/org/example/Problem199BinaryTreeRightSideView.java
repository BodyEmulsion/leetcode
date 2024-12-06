package org.example;

import java.util.ArrayList;
import java.util.List;

public class Problem199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<TreeNode> currentLevel = new ArrayList<>();
        if (root != null) {
            currentLevel.add(root);
        }
        while (!currentLevel.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            result.add(currentLevel.getFirst().val);
            for (TreeNode node : currentLevel) {
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
            }
            currentLevel = nextLevel;
        }
        return result;
    }
}
