package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/26/15.
 */
public class BestTimeBuySellStock {
    public class Solution {
        //https://en.wikipedia.org/wiki/Maximum_subarray_problem
        public int maxProfitKadane(int[] prices) {
            int maxEndingHere = 0, maxSoFar = 0;

            for (int i = 1; i < prices.length; i++) {
                maxEndingHere = Math.max(0, maxEndingHere + prices[i] - prices[i - 1]);
                maxSoFar = Math.max(maxSoFar, maxEndingHere);
            }
            return maxSoFar;
        }

        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE, max = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min) min = prices[i];
                else max = Math.max(max, prices[i] - min);
            }

            return max;
        }
    }
}
