package com.betterman.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhuangda on 12/31/15.
 */
public class ThreeSumSmaller {
    public class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums);
            int count = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                int prevCount = count;
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[lo] + nums[hi] + nums[i];
                    if (sum < target) {
                        count += hi - lo;
                        lo++;
                    } else {
                        hi--;
                    }
                }

                if (prevCount == count) break; //if current nums[i] doesn't increase the count, then larger nums[i] won't neither.
            }
            return count;
        }
    }
}
