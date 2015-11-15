package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 11/9/15.
 */
public class BestTimeStockII {
    //proof:
    // Assume there is another way to earn more profit than this approach.
    // Then for a specific period of interval, it applies a different strategy.
    // say a, b, c, d (a < b, c < b, c < d, a << d).
    // someone may argue that buy in at price a and sell at price d would earn more.
    // (d - c) + (b - a) - (d - a) = b - c > 0
    // => (d - c) + (b - a) > d - a
    // period.
    public class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }

            int profit = 0;

            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] - prices[i] > 0) {
                    profit += prices[i + 1] - prices[i];
                }
            }
            return profit;

        }
    }
}
