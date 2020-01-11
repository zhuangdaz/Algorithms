package com.betterman.algorithms.boston2.array;

public class FindMinInRotatedSortedArray {

  class Solution {

    /**
     * time: O(logn)
     * space: O(1)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
      int lo = 0, hi = nums.length - 1;
      while (lo < hi) {
        if (nums[lo] < nums[hi]) {
          break;
        }
        int mid = (lo + hi) / 2;
        if (nums[mid] >= nums[lo]) {
          lo = mid + 1;
        } else {
          hi = mid;
        }
      }

      return nums[lo];
    }
  }

}
