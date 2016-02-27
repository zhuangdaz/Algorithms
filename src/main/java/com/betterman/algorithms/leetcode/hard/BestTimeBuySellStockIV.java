package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 2/26/16.
 */

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock
 * before you buy again).
 */
public class BestTimeBuySellStockIV {
    public class Solution {
        //O(kn); O(n)
        public int maxProfit(int k, int[] prices) {
            if (prices.length <= 1) return 0;
            if (k >= prices.length / 2) return quickSolve(prices);

            int[] dp = new int[prices.length];

            while (k-- > 0) {
                int tmpMax = -prices[0];
                for (int i = 1; i < prices.length; i++) {
                    int tmp = dp[i];
                    dp[i] = Math.max(dp[i - 1], prices[i] + tmpMax);
                    tmpMax = Math.max(tmpMax, tmp - prices[i]);
                }
            }
            return dp[prices.length - 1];
        }

        private int quickSolve(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
    }
}
