package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 3/10/16.
 */
public class SymmetricTree {
    public class Solution {
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null || right == null) return left == right;

            if (left.val != right.val) return false;
            return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
        }
    }
}
