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

        public void rotate2(int[] nums, int k) {
            if (k % nums.length == 0) return;

            int n = nums.length;
            k %= n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
    }
}
