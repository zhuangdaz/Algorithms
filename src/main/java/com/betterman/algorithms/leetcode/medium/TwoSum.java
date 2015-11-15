package com.betterman.algorithms.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by zhuangda on 10/9/15.
 */
public class TwoSum {
    public static class Solution {
        public int[] twoSum(int[] nums, int target) {
            //iterate from left to right, index i
            //  check map to see if contains (target - nums[i])
            //      if yes, then return map.get(target - nums[i]), i
            //      else, map.put(nums[i], i), continue
            //O(n) runtime, O(n) space
            HashMap<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                int toCheck = target - nums[i];
                if (map.containsKey(toCheck)) {
                    return new int[]{map.get(toCheck) + 1, i + 1};
                } else {
                    map.put(nums[i], i);
                }
            }
            return null;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{2, 3, 4};
        int target = 6;
        int[] ret = sol.twoSum(nums, target);
        System.out.println(Arrays.toString(ret));
    }

}
