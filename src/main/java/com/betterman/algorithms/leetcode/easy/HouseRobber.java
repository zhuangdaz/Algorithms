package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 2/9/16.
 */

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police if
 * two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine
 * the maximum amount of money you can rob tonight without alerting the police.
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
