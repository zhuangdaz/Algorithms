package com.betterman.algorithms.boston2.array;

public class MaxSubArray {

  class Solution {

    /**
     * time: O(n)
     * space: O(1)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
      if (nums == null || nums.length == 0) {
        throw new IllegalArgumentException("Input array is invalid");
      }

      int max = nums[0];
      for (int i = 1; i < nums.length; i++) {
        nums[i] += nums[i - 1] > 0 ? nums[i - 1] : 0;
        max = Math.max(max, nums[i]);
      }
      return max;
    }
  }
}
