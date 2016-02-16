package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 2/15/16.
 */
public class MaximalSquare {
    public class Solution {
        //O(mn) O(mn)
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
            int max = 0;
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i - 1][j - 1] == '0') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                        if (dp[i][j] > max) max = dp[i][j];
                    }
                }
            }
            return max * max;

        }

        //O(mn) O(n)
        public int maximalSquareOpt(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
            int max = 0;
            int m = matrix.length, n = matrix[0].length;
            int[] dp = new int[n + 1];
            int last = 0;

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int tmp = dp[j];
                    if (matrix[i-1][j-1] == '1') {
                        dp[j] = Math.min(last, Math.min(dp[j-1], dp[j])) + 1;
                        if (dp[j] > max) max = dp[j];
                    } else {
                        dp[j] = 0;
                    }
                    last = tmp;
                }
            }
            return max*max;
        }
    }
}
