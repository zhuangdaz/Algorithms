package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 2/8/16.
 */
public class DungeonGame {
    public class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            int[] dp = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            dp[n - 1] = 1;

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    dp[j] = Math.max(1, Math.min(dp[j + 1], dp[j]) - dungeon[i][j]);
                }
            }
            return dp[0];
        }
    }
}
