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
            //dp[k][i] = max(dp[k][i-1], max(dp[k-1][j] + prices[i] - prices[j]))
            // = max(dp[k][i-1], max(dp[k-1][j] - prices[j]) + prices[i])
            for (int k = 1; k <= K; k++) {
                int tmpMax = dp[k - 1][0] - prices[0];
                for (int i = 1; i < prices.length; i++) {
                    dp[k][i] = Math.max(dp[k][i - 1], tmpMax + prices[i]);
                    tmpMax = Math.max(tmpMax, dp[k - 1][i] - prices[i]);
                }
            }
            return dp[K][prices.length - 1];
        }

        public int maxProfitOneDimensionSpace(int[] prices) {
            if (prices.length <= 1) return 0;
            int K = 2;
            int[] dp = new int[prices.length];

            for (int k = 1; k <= K; k++) {
                int tmpMax = - prices[0];
                for (int i = 1; i < prices.length; i++) {
                    int tmp = dp[i];
                    dp[i] = Math.max(dp[i - 1], tmpMax + prices[i]);
                    if (tmp - prices[i] > tmpMax) tmpMax = tmp - prices[i];
                }
            }
            return dp[prices.length - 1];
        }
    }
}
