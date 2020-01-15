package com.betterman.algorithms.boston2.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  static class Solution {

    /**
     * time: O(n^2)
     * space: O(1)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);

      List<List<Integer>> res = new ArrayList();
      for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        }
        if (nums[i] > 0) {
          break;
        }
        int target = -nums[i];
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
          int sum = nums[lo] + nums[hi];
          if (sum == target) {
            List<Integer> triplet = Arrays.asList(nums[i], nums[lo], nums[hi]);
            res.add(triplet);
            while (lo < hi && nums[lo] == triplet.get(1)) {
              lo++;
            }
            while (hi > lo && nums[hi] == triplet.get(2)) {
              hi--;
            }
          } else if (sum < target) {
            lo++;
          } else {
            hi--;
          }
        }
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
    solution.threeSum(nums);
  }

}
