package com.betterman.algorithms.leetcode2.medium;

/**
 * Created by zhuangda on 3/13/16.
 */

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is
 * missing from the array.
 *
 * For example, Given nums = [0, 1, 3] return 2.
 *
 * Note: Your algorithm should run in linear runtime complexity. Could you implement it using only
 * constant extra space complexity?
 */
public class MissingNumber {
    public class Solution {
        public int missingNumber(int[] nums) {
            int ans = nums.length;
            for (int i = 0; i < nums.length; i++) {
                ans ^= i ^ nums[i];
            }
            return ans;
        }
    }
}
