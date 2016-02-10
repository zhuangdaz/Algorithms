package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 2/10/16.
 */
public class PaintHouse {
    public class Solution {
        public int minCost(int[][] costs) {
            if(costs==null||costs.length==0){
                return 0;
            }

            int rows = costs.length;
            int k = costs[0].length;
            int[] dp = new int[k];
            for (int i = 0; i < k; i++) {
                dp[i] = costs[0][i];
            }
            int[] tmp = new int[k];
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < k; j++) {
                    tmp[j] = min(dp, j) + costs[i][j];
                }

                for (int j = 0; j < k; j++) {
                    dp[j] = tmp[j];
                }
            }

            return min(dp);
        }

        private int min(int[] nums) {
            int min = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num < min) min = num;
            }
            return min;
        }

        private int min(int[] nums, int skip) {
            int tmp = nums[skip];
            nums[skip] = Integer.MAX_VALUE;
            int min = min(nums);
            nums[skip] = tmp;
            return min;
        }
    }
}
