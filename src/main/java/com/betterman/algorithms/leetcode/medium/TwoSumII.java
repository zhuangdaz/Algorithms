package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/29/15.
 */
public class TwoSumII {
    public class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];

            int lo = 0, hi = nums.length - 1;
            while(lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum < target) lo++;
                else if (sum > target) hi--;
                else break;
            }
            res[0] = lo + 1;
            res[1] = hi + 1;
            return res;
        }
    }
}
