package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 1/9/16.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * <p>
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * <p>
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * <p>
 * Follow Up:
 * Can you do it in O(n) time?
 */
public class MaxSizeSubarraySumEqualsK {
    public class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap();
            map.put(0, -1); //smart trick
            int sum = 0, max = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                max = Math.max(max, i - map.getOrDefault(sum - k, i));
                map.putIfAbsent(sum, i);  // case: [1, 0, -1], -1
            }
            return max;
        }
    }
}
