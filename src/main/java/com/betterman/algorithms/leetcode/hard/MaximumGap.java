package com.betterman.algorithms.leetcode.hard;

import java.util.Arrays;

/**
 * Created by zhuangda on 3/8/16.
 */
public class MaximumGap {
    public class Solution {
        public int maximumGap(int[] nums) {
            if (nums.length < 2) return 0;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            if (max == min) return 0;

            int minGap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
            int[] lowers = new int[nums.length - 1];
            int[] uppers = new int[nums.length - 1];

            Arrays.fill(lowers, Integer.MAX_VALUE);
            Arrays.fill(uppers, Integer.MIN_VALUE);

            for (int num : nums) {
                int i = num == max ? nums.length - 2 : (num - min - 1) / minGap;
                lowers[i] = Math.min(lowers[i], num);
                uppers[i] = Math.max(uppers[i], num);
            }

            int prev = uppers[0];
            int maxGap = minGap;
            for (int i = 1; i < nums.length - 1; i++) {
                if (lowers[i] == Integer.MAX_VALUE) continue;
                int gap = lowers[i] - prev;
                if (gap > maxGap) maxGap = gap;
                prev = uppers[i];
            }
            return maxGap;
        }
    }
}
