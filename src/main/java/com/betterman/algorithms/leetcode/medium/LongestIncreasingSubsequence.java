package com.betterman.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhuangda on 2/5/16.
 */
public class LongestIncreasingSubsequence {
    public class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;

            for (int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if (i < 0) i = -(i + 1);

                dp[i] = num;
                if (i == len) len++;
            }
            return len;
        }
    }
}
