package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/2/16.
 */
public class SearchInRotatedSortedArrayII {
    public class Solution {
        public boolean search(int[] nums, int target) {
            return helper(nums, 0, nums.length - 1, target);
        }

        // c0: 4 0 1 2 3 t: 2
        // c1: 4 0 1 2 3 t: 4
        // c2: 1 2 3 4 0 t: 2
        // c3: 1 2 3 4 0 t: 4
        // c4: 4 0 1 1 1 t: 1
        // c5: 4 0 1 1 1 t: 2
        // c6: 3 3 3 4 0 t: 3
        // c7: 3 3 3 4 0 t: 4
        // c8: 1 2 3 4 0 t: 3
        // c9: 1 1 1 4 1 t: 4
        //c10: 1 4 1 1 1 t: 4

        //worst case: O(n), average: O(lgn)
        private boolean helper(int[] nums, int lo, int hi, int target) {
            if (lo > hi) return false;

            int mid = (lo + hi) / 2;
            //c8
            if (nums[mid] == target) {
                return true;
            }

            //c9 c10
            if (nums[mid] == nums[hi] && nums[mid] == nums[lo])
                return helper(nums, lo, mid - 1, target) || helper(nums, mid + 1, hi, target);
            //c0 c1 c4 c5
            else if (nums[mid] <= nums[hi]) {
                if (target > nums[mid] && target <= nums[hi]) return helper(nums, mid + 1, hi, target);
                else return helper(nums, lo, mid - 1, target);
            //c2 c3 c6 c7
            } else {
                if (target >= nums[lo] && target < nums[mid]) return helper(nums, lo, mid - 1, target);
                else return helper(nums, mid + 1, hi, target);
            }
        }
    }
}
