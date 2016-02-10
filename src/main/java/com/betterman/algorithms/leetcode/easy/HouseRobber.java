package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 2/9/16.
 */
public class HouseRobber {
    public class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            int includeLast = nums[0];
            int excludeLast = 0;

            for (int i = 1; i < nums.length; i++) {
                int tmp = includeLast;
                includeLast = excludeLast + nums[i];
                excludeLast = Math.max(tmp, excludeLast);
            }
            return Math.max(includeLast, excludeLast);
        }
    }
}
