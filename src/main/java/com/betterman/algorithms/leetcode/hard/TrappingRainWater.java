package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 1/2/16.
 */
public class TrappingRainWater {
    public class Solution {
        public int trap(int[] height) {
            int res = 0;
            int left = 0, right = height.length - 1;
            int maxLeft = 0, maxRight = 0;
            while (left < right) {
                if (height[left] <= height[right]) {
                    if (height[left] >= maxLeft) maxLeft = height[left];
                    else res += maxLeft - height[left];
                    left++;
                } else {
                    if (height[right] >= maxRight) maxRight = height[right];
                    else res += maxRight - height[right];
                    right--;
                }
            }
            return res;
        }
    }
}
