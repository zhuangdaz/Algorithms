package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/30/15.
 */
public class MaxSubarray {
    public class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0], sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (sum < 0) sum = nums[i];
                else sum += nums[i];
                max = Math.max(sum, max);
            }
            return max;
        }
    }
}
