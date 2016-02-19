package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 2/18/16.
 */
public class PaintHouseII {
    public class Solution {
        public int minCostII(int[][] costs) {
            if (costs == null || costs.length == 0) return 0;
            int k = costs[0].length;
            int[] dp = new int[k];

            int min1 = 0, min2 = 0;
            for (int i = 0; i < costs.length; i++) {
                int last1 = min1, last2 = min2;
                min1 = Integer.MAX_VALUE;
                min2 = Integer.MAX_VALUE;

                for (int j = 0; j < k; j++) {
                    if (dp[j] != last1) {
                        dp[j] = last1 + costs[i][j];
                    } else {
                        dp[j] = last2 + costs[i][j];
                    }

                    if (dp[j] < min1) {
                        min2 = min1;
                        min1 = dp[j];
                    } else if (dp[j] < min2) {
                        min2 = dp[j];
                    }
                }
            }
            return min1;
        }
    }
}
