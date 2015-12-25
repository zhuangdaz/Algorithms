package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/24/15.
 */

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchRange {
    public class Solution {
        public int[] searchRange(int[] nums, int target) {
            //upperbound
            int lo = 0, hi = nums.length - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] <= target) lo = mid + 1;
                else hi = mid - 1;
            }

            //lowerbound
            int lo2 = 0, hi2 = nums.length - 1;
            while (lo2 <= hi2) {
                int mid = (lo2 + hi2) / 2;
                if (nums[mid] >= target) hi2 = mid - 1;
                else lo2 = mid + 1;
            }


            if (lo2 > hi) {
                return new int[]{-1, -1};
            } else {
                return new int[]{lo2, hi};
            }
        }
    }
}
