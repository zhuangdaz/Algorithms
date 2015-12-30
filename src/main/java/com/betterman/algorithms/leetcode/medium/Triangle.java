package com.betterman.algorithms.leetcode.medium;

import java.util.List;

/**
 * Created by zhuangda on 12/30/15.
 */
public class Triangle {
    public class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] dp = new int[triangle.size() + 1];

            for (int i = triangle.size() - 1; i > -1; i--) {
                List<Integer> row = triangle.get(i);
                for (int j = 0; j < row.size(); j++) {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
                }
            }
            return dp[0];
        }
    }
}
