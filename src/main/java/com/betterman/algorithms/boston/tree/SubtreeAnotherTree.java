package com.betterman.algorithms.boston.tree;

import com.betterman.algorithms.leetcode.common.TreeNode;

public class SubtreeAnotherTree {
    public boolean isSubTree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        return isSameTree(s, t) || isSubTree(s.left, t) || isSubTree(s.right, t);
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }

        return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
