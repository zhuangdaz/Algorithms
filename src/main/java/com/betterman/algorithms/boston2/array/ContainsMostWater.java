package com.betterman.algorithms.boston2.array;

public class ContainsMostWater {

  class Solution {

    /**
     * time: O(n)
     * space: O(1)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
      int max = Integer.MIN_VALUE;

      int lo = 0, hi = height.length - 1;
      while (lo < hi) {
        int area = Math.min(height[lo], height[hi]) * (hi - lo);
        max = Math.max(max, area);

        if (height[lo] <= height[hi]) {
          lo++;
        } else {
          hi--;
        }
      }
      return max;
    }
  }

}
