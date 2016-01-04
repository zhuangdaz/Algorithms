package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 1/3/16.
 */
public class JumpGameII {
    public class Solution {
        public int jump(int[] nums) {
            int jumps = 0;
            int max = 0;

            for (int i = 0, nextMax = 0; i <= max && max < nums.length - 1; i++) {
                if (nextMax < nums[i] + i) nextMax = nums[i] + i;

                if (i == max) {
                    max = nextMax;
                    jumps++;
                }
            }

            return max >= nums.length - 1 ? jumps : -1;
        }
    }
}
