package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 2/8/16.
 */
public class CountCompleteTreeNodes {
    public class Solution {
        private int height(TreeNode n) {
            if (n == null) return 0;
            else return height(n.left) + 1;
        }

        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            int h = height(root.left), count = 0;
            while (root != null) {
                if (height(root.right) < h) {
                    count += 1 << h - 1;
                    root = root.left;
                } else {
                    count += 1 << h;
                    root = root.right;
                }
                h--;
            }
            return count;
        }
    }
}
