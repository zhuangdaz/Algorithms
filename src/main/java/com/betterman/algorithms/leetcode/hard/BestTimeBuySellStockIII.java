package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 1/5/16.
 */
public class BestTimeBuySellStockIII {
    public class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) return 0;
            int K = 2;
            int[][] dp = new int[K + 1][prices.length];
            //dp[k][0] = 0
            //dp[0][i] = 0
            for (int k = 1; k <= K; k++) {
                int tmpMax = dp[k - 1][0] - prices[0];
                for (int i = 1; i < prices.length; i++) {
                    dp[k][i] = Math.max(dp[k][i - 1], tmpMax + prices[i]);
                    if (dp[k - 1][i] - prices[i] > tmpMax) tmpMax = dp[k - 1][i] - prices[i];
                }
            }
            return dp[K][prices.length - 1];
        }
    }
}
