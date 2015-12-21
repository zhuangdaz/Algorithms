package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/21/15.
 */
public class RemoveElement {
    public class Solution {
        public int removeElement(int[] nums, int val) {
            int count = 0;
            for (int i = 0; i < nums.length - count; ) {
                if (nums[i] == val) {
                    count++;
                    nums[i] = nums[nums.length - count];
                } else {
                    i++;
                }
            }
            return nums.length - count;
        }

        public int removeElementNeat(int[] nums, int val) {
            int begin = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) nums[begin++] = nums[i];
            }
            return begin;
        }
    }
}
