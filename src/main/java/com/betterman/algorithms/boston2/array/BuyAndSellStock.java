package com.betterman.algorithms.boston2.array;

public class BuyAndSellStock {

  class Solution {

    /**
     * time: O(n)
     * space: O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
      int min = Integer.MAX_VALUE, maxProfit = 0;

      for (int price : prices) {
        if (price < min) {
          min = price;
        } else if (maxProfit < price - min) {
          maxProfit = price - min;
        }
      }
      return maxProfit;
    }
  }

}
