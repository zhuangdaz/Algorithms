package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 2/9/16.
 */

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j),
 * inclusive.
 *
 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3 Note: You may assume that the array
 * does not change. There are many calls to sumRange function. Show Company Tags Hide Tags
 */
public class RangeSumQuery {
    public class NumArray {
        int[] dp;

        public NumArray(int[] nums) {
            dp = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                dp[i] = nums[i - 1] + dp[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            if (i > j || j >= dp.length - 1) return dp[0];
            else {
                return dp[j + 1] - dp[i];
            }
        }
    }


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
}
