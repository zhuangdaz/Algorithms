package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/29/15.
 */
public class MinPathSum {
    public class Solution {
        public int minPathSum(int[][] grid) {
            int[] dp = new int[grid[0].length];
            dp[0] = grid[0][0];

            for (int i = 1; i < grid[0].length; i++) {
                dp[i] = dp[i - 1] + grid[0][i];
            }

            for (int i = 1; i < grid.length; i++) {
                dp[0] += grid[i][0];
                for (int j = 1; j < grid[0].length; j++) {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
            return dp[dp.length - 1];
        }
    }
}
