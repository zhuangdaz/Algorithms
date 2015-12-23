package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/23/15.
 */

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinSizeSubarraySum {
    public class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int min = Integer.MAX_VALUE;
            for (int l = 0, r = 0, sum = 0; r < nums.length; r++) {
                sum += nums[r];

                while (sum >= s) {
                    min = Math.min(r - l + 1, min);
                    sum -= nums[l++];
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
}
