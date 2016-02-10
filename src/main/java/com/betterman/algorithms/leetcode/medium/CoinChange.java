package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 2/10/16.
 */
public class CoinChange {
    public class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount <= 0) return 0;
            int[] dp = new int[amount + 1];

            for (int i = 1; i <= amount; i++) {
                int min = Integer.MAX_VALUE;
                for (int c : coins) {
                    int last = i - c;
                    if (last >= 0 && dp[last] < min) {
                        min = dp[last];
                    }
                }
                if (min == Integer.MAX_VALUE) dp[i] = Integer.MAX_VALUE;
                else dp[i] = min + 1;
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}
