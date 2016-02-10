package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 2/9/16.
 */
public class ClimbingStairs {
    public class Solution {
        public int climbStairs(int n) {
            int dp_1 = 1, dp_2 = 1;

            for (int i = 2; i <= n; i++) {
                int tmp = dp_1;
                dp_1 += dp_2;
                dp_2 = tmp;
            }
            return dp_1;
        }
    }
}
