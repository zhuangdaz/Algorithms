package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/23/16.
 */
public class SuperUglyNumber {
    public class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] dp = new int[n];
            dp[0] = 1;
            int[] indexs = new int[primes.length];
            for (int i = 1; i < n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < indexs.length; j++) {
                    if (min > dp[indexs[j]] * primes[j]) {
                        min = dp[indexs[j]] * primes[j];
                    }
                }

                dp[i] = min;

                for (int j = 0; j < indexs.length; j++) {
                    if (min == dp[indexs[j]] * primes[j]) {
                        indexs[j]++;
                    }
                }
            }

            return dp[n - 1];
        }
    }
}
