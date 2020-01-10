package com.betterman.algorithms.boston2.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  class Solution {

    /**
     * time: O(n)
     * space: O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap();

      for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
          return new int[]{map.get(target - nums[i]), i};
        }

        map.put(nums[i], i);
      }

      throw new IllegalArgumentException("No two sum solution");
    }
  }

}
