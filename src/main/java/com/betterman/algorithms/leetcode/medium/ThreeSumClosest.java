package com.betterman.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhuangda on 12/29/15.
 */
public class ThreeSumClosest {
    public static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int min = 0;
            int distAll = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (sum > target) hi--;
                    else if (sum < target) lo++;

                    if (Math.abs(sum - target) < distAll) {
                        distAll = Math.abs(sum - target);
                        min = sum;

                        if (min == target) return min;
                    }
                }

                while (i + 1 < nums.length - 2 && nums[i + 1] == nums[i]) i++;
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{
            4, 0, 5, -5, 3, 3, 0, -4, -5
        };
        int target = -2;
        System.out.println(solution.threeSumClosest(nums, target));
    }
}
