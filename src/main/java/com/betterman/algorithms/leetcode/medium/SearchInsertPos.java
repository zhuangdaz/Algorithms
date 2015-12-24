package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/24/15.
 */

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 *  GREAT TEST CASES, cover all situations.
 */
public class SearchInsertPos {
    public class Solution {
        //Time: O(lgn) - Binary Search
        public int searchInsert(int[] nums, int target) {
            int lo = 0, hi = nums.length - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] < target) lo = mid + 1;
                else hi = mid - 1;
            }
            return lo;
        }
    }

}
