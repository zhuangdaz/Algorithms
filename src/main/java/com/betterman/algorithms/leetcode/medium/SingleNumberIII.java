package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 3/9/16.
 */
public class SingleNumberIII {
    public static class Solution {
        public int[] singleNumber(int[] nums) {
            int cmb = 0;
            for (int num : nums) {
                cmb ^= num;
            }

            int diff = cmb & ~(cmb - 1);
            int a = 0;
            for (int num : nums) {
                if ((num & diff) == 1) {
                    a ^= num;
                }
            }

            int b = cmb ^ a;
            return new int[]{a, b};
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 5, 2};
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums));

    }
}
