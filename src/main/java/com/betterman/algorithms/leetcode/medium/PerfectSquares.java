package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/22/16.
 */
public class PerfectSquares {
    public class Solution {
        public int numSquares(int n) {
            if (n <= 0) return 0;
            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                int min = dp[i - 1];
                for (int j = 2; j * j <= i; j++) {
                    int cnt = dp[i - j * j];
                    if (cnt < min) {
                        min = cnt;
                    }
                }
                dp[i] = min + 1;
            }
            return dp[n];
        }
    }
}
