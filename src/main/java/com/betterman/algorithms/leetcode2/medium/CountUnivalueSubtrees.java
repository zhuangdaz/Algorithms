package com.betterman.algorithms.leetcode2.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 3/17/16.
 */
public class CountUnivalueSubtrees {
    public class Solution {
        int count = 0;

        public int countUnivalSubtrees(TreeNode root) {
            all(root, 0);
            return count;
        }

        private boolean all(TreeNode node, int val) {
            if (node == null) return true;

            if (!all(node.left, node.val) | !all(node.right, node.val)) {
                return false;
            }
            count++;
            return node.val == val;
        }
    }

}
