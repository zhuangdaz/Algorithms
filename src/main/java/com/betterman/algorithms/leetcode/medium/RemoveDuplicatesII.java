package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/26/15.
 */
public class RemoveDuplicatesII {
    public class Solution {
        public int removeDuplicates(int[] nums) {
            return removeDuplicatesK(nums, 2);
        }

        public int removeDuplicatesK(int[] nums, int k) {
            if (nums.length <= k) return nums.length;

            int slow = 1, cnt = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[slow++] = nums[i];
                    cnt = 1;
                } else {
                    if (cnt < k) {
                        cnt++;
                        nums[slow++] = nums[i];
                    }
                }
            }
            return slow;
        }
    }
}
