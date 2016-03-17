package com.betterman.algorithms.leetcode2.medium;

import java.util.Arrays;

/**
 * Created by zhuangda on 3/14/16.
 */
public class ThreeSumSmaller {
    public class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums);

            int count = 0;

            for (int i = 0; i < nums.length - 2; i++) {
                int lo = i + 1, hi = nums.length - 1;
                int prev = count;
                while (lo < hi) {
                    int sum = nums[lo] + nums[hi] + nums[i];
                    if (sum < target) {
                        count += hi - lo;  //KEY!!
                        lo++;
                    }
                    else {
                        hi--;
                    }
                }
                if (prev == count) return count;  //pruning
            }
            return count;
        }
    }
}
