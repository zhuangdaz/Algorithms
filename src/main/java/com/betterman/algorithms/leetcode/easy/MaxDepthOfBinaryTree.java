package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 3/11/16.
 */
public class MaxDepthOfBinaryTree {
    public class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;

            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
