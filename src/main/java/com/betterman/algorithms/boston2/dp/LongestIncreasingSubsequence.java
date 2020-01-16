package com.betterman.algorithms.boston2.dp;

public class LongestIncreasingSubsequence {

  class Solution {

    /**
     * time: O(nlogn) space: O(n)
     * <p>
     * tails[i] is to store the last element of increasing subsequence of size i, it can be replaced
     * by a smaller element seen later in the array
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
      int n = nums.length;
      int[] tails = new int[n];
      int len = 0;

      for (int num : nums) {
        int index = binarySearch(tails, len, num);
        tails[index] = num;
        if (index == len) {
          len++;
        }
      }
      return len;
    }

    private int binarySearch(int[] arr, int endExclusive, int target) {
      int lo = 0, hi = endExclusive - 1;
      while (lo <= hi) {
        int mid = (lo + hi) / 2;
        if (arr[mid] == target) {
          return mid;
        } else if (arr[mid] < target) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }
      return lo;
    }
  }

}
