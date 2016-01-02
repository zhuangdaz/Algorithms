package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/1/16.
 */
public class FindMinInRotatedSortedArray {
    public class Solution {
        public int findMin(int[] nums) {
            if (nums[0] < nums[nums.length - 1]) return nums[0];
            int lo = 0, hi = nums.length - 1;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (nums[mid] > nums[hi]) lo = mid + 1;
                else hi = mid;
            }
            return nums[lo];
        }
    }
}
