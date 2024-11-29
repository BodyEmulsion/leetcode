package org.example;

import java.util.ArrayList;
import java.util.List;

public class Problem872LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        var leafs1 = getLeafs(root1);
        var leafs2 = getLeafs(root2);
        return leafs1.equals(leafs2);
    }

    private List<Integer> getLeafs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            List<Integer> result = new ArrayList<>();
            result.add(root.val);
            return result;
        }
        List<Integer> lefts = getLeafs(root.left);
        List<Integer> rights = getLeafs(root.right);
        lefts.addAll(rights);
        return lefts;
    }
}
