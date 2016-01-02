package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/2/16.
 */
public class ContainerWithMostWater {
    public class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            int l = 0, r = height.length - 1;
            while (l < r) {
                int area = (r - l) * Math.min(height[l], height[r]);
                if (area > max) max = area;
                if (height[l] < height[r]) l++;
                else r--;
            }
            return max;
        }
    }
}
