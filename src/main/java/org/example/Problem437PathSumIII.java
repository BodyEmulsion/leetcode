package org.example;

import java.util.ArrayList;
import java.util.List;

//Straightforward algorithm O(n^2) TODO: proper solution
public class Problem437PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSum(new ArrayList<>(List.of(root)), targetSum);
    }

    private int pathSum(List<TreeNode> parents, int targetSum) {
        TreeNode last = parents.getLast();
        if (last == null) {
            return 0;
        }

        int current = 0;
        long sum = 0;
        for (int i = parents.size() - 1; i >= 0; i--) {
            sum += parents.get(i).val;
            if (sum == targetSum) {
                current++;
            }
        }

        parents.add(last.left);
        int left = pathSum(parents, targetSum);
        parents.removeLast();

        parents.add(last.right);
        int right = pathSum(parents, targetSum);
        parents.removeLast();

        return current + left + right;
    }
}