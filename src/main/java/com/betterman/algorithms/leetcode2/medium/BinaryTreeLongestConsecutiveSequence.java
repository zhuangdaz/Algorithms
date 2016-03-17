package com.betterman.algorithms.leetcode2.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 3/16/16.
 */
public class BinaryTreeLongestConsecutiveSequence {
    public class Solution {
        public int longestConsecutive(TreeNode root) {
            if (root == null) return 0;
            return dfs(root, root.val, 0);
        }

        private int dfs(TreeNode root, int target, int len) {
            if (root == null) return 0;

            if (root.val == target) len++;
            else len = 1;

            int left = dfs(root.left, root.val + 1, len);
            int right = dfs(root.right, root.val + 1, len);

            return Math.max(Math.max(left, right), len);
        }
    }

}
