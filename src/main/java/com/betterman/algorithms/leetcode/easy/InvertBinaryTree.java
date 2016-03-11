package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 3/11/16.
 */
public class InvertBinaryTree {
    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            TreeNode right = invertTree(root.left);
            TreeNode left = invertTree(root.right);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
