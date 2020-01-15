package com.betterman.algorithms.boston2.array;

public class SearchInRotatedSortedArray {

  class Solution {

    /**
     * time: O(logn)
     * space: O(1)
     * another approach: find the min from the array, and use that index to do a modular calculation to find its actual place after rotation.
     * (i + rot) % n = original index
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
        return -1;
      }

      int lo = 0, hi = nums.length - 1;
      if (nums[lo] <= nums[hi]) {
        return binarySearch(nums, lo, hi, target);
      }

      while (lo <= hi) {
        int mid = (lo + hi) / 2;

        if (nums[mid] >= nums[lo]) {
          if (nums[lo] <= target && target <= nums[mid]) {
            return binarySearch(nums, lo, mid, target);
          } else {
            lo = mid + 1;
          }
        } else {
          if (nums[mid] <= target && target <= nums[hi]) {
            return binarySearch(nums, mid, hi, target);
          } else {
            hi = mid - 1;
          }
        }
      }
      return -1;
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
      while (lo <= hi) {
        int mid = (lo + hi) / 2;
        if (nums[mid] == target) {
          return mid;
        } else if (nums[mid] > target) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      }
      return -1;
    }
  }
}
