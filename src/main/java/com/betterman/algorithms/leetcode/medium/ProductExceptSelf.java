package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 11/24/15.
 */
public class ProductExceptSelf {
    public class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] ret = new int[nums.length];

            int prod = 1;
            for (int i = 0; i < nums.length; i++) {
                ret[i] = prod;
                prod *= nums[i];
            }

            prod = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                ret[i] *= prod;
                prod *= nums[i];
            }

            return ret;
        }
    }
}
