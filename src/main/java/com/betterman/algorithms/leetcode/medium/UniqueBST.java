package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 2/14/16.
 */

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example, Given n = 3, there are a total of 5 unique BST's.
 */
public class UniqueBST {
    public class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
}
