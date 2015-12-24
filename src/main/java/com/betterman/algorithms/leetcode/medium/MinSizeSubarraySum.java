package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/23/15.
 */

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinSizeSubarraySum {
    public static class Solution {
        //O(n)
        public int minSubArrayLen(int s, int[] nums) {
            int min = Integer.MAX_VALUE;
            for (int l = 0, r = 0, sum = 0; r < nums.length; r++) {
                sum += nums[r];

                while (sum >= s) {
                    min = Math.min(r - l + 1, min);
                    sum -= nums[l++];
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }


        //O(nlgn)
        public int minSubArrayLenBinarySearch(int s, int[] nums) {
            int[] sums = new int[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < sums.length; i++) {
                int minIdx = binarySearch(sums, i + 1, sums.length - 1, sums[i] + s);
                if (minIdx == sums.length) break; //can exit safely because the rest sub arrays have fewer positive numbers so that it is impossible to have a sum greater than s
                min = Math.min(min, minIdx - i);
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }


        private int binarySearch(int[] sums, int lo, int hi, int key) {
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (sums[mid] >= key) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return lo;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = 4;
        int[] nums = new int[]{1, 4, 4};
        System.out.println(solution.minSubArrayLenBinarySearch(s, nums));
    }
}
