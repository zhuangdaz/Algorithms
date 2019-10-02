package com.betterman.algorithms.boston.tree;

import com.betterman.algorithms.leetcode.common.TreeNode;

public class BinaryTreeMaximumPathSum {
    // We can use a 1-element int[] to avoid global variable
    int maxSum;

    /**
     * Time: O(n)
     * Space: O(n) or O(logn) if balanced tree
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxSum;
    }

    private int maxPathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));

        maxSum = Math.max(maxSum, left + root.val + right);
        String s = "ds";
        s.split(",");

        return Math.max(left, right) + root.val;
    }
}
