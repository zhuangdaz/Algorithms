package com.betterman.algorithms.boston2.array;

public class MaxProductSubArray {

  class Solution {

    /**
     * time: O(n)
     * space: O(1)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
      int max = nums[0];

      // subproblem: find the max and min product that ends with nums[i]
      // maxProduct can only be among:
      // nums[i], max[i - 1] * nums[i], min[i - 1] * nums[i]
      for (int i = 1, imax = max, imin = max; i < nums.length; i++) {
        if (nums[i] < 0) {
          int tmp = imax;
          imax = imin;
          imin = tmp;
        }

        imax = Math.max(nums[i], imax * nums[i]);
        imin = Math.min(nums[i], imin * nums[i]);

        max = Math.max(max, imax);
      }
      return max;
    }
  }
}
