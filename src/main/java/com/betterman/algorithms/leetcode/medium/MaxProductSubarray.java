package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/30/15.
 */
public class MaxProductSubarray {
    public class Solution {
        public int maxProduct(int[] nums) {
            int maxSofar = nums[0], minHere = nums[0], maxHere = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int tmp = maxHere;
                maxHere = Math.max(Math.max(maxHere * nums[i], minHere * nums[i]), nums[i]);
                minHere = Math.min(Math.min(tmp * nums[i], minHere * nums[i]), nums[i]);

                if (maxSofar < maxHere) maxSofar = maxHere;
            }
            return maxSofar;
        }
    }
}
