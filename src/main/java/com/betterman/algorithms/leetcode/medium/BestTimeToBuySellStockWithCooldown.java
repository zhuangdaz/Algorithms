package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 2/15/16.
 */
public class BestTimeToBuySellStockWithCooldown {
    public class Solution {
        /**
         * buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
         * sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
         */
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) return 0;
            int prevSell = 0, sell = 0;
            int buy = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                int prevBuy = buy;
                buy = Math.max(buy, prevSell - prices[i]);
                prevSell = sell;
                sell = Math.max(sell, prevBuy + prices[i]);
            }
            return sell;
        }
    }
}
