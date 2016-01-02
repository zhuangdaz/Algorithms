package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/1/16.
 */
public class FindPeakElement {
    public class Solution {
        //sequantial
        public int findPeakElement(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) return i - 1;
            }
            return nums.length - 1;
        }

        //recursive binary search
        public int findPeakElementBinarySearchRecursive(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private int helper(int[] nums, int lo, int hi) {
            if (lo == hi) return lo;

            int mid1 = (lo + hi) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) return helper(nums, mid2, hi);
            else return helper(nums, lo, mid1);
        }

        //Binary search iterative
        public int findPeakElementBinarySearchIterative(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            while (lo < hi) {
                int mid1 = (lo + hi) / 2;
                int mid2 = mid1 + 1;
                if (nums[mid1] < nums[mid2]) {
                    lo = mid2;
                } else {
                    hi = mid1;
                }
            }
            return lo;
        }
    }
}
