package org.example;

import java.util.ArrayList;
import java.util.List;

//it ain't much but it's honest work
public class Problem236LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var pParents = getParents(root, p);
        var qParents = getParents(root, q);
        var lowestCommonAncestor = root;
        for (int i = 1; i <= Math.min(pParents.size(), qParents.size()); i++) {
            if (pParents.get(pParents.size() - i).val == qParents.get(qParents.size() - i).val) {
                lowestCommonAncestor = pParents.get(pParents.size() - i);
            }
        }
        return lowestCommonAncestor;
    }

    private List<TreeNode> getParents(TreeNode root, TreeNode node) {
        if (root == null) {
            return null;
        }
        if (root.val == node.val) {
            return new ArrayList<>(List.of(node));
        }
        var left = getParents(root.left, node);
        var right = getParents(root.right, node);
        var result = left != null ? left : right;
        if (result != null) {
            result.add(root);
        }
        return result;
    }
}
