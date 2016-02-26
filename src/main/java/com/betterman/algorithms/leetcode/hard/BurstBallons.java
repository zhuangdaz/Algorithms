package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 2/25/16.
 */
public class BurstBallons {
    public class Solution {
        //divide and conquer: find the last balloon to burst first
        public int maxCoins(int[] iNums) {
            int[] nums = new int[iNums.length + 2];
            int n = 1;
            for (int num : iNums) {
                if (num > 0) {
                    nums[n++] = num;
                }
            }
            nums[0] = 1;
            nums[n++] = 1;

            int[][] mem = new int[n][n];
            return burst(mem, nums, 0, n - 1);
        }

        private int burst(int[][] mem, int[] nums, int left, int right) {
            if (left + 1 == right) return 0;
            if (mem[left][right] > 0) return mem[left][right];

            int ans = 0;
            for (int i = left + 1; i < right; i++) {
                ans = Math.max(ans, nums[left] * nums[i] * nums[right] +
                        burst(mem, nums, left, i) + burst(mem, nums, i, right));
            }
            mem[left][right] = ans;
            return ans;
        }

        //O(n^3)
        public int maxCoinsDP(int[] iNums) {
            int[] nums = new int[iNums.length + 2];
            int n = 1;
            for (int num : iNums) {
                if (num > 0) {
                    nums[n++] = num;
                }
            }
            nums[0] = 1;
            nums[n++] = 1;

            int[][] dp = new int[n][n];

            for (int k = 2; k < n; k++) {
                for (int left = 0; left + k < n; left++) {
                    int right = left + k;
                    for (int i = left + 1; i < right; i++) {
                        dp[left][right] = Math.max(dp[left][right],
                                nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
