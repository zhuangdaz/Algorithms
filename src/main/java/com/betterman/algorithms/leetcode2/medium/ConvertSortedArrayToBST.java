package com.betterman.algorithms.leetcode2.medium;

import com.betterman.algorithms.leetcode.common.TreeNode;

/**
 * Created by zhuangda on 3/14/16.
 */
public class ConvertSortedArrayToBST {
    public class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
            if (lo > hi) return null;

            int mid = (lo + hi) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, lo, mid - 1);
            root.right = sortedArrayToBST(nums, mid + 1, hi);
            return root;
        }
    }
}
