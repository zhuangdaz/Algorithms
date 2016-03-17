package com.betterman.algorithms.leetcode2.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 3/16/16.
 */
public class HouseRobberIII {
    public class Solution {
        public int rob(TreeNode root) {
            int[] ans = robDFS(root);
            return Math.max(ans[0], ans[1]);
        }

        private int[] robDFS(TreeNode root) {
            int[] ans = new int[2];
            if (root == null) return ans;

            int[] left = robDFS(root.left);
            int[] right = robDFS(root.right);
            //0:not rob root
            //1:rob root
            ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            ans[1] = left[0] + right[0] + root.val;
            return ans;
        }
    }
}
