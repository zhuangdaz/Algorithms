package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/28/15.
 */

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    public class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int total = (n + 1) * n / 2;

            for (int num : nums) {
                total -= num;
            }
            return total;
        }

        //Bit Manipulation
        public int missingNumberBitManipulation(int[] nums) {
            int res = nums.length;
            for (int i = 0; i < nums.length; i++) {
                res ^= nums[i];
                res ^= i;
            }
            return res;
        }
    }
}
