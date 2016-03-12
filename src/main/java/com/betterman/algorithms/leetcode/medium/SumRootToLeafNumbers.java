package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 3/11/16.
 */
public class SumRootToLeafNumbers {
    public class Solution {
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode node, int path) {
            if (node == null) return 0;

            path = path * 10 + node.val;
            if (node.left == null && node.right == null) {
                return path;
            }

            return dfs(node.left, path) + dfs(node.right, path);
        }
    }
}
