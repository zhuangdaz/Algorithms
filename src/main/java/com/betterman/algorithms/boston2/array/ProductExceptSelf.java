package com.betterman.algorithms.boston2.array;

public class ProductExceptSelf {

  class Solution {

    /**
     * time: O(n)
     * space: O(1)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
      int[] res = new int[nums.length];

      int fromLeft = 1;
      for (int i = 0; i < nums.length; i++) {
        res[i] = fromLeft;
        fromLeft *= nums[i];
      }

      int fromRight = 1;
      for (int i = nums.length - 1; i >= 0; i--) {
        res[i] *= fromRight;
        fromRight *= nums[i];
      }

      return res;
    }
  }
}
