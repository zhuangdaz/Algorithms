package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/20/15.
 */
public class RoateArray {
    public class Solution {
        public void rotate(int[] nums, int k) {
            if (k % nums.length == 0) return;

            k %= nums.length;

            int[] tmpK = new int[k];
            int n = nums.length;
            for (int i = 0; i < k; i++) {
                tmpK[i] = nums[n - k + i];
            }

            for (int i = n - k - 1; i >= 0; i--) {
                nums[i + k] = nums[i];
            }

            for (int i = 0; i < k; i++) {
                nums[i] = tmpK[i];
            }
        }
    }
}
