package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 3/9/16.
 */

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 *
 */
public class BalancedBinaryTree {
    public class Solution {
        public boolean isBalanced(TreeNode root) {
            return height(root) != -1;
        }

        private int height(TreeNode root) {
            if (root == null) return 0;

            int left = height(root.left);
            if (left == -1) return -1;
            int right = height(root.right);
            if (right == -1) return -1;

            if (Math.abs(left - right) > 1) return -1;
            else return Math.max(left, right) + 1;
        }
    }
}
