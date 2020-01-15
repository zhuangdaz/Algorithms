package com.betterman.algorithms.boston2.dp;

public class ClimbStairs {

  class Solution {

    /**
     * time: O(n)
     * space: O(1)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
      int twoStepsBefore = 0, oneStepBefore = 1;
      while (n-- != 0) {
        int cur = twoStepsBefore + oneStepBefore;
        twoStepsBefore = oneStepBefore;
        oneStepBefore = cur;
      }
      return oneStepBefore;
    }
  }

}
