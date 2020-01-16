package com.betterman.algorithms.boston2.dp;

public class CoinChange {

  class Solution {

    /**
     * time: O(amount * coins.length)
     * space: O(amount)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
      int[] dp = new int[amount + 1];

      for (int i = 1; i <= amount; i++) {
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
          int remain = i - coin;
          if (remain == 0) {
            min = 0;
          } else if (remain > 0 && dp[remain] != -1) {
            min = Math.min(min, dp[remain]);
          }
        }

        dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
      }

      return dp[amount];
    }
  }

}
