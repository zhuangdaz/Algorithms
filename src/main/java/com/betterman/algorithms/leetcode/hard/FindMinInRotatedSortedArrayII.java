package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 1/2/16.
 */
public class FindMinInRotatedSortedArrayII {
    public class Solution {
        //[10,1,10,10,10]
        public int findMin(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            while (lo < hi) {
                if (nums[lo] < nums[hi]) return nums[lo]; //[1 2 3 4]
                int mid = (lo + hi) / 2;
                if (nums[mid] > nums[lo]) {
                    lo = mid + 1;
                } else if (nums[mid] < nums[lo]) {
                    hi = mid;
                } else {
                    lo++;
                }
            }
            return nums[lo];
        }

        public int findMinFromBack(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] > nums[hi]) {
                    lo = mid + 1;
                } else if (nums[mid] < nums[hi]) {
                    hi = mid;
                } else {
                    hi--;
                }
            }
            return nums[lo];
        }
    }
}
