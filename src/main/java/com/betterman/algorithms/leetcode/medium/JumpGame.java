package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/31/15.
 */
public class JumpGame {
    public class Solution {
        public boolean canJump(int[] nums) {
            int len = 0;
            for (int i = 0; len < nums.length - 1 && i <= len; i++) {
                if (i + nums[i] > len) len = i + nums[i];
            }
            return len >= nums.length - 1;
        }
    }
}
