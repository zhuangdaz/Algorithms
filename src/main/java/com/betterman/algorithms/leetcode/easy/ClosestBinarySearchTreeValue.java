package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 2/1/16.
 */
public class ClosestBinarySearchTreeValue {
    public class Solution {
        public int closestValue(TreeNode root, double target) {
            int ans = root.val;
            while (root != null) {
                if (root.val == target) return root.val;
                if (Double.compare(Math.abs(root.val - target), Math.abs(ans - target)) < 0) {
                    ans = root.val;
                }
                root = root.val < target ? root.right : root.left;
            }
            return ans;
        }
    }
}
