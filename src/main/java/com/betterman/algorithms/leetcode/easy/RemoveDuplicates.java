package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/21/15.
 */
public class RemoveDuplicates {
    public static class Solution {
        public int removeDuplicates(int[] nums) {
            int p1 = 1, p2 = 1;

            while(p2 < nums.length) {
                while(p2 < nums.length && nums[p2] == nums[p2 - 1]) p2++;
                if (p2 < nums.length) {
                    nums[p1] = nums[p2];
                    p1++;
                }

            }
            return p1;
        }

        public int removeDuplicatesNeat(int[] nums) {
            if (nums.length == 0) return 0;
            int p = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) nums[p++] = nums[i];
            }
            return p;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2};
        solution.removeDuplicates(nums);
    }
}
