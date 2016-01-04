package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 1/3/16.
 */
public class FindDupNumber {
    // if the question is like:
    // an size-n array with 1-n integers, then notice the solution relates to array index
    public class Solution {
        public int findDuplicate(int[] nums) {
            int slow = nums[0], fast = nums[nums[0]];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
